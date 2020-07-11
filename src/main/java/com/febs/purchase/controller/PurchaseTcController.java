package com.febs.purchase.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.purchase.biz.PurchaseTcBiz;
import com.febs.purchase.entity.PurchaseTc;
import com.febs.purchase.service.IPurchaseTcService;

import com.febs.purchase.vo.req.PurchaseTcReq;
import com.febs.purchase.vo.resp.PurchaseTcResp;
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
 * 退仓单 Controller
 *
 * @author liubaixing
 * @date 2020-06-27 19:55:32
 */
@Slf4j
@Validated
@RestController
@RequestMapping("purchaseTc")
public class PurchaseTcController extends BaseController {

    @Autowired
    private IPurchaseTcService purchaseTcService;

    @Autowired
    private PurchaseTcBiz tcBiz;

    @GetMapping("")
    @RequiresPermissions("purchaseTc:list")
    public FebsResponse getAllPurchaseTcs(PurchaseTcReq purchaseTc) {
        return new FebsResponse().success().data(purchaseTcService.findPurchaseTcs(purchaseTc));
    }

    @GetMapping("/list")
    @RequiresPermissions("purchaseTc:list")
    public FebsResponse purchaseTcList(QueryRequest request, PurchaseTcReq purchaseTc) {
        Map<String, Object> dataTable = getDataTable(this.purchaseTcService.findPurchaseTcs(request, purchaseTc));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增退仓单", exceptionMessage = "新增退仓单失败")
    @PostMapping("")
    @RequiresPermissions("purchaseTc:add")
    public FebsResponse addPurchaseTc(@Valid PurchaseTc purchaseTc) {
        this.purchaseTcService.createPurchaseTc(purchaseTc);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除退仓单", exceptionMessage = "删除退仓单失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("purchaseTc:delete")
    public FebsResponse deletePurchaseTc(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.purchaseTcService.deletePurchaseTc(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改退仓单", exceptionMessage = "修改退仓单失败")
    @PostMapping("/update")
    @RequiresPermissions("purchaseTc:update")
    public FebsResponse updatePurchaseTc(PurchaseTc purchaseTc) {
        this.purchaseTcService.updatePurchaseTc(purchaseTc);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("purchaseTc:export")
    public void export(QueryRequest queryRequest, PurchaseTcReq purchaseTc, HttpServletResponse response) throws IOException {
        List<PurchaseTcResp> purchaseTcs = this.purchaseTcService.findPurchaseTcs(queryRequest, purchaseTc).getRecords();
        ExcelUtil.export(purchaseTcs, PurchaseTcResp.class,"退仓单",response);
    }

    @ApiOperation("查看")
    @ControllerEndpoint(operation = "查看退仓单", exceptionMessage = "查看退仓单失败")
    @GetMapping("/view/{id}")
    @RequiresPermissions("purchaseTc:view")
    public FebsResponse view(@PathVariable Long id){
        return new FebsResponse().data(tcBiz.view(id));
    }


    @ApiOperation("确认")
    @ControllerEndpoint(operation = "确认退仓单", exceptionMessage = "确认退仓单失败")
    @GetMapping("/confirm/{id}")
    @RequiresPermissions("purchaseTc:confirm")
    public FebsResponse confirm(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseTc purchaseTc = new PurchaseTc();
        purchaseTc.setId(id );
        purchaseTc.setQr((byte)1);
        purchaseTc.setQrr(user.getUsername());
        purchaseTc.setQrrq(new Date());
        this.purchaseTcService.updatePurchaseTc(purchaseTc);
        return new FebsResponse().success();
    }

    @ApiOperation("审核")
    @ControllerEndpoint(operation = "审核退仓单", exceptionMessage = "审核退仓单失败")
    @GetMapping("/check/{id}")
    @RequiresPermissions("purchaseTc:check")
    public FebsResponse check(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseTc purchaseTc = new PurchaseTc();
        purchaseTc.setId(id );
        purchaseTc.setSh((byte)1);
        purchaseTc.setShr(user.getUsername());
        purchaseTc.setShrq(new Date());
        this.purchaseTcService.updatePurchaseTc(purchaseTc);
        return new FebsResponse().success();
    }


    @ApiOperation("关闭")
    @ControllerEndpoint(operation = "关闭退仓单", exceptionMessage = "关闭退仓单失败")
    @GetMapping("/close/{id}")
    @RequiresPermissions("purchaseTc:close")
    public FebsResponse close(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseTc purchaseTc = new PurchaseTc();
        purchaseTc.setId(id );
        purchaseTc.setZs((byte)1);
        purchaseTc.setZsr(user.getUsername());
        purchaseTc.setZsrq(new Date());
        this.purchaseTcService.updatePurchaseTc(purchaseTc);
        return new FebsResponse().success();
    }


    @ApiOperation("开始退仓")
    @ControllerEndpoint(operation = "开始退仓", exceptionMessage = "开始退仓失败")
    @GetMapping("/kstc/{id}")
    @RequiresPermissions("purchaseTc:kstc")
    public FebsResponse kstc(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseTc purchaseTc = new PurchaseTc();
        purchaseTc.setId(id );
        purchaseTc.setKstc((byte)1);
        purchaseTc.setKstcr(user.getUsername());
        purchaseTc.setKstcrq(new Date());
        this.purchaseTcService.updatePurchaseTc(purchaseTc);
        return new FebsResponse().success();
    }

    @ApiOperation("退仓发货")
    @ControllerEndpoint(operation = "退仓发货", exceptionMessage = "退仓发货失败")
    @PostMapping("/tcfh/{id}")
    @RequiresPermissions("purchaseTc:tcfh")
    public FebsResponse tcfh(@RequestBody PurchaseTc purchaseTc){
        User user = getCurrentUser();
        purchaseTc.setTcfh((byte)1);
        purchaseTc.setTcfhr(user.getUsername());
        purchaseTc.setTcfhrq(new Date());
        this.purchaseTcService.updatePurchaseTc(purchaseTc);
        return new FebsResponse().success();
    }


    @ApiOperation("运费录入")
    @ControllerEndpoint(operation = "运费录入", exceptionMessage = "运费录入失败")
    @PostMapping("/yflr")
    @RequiresPermissions("purchaseTc:yflr")
    public FebsResponse yflr(@RequestBody PurchaseTcReq req){
        User user = getCurrentUser();
        PurchaseTc purchaseTc = new PurchaseTc();
        purchaseTc.setId(req.getId());
        purchaseTc.setYflr((byte)1);
        purchaseTc.setYflrr(user.getUsername());
        purchaseTc.setYflrrq(new Date());
        this.purchaseTcService.updatePurchaseTc(purchaseTc);
        return new FebsResponse().success();
    }
    @ApiOperation("印刷费录入")
    @ControllerEndpoint(operation = "印刷费录入", exceptionMessage = "印刷费录入失败")
    @PostMapping("/ysflr")
    @RequiresPermissions("purchaseTc:ysflr")
    public FebsResponse ysflr(@RequestBody PurchaseTcReq req){
        User user = getCurrentUser();
        PurchaseTc purchaseTc = new PurchaseTc();
        purchaseTc.setId(req.getId());
        purchaseTc.setYsflr((byte)1);
        purchaseTc.setYsflrr(user.getUsername());
        purchaseTc.setYsflrrq(new Date());
        this.purchaseTcService.updatePurchaseTc(purchaseTc);
        return new FebsResponse().success();
    }

    @ApiOperation("开始收货")
    @ControllerEndpoint(operation = "开始收货", exceptionMessage = "开始收货失败")
    @GetMapping("/kssh/{id}")
    @RequiresPermissions("purchaseTc:kssh")
    public FebsResponse kssh(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseTc purchaseTc = new PurchaseTc();
        purchaseTc.setId(id);
        purchaseTc.setKssh((byte)1);
        purchaseTc.setKsshr(user.getUsername());
        purchaseTc.setKsshrq(new Date());
        this.purchaseTcService.updatePurchaseTc(purchaseTc);
        return new FebsResponse().success();
    }

    @ApiOperation("收货确认")
    @ControllerEndpoint(operation = "收货确认", exceptionMessage = "收货确认失败")
    @GetMapping("/shqr/{id}")
    @RequiresPermissions("purchaseTc:shqr")
    public FebsResponse shqr(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseTc purchaseTc = new PurchaseTc();
        purchaseTc.setId(id);
        purchaseTc.setShqr((byte)1);
        purchaseTc.setShqrr(user.getUsername());
        purchaseTc.setShqrrq(new Date());
        this.purchaseTcService.updatePurchaseTc(purchaseTc);
        return new FebsResponse().success();
    }

}
