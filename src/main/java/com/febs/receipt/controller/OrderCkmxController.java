package com.febs.receipt.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.receipt.entity.OrderCkmx;
import com.febs.receipt.service.IOrderCkmxService;

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
 * 出库单明细 Controller
 *
 * @author liubaixing
 * @date 2020-07-03 22:44:06
 */
@Slf4j
@Validated
@RestController
@RequestMapping("orderCkmx")
public class OrderCkmxController extends BaseController {

    @Autowired
    private IOrderCkmxService orderCkmxService;


    @GetMapping("")
    @RequiresPermissions("orderCkmx:list")
    public FebsResponse getAllOrderCkmxs(OrderCkmx orderCkmx) {
        return new FebsResponse().success().data(orderCkmxService.findOrderCkmxs(orderCkmx));
    }

    @GetMapping("/list")
    @RequiresPermissions("orderCkmx:list")
    public FebsResponse orderCkmxList(QueryRequest request, OrderCkmx orderCkmx) {
        Map<String, Object> dataTable = getDataTable(this.orderCkmxService.findOrderCkmxs(request, orderCkmx));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增出库单明细", exceptionMessage = "新增出库单明细失败")
    @PostMapping("")
    @RequiresPermissions("orderCkmx:add")
    public FebsResponse addOrderCkmx(@Valid OrderCkmx orderCkmx) {
        this.orderCkmxService.createOrderCkmx(orderCkmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除出库单明细", exceptionMessage = "删除出库单明细失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("orderCkmx:delete")
    public FebsResponse deleteOrderCkmx(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderCkmxService.deleteOrderCkmx(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改出库单明细", exceptionMessage = "修改出库单明细失败")
    @PostMapping("/update")
    @RequiresPermissions("orderCkmx:update")
    public FebsResponse updateOrderCkmx(OrderCkmx orderCkmx) {
        this.orderCkmxService.updateOrderCkmx(orderCkmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("orderCkmx:export")
    public void export(QueryRequest queryRequest, OrderCkmx orderCkmx, HttpServletResponse response) throws IOException {
        List<OrderCkmx> orderCkmxs = this.orderCkmxService.findOrderCkmxs(queryRequest, orderCkmx).getRecords();
        ExcelUtil.export(orderCkmxs, OrderCkmx.class,"出库单明细",response);
    }
}
