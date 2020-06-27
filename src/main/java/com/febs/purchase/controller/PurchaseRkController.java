package com.febs.purchase.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.purchase.entity.PurchaseRk;
import com.febs.purchase.service.IPurchaseRkService;

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
 * 入库单 Controller
 *
 * @author liubaixing
 * @date 2020-06-27 19:56:08
 */
@Slf4j
@Validated
@RestController
@RequestMapping("purchaseRk")
public class PurchaseRkController extends BaseController {

    @Autowired
    private IPurchaseRkService purchaseRkService;


    @GetMapping("")
    @RequiresPermissions("purchaseRk:list")
    public FebsResponse getAllPurchaseRks(PurchaseRk purchaseRk) {
        return new FebsResponse().success().data(purchaseRkService.findPurchaseRks(purchaseRk));
    }

    @GetMapping("/list")
    @RequiresPermissions("purchaseRk:list")
    public FebsResponse purchaseRkList(QueryRequest request, PurchaseRk purchaseRk) {
        Map<String, Object> dataTable = getDataTable(this.purchaseRkService.findPurchaseRks(request, purchaseRk));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增入库单", exceptionMessage = "新增入库单失败")
    @PostMapping("")
    @RequiresPermissions("purchaseRk:add")
    public FebsResponse addPurchaseRk(@Valid PurchaseRk purchaseRk) {
        this.purchaseRkService.createPurchaseRk(purchaseRk);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除入库单", exceptionMessage = "删除入库单失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("purchaseRk:delete")
    public FebsResponse deletePurchaseRk(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.purchaseRkService.deletePurchaseRk(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改入库单", exceptionMessage = "修改入库单失败")
    @PostMapping("/update")
    @RequiresPermissions("purchaseRk:update")
    public FebsResponse updatePurchaseRk(PurchaseRk purchaseRk) {
        this.purchaseRkService.updatePurchaseRk(purchaseRk);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("purchaseRk:export")
    public void export(QueryRequest queryRequest, PurchaseRk purchaseRk, HttpServletResponse response) throws IOException {
        List<PurchaseRk> purchaseRks = this.purchaseRkService.findPurchaseRks(queryRequest, purchaseRk).getRecords();
        ExcelUtil.export(purchaseRks, PurchaseRk.class,"入库单",response);
    }
}
