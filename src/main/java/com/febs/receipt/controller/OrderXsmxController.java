package com.febs.receipt.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.receipt.entity.OrderXsmx;
import com.febs.receipt.service.IOrderXsmxService;
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
 * 销售单明细 Controller
 *
 * @author liubaixing
 * @date 2020-06-02 13:38:56
 */
@Slf4j
@Validated
@RestController
@RequestMapping("orderXsmx")
public class OrderXsmxController extends BaseController {

    @Autowired
    private IOrderXsmxService orderXsmxService;


    @GetMapping("")
    @RequiresPermissions("orderXsmx:list")
    public FebsResponse getAllOrderXsmxs(OrderXsmx orderXsmx) {
        return new FebsResponse().success().data(orderXsmxService.findOrderXsmxs(orderXsmx));
    }

    @GetMapping("/list")
    @RequiresPermissions("orderXsmx:list")
    public FebsResponse orderXsmxList(QueryRequest request, OrderXsmx orderXsmx) {
        Map<String, Object> dataTable = getDataTable(this.orderXsmxService.findOrderXsmxs(request, orderXsmx));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增OrderXsmx", exceptionMessage = "新增OrderXsmx失败")
    @PostMapping("")
    @RequiresPermissions("orderXsmx:add")
    public FebsResponse addOrderXsmx(@Valid OrderXsmx orderXsmx) {
        this.orderXsmxService.createOrderXsmx(orderXsmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除OrderXsmx", exceptionMessage = "删除OrderXsmx失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("orderXsmx:delete")
    public FebsResponse deleteOrderXsmx(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderXsmxService.deleteOrderXsmx(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改OrderXsmx", exceptionMessage = "修改OrderXsmx失败")
    @PostMapping("/update")
    @RequiresPermissions("orderXsmx:update")
    public FebsResponse updateOrderXsmx(OrderXsmx orderXsmx) {
        this.orderXsmxService.updateOrderXsmx(orderXsmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("orderXsmx:export")
    public void export(QueryRequest queryRequest, OrderXsmx orderXsmx, HttpServletResponse response) {
        List<OrderXsmx> orderXsmxs = this.orderXsmxService.findOrderXsmxs(queryRequest, orderXsmx).getRecords();
        ExcelKit.$Export(OrderXsmx.class, response).downXlsx(orderXsmxs, false);
    }
}
