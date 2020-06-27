package com.febs.purchase.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.purchase.entity.PurchaseTc;
import com.febs.purchase.service.IPurchaseTcService;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
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


    @GetMapping("")
    @RequiresPermissions("purchaseTc:list")
    public FebsResponse getAllPurchaseTcs(PurchaseTc purchaseTc) {
        return new FebsResponse().success().data(purchaseTcService.findPurchaseTcs(purchaseTc));
    }

    @GetMapping("/list")
    @RequiresPermissions("purchaseTc:list")
    public FebsResponse purchaseTcList(QueryRequest request, PurchaseTc purchaseTc) {
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
    public void export(QueryRequest queryRequest, PurchaseTc purchaseTc, HttpServletResponse response) throws IOException {
        List<PurchaseTc> purchaseTcs = this.purchaseTcService.findPurchaseTcs(queryRequest, purchaseTc).getRecords();
        ExcelUtil.export(purchaseTcs, PurchaseTc.class,"退仓单",response);
    }
}
