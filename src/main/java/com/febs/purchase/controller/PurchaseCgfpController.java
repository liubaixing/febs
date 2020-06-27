package com.febs.purchase.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.purchase.entity.PurchaseCgfp;
import com.febs.purchase.service.IPurchaseCgfpService;

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
 * 采购发票 Controller
 *
 * @author liubaixing
 * @date 2020-06-27 19:55:27
 */
@Slf4j
@Validated
@RestController
@RequestMapping("purchaseCgfp")
public class PurchaseCgfpController extends BaseController {

    @Autowired
    private IPurchaseCgfpService purchaseCgfpService;


    @GetMapping("")
    @RequiresPermissions("purchaseCgfp:list")
    public FebsResponse getAllPurchaseCgfps(PurchaseCgfp purchaseCgfp) {
        return new FebsResponse().success().data(purchaseCgfpService.findPurchaseCgfps(purchaseCgfp));
    }

    @GetMapping("/list")
    @RequiresPermissions("purchaseCgfp:list")
    public FebsResponse purchaseCgfpList(QueryRequest request, PurchaseCgfp purchaseCgfp) {
        Map<String, Object> dataTable = getDataTable(this.purchaseCgfpService.findPurchaseCgfps(request, purchaseCgfp));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增采购发票", exceptionMessage = "新增采购发票失败")
    @PostMapping("")
    @RequiresPermissions("purchaseCgfp:add")
    public FebsResponse addPurchaseCgfp(@Valid PurchaseCgfp purchaseCgfp) {
        this.purchaseCgfpService.createPurchaseCgfp(purchaseCgfp);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除采购发票", exceptionMessage = "删除采购发票失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("purchaseCgfp:delete")
    public FebsResponse deletePurchaseCgfp(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.purchaseCgfpService.deletePurchaseCgfp(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改采购发票", exceptionMessage = "修改采购发票失败")
    @PostMapping("/update")
    @RequiresPermissions("purchaseCgfp:update")
    public FebsResponse updatePurchaseCgfp(PurchaseCgfp purchaseCgfp) {
        this.purchaseCgfpService.updatePurchaseCgfp(purchaseCgfp);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("purchaseCgfp:export")
    public void export(QueryRequest queryRequest, PurchaseCgfp purchaseCgfp, HttpServletResponse response) throws IOException {
        List<PurchaseCgfp> purchaseCgfps = this.purchaseCgfpService.findPurchaseCgfps(queryRequest, purchaseCgfp).getRecords();
        ExcelUtil.export(purchaseCgfps, PurchaseCgfp.class,"采购发票",response);
    }
}
