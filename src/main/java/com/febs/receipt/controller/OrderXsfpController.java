package com.febs.receipt.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.receipt.entity.OrderXsfp;
import com.febs.receipt.service.IOrderXsfpService;

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
 * 销售发票 Controller
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:16
 */
@Slf4j
@Validated
@RestController
@RequestMapping("orderXsfp")
public class OrderXsfpController extends BaseController {

    @Autowired
    private IOrderXsfpService orderXsfpService;


    @GetMapping("")
    @RequiresPermissions("orderXsfp:list")
    public FebsResponse getAllOrderXsfps(OrderXsfp orderXsfp) {
        return new FebsResponse().success().data(orderXsfpService.findOrderXsfps(orderXsfp));
    }

    @GetMapping("/list")
    @RequiresPermissions("orderXsfp:list")
    public FebsResponse orderXsfpList(QueryRequest request, OrderXsfp orderXsfp) {
        Map<String, Object> dataTable = getDataTable(this.orderXsfpService.findOrderXsfps(request, orderXsfp));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增销售发票", exceptionMessage = "新增销售发票失败")
    @PostMapping("")
    @RequiresPermissions("orderXsfp:add")
    public FebsResponse addOrderXsfp(@Valid OrderXsfp orderXsfp) {
        this.orderXsfpService.createOrderXsfp(orderXsfp);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除销售发票", exceptionMessage = "删除销售发票失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("orderXsfp:delete")
    public FebsResponse deleteOrderXsfp(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderXsfpService.deleteOrderXsfp(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改销售发票", exceptionMessage = "修改销售发票失败")
    @PostMapping("/update")
    @RequiresPermissions("orderXsfp:update")
    public FebsResponse updateOrderXsfp(OrderXsfp orderXsfp) {
        this.orderXsfpService.updateOrderXsfp(orderXsfp);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("orderXsfp:export")
    public void export(QueryRequest queryRequest, OrderXsfp orderXsfp, HttpServletResponse response) throws IOException {
        List<OrderXsfp> orderXsfps = this.orderXsfpService.findOrderXsfps(queryRequest, orderXsfp).getRecords();
        ExcelUtil.export(orderXsfps, OrderXsfp.class,"销售发票",response);
    }
}
