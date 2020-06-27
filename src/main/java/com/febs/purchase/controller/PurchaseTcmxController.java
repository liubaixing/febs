package com.febs.purchase.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.purchase.entity.PurchaseTcmx;
import com.febs.purchase.service.IPurchaseTcmxService;

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
 * 退仓单明细 Controller
 *
 * @author liubaixing
 * @date 2020-06-27 19:55:35
 */
@Slf4j
@Validated
@RestController
@RequestMapping("purchaseTcmx")
public class PurchaseTcmxController extends BaseController {

    @Autowired
    private IPurchaseTcmxService purchaseTcmxService;


    @GetMapping("")
    @RequiresPermissions("purchaseTcmx:list")
    public FebsResponse getAllPurchaseTcmxs(PurchaseTcmx purchaseTcmx) {
        return new FebsResponse().success().data(purchaseTcmxService.findPurchaseTcmxs(purchaseTcmx));
    }

    @GetMapping("/list")
    @RequiresPermissions("purchaseTcmx:list")
    public FebsResponse purchaseTcmxList(QueryRequest request, PurchaseTcmx purchaseTcmx) {
        Map<String, Object> dataTable = getDataTable(this.purchaseTcmxService.findPurchaseTcmxs(request, purchaseTcmx));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增退仓单明细", exceptionMessage = "新增退仓单明细失败")
    @PostMapping("")
    @RequiresPermissions("purchaseTcmx:add")
    public FebsResponse addPurchaseTcmx(@Valid PurchaseTcmx purchaseTcmx) {
        this.purchaseTcmxService.createPurchaseTcmx(purchaseTcmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除退仓单明细", exceptionMessage = "删除退仓单明细失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("purchaseTcmx:delete")
    public FebsResponse deletePurchaseTcmx(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.purchaseTcmxService.deletePurchaseTcmx(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改退仓单明细", exceptionMessage = "修改退仓单明细失败")
    @PostMapping("/update")
    @RequiresPermissions("purchaseTcmx:update")
    public FebsResponse updatePurchaseTcmx(PurchaseTcmx purchaseTcmx) {
        this.purchaseTcmxService.updatePurchaseTcmx(purchaseTcmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("purchaseTcmx:export")
    public void export(QueryRequest queryRequest, PurchaseTcmx purchaseTcmx, HttpServletResponse response) throws IOException {
        List<PurchaseTcmx> purchaseTcmxs = this.purchaseTcmxService.findPurchaseTcmxs(queryRequest, purchaseTcmx).getRecords();
        ExcelUtil.export(purchaseTcmxs, PurchaseTcmx.class,"退仓单明细",response);
    }
}
