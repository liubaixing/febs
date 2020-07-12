package com.febs.purchase.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.purchase.entity.PurchaseCgtkmx;
import com.febs.purchase.service.IPurchaseCgtkmxService;

import com.febs.purchase.vo.resp.PurchaseCgtkmxResp;
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
 * 采购退款明细 Controller
 *
 * @author liubaixing
 * @date 2020-06-27 19:54:49
 */
@Slf4j
@Validated
@RestController
@RequestMapping("purchaseCgtkmx")
public class PurchaseCgtkmxController extends BaseController {

    @Autowired
    private IPurchaseCgtkmxService purchaseCgtkmxService;


    @GetMapping("")
    @RequiresPermissions("purchaseCgtkmx:list")
    public FebsResponse getAllPurchaseCgtkmxs(PurchaseCgtkmx purchaseCgtkmx) {
        return new FebsResponse().success().data(purchaseCgtkmxService.findPurchaseCgtkmxs(purchaseCgtkmx));
    }

    @GetMapping("/list")
    @RequiresPermissions("purchaseCgtkmx:list")
    public FebsResponse purchaseCgtkmxList(QueryRequest request, PurchaseCgtkmx purchaseCgtkmx) {
        Map<String, Object> dataTable = getDataTable(this.purchaseCgtkmxService.findPurchaseCgtkmxs(request, purchaseCgtkmx));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增采购退款明细", exceptionMessage = "新增采购退款明细失败")
    @PostMapping("")
    @RequiresPermissions("purchaseCgtkmx:add")
    public FebsResponse addPurchaseCgtkmx(@Valid PurchaseCgtkmx purchaseCgtkmx) {
        this.purchaseCgtkmxService.createPurchaseCgtkmx(purchaseCgtkmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除采购退款明细", exceptionMessage = "删除采购退款明细失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("purchaseCgtkmx:delete")
    public FebsResponse deletePurchaseCgtkmx(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.purchaseCgtkmxService.deletePurchaseCgtkmx(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改采购退款明细", exceptionMessage = "修改采购退款明细失败")
    @PostMapping("/update")
    @RequiresPermissions("purchaseCgtkmx:update")
    public FebsResponse updatePurchaseCgtkmx(PurchaseCgtkmx purchaseCgtkmx) {
        this.purchaseCgtkmxService.updatePurchaseCgtkmx(purchaseCgtkmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("purchaseCgtkmx:export")
    public void export(QueryRequest queryRequest, PurchaseCgtkmx purchaseCgtkmx, HttpServletResponse response) throws IOException {
        List<PurchaseCgtkmxResp> purchaseCgtkmxs = this.purchaseCgtkmxService.findPurchaseCgtkmxs(queryRequest, purchaseCgtkmx).getRecords();
        ExcelUtil.export(purchaseCgtkmxs, PurchaseCgtkmxResp.class,"采购退款明细",response);
    }
}
