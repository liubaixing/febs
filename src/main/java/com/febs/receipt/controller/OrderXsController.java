package com.febs.receipt.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.enums.DeletedEnum;
import com.febs.common.enums.order.OrderStatusEnum;
import com.febs.common.exception.FebsException;
import com.febs.common.listener.goods.ShangpinDataListener;
import com.febs.common.listener.receipt.OrderXslistener;
import com.febs.common.utils.ExcelUtil;
import com.febs.receipt.biz.OrderXsBiz;
import com.febs.receipt.entity.OrderXs;
import com.febs.receipt.service.IOrderXsService;
import com.febs.receipt.vo.req.OrderXsReq;
import com.febs.receipt.vo.resp.OrderXsResp;
import com.febs.shangpin.vo.resp.ShangpinResp;
import com.febs.system.entity.User;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * 销售单 Controller
 *
 * @author liubaixing
 * @date 2020-06-11 11:36:56
 */
@Slf4j
@Validated
@RestController
@RequestMapping("orderXs")
public class OrderXsController extends BaseController {

    @Autowired
    private IOrderXsService orderXsService;

    @Autowired
    private OrderXsBiz orderXsBiz;


    @GetMapping("")
    @RequiresPermissions("orderXs:list")
    public FebsResponse getAllOrderXss(OrderXsReq orderXs) {
        return new FebsResponse().success().data(orderXsService.findOrderXss(orderXs));
    }

    @GetMapping("/list")
    @RequiresPermissions("orderXs:list")
    public FebsResponse orderXsList(QueryRequest request, OrderXsReq orderXs) {
        Map<String, Object> dataTable = getDataTable(this.orderXsBiz.findByPage(request, orderXs));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增销售单", exceptionMessage = "新增销售单失败")
    @PostMapping("")
    @RequiresPermissions("orderXs:add")
    public FebsResponse addOrderXs(@Valid OrderXs orderXs) {
        User user = getCurrentUser();
        orderXs.setUserId(user.getUserId());
        this.orderXsBiz.create(orderXs);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除销售单", exceptionMessage = "删除销售单失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("orderXs:delete")
    public FebsResponse deleteOrderXs(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderXsBiz.delete(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改销售单", exceptionMessage = "修改销售单失败")
    @PostMapping("/update")
    @RequiresPermissions("orderXs:update")
    public FebsResponse updateOrderXs(OrderXs orderXs) {
        this.orderXsBiz.update(orderXs);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "确认销售单", exceptionMessage = "确认销售单失败")
    @PostMapping("/confirm/{id}/{status}")
    @RequiresPermissions("orderXs:confirm")
    public FebsResponse orderXsConfirm(
            @PathVariable Long id,
            @PathVariable boolean status
    ){
        User user = getCurrentUser();
        String type = OrderStatusEnum.CONFIRM.getStatus();
        this.orderXsBiz.orderXsStatusCheck(id,type,status,user.getUsername());
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "审核销售单", exceptionMessage = "审核销售单失败")
    @PostMapping("/check/{id}/{status}")
    @RequiresPermissions("orderXs:check")
    public FebsResponse orderXsCheck(
            @PathVariable Long id,
            @PathVariable boolean status
    ){
        User user = getCurrentUser();
        String type = OrderStatusEnum.CHECK.getStatus();
        this.orderXsBiz.orderXsStatusCheck(id,type,status,user.getUsername());
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "执行销售单", exceptionMessage = "执行销售单失败")
    @PostMapping("/execute/{id}/{status}")
    @RequiresPermissions("orderXs:execute")
    public FebsResponse orderXsExecute(
            @PathVariable Long id,
            @PathVariable boolean status
    ){
        User user = getCurrentUser();
        String type = OrderStatusEnum.EXECUTION.getStatus();
        this.orderXsBiz.orderXsStatusCheck(id,type,status,user.getUsername());
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("orderXs:export")
    public void export(QueryRequest queryRequest, OrderXsReq orderXs, HttpServletResponse response) throws IOException {
        List<OrderXsResp> orderXss = this.orderXsBiz.findByPage(queryRequest, orderXs).getRecords();
        ExcelUtil.export(orderXss, OrderXsResp.class,"销售单",response);
    }

    @ApiOperation("导入")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @PostMapping("import")
    public void excelImport(@RequestParam MultipartFile file) throws IOException{
        EasyExcel.read(file.getInputStream(), OrderXsResp.class, new OrderXslistener(orderXsBiz)).sheet().doRead();
    }

}
