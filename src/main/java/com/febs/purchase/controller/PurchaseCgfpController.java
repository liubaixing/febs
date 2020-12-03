package com.febs.purchase.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.entity.excel.CommonExcelEntity;
import com.febs.common.listener.CommonExcelListener;
import com.febs.common.utils.ExcelUtil;
import com.febs.orderqt.service.IOrderqtYfdService;
import com.febs.orderqt.service.IOrderqtYsfdService;
import com.febs.orderqt.vo.req.YfdReq;
import com.febs.orderqt.vo.req.YsfdReq;
import com.febs.orderqt.vo.resp.YfdResp;
import com.febs.orderqt.vo.resp.YsfdResp;
import com.febs.purchase.biz.PurchaseCgfpBiz;
import com.febs.purchase.entity.PurchaseCgfp;
import com.febs.purchase.service.IPurchaseCgService;
import com.febs.purchase.service.IPurchaseCgfpService;

import com.febs.purchase.service.IPurchaseTcService;
import com.febs.purchase.view.CgfkView;
import com.febs.purchase.view.CgfpView;
import com.febs.purchase.vo.req.CgfpCreateReq;
import com.febs.purchase.vo.req.PurchaseCgReq;
import com.febs.purchase.vo.req.PurchaseCgfpReq;
import com.febs.purchase.vo.req.PurchaseTcReq;
import com.febs.purchase.vo.resp.PurchaseCgResp;
import com.febs.purchase.vo.resp.PurchaseCgfpResp;
import com.febs.purchase.vo.resp.PurchaseTcResp;
import com.febs.system.entity.User;
import com.febs.system.service.IUserCangkuService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 采购发票 Controller
 *
 * @author liubaixing
 * @date 2020-06-27 19:55:27
 */
@Slf4j
@Validated
@RestController
@RequestMapping("purchaseCgfp")
public class PurchaseCgfpController extends BaseController {

    @Autowired
    private IPurchaseCgfpService purchaseCgfpService;

    @Autowired
    private PurchaseCgfpBiz cgfpBiz;

    @Autowired
    private IPurchaseCgService cgService;
    @Autowired
    private IPurchaseTcService tcService;
    @Autowired
    private IOrderqtYfdService yfdService;
    @Autowired
    private IOrderqtYsfdService ysfdService;
    @Autowired
    private IUserCangkuService userCangkuService;


    @GetMapping("")
//    @RequiresPermissions("purchaseCgfp:list")
    public FebsResponse getAllPurchaseCgfps(PurchaseCgfpReq purchaseCgfp) {
        return new FebsResponse().success().data(purchaseCgfpService.findPurchaseCgfps(purchaseCgfp));
    }

    @GetMapping("/list")
//    @RequiresPermissions("purchaseCgfp:list")
    public FebsResponse purchaseCgfpList(QueryRequest request, PurchaseCgfpReq purchaseCgfp) {
        Map<String, Object> dataTable = getDataTable(this.purchaseCgfpService.findPurchaseCgfps(request, purchaseCgfp));
        return new FebsResponse().success().data(dataTable);
    }

    @ApiOperation("导入查询")
    @PostMapping("/list/import")
    public FebsResponse importQuery(@RequestParam MultipartFile file) throws IOException {

        CommonExcelListener<CommonExcelEntity> listener = new CommonExcelListener<CommonExcelEntity>();
        EasyExcel.read(file.getInputStream(),CommonExcelEntity.class,listener).sheet().doRead();

        List<CommonExcelEntity> datas = listener.getDatas();

        if (CollectionUtils.isEmpty(datas)){
            return new FebsResponse().success();
        }

        List<String> cgNoList = datas.stream().filter(i->i.getRow2()!=null).map(CommonExcelEntity::getRow2).collect(Collectors.toList());
        List<String> tcNoList = datas.stream().filter(i->i.getRow3()!=null).map(CommonExcelEntity::getRow3).collect(Collectors.toList());
        List<String> yfdNoList = datas.stream().filter(i->i.getRow4()!=null).map(CommonExcelEntity::getRow4).collect(Collectors.toList());
        List<String> ysfdNoList = datas.stream().filter(i->i.getRow5()!=null).map(CommonExcelEntity::getRow5).collect(Collectors.toList());

        User user = getCurrentUser();
        List<Long> cangkuList = userCangkuService.getUserCangku(user.getUserId());

        List<PurchaseCgResp> cgRespList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(cgNoList)){
            if (CollectionUtils.isNotEmpty(cangkuList)){
                PurchaseCgReq cgReq = new PurchaseCgReq();
                cgReq.setCangkuList(cangkuList);
                cgReq.setDjbhList(cgNoList);
                cgRespList = cgService.findPurchaseCgs(cgReq);
            }
        }

        List<PurchaseTcResp> tcRespList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(tcNoList)){

            if (CollectionUtils.isNotEmpty(cangkuList)){
                PurchaseTcReq tcReq = new PurchaseTcReq();
                tcReq.setCangkuList(cangkuList);
                tcReq.setDjbhList(tcNoList);
                tcRespList = tcService.findPurchaseTcs(tcReq);
            }
        }

        List<YfdResp> yfdRespList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(yfdNoList)){
            YfdReq yfdReq = new YfdReq();
            yfdReq.setDjbhList(yfdNoList);
            yfdRespList = yfdService.findOrderqtYfds(yfdReq);
        }

        List<YsfdResp> ysfdRespList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(ysfdNoList)){
            YsfdReq ysfdReq = new YsfdReq();
            ysfdReq.setDjbhList(ysfdNoList);
            ysfdRespList = ysfdService.findOrderqtYsfds(ysfdReq);
        }

        CgfpView cgfpView = new CgfpView();
        cgfpView.setCgRespList(cgRespList);
        cgfpView.setTcRespList(tcRespList);
        cgfpView.setYfdRespList(yfdRespList);
        cgfpView.setYsfdRespList(ysfdRespList);
        return new FebsResponse().success().data(cgfpView);
    }

    @ControllerEndpoint(operation = "新增采购发票", exceptionMessage = "新增采购发票失败")
    @PostMapping("")
//    @RequiresPermissions("purchaseCgfp:add")
    public FebsResponse addPurchaseCgfp(@Valid PurchaseCgfp purchaseCgfp) {
        this.purchaseCgfpService.createPurchaseCgfp(purchaseCgfp);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除采购发票", exceptionMessage = "删除采购发票失败")
    @GetMapping("delete/{ids}")
//    @RequiresPermissions("purchaseCgfp:delete")
    public FebsResponse deletePurchaseCgfp(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.purchaseCgfpService.deletePurchaseCgfp(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改采购发票", exceptionMessage = "修改采购发票失败")
    @PostMapping("/update")
//    @RequiresPermissions("purchaseCgfp:update")
    public FebsResponse updatePurchaseCgfp(PurchaseCgfp purchaseCgfp) {
        this.purchaseCgfpService.updatePurchaseCgfp(purchaseCgfp);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
//    @RequiresPermissions("purchaseCgfp:export")
    public void export(QueryRequest queryRequest, PurchaseCgfpReq purchaseCgfp, HttpServletResponse response) throws IOException {
        List<PurchaseCgfpResp> purchaseCgfps = this.purchaseCgfpService.findPurchaseCgfps(queryRequest, purchaseCgfp).getRecords();
        ExcelUtil.export(purchaseCgfps, PurchaseCgfpResp.class,"采购发票",response);
    }


    @ApiOperation("作废")
    @ControllerEndpoint(operation = "作废", exceptionMessage = "作废失败")
    @GetMapping("/zf/{id}")
//    @RequiresPermissions("purchaseCgfp:zf")
    public FebsResponse zf(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseCgfp purchasefp = new PurchaseCgfp();
        purchasefp.setId(id);
        purchasefp.setZf((byte)1);
        purchasefp.setZfr(user.getUsername());
        purchasefp.setZfrq(new Date());
        this.purchaseCgfpService.updatePurchaseCgfp(purchasefp);
        return new FebsResponse().success();
    }

    @ApiOperation("确认")
    @ControllerEndpoint(operation = "确认", exceptionMessage = "确认失败")
    @GetMapping("/qr/{id}")
//    @RequiresPermissions("purchaseCgfp:qr")
    public FebsResponse qr(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseCgfp purchasefp = new PurchaseCgfp();
        purchasefp.setId(id);
        purchasefp.setQr((byte)1);
        purchasefp.setQrr(user.getUsername());
        purchasefp.setQrrq(new Date());
        this.purchaseCgfpService.updatePurchaseCgfp(purchasefp);
        return new FebsResponse().success();
    }

    @ApiOperation("审核")
    @ControllerEndpoint(operation = "审核", exceptionMessage = "审核失败")
    @GetMapping("/sh/{id}")
//    @RequiresPermissions("purchaseCgfp:sh")
    public FebsResponse sh(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseCgfp purchasefp = new PurchaseCgfp();
        purchasefp.setId(id);
        purchasefp.setSh((byte)1);
        purchasefp.setAuditor(user.getUsername());
        purchasefp.setShrq(new Date());
        this.purchaseCgfpService.updatePurchaseCgfp(purchasefp);
        return new FebsResponse().success();
    }


    @ApiOperation("开票")
    @ControllerEndpoint(operation = "开票", exceptionMessage = "开票失败")
    @GetMapping("/kp/{djbh}")
//    @RequiresPermissions("purchaseCgfp:kp")
    public FebsResponse kp(@PathVariable String djbh){
        User user = getCurrentUser();
        cgfpBiz.kp(djbh,user);
        return new FebsResponse().success();
    }

    @ApiOperation("查看")
    @ControllerEndpoint(operation = "查看", exceptionMessage = "查看失败")
    @GetMapping("/view/{id}")
//    @RequiresPermissions("purchaseCgfp:view")
    public FebsResponse view(@PathVariable Long id){
        return new FebsResponse().success().data(cgfpBiz.view(id));
    }

    @ApiOperation("开始生成")
    @ControllerEndpoint(operation = "生成", exceptionMessage = "生成失败")
    @PostMapping("/kssc")
//    @RequiresPermissions("purchaseCgfp:kssc")
    public FebsResponse kssc(CgfpCreateReq req){
        User user = getCurrentUser();
        cgfpBiz.kssc(req,user);
        return new FebsResponse().success();
    }

}
