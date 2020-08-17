package com.febs.purchase.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.purchase.biz.PurchaseCgBiz;
import com.febs.purchase.entity.PurchaseCg;
import com.febs.purchase.entity.PurchaseCgmx;
import com.febs.purchase.entity.PurchaseCgmxExample;
import com.febs.purchase.service.IPurchaseCgService;

import com.febs.purchase.service.IPurchaseCgmxService;
import com.febs.purchase.vo.req.PurchaseCgReq;
import com.febs.purchase.vo.resp.PurchaseCgResp;
import com.febs.receipt.entity.OrderXs;
import com.febs.receipt.entity.OrderXsExample;
import com.febs.receipt.service.IOrderXsService;
import com.febs.system.entity.User;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 采购单 Controller
 *
 * @author liubaixing
 * @date 2020-06-27 19:45:59
 */
@Slf4j
@Validated
@RestController
@RequestMapping("purchaseCg")
public class PurchaseCgController extends BaseController {

    @Autowired
    private IPurchaseCgService purchaseCgService;

    @Autowired
    private IPurchaseCgmxService cgmxService;

    @Autowired
    private PurchaseCgBiz cgBiz;

    @Autowired
    private IOrderXsService xsService;

    @GetMapping("")
    //@RequiresPermissions("purchaseCg:list")
    public FebsResponse getAllPurchaseCgs(PurchaseCgReq purchaseCg) {
        return new FebsResponse().success().data(purchaseCgService.findPurchaseCgs(purchaseCg));
    }

    @GetMapping("/list")
    //@RequiresPermissions("purchaseCg:list")
    public FebsResponse purchaseCgList(QueryRequest request, PurchaseCgReq purchaseCg) {
        Map<String, Object> dataTable = getDataTable(this.purchaseCgService.findPurchaseCgs(request, purchaseCg));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增采购单", exceptionMessage = "新增采购单失败")
    @PostMapping("")
    //@RequiresPermissions("purchaseCg:add")
    public FebsResponse addPurchaseCg(@Valid PurchaseCg purchaseCg) {
        this.purchaseCgService.createPurchaseCg(purchaseCg);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除采购单", exceptionMessage = "删除采购单失败")
    @GetMapping("delete/{ids}")
//    @RequiresPermissions("purchaseCg:delete")
    public FebsResponse deletePurchaseCg(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.purchaseCgService.deletePurchaseCg(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改采购单", exceptionMessage = "修改采购单失败")
    @PostMapping("/update")
//    @RequiresPermissions("purchaseCg:update")
    public FebsResponse updatePurchaseCg(PurchaseCg purchaseCg) {
        this.purchaseCgService.updatePurchaseCg(purchaseCg);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
//    @RequiresPermissions("purchaseCg:export")
    public void export(QueryRequest queryRequest, PurchaseCgReq purchaseCg, HttpServletResponse response) throws IOException {
        List<PurchaseCgResp> purchaseCgs = this.purchaseCgService.findPurchaseCgs(queryRequest, purchaseCg).getRecords();
        ExcelUtil.export(purchaseCgs, PurchaseCgResp.class,"采购单",response);
    }

    @ApiOperation("查看")
    @ControllerEndpoint(operation = "查看采购单", exceptionMessage = "查看采购单失败")
    @GetMapping("/view/{id}")
//    @RequiresPermissions("purchaseCg:view")
    public FebsResponse view(@PathVariable Long id){
        return new FebsResponse().success().data(cgBiz.view(id));
    }

    @ApiOperation("确认")
    @ControllerEndpoint(operation = "确认采购单", exceptionMessage = "确认采购单失败")
    @GetMapping("/confirm/{id}")
//    @RequiresPermissions("purchaseCg:confirm")
    public FebsResponse confirm(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseCg purchaseCg = new PurchaseCg();
        purchaseCg.setId(id);
        purchaseCg.setQr((byte)1);
        purchaseCg.setQrr(user.getUsername());
        purchaseCg.setQrrq(new Date());
        this.purchaseCgService.updatePurchaseCg(purchaseCg);
        return new FebsResponse().success();
    }

    @ApiOperation("反确认")
    @ControllerEndpoint(operation = "反确认采购单", exceptionMessage = "反确认采购单失败")
    @GetMapping("/unConfirm/{id}")
//    @RequiresPermissions("purchaseCg:unConfirm")
    public FebsResponse unConfirm(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseCg purchaseCg = new PurchaseCg();
        purchaseCg.setId(id);
        purchaseCg.setQr((byte)0);
        purchaseCg.setQrr(user.getUsername());
        purchaseCg.setQrrq(new Date());
        this.purchaseCgService.updatePurchaseCg(purchaseCg);
        return new FebsResponse().success();
    }

    @ApiOperation("审核")
    @ControllerEndpoint(operation = "审核采购单", exceptionMessage = "审核采购单失败")
    @GetMapping("/check/{id}")
//    @RequiresPermissions("purchaseCg:check")
    public FebsResponse check(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseCg purchaseCg = new PurchaseCg();
        purchaseCg.setId(id);
        purchaseCg.setSh((byte)1);
        purchaseCg.setAuditor(user.getUsername());
        purchaseCg.setShrq(new Date());
        this.purchaseCgService.updatePurchaseCg(purchaseCg);
        return new FebsResponse().success();
    }

    @ApiOperation("反审核")
    @ControllerEndpoint(operation = "反审核采购单", exceptionMessage = "反审核采购单失败")
    @GetMapping("/unCheck/{id}")
//    @RequiresPermissions("purchaseCg:unCheck")
    public FebsResponse unCheck(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseCg purchaseCg = new PurchaseCg();
        purchaseCg.setId(id);
        purchaseCg.setSh((byte)0);
        purchaseCg.setAuditor(user.getUsername());
        purchaseCg.setShrq(new Date());
        this.purchaseCgService.updatePurchaseCg(purchaseCg);
        return new FebsResponse().success();
    }


    @ApiOperation("开始收货")
    @ControllerEndpoint(operation = "开始收货", exceptionMessage = "开始收货失败")
    @GetMapping("/kssh/{id}")
//    @RequiresPermissions("purchaseCg:kssh")
    public FebsResponse kssh(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseCg purchaseCg = new PurchaseCg();
        purchaseCg.setId(id);
        purchaseCg.setKssh((byte)1);
        purchaseCg.setKsshr(user.getUsername());
        purchaseCg.setKsshrq(new Date());
        this.purchaseCgService.updatePurchaseCg(purchaseCg);
        return new FebsResponse().success();
    }


    @ApiOperation("反开始收货")
    @ControllerEndpoint(operation = "反开始收货", exceptionMessage = "反开始收货失败")
    @GetMapping("/unKssh/{id}")
//    @RequiresPermissions("purchaseCg:unKssh")
    public FebsResponse unKssh(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseCg purchaseCg = new PurchaseCg();
        purchaseCg.setId(id);
        purchaseCg.setKssh((byte)0);
        purchaseCg.setKsshr(user.getUsername());
        purchaseCg.setKsshrq(new Date());
        this.purchaseCgService.updatePurchaseCg(purchaseCg);
        return new FebsResponse().success();
    }

    @ApiOperation("收货确认")
    @ControllerEndpoint(operation = "收货确认", exceptionMessage = "收货确认失败")
    @GetMapping("/shqr/{id}")
//    @RequiresPermissions("purchaseCg:shqr")
    public FebsResponse shqr(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseCg purchaseCg = new PurchaseCg();
        purchaseCg.setId(id);
        purchaseCg.setShqr((byte)1);
        purchaseCg.setShqrr(user.getUsername());
        purchaseCg.setShqrrq(new Date());
        this.purchaseCgService.updatePurchaseCg(purchaseCg);
        return new FebsResponse().success();
    }


    @ApiOperation("反收货确认")
    @ControllerEndpoint(operation = "反收货确认", exceptionMessage = "反收货确认失败")
    @GetMapping("/unShqr/{id}")
//    @RequiresPermissions("purchaseCg:unShqr")
    public FebsResponse unShqr(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseCg purchaseCg = new PurchaseCg();
        purchaseCg.setId(id);
        purchaseCg.setShqr((byte)0);
        purchaseCg.setShqrr(user.getUsername());
        purchaseCg.setShqrrq(new Date());
        this.purchaseCgService.updatePurchaseCg(purchaseCg);
        return new FebsResponse().success();
    }

    @ApiOperation("作废")
    @ControllerEndpoint(operation = "作废", exceptionMessage = "作废失败")
    @GetMapping("/zf/{id}")
//    @RequiresPermissions("purchaseCg:zf")
    public FebsResponse zf(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseCg purchaseCg = new PurchaseCg();
        purchaseCg.setId(id);
        purchaseCg.setZf((byte)1);
        purchaseCg.setZfr(user.getUsername());
        purchaseCg.setZfrq(new Date());
        this.purchaseCgService.updatePurchaseCg(purchaseCg);
        return new FebsResponse().success();
    }

    @ApiOperation("关闭")
    @ControllerEndpoint(operation = "关闭", exceptionMessage = "关闭失败")
    @GetMapping("/close/{id}")
//    @RequiresPermissions("purchaseCg:close")
    public FebsResponse close(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseCg purchaseCg = new PurchaseCg();
        purchaseCg.setId(id);
        purchaseCg.setZs((byte)1);
        purchaseCg.setZsr(user.getUsername());
        purchaseCg.setZsrq(new Date());
        this.purchaseCgService.updatePurchaseCg(purchaseCg);
        return new FebsResponse().success();
    }


    @ApiOperation("反关闭")
    @ControllerEndpoint(operation = "反关闭", exceptionMessage = "反关闭失败")
    @GetMapping("/unClose/{id}")
//    @RequiresPermissions("purchaseCg:unClose")
    public FebsResponse unClose(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseCg purchaseCg = new PurchaseCg();
        purchaseCg.setId(id);
        purchaseCg.setZs((byte)0);
        purchaseCg.setZsr(user.getUsername());
        purchaseCg.setZsrq(new Date());
        this.purchaseCgService.updatePurchaseCg(purchaseCg);
        return new FebsResponse().success();
    }

    @ApiOperation("分配下单")
    @ControllerEndpoint(operation = "分配下单", exceptionMessage = "分配下单失败")
    @PostMapping("/fpxd")
//    @RequiresPermissions("purchaseCg:fpxd")
    public FebsResponse fpxd(PurchaseCgReq req){

        PurchaseCgmx record = new PurchaseCgmx();
        record.setDj(req.getDj());

        PurchaseCgmxExample example = new PurchaseCgmxExample();
        example.createCriteria().andIdEqualTo(req.getMxId()).andSpIdEqualTo(req.getSpId());
        cgmxService.updateByExample(record,example);
        return new FebsResponse().success();
    }

    @ApiOperation("反分配下单(销售单号)")
    @ControllerEndpoint(operation = "反分配下单", exceptionMessage = "反分配下单失败")
    @GetMapping("/unFpxd{xsdh}")
//    @RequiresPermissions("purchaseCg:unFpxd")
    public FebsResponse unFpxd(@PathVariable("xsdh")String xsdh){
        User user = getCurrentUser();

        OrderXs orderXs = new OrderXs();
        orderXs.setGb((byte)1);
        orderXs.setGbr(user.getUsername());
        orderXs.setGbrq(new Date());

        OrderXsExample example = new OrderXsExample();
        example.createCriteria().andDjbhEqualTo(xsdh);

        xsService.updateByExample(orderXs,example);
        return new FebsResponse().success();
    }

    @ApiOperation("开始发货")
    @ControllerEndpoint(operation = "开始发货", exceptionMessage = "开始发货失败")
    @GetMapping("/ksfh")
//    @RequiresPermissions("purchaseCg:ksfh")
    public FebsResponse ksfh(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseCg purchaseCg = new PurchaseCg();
        purchaseCg.setId(id);
        purchaseCg.setKsfh((byte)1);
        purchaseCg.setKsfhr(user.getUsername());
        purchaseCg.setKsfhrq(new Date());
        this.purchaseCgService.updatePurchaseCg(purchaseCg);
        return new FebsResponse().success();
    }


    @ApiOperation("开始配货")
    @ControllerEndpoint(operation = "开始配货", exceptionMessage = "开始配货失败")
    @GetMapping("/ksph")
//    @RequiresPermissions("purchaseCg:ksph")
    public FebsResponse ksph(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseCg purchaseCg = new PurchaseCg();
        purchaseCg.setId(id);
        purchaseCg.setKsph((byte)1);
        purchaseCg.setKsphr(user.getUsername());
        purchaseCg.setKsphrq(new Date());
        this.purchaseCgService.updatePurchaseCg(purchaseCg);
        return new FebsResponse().success();
    }

    @ApiOperation("采购发货")
    @ControllerEndpoint(operation = "采购发货", exceptionMessage = "采购发货失败")
    @PostMapping("/cgfh")
//    @RequiresPermissions("purchaseCg:cgfh")
    public FebsResponse cgfh(PurchaseCg purchaseCg){
        User user = getCurrentUser();
        purchaseCg.setCgfh((byte)1);
        purchaseCg.setCgfhr(user.getUsername());
        purchaseCg.setCgfhrq(new Date());
        this.purchaseCgService.updatePurchaseCg(purchaseCg);
        return new FebsResponse().success();
    }

    @ApiOperation("运费录入")
    @ControllerEndpoint(operation = "运费录入", exceptionMessage = "运费录入失败")
    @PostMapping("/yflr")
//    @RequiresPermissions("purchaseCg:yflr")
    public FebsResponse yflr(PurchaseCgReq req){
        User user = getCurrentUser();
        PurchaseCg purchaseCg = new PurchaseCg();
        purchaseCg.setId(req.getId());
        purchaseCg.setYflr((byte)1);
        purchaseCg.setYflrr(user.getUsername());
        purchaseCg.setYflrrq(new Date());
        this.purchaseCgService.updatePurchaseCg(purchaseCg);
        return new FebsResponse().success();
    }
    @ApiOperation("印刷费录入")
    @ControllerEndpoint(operation = "印刷费录入", exceptionMessage = "印刷费录入失败")
    @PostMapping("/ysflr")
//    @RequiresPermissions("purchaseCg:ysflr")
    public FebsResponse ysflr(PurchaseCgReq req){
        User user = getCurrentUser();
        PurchaseCg purchaseCg = new PurchaseCg();
        purchaseCg.setId(req.getId());
        purchaseCg.setYsflr((byte)1);
        purchaseCg.setYsflrr(user.getUsername());
        purchaseCg.setYsflrrq(new Date());
        this.purchaseCgService.updatePurchaseCg(purchaseCg);
        return new FebsResponse().success();
    }
    @ApiOperation("生成退仓")
    @ControllerEndpoint(operation = "生成退仓", exceptionMessage = "生成退仓失败")
    @PostMapping("/sctc")
//    @RequiresPermissions("purchaseCg:sctc")
    public FebsResponse sctc(PurchaseCgReq req){
        User user = getCurrentUser();
        req.setSctcr(user.getUsername());
        cgBiz.sctc(req);
        return new FebsResponse().success();
    }
}
