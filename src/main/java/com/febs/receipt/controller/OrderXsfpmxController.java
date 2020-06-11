package com.febs.receipt.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.receipt.entity.OrderXsfpmx;
import com.febs.receipt.service.IOrderXsfpmxService;

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
 * 销售发票明细 Controller
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:07
 */
@Slf4j
@Validated
@RestController
@RequestMapping("orderXsfpmx")
public class OrderXsfpmxController extends BaseController {

    @Autowired
    private IOrderXsfpmxService orderXsfpmxService;


    @GetMapping("")
    @RequiresPermissions("orderXsfpmx:list")
    public FebsResponse getAllOrderXsfpmxs(OrderXsfpmx orderXsfpmx) {
        return new FebsResponse().success().data(orderXsfpmxService.findOrderXsfpmxs(orderXsfpmx));
    }

    @GetMapping("/list")
    @RequiresPermissions("orderXsfpmx:list")
    public FebsResponse orderXsfpmxList(QueryRequest request, OrderXsfpmx orderXsfpmx) {
        Map<String, Object> dataTable = getDataTable(this.orderXsfpmxService.findOrderXsfpmxs(request, orderXsfpmx));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增销售发票明细", exceptionMessage = "新增销售发票明细失败")
    @PostMapping("")
    @RequiresPermissions("orderXsfpmx:add")
    public FebsResponse addOrderXsfpmx(@Valid OrderXsfpmx orderXsfpmx) {
        this.orderXsfpmxService.createOrderXsfpmx(orderXsfpmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除销售发票明细", exceptionMessage = "删除销售发票明细失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("orderXsfpmx:delete")
    public FebsResponse deleteOrderXsfpmx(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderXsfpmxService.deleteOrderXsfpmx(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改销售发票明细", exceptionMessage = "修改销售发票明细失败")
    @PostMapping("/update")
    @RequiresPermissions("orderXsfpmx:update")
    public FebsResponse updateOrderXsfpmx(OrderXsfpmx orderXsfpmx) {
        this.orderXsfpmxService.updateOrderXsfpmx(orderXsfpmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("orderXsfpmx:export")
    public void export(QueryRequest queryRequest, OrderXsfpmx orderXsfpmx, HttpServletResponse response) throws IOException {
        List<OrderXsfpmx> orderXsfpmxs = this.orderXsfpmxService.findOrderXsfpmxs(queryRequest, orderXsfpmx).getRecords();
        ExcelUtil.export(orderXsfpmxs, OrderXsfpmx.class,"销售发票明细",response);
    }
}
