package com.febs.purchase.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.purchase.entity.PurchaseCg;
import com.febs.purchase.service.IPurchaseCgService;

import com.febs.purchase.vo.req.PurchaseCgReq;
import com.febs.purchase.vo.resp.PurchaseCgResp;
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
 * 采购单 Controller
 *
 * @author liubaixing
 * @date 2020-06-27 19:45:59
 */
@Slf4j
@Validated
@RestController
@RequestMapping("purchaseCg")
public class PurchaseCgController extends BaseController {

    @Autowired
    private IPurchaseCgService purchaseCgService;


    @GetMapping("")
    @RequiresPermissions("purchaseCg:list")
    public FebsResponse getAllPurchaseCgs(PurchaseCg purchaseCg) {
        return new FebsResponse().success().data(purchaseCgService.findPurchaseCgs(purchaseCg));
    }

    @GetMapping("/list")
    @RequiresPermissions("purchaseCg:list")
    public FebsResponse purchaseCgList(QueryRequest request, PurchaseCgReq purchaseCg) {
        Map<String, Object> dataTable = getDataTable(this.purchaseCgService.findPurchaseCgs(request, purchaseCg));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增采购单", exceptionMessage = "新增采购单失败")
    @PostMapping("")
    @RequiresPermissions("purchaseCg:add")
    public FebsResponse addPurchaseCg(@Valid PurchaseCg purchaseCg) {
        this.purchaseCgService.createPurchaseCg(purchaseCg);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除采购单", exceptionMessage = "删除采购单失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("purchaseCg:delete")
    public FebsResponse deletePurchaseCg(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.purchaseCgService.deletePurchaseCg(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改采购单", exceptionMessage = "修改采购单失败")
    @PostMapping("/update")
    @RequiresPermissions("purchaseCg:update")
    public FebsResponse updatePurchaseCg(PurchaseCg purchaseCg) {
        this.purchaseCgService.updatePurchaseCg(purchaseCg);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("purchaseCg:export")
    public void export(QueryRequest queryRequest, PurchaseCgReq purchaseCg, HttpServletResponse response) throws IOException {
        List<PurchaseCgResp> purchaseCgs = this.purchaseCgService.findPurchaseCgs(queryRequest, purchaseCg).getRecords();
        ExcelUtil.export(purchaseCgs, PurchaseCgResp.class,"采购单",response);
    }
}
