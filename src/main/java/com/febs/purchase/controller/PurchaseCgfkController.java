package com.febs.purchase.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.purchase.entity.PurchaseCgfk;
import com.febs.purchase.service.IPurchaseCgfkService;

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
 * 采购付款 Controller
 *
 * @author liubaixing
 * @date 2020-06-27 19:46:20
 */
@Slf4j
@Validated
@RestController
@RequestMapping("purchaseCgfk")
public class PurchaseCgfkController extends BaseController {

    @Autowired
    private IPurchaseCgfkService purchaseCgfkService;


    @GetMapping("")
    @RequiresPermissions("purchaseCgfk:list")
    public FebsResponse getAllPurchaseCgfks(PurchaseCgfk purchaseCgfk) {
        return new FebsResponse().success().data(purchaseCgfkService.findPurchaseCgfks(purchaseCgfk));
    }

    @GetMapping("/list")
    @RequiresPermissions("purchaseCgfk:list")
    public FebsResponse purchaseCgfkList(QueryRequest request, PurchaseCgfk purchaseCgfk) {
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
    public void export(QueryRequest queryRequest, PurchaseCgfk purchaseCgfk, HttpServletResponse response) throws IOException {
        List<PurchaseCgfk> purchaseCgfks = this.purchaseCgfkService.findPurchaseCgfks(queryRequest, purchaseCgfk).getRecords();
        ExcelUtil.export(purchaseCgfks, PurchaseCgfk.class,"采购付款",response);
    }
}
