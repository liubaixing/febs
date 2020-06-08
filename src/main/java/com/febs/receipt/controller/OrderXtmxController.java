package com.febs.receipt.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.receipt.entity.OrderXtmx;
import com.febs.receipt.service.IOrderXtmxService;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * 销退单明细 Controller
 *
 * @author liubaixing
 * @date 2020-06-02 13:38:50
 */
@Slf4j
@Validated
@RestController
@RequestMapping("orderXtmx")
public class OrderXtmxController extends BaseController {

    @Autowired
    private IOrderXtmxService orderXtmxService;


    @GetMapping("")
    @RequiresPermissions("orderXtmx:list")
    public FebsResponse getAllOrderXtmxs(OrderXtmx orderXtmx) {
        return new FebsResponse().success().data(orderXtmxService.findOrderXtmxs(orderXtmx));
    }

    @GetMapping("/list")
    @RequiresPermissions("orderXtmx:list")
    public FebsResponse orderXtmxList(QueryRequest request, OrderXtmx orderXtmx) {
        Map<String, Object> dataTable = getDataTable(this.orderXtmxService.findOrderXtmxs(request, orderXtmx));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增OrderXtmx", exceptionMessage = "新增OrderXtmx失败")
    @PostMapping("")
    @RequiresPermissions("orderXtmx:add")
    public FebsResponse addOrderXtmx(@Valid OrderXtmx orderXtmx) {
        this.orderXtmxService.createOrderXtmx(orderXtmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除OrderXtmx", exceptionMessage = "删除OrderXtmx失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("orderXtmx:delete")
    public FebsResponse deleteOrderXtmx(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderXtmxService.deleteOrderXtmx(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改OrderXtmx", exceptionMessage = "修改OrderXtmx失败")
    @PostMapping("/update")
    @RequiresPermissions("orderXtmx:update")
    public FebsResponse updateOrderXtmx(OrderXtmx orderXtmx) {
        this.orderXtmxService.updateOrderXtmx(orderXtmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("orderXtmx:export")
    public void export(QueryRequest queryRequest, OrderXtmx orderXtmx, HttpServletResponse response) {
        List<OrderXtmx> orderXtmxs = this.orderXtmxService.findOrderXtmxs(queryRequest, orderXtmx).getRecords();
        ExcelKit.$Export(OrderXtmx.class, response).downXlsx(orderXtmxs, false);
    }
}
