package com.febs.purchase.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.purchase.entity.PurchaseCgtk;
import com.febs.purchase.service.IPurchaseCgtkService;

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
 * 采购退款 Controller
 *
 * @author liubaixing
 * @date 2020-06-27 19:54:56
 */
@Slf4j
@Validated
@RestController
@RequestMapping("purchaseCgtk")
public class PurchaseCgtkController extends BaseController {

    @Autowired
    private IPurchaseCgtkService purchaseCgtkService;


    @GetMapping("")
    @RequiresPermissions("purchaseCgtk:list")
    public FebsResponse getAllPurchaseCgtks(PurchaseCgtk purchaseCgtk) {
        return new FebsResponse().success().data(purchaseCgtkService.findPurchaseCgtks(purchaseCgtk));
    }

    @GetMapping("/list")
    @RequiresPermissions("purchaseCgtk:list")
    public FebsResponse purchaseCgtkList(QueryRequest request, PurchaseCgtk purchaseCgtk) {
        Map<String, Object> dataTable = getDataTable(this.purchaseCgtkService.findPurchaseCgtks(request, purchaseCgtk));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增采购退款", exceptionMessage = "新增采购退款失败")
    @PostMapping("")
    @RequiresPermissions("purchaseCgtk:add")
    public FebsResponse addPurchaseCgtk(@Valid PurchaseCgtk purchaseCgtk) {
        this.purchaseCgtkService.createPurchaseCgtk(purchaseCgtk);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除采购退款", exceptionMessage = "删除采购退款失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("purchaseCgtk:delete")
    public FebsResponse deletePurchaseCgtk(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.purchaseCgtkService.deletePurchaseCgtk(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改采购退款", exceptionMessage = "修改采购退款失败")
    @PostMapping("/update")
    @RequiresPermissions("purchaseCgtk:update")
    public FebsResponse updatePurchaseCgtk(PurchaseCgtk purchaseCgtk) {
        this.purchaseCgtkService.updatePurchaseCgtk(purchaseCgtk);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("purchaseCgtk:export")
    public void export(QueryRequest queryRequest, PurchaseCgtk purchaseCgtk, HttpServletResponse response) throws IOException {
        List<PurchaseCgtk> purchaseCgtks = this.purchaseCgtkService.findPurchaseCgtks(queryRequest, purchaseCgtk).getRecords();
        ExcelUtil.export(purchaseCgtks, PurchaseCgtk.class,"采购退款",response);
    }
}
