package com.febs.purchase.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.purchase.entity.PurchaseRkmx;
import com.febs.purchase.service.IPurchaseRkmxService;

import com.febs.purchase.vo.resp.PurchaseRkmxResp;
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
 * 入库单明细 Controller
 *
 * @author liubaixing
 * @date 2020-06-27 19:56:10
 */
@Slf4j
@Validated
@RestController
@RequestMapping("purchaseRkmx")
public class PurchaseRkmxController extends BaseController {

    @Autowired
    private IPurchaseRkmxService purchaseRkmxService;


    @GetMapping("")
    @RequiresPermissions("purchaseRkmx:list")
    public FebsResponse getAllPurchaseRkmxs(PurchaseRkmx purchaseRkmx) {
        return new FebsResponse().success().data(purchaseRkmxService.findPurchaseRkmxs(purchaseRkmx));
    }

    @GetMapping("/list")
    @RequiresPermissions("purchaseRkmx:list")
    public FebsResponse purchaseRkmxList(QueryRequest request, PurchaseRkmx purchaseRkmx) {
        Map<String, Object> dataTable = getDataTable(this.purchaseRkmxService.findPurchaseRkmxs(request, purchaseRkmx));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增入库单明细", exceptionMessage = "新增入库单明细失败")
    @PostMapping("")
    @RequiresPermissions("purchaseRkmx:add")
    public FebsResponse addPurchaseRkmx(@Valid PurchaseRkmx purchaseRkmx) {
        this.purchaseRkmxService.createPurchaseRkmx(purchaseRkmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除入库单明细", exceptionMessage = "删除入库单明细失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("purchaseRkmx:delete")
    public FebsResponse deletePurchaseRkmx(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.purchaseRkmxService.deletePurchaseRkmx(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改入库单明细", exceptionMessage = "修改入库单明细失败")
    @PostMapping("/update")
    @RequiresPermissions("purchaseRkmx:update")
    public FebsResponse updatePurchaseRkmx(PurchaseRkmx purchaseRkmx) {
        this.purchaseRkmxService.updatePurchaseRkmx(purchaseRkmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("purchaseRkmx:export")
    public void export(QueryRequest queryRequest, PurchaseRkmx purchaseRkmx, HttpServletResponse response) throws IOException {
        List<PurchaseRkmxResp> purchaseRkmxs = this.purchaseRkmxService.findPurchaseRkmxs(queryRequest, purchaseRkmx).getRecords();
        ExcelUtil.export(purchaseRkmxs, PurchaseRkmxResp.class,"入库单明细",response);
    }
}
