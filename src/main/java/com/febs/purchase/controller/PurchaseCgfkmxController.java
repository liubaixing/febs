package com.febs.purchase.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.purchase.entity.PurchaseCgfkmx;
import com.febs.purchase.service.IPurchaseCgfkmxService;

import com.febs.purchase.vo.resp.PurchaseCgfkmxResp;
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
 * 采购付款明细 Controller
 *
 * @author liubaixing
 * @date 2020-06-27 20:02:41
 */
@Slf4j
@Validated
@RestController
@RequestMapping("purchaseCgfkmx")
public class PurchaseCgfkmxController extends BaseController {

    @Autowired
    private IPurchaseCgfkmxService purchaseCgfkmxService;


    @GetMapping("")
//    @RequiresPermissions("purchaseCgfkmx:list")
    public FebsResponse getAllPurchaseCgfkmxs(PurchaseCgfkmx purchaseCgfkmx) {
        return new FebsResponse().success().data(purchaseCgfkmxService.findPurchaseCgfkmxs(purchaseCgfkmx));
    }

    @GetMapping("/list")
//    @RequiresPermissions("purchaseCgfkmx:list")
    public FebsResponse purchaseCgfkmxList(QueryRequest request, PurchaseCgfkmx purchaseCgfkmx) {
        Map<String, Object> dataTable = getDataTable(this.purchaseCgfkmxService.findPurchaseCgfkmxs(request, purchaseCgfkmx));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增采购付款明细", exceptionMessage = "新增采购付款明细失败")
    @PostMapping("")
//    @RequiresPermissions("purchaseCgfkmx:add")
    public FebsResponse addPurchaseCgfkmx(@Valid PurchaseCgfkmx purchaseCgfkmx) {
        this.purchaseCgfkmxService.createPurchaseCgfkmx(purchaseCgfkmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除采购付款明细", exceptionMessage = "删除采购付款明细失败")
    @GetMapping("delete/{ids}")
//    @RequiresPermissions("purchaseCgfkmx:delete")
    public FebsResponse deletePurchaseCgfkmx(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.purchaseCgfkmxService.deletePurchaseCgfkmx(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改采购付款明细", exceptionMessage = "修改采购付款明细失败")
    @PostMapping("/update")
//    @RequiresPermissions("purchaseCgfkmx:update")
    public FebsResponse updatePurchaseCgfkmx(PurchaseCgfkmx purchaseCgfkmx) {
        this.purchaseCgfkmxService.updatePurchaseCgfkmx(purchaseCgfkmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
//    @RequiresPermissions("purchaseCgfkmx:export")
    public void export(QueryRequest queryRequest, PurchaseCgfkmx purchaseCgfkmx, HttpServletResponse response) throws IOException {
        List<PurchaseCgfkmxResp> purchaseCgfkmxs = this.purchaseCgfkmxService.findPurchaseCgfkmxs(queryRequest, purchaseCgfkmx).getRecords();
        ExcelUtil.export(purchaseCgfkmxs, PurchaseCgfkmxResp.class,"采购付款明细",response);
    }
}
