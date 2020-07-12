package com.febs.purchase.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.purchase.entity.PurchaseCgfpmx;
import com.febs.purchase.service.IPurchaseCgfpmxService;

import com.febs.purchase.vo.resp.PurchaseCgfpmxResp;
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
 * 采购发票明细 Controller
 *
 * @author liubaixing
 * @date 2020-06-27 19:55:24
 */
@Slf4j
@Validated
@RestController
@RequestMapping("purchaseCgfpmx")
public class PurchaseCgfpmxController extends BaseController {

    @Autowired
    private IPurchaseCgfpmxService purchaseCgfpmxService;


    @GetMapping("")
    @RequiresPermissions("purchaseCgfpmx:list")
    public FebsResponse getAllPurchaseCgfpmxs(PurchaseCgfpmx purchaseCgfpmx) {
        return new FebsResponse().success().data(purchaseCgfpmxService.findPurchaseCgfpmxs(purchaseCgfpmx));
    }

    @GetMapping("/list")
    @RequiresPermissions("purchaseCgfpmx:list")
    public FebsResponse purchaseCgfpmxList(QueryRequest request, PurchaseCgfpmx purchaseCgfpmx) {
        Map<String, Object> dataTable = getDataTable(this.purchaseCgfpmxService.findPurchaseCgfpmxs(request, purchaseCgfpmx));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增采购发票明细", exceptionMessage = "新增采购发票明细失败")
    @PostMapping("")
    @RequiresPermissions("purchaseCgfpmx:add")
    public FebsResponse addPurchaseCgfpmx(@Valid PurchaseCgfpmx purchaseCgfpmx) {
        this.purchaseCgfpmxService.createPurchaseCgfpmx(purchaseCgfpmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除采购发票明细", exceptionMessage = "删除采购发票明细失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("purchaseCgfpmx:delete")
    public FebsResponse deletePurchaseCgfpmx(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.purchaseCgfpmxService.deletePurchaseCgfpmx(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改采购发票明细", exceptionMessage = "修改采购发票明细失败")
    @PostMapping("/update")
    @RequiresPermissions("purchaseCgfpmx:update")
    public FebsResponse updatePurchaseCgfpmx(PurchaseCgfpmx purchaseCgfpmx) {
        this.purchaseCgfpmxService.updatePurchaseCgfpmx(purchaseCgfpmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("purchaseCgfpmx:export")
    public void export(QueryRequest queryRequest, PurchaseCgfpmx purchaseCgfpmx, HttpServletResponse response) throws IOException {
        List<PurchaseCgfpmxResp> purchaseCgfpmxs = this.purchaseCgfpmxService.findPurchaseCgfpmxs(queryRequest, purchaseCgfpmx).getRecords();
        ExcelUtil.export(purchaseCgfpmxs, PurchaseCgfpmxResp.class,"采购发票明细",response);
    }
}
