package com.febs.purchase.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.purchase.entity.PurchaseCgmx;
import com.febs.purchase.service.IPurchaseCgmxService;

import com.febs.purchase.vo.resp.PurchaseCgmxResp;
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
 * 采购单明细 Controller
 *
 * @author liubaixing
 * @date 2020-06-27 19:46:14
 */
@Slf4j
@Validated
@RestController
@RequestMapping("purchaseCgmx")
public class PurchaseCgmxController extends BaseController {

    @Autowired
    private IPurchaseCgmxService purchaseCgmxService;


    @GetMapping("")
//    @RequiresPermissions("purchaseCgmx:list")
    public FebsResponse getAllPurchaseCgmxs(PurchaseCgmx purchaseCgmx) {
        return new FebsResponse().success().data(purchaseCgmxService.findPurchaseCgmxs(purchaseCgmx));
    }

    @GetMapping("/list")
//    @RequiresPermissions("purchaseCgmx:list")
    public FebsResponse purchaseCgmxList(QueryRequest request, PurchaseCgmx purchaseCgmx) {
        Map<String, Object> dataTable = getDataTable(this.purchaseCgmxService.findPurchaseCgmxs(request, purchaseCgmx));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增采购单明细", exceptionMessage = "新增采购单明细失败")
    @PostMapping("")
//    @RequiresPermissions("purchaseCgmx:add")
    public FebsResponse addPurchaseCgmx(@Valid PurchaseCgmx purchaseCgmx) {
        this.purchaseCgmxService.createPurchaseCgmx(purchaseCgmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除采购单明细", exceptionMessage = "删除采购单明细失败")
    @GetMapping("delete/{ids}")
//    @RequiresPermissions("purchaseCgmx:delete")
    public FebsResponse deletePurchaseCgmx(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.purchaseCgmxService.deletePurchaseCgmx(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改采购单明细", exceptionMessage = "修改采购单明细失败")
    @PostMapping("/update")
//    @RequiresPermissions("purchaseCgmx:update")
    public FebsResponse updatePurchaseCgmx(PurchaseCgmx purchaseCgmx) {
        this.purchaseCgmxService.updatePurchaseCgmx(purchaseCgmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
//    @RequiresPermissions("purchaseCgmx:export")
    public void export(QueryRequest queryRequest, PurchaseCgmx purchaseCgmx, HttpServletResponse response) throws IOException {
        List<PurchaseCgmxResp> purchaseCgmxs = this.purchaseCgmxService.findPurchaseCgmxs(queryRequest, purchaseCgmx).getRecords();
        ExcelUtil.export(purchaseCgmxs, PurchaseCgmxResp.class,"采购单明细",response);
    }
}
