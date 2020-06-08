package com.febs.receipt.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.receipt.entity.OrderXstk;
import com.febs.receipt.service.IOrderXstkService;
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
 * 销售退款 Controller
 *
 * @author liubaixing
 * @date 2020-06-02 13:37:38
 */
@Slf4j
@Validated
@RestController
@RequestMapping("orderXstk")
public class OrderXstkController extends BaseController {

    @Autowired
    private IOrderXstkService orderXstkService;


    @GetMapping("")
    @RequiresPermissions("orderXstk:list")
    public FebsResponse getAllOrderXstks(OrderXstk orderXstk) {
        return new FebsResponse().success().data(orderXstkService.findOrderXstks(orderXstk));
    }

    @GetMapping("/list")
    @RequiresPermissions("orderXstk:list")
    public FebsResponse orderXstkList(QueryRequest request, OrderXstk orderXstk) {
        Map<String, Object> dataTable = getDataTable(this.orderXstkService.findOrderXstks(request, orderXstk));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增OrderXstk", exceptionMessage = "新增OrderXstk失败")
    @PostMapping("")
    @RequiresPermissions("orderXstk:add")
    public FebsResponse addOrderXstk(@Valid OrderXstk orderXstk) {
        this.orderXstkService.createOrderXstk(orderXstk);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除OrderXstk", exceptionMessage = "删除OrderXstk失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("orderXstk:delete")
    public FebsResponse deleteOrderXstk(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderXstkService.deleteOrderXstk(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改OrderXstk", exceptionMessage = "修改OrderXstk失败")
    @PostMapping("/update")
    @RequiresPermissions("orderXstk:update")
    public FebsResponse updateOrderXstk(OrderXstk orderXstk) {
        this.orderXstkService.updateOrderXstk(orderXstk);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("orderXstk:export")
    public void export(QueryRequest queryRequest, OrderXstk orderXstk, HttpServletResponse response) {
        List<OrderXstk> orderXstks = this.orderXstkService.findOrderXstks(queryRequest, orderXstk).getRecords();
        ExcelKit.$Export(OrderXstk.class, response).downXlsx(orderXstks, false);
    }
}
