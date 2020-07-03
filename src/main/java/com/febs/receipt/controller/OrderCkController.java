package com.febs.receipt.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.receipt.entity.OrderCk;
import com.febs.receipt.service.IOrderCkService;

import com.febs.receipt.vo.req.OrderCkReq;
import com.febs.receipt.vo.resp.OrderCkResp;
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
 * 出库单 Controller
 *
 * @author liubaixing
 * @date 2020-07-03 22:44:01
 */
@Slf4j
@Validated
@RestController
@RequestMapping("orderCk")
public class OrderCkController extends BaseController {

    @Autowired
    private IOrderCkService orderCkService;


    @GetMapping("")
    @RequiresPermissions("orderCk:list")
    public FebsResponse getAllOrderCks(OrderCk orderCk) {
        return new FebsResponse().success().data(orderCkService.findOrderCks(orderCk));
    }

    @GetMapping("/list")
    @RequiresPermissions("orderCk:list")
    public FebsResponse orderCkList(QueryRequest request, OrderCkReq orderCk) {
        Map<String, Object> dataTable = getDataTable(this.orderCkService.findOrderCks(request, orderCk));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增出库单", exceptionMessage = "新增出库单失败")
    @PostMapping("")
    @RequiresPermissions("orderCk:add")
    public FebsResponse addOrderCk(@Valid OrderCk orderCk) {
        this.orderCkService.createOrderCk(orderCk);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除出库单", exceptionMessage = "删除出库单失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("orderCk:delete")
    public FebsResponse deleteOrderCk(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderCkService.deleteOrderCk(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改出库单", exceptionMessage = "修改出库单失败")
    @PostMapping("/update")
    @RequiresPermissions("orderCk:update")
    public FebsResponse updateOrderCk(OrderCk orderCk) {
        this.orderCkService.updateOrderCk(orderCk);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("orderCk:export")
    public void export(QueryRequest queryRequest, OrderCkReq orderCk, HttpServletResponse response) throws IOException {
        List<OrderCkResp> orderCks = this.orderCkService.findOrderCks(queryRequest, orderCk).getRecords();
        ExcelUtil.export(orderCks, OrderCkResp.class,"出库单",response);
    }
}
