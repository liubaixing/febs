package com.febs.receipt.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.receipt.entity.OrderXssk;
import com.febs.receipt.service.IOrderXsskService;

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
 * 销售收款 Controller
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:18
 */
@Slf4j
@Validated
@RestController
@RequestMapping("orderXssk")
public class OrderXsskController extends BaseController {

    @Autowired
    private IOrderXsskService orderXsskService;


    @GetMapping("")
    @RequiresPermissions("orderXssk:list")
    public FebsResponse getAllOrderXssks(OrderXssk orderXssk) {
        return new FebsResponse().success().data(orderXsskService.findOrderXssks(orderXssk));
    }

    @GetMapping("/list")
    @RequiresPermissions("orderXssk:list")
    public FebsResponse orderXsskList(QueryRequest request, OrderXssk orderXssk) {
        Map<String, Object> dataTable = getDataTable(this.orderXsskService.findOrderXssks(request, orderXssk));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增销售收款", exceptionMessage = "新增销售收款失败")
    @PostMapping("")
    @RequiresPermissions("orderXssk:add")
    public FebsResponse addOrderXssk(@Valid OrderXssk orderXssk) {
        this.orderXsskService.createOrderXssk(orderXssk);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除销售收款", exceptionMessage = "删除销售收款失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("orderXssk:delete")
    public FebsResponse deleteOrderXssk(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderXsskService.deleteOrderXssk(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改销售收款", exceptionMessage = "修改销售收款失败")
    @PostMapping("/update")
    @RequiresPermissions("orderXssk:update")
    public FebsResponse updateOrderXssk(OrderXssk orderXssk) {
        this.orderXsskService.updateOrderXssk(orderXssk);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("orderXssk:export")
    public void export(QueryRequest queryRequest, OrderXssk orderXssk, HttpServletResponse response) throws IOException {
        List<OrderXssk> orderXssks = this.orderXsskService.findOrderXssks(queryRequest, orderXssk).getRecords();
        ExcelUtil.export(orderXssks, OrderXssk.class,"销售收款",response);
    }
}
