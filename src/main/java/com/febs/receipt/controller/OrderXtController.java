package com.febs.receipt.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.receipt.entity.OrderXt;
import com.febs.receipt.service.IOrderXtService;

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
 * 销退单 Controller
 *
 * @author liubaixing
 * @date 2020-06-11 11:46:11
 */
@Slf4j
@Validated
@RestController
@RequestMapping("orderXt")
public class OrderXtController extends BaseController {

    @Autowired
    private IOrderXtService orderXtService;


    @GetMapping("")
    @RequiresPermissions("orderXt:list")
    public FebsResponse getAllOrderXts(OrderXt orderXt) {
        return new FebsResponse().success().data(orderXtService.findOrderXts(orderXt));
    }

    @GetMapping("/list")
    @RequiresPermissions("orderXt:list")
    public FebsResponse orderXtList(QueryRequest request, OrderXt orderXt) {
        Map<String, Object> dataTable = getDataTable(this.orderXtService.findOrderXts(request, orderXt));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增销退单", exceptionMessage = "新增销退单失败")
    @PostMapping("")
    @RequiresPermissions("orderXt:add")
    public FebsResponse addOrderXt(@Valid OrderXt orderXt) {
        this.orderXtService.createOrderXt(orderXt);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除销退单", exceptionMessage = "删除销退单失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("orderXt:delete")
    public FebsResponse deleteOrderXt(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderXtService.deleteOrderXt(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改销退单", exceptionMessage = "修改销退单失败")
    @PostMapping("/update")
    @RequiresPermissions("orderXt:update")
    public FebsResponse updateOrderXt(OrderXt orderXt) {
        this.orderXtService.updateOrderXt(orderXt);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("orderXt:export")
    public void export(QueryRequest queryRequest, OrderXt orderXt, HttpServletResponse response) throws IOException {
        List<OrderXt> orderXts = this.orderXtService.findOrderXts(queryRequest, orderXt).getRecords();
        ExcelUtil.export(orderXts, OrderXt.class,"销退单",response);
    }
}
