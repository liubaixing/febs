package com.febs.orderqt.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.orderqt.entity.OrderqtYsfdmx;
import com.febs.orderqt.service.IOrderqtYsfdmxService;
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
 * 印刷费单明细 Controller
 *
 * @author liubaixing
 * @date 2020-07-29 14:14:26
 */
@Slf4j
@Validated
@RestController
@RequestMapping("orderqtYsfdmx")
public class OrderqtYsfdmxController extends BaseController {

    @Autowired
    private IOrderqtYsfdmxService orderqtYsfdmxService;


    @GetMapping("")
    @RequiresPermissions("orderqtYsfdmx:list")
    public FebsResponse getAllOrderqtYsfdmxs(OrderqtYsfdmx orderqtYsfdmx) {
        return new FebsResponse().success().data(orderqtYsfdmxService.findOrderqtYsfdmxs(orderqtYsfdmx));
    }

    @GetMapping("/list")
    @RequiresPermissions("orderqtYsfdmx:list")
    public FebsResponse orderqtYsfdmxList(QueryRequest request, OrderqtYsfdmx orderqtYsfdmx) {
        Map<String, Object> dataTable = getDataTable(this.orderqtYsfdmxService.findOrderqtYsfdmxs(request, orderqtYsfdmx));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增印刷费单明细", exceptionMessage = "新增印刷费单明细失败")
    @PostMapping("")
    @RequiresPermissions("orderqtYsfdmx:add")
    public FebsResponse addOrderqtYsfdmx(@Valid OrderqtYsfdmx orderqtYsfdmx) {
        this.orderqtYsfdmxService.createOrderqtYsfdmx(orderqtYsfdmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除印刷费单明细", exceptionMessage = "删除印刷费单明细失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("orderqtYsfdmx:delete")
    public FebsResponse deleteOrderqtYsfdmx(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderqtYsfdmxService.deleteOrderqtYsfdmx(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改印刷费单明细", exceptionMessage = "修改印刷费单明细失败")
    @PostMapping("/update")
    @RequiresPermissions("orderqtYsfdmx:update")
    public FebsResponse updateOrderqtYsfdmx(OrderqtYsfdmx orderqtYsfdmx) {
        this.orderqtYsfdmxService.updateOrderqtYsfdmx(orderqtYsfdmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("orderqtYsfdmx:export")
    public void export(QueryRequest queryRequest, OrderqtYsfdmx orderqtYsfdmx, HttpServletResponse response) throws IOException {
        List<OrderqtYsfdmx> orderqtYsfdmxs = this.orderqtYsfdmxService.findOrderqtYsfdmxs(queryRequest, orderqtYsfdmx).getRecords();
        ExcelUtil.export(orderqtYsfdmxs, OrderqtYsfdmx.class,"印刷费单明细",response);
    }
}
