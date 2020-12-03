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
import com.febs.purchase.biz.PurchaseCgfkBiz;
import com.febs.purchase.entity.PurchaseCg;
import com.febs.purchase.entity.PurchaseCgfk;
import com.febs.purchase.service.IPurchaseCgService;
import com.febs.purchase.service.IPurchaseCgfkService;

import com.febs.purchase.service.IPurchaseTcService;
import com.febs.purchase.view.CgfkView;
import com.febs.purchase.vo.req.CgfkCreateReq;
import com.febs.purchase.vo.req.PurchaseCgReq;
import com.febs.purchase.vo.req.PurchaseCgfkReq;
import com.febs.purchase.vo.req.PurchaseTcReq;
import com.febs.purchase.vo.resp.PurchaseCgResp;
import com.febs.purchase.vo.resp.PurchaseCgfkResp;
import com.febs.purchase.vo.resp.PurchaseTcResp;
import com.febs.receipt.service.IOrderXsService;
import com.febs.receipt.vo.req.OrderXsReq;
import com.febs.receipt.vo.resp.OrderXsResp;
import com.febs.system.entity.User;
import com.febs.system.service.IUserCangkuService;
import io.swagger.annotations.Api;
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
 * 采购付款 Controller
 *
 * @author liubaixing
 * @date 2020-06-27 19:46:20
 */
@Api("采购付款")
@Slf4j
@Validated
@RestController
@RequestMapping("purchaseCgfk")
public class PurchaseCgfkController extends BaseController {

    @Autowired
    private IPurchaseCgfkService purchaseCgfkService;

    @Autowired
    private PurchaseCgfkBiz cgfkBiz;

    @Autowired
    private IPurchaseCgService cgService;

    @Autowired
    private IOrderqtYfdService yfdService;
    @Autowired
    private IOrderqtYsfdService ysfdService;
    @Autowired
    private IUserCangkuService userCangkuService;


    @GetMapping("")
//    @RequiresPermissions("purchaseCgfk:list")
    public FebsResponse getAllPurchaseCgfks(PurchaseCgfkReq purchaseCgfk) {
        return new FebsResponse().success().data(purchaseCgfkService.findPurchaseCgfks(purchaseCgfk));
    }

    @GetMapping("/list")
//    @RequiresPermissions("purchaseCgfk:list")
    public FebsResponse purchaseCgfkList(QueryRequest request, PurchaseCgfkReq purchaseCgfk) {
        Map<String, Object> dataTable = getDataTable(this.purchaseCgfkService.findPurchaseCgfks(request, purchaseCgfk));
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

        CgfkView cgfkView = new CgfkView();
        cgfkView.setCgRespList(cgRespList);
        cgfkView.setYfdRespList(yfdRespList);
        cgfkView.setYsfdRespList(ysfdRespList);
        return new FebsResponse().success().data(cgfkView);
    }

    @ControllerEndpoint(operation = "新增采购付款", exceptionMessage = "新增采购付款失败")
    @PostMapping("")
//    @RequiresPermissions("purchaseCgfk:add")
    public FebsResponse addPurchaseCgfk(@Valid PurchaseCgfk purchaseCgfk) {
        this.purchaseCgfkService.createPurchaseCgfk(purchaseCgfk);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除采购付款", exceptionMessage = "删除采购付款失败")
    @GetMapping("delete/{ids}")
//    @RequiresPermissions("purchaseCgfk:delete")
    public FebsResponse deletePurchaseCgfk(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.purchaseCgfkService.deletePurchaseCgfk(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改采购付款", exceptionMessage = "修改采购付款失败")
    @PostMapping("/update")
//    @RequiresPermissions("purchaseCgfk:update")
    public FebsResponse updatePurchaseCgfk(PurchaseCgfk purchaseCgfk) {
        this.purchaseCgfkService.updatePurchaseCgfk(purchaseCgfk);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
//    @RequiresPermissions("purchaseCgfk:export")
    public void export(QueryRequest queryRequest, PurchaseCgfkReq purchaseCgfk, HttpServletResponse response) throws IOException {
        List<PurchaseCgfkResp> purchaseCgfks = this.purchaseCgfkService.findPurchaseCgfks(queryRequest, purchaseCgfk).getRecords();
        ExcelUtil.export(purchaseCgfks, PurchaseCgfkResp.class,"采购付款",response);
    }


    @ApiOperation("作废")
    @ControllerEndpoint(operation = "作废", exceptionMessage = "作废失败")
    @GetMapping("/zf/{id}")
//    @RequiresPermissions("purchaseCgfk:zf")
    public FebsResponse zf(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseCgfk purchaseFk = new PurchaseCgfk();
        purchaseFk.setId(id);
        purchaseFk.setZf((byte)1);
        purchaseFk.setZfr(user.getUsername());
        purchaseFk.setZfrq(new Date());
        this.purchaseCgfkService.updatePurchaseCgfk(purchaseFk);
        return new FebsResponse().success();
    }

    @ApiOperation("确认")
    @ControllerEndpoint(operation = "确认", exceptionMessage = "确认失败")
    @GetMapping("/qr/{id}")
//    @RequiresPermissions("purchaseCgfk:qr")
    public FebsResponse qr(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseCgfk purchaseFk = new PurchaseCgfk();
        purchaseFk.setId(id);
        purchaseFk.setQr((byte)1);
        purchaseFk.setQrr(user.getUsername());
        purchaseFk.setQrrq(new Date());
        this.purchaseCgfkService.updatePurchaseCgfk(purchaseFk);
        return new FebsResponse().success();
    }

    @ApiOperation("审核")
    @ControllerEndpoint(operation = "审核", exceptionMessage = "审核失败")
    @GetMapping("/sh/{id}")
//    @RequiresPermissions("purchaseCgfk:sh")
    public FebsResponse sh(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseCgfk purchaseFk = new PurchaseCgfk();
        purchaseFk.setId(id);
        purchaseFk.setSh((byte)1);
        purchaseFk.setAuditor(user.getUsername());
        purchaseFk.setShrq(new Date());
        this.purchaseCgfkService.updatePurchaseCgfk(purchaseFk);
        return new FebsResponse().success();
    }


    @ApiOperation("付款")
    @ControllerEndpoint(operation = "付款", exceptionMessage = "付款失败")
    @GetMapping("/fk/{djbh}")
//    @RequiresPermissions("purchaseCgfk:fk")
    public FebsResponse fk(@PathVariable String djbh){
        User user = getCurrentUser();
        cgfkBiz.fk(djbh,user);
        return new FebsResponse().success();
    }

    @ApiOperation("查看")
    @ControllerEndpoint(operation = "查看", exceptionMessage = "查看失败")
    @GetMapping("/view/{id}")
//    @RequiresPermissions("purchaseCgfk:view")
    public FebsResponse view(@PathVariable Long id){
        return new FebsResponse().success().data(cgfkBiz.view(id));
    }

    @ApiOperation("开始生成")
    @ControllerEndpoint(operation = "生成", exceptionMessage = "生成失败")
    @PostMapping("/kssc")
//    @RequiresPermissions("purchaseCgfk:kssc")
    public FebsResponse kssc(CgfkCreateReq req){
        User user = getCurrentUser();
        cgfkBiz.kssc(req,user);
        return new FebsResponse().success();
    }

}
