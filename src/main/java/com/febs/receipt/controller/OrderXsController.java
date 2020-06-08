package com.febs.receipt.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.receipt.entity.OrderXs;
import com.febs.receipt.service.IOrderXsService;
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
 * 销售单 Controller
 *
 * @author liubaixing
 * @date 2020-06-02 11:27:56
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

    @ControllerEndpoint(operation = "新增OrderXs", exceptionMessage = "新增OrderXs失败")
    @PostMapping("")
    @RequiresPermissions("orderXs:add")
    public FebsResponse addOrderXs(@Valid OrderXs orderXs) {
        this.orderXsService.createOrderXs(orderXs);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除OrderXs", exceptionMessage = "删除OrderXs失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("orderXs:delete")
    public FebsResponse deleteOrderXs(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderXsService.deleteOrderXs(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改OrderXs", exceptionMessage = "修改OrderXs失败")
    @PostMapping("/update")
    @RequiresPermissions("orderXs:update")
    public FebsResponse updateOrderXs(OrderXs orderXs) {
        this.orderXsService.updateOrderXs(orderXs);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("orderXs:export")
    public void export(QueryRequest queryRequest, OrderXs orderXs, HttpServletResponse response) {
        List<OrderXs> orderXss = this.orderXsService.findOrderXss(queryRequest, orderXs).getRecords();
        ExcelKit.$Export(OrderXs.class, response).downXlsx(orderXss, false);
    }
}
