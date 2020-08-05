package com.febs.receipt.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.entity.excel.CkExcel;
import com.febs.common.listener.UploadDataListener;
import com.febs.common.utils.BeanUtils;
import com.febs.common.utils.ExcelUtil;
import com.febs.receipt.biz.OrderCkBiz;
import com.febs.receipt.entity.OrderCk;
import com.febs.receipt.service.IOrderCkService;

import com.febs.receipt.vo.req.OrderCkReq;
import com.febs.receipt.vo.resp.OrderCkResp;
import com.febs.system.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
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
@Api(tags = "出库单管理")
@RestController
@RequestMapping("orderCk")
public class OrderCkController extends BaseController {

    @Autowired
    private IOrderCkService orderCkService;

    @Autowired
    private OrderCkBiz ckBiz;

    @GetMapping("")
//    @RequiresPermissions("orderCk:list")
    public FebsResponse getAllOrderCks(OrderCkReq orderCk) {
        return new FebsResponse().success().data(orderCkService.findOrderCks(orderCk));
    }

    @GetMapping("/list")
//    @RequiresPermissions("orderCk:list")
    public FebsResponse orderCkList(QueryRequest request, OrderCkReq orderCk) {
        Map<String, Object> dataTable = getDataTable(this.orderCkService.findOrderCks(request, orderCk));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增出库单", exceptionMessage = "新增出库单失败")
    @PostMapping("")
//    @RequiresPermissions("orderCk:add")
    public FebsResponse addOrderCk(@Valid OrderCkReq req) {
        User user = getCurrentUser();
        req.setZdr(user.getUsername());
        req.setZdrq(new Date());
        ckBiz.add(req);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除出库单", exceptionMessage = "删除出库单失败")
    @GetMapping("delete/{ids}")
//    @RequiresPermissions("orderCk:delete")
    public FebsResponse deleteOrderCk(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderCkService.deleteOrderCk(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改出库单", exceptionMessage = "修改出库单失败")
    @PostMapping("/update")
//    @RequiresPermissions("orderCk:update")
    public FebsResponse updateOrderCk(OrderCk orderCk) {
        this.orderCkService.updateOrderCk(orderCk);
        return new FebsResponse().success();
    }

    @ApiOperation("查看")
    @ControllerEndpoint(operation = "查看", exceptionMessage = "查看失败")
    @GetMapping("/view/{id}")
//    @RequiresPermissions("orderCk:view")
    public FebsResponse view(@PathVariable Long id ){
        return new FebsResponse().success().data(ckBiz.view(id));
    }


    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
//    @RequiresPermissions("orderCk:export")
    public FebsResponse export(QueryRequest queryRequest, OrderCkReq orderCk, HttpServletResponse response) throws IOException {
        List<OrderCkResp> orderCks = this.orderCkService.findOrderCks(queryRequest, orderCk).getRecords();
        List<CkExcel> data = BeanUtils.transformFromInBatch(orderCks,CkExcel.class);
        ExcelUtil.export(data, CkExcel.class,"出库单",response);
        return new FebsResponse().success().data("导出成功");
    }

    @ApiOperation("导入")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @PostMapping("upload")
    public FebsResponse upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), CkExcel.class, new UploadDataListener(orderCkService)).sheet().doRead();
        return new FebsResponse().success().data("导入成功");
    }

    @ApiOperation("确认")
    @ControllerEndpoint(operation = "确认销售收款单", exceptionMessage = "确认销售收款单失败")
    @GetMapping("/confirm/{id}")
//    @RequiresPermissions("orderCk:confirm")
    public FebsResponse OrderXsskConfirm(@PathVariable Long id){
        User user = getCurrentUser();
        OrderCk ck = new OrderCk();
        ck.setId(id);
        ck.setQr((byte)1);
        ck.setQrr(user.getUsername());
        ck.setQrrq(new Date());
        orderCkService.updateOrderCk(ck);
        return new FebsResponse().success();
    }


    @ApiOperation("关闭")
    @ControllerEndpoint(operation = "关闭", exceptionMessage = "关闭失败")
    @GetMapping("/close/{id}")
//    @RequiresPermissions("orderCk:close")
    public FebsResponse close(@PathVariable Long id){
        User user = getCurrentUser();
        OrderCk ck = new OrderCk();
        ck.setId(id);
        ck.setGb((byte)1);
        ck.setGbr(user.getUsername());
        ck.setGbrq(new Date());
        orderCkService.updateOrderCk(ck);
        return new FebsResponse().success();
    }

    @ApiOperation("作废")
    @ControllerEndpoint(operation = "作废", exceptionMessage = "作废失败")
    @GetMapping("/zf/{id}")
//    @RequiresPermissions("orderCk:zf")
    public FebsResponse zf(@PathVariable Long id){
        User user = getCurrentUser();
        OrderCk ck = new OrderCk();
        ck.setId(id);
        ck.setZf((byte)1);
        ck.setZfr(user.getUsername());
        ck.setZfrq(new Date());
        orderCkService.updateOrderCk(ck);
        return new FebsResponse().success();
    }

    @ApiOperation("备货发货")
    @ControllerEndpoint(operation = "备货发货", exceptionMessage = "备货发货失败")
    @PostMapping("/bhfh/{id}")
//    @RequiresPermissions("orderCk:bhfh")
    public FebsResponse bhfh(OrderCkReq req){
        User user = getCurrentUser();
        ckBiz.bhfh(req,user);
        return new FebsResponse().success();
    }

}
