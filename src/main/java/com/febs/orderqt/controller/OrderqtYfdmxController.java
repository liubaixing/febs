package com.febs.orderqt.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.orderqt.entity.OrderqtYfdmx;
import com.febs.orderqt.service.IOrderqtYfdmxService;
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
 * 运费单明细 Controller
 *
 * @author liubaixing
 * @date 2020-07-29 14:14:20
 */
@Slf4j
@Validated
@RestController
@RequestMapping("orderqtYfdmx")
public class OrderqtYfdmxController extends BaseController {

    @Autowired
    private IOrderqtYfdmxService orderqtYfdmxService;


    @GetMapping("")
    @RequiresPermissions("orderqtYfdmx:list")
    public FebsResponse getAllOrderqtYfdmxs(OrderqtYfdmx orderqtYfdmx) {
        return new FebsResponse().success().data(orderqtYfdmxService.findOrderqtYfdmxs(orderqtYfdmx));
    }

    @GetMapping("/list")
    @RequiresPermissions("orderqtYfdmx:list")
    public FebsResponse orderqtYfdmxList(QueryRequest request, OrderqtYfdmx orderqtYfdmx) {
        Map<String, Object> dataTable = getDataTable(this.orderqtYfdmxService.findOrderqtYfdmxs(request, orderqtYfdmx));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增运费单明细", exceptionMessage = "新增运费单明细失败")
    @PostMapping("")
    @RequiresPermissions("orderqtYfdmx:add")
    public FebsResponse addOrderqtYfdmx(@Valid OrderqtYfdmx orderqtYfdmx) {
        this.orderqtYfdmxService.createOrderqtYfdmx(orderqtYfdmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除运费单明细", exceptionMessage = "删除运费单明细失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("orderqtYfdmx:delete")
    public FebsResponse deleteOrderqtYfdmx(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderqtYfdmxService.deleteOrderqtYfdmx(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改运费单明细", exceptionMessage = "修改运费单明细失败")
    @PostMapping("/update")
    @RequiresPermissions("orderqtYfdmx:update")
    public FebsResponse updateOrderqtYfdmx(OrderqtYfdmx orderqtYfdmx) {
        this.orderqtYfdmxService.updateOrderqtYfdmx(orderqtYfdmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("orderqtYfdmx:export")
    public void export(QueryRequest queryRequest, OrderqtYfdmx orderqtYfdmx, HttpServletResponse response) throws IOException {
        List<OrderqtYfdmx> orderqtYfdmxs = this.orderqtYfdmxService.findOrderqtYfdmxs(queryRequest, orderqtYfdmx).getRecords();
        ExcelUtil.export(orderqtYfdmxs, OrderqtYfdmx.class,"运费单明细",response);
    }
}
