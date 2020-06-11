package com.febs.receipt.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.receipt.entity.OrderXs;
import com.febs.receipt.service.IOrderXsService;
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
 * 销售单 Controller
 *
 * @author liubaixing
 * @date 2020-06-11 11:36:56
 */
@Slf4j
@Validated
@RestController
@RequestMapping("orderXs")
public class OrderXsController extends BaseController {

    @Autowired
    private IOrderXsService orderXsService;


    @GetMapping("")
    @RequiresPermissions("orderXs:list")
    public FebsResponse getAllOrderXss(OrderXs orderXs) {
        return new FebsResponse().success().data(orderXsService.findOrderXss(orderXs));
    }

    @GetMapping("/list")
    @RequiresPermissions("orderXs:list")
    public FebsResponse orderXsList(QueryRequest request, OrderXs orderXs) {
        Map<String, Object> dataTable = getDataTable(this.orderXsService.findOrderXss(request, orderXs));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增销售单", exceptionMessage = "新增销售单失败")
    @PostMapping("")
    @RequiresPermissions("orderXs:add")
    public FebsResponse addOrderXs(@Valid OrderXs orderXs) {
        this.orderXsService.createOrderXs(orderXs);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除销售单", exceptionMessage = "删除销售单失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("orderXs:delete")
    public FebsResponse deleteOrderXs(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderXsService.deleteOrderXs(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改销售单", exceptionMessage = "修改销售单失败")
    @PostMapping("/update")
    @RequiresPermissions("orderXs:update")
    public FebsResponse updateOrderXs(OrderXs orderXs) {
        this.orderXsService.updateOrderXs(orderXs);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("orderXs:export")
    public void export(QueryRequest queryRequest, OrderXs orderXs, HttpServletResponse response) throws IOException {
        List<OrderXs> orderXss = this.orderXsService.findOrderXss(queryRequest, orderXs).getRecords();
        ExcelUtil.export(orderXss, OrderXs.class,"销售单",response);
    }
}
