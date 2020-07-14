package com.febs.purchase.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.purchase.biz.PurchaseCgfkBiz;
import com.febs.purchase.entity.PurchaseCgfk;
import com.febs.purchase.service.IPurchaseCgfkService;

import com.febs.purchase.vo.req.PurchaseCgfkReq;
import com.febs.purchase.vo.resp.PurchaseCgfkResp;
import com.febs.system.entity.User;
import io.swagger.annotations.Api;
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

    @GetMapping("")
    @RequiresPermissions("purchaseCgfk:list")
    public FebsResponse getAllPurchaseCgfks(PurchaseCgfkReq purchaseCgfk) {
        return new FebsResponse().success().data(purchaseCgfkService.findPurchaseCgfks(purchaseCgfk));
    }

    @GetMapping("/list")
    @RequiresPermissions("purchaseCgfk:list")
    public FebsResponse purchaseCgfkList(QueryRequest request, PurchaseCgfkReq purchaseCgfk) {
        Map<String, Object> dataTable = getDataTable(this.purchaseCgfkService.findPurchaseCgfks(request, purchaseCgfk));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增采购付款", exceptionMessage = "新增采购付款失败")
    @PostMapping("")
    @RequiresPermissions("purchaseCgfk:add")
    public FebsResponse addPurchaseCgfk(@Valid PurchaseCgfk purchaseCgfk) {
        this.purchaseCgfkService.createPurchaseCgfk(purchaseCgfk);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除采购付款", exceptionMessage = "删除采购付款失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("purchaseCgfk:delete")
    public FebsResponse deletePurchaseCgfk(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.purchaseCgfkService.deletePurchaseCgfk(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改采购付款", exceptionMessage = "修改采购付款失败")
    @PostMapping("/update")
    @RequiresPermissions("purchaseCgfk:update")
    public FebsResponse updatePurchaseCgfk(PurchaseCgfk purchaseCgfk) {
        this.purchaseCgfkService.updatePurchaseCgfk(purchaseCgfk);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("purchaseCgfk:export")
    public void export(QueryRequest queryRequest, PurchaseCgfkReq purchaseCgfk, HttpServletResponse response) throws IOException {
        List<PurchaseCgfkResp> purchaseCgfks = this.purchaseCgfkService.findPurchaseCgfks(queryRequest, purchaseCgfk).getRecords();
        ExcelUtil.export(purchaseCgfks, PurchaseCgfkResp.class,"采购付款",response);
    }


    @ApiOperation("作废")
    @ControllerEndpoint(operation = "作废", exceptionMessage = "作废失败")
    @GetMapping("/zf/{id}")
    @RequiresPermissions("purchaseCgfk:zf")
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
    @RequiresPermissions("purchaseCgfk:qr")
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
    @RequiresPermissions("purchaseCgfk:sh")
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
    @GetMapping("/fk/{id}")
    @RequiresPermissions("purchaseCgfk:fk")
    public FebsResponse fk(@PathVariable Long id){
        User user = getCurrentUser();
        return new FebsResponse().success();
    }

    @ApiOperation("查看")
    @ControllerEndpoint(operation = "查看", exceptionMessage = "查看失败")
    @GetMapping("/view/{id}")
    @RequiresPermissions("purchaseCgfk:view")
    public FebsResponse view(@PathVariable Long id){
        return new FebsResponse().data(cgfkBiz.view(id));
    }

    @ApiOperation("开始生成")
    @ControllerEndpoint(operation = "生成", exceptionMessage = "生成失败")
    @PostMapping("/kssc")
    @RequiresPermissions("purchaseCgfk:kssc")
    public FebsResponse kssc(@RequestBody Long id){
        User user = getCurrentUser();
        return new FebsResponse().success();
    }

}
