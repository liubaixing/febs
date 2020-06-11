package com.febs.receipt.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.receipt.entity.OrderXstkmx;
import com.febs.receipt.service.IOrderXstkmxService;

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
 * 销售退款明细 Controller
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:13
 */
@Slf4j
@Validated
@RestController
@RequestMapping("orderXstkmx")
public class OrderXstkmxController extends BaseController {

    @Autowired
    private IOrderXstkmxService orderXstkmxService;


    @GetMapping("")
    @RequiresPermissions("orderXstkmx:list")
    public FebsResponse getAllOrderXstkmxs(OrderXstkmx orderXstkmx) {
        return new FebsResponse().success().data(orderXstkmxService.findOrderXstkmxs(orderXstkmx));
    }

    @GetMapping("/list")
    @RequiresPermissions("orderXstkmx:list")
    public FebsResponse orderXstkmxList(QueryRequest request, OrderXstkmx orderXstkmx) {
        Map<String, Object> dataTable = getDataTable(this.orderXstkmxService.findOrderXstkmxs(request, orderXstkmx));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增销售退款明细", exceptionMessage = "新增销售退款明细失败")
    @PostMapping("")
    @RequiresPermissions("orderXstkmx:add")
    public FebsResponse addOrderXstkmx(@Valid OrderXstkmx orderXstkmx) {
        this.orderXstkmxService.createOrderXstkmx(orderXstkmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除销售退款明细", exceptionMessage = "删除销售退款明细失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("orderXstkmx:delete")
    public FebsResponse deleteOrderXstkmx(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderXstkmxService.deleteOrderXstkmx(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改销售退款明细", exceptionMessage = "修改销售退款明细失败")
    @PostMapping("/update")
    @RequiresPermissions("orderXstkmx:update")
    public FebsResponse updateOrderXstkmx(OrderXstkmx orderXstkmx) {
        this.orderXstkmxService.updateOrderXstkmx(orderXstkmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("orderXstkmx:export")
    public void export(QueryRequest queryRequest, OrderXstkmx orderXstkmx, HttpServletResponse response) throws IOException {
        List<OrderXstkmx> orderXstkmxs = this.orderXstkmxService.findOrderXstkmxs(queryRequest, orderXstkmx).getRecords();
        ExcelUtil.export(orderXstkmxs, OrderXstkmx.class,"销售退款明细",response);
    }
}
