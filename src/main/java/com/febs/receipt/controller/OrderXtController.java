package com.febs.receipt.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.receipt.biz.OrderXtBiz;
import com.febs.receipt.entity.OrderXs;
import com.febs.receipt.entity.OrderXt;
import com.febs.receipt.service.IOrderXtService;

import com.febs.receipt.vo.req.OrderXsReq;
import com.febs.receipt.vo.req.OrderXtReq;
import com.febs.receipt.vo.resp.OrderXtResp;
import com.febs.system.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 销退单 Controller
 *
 * @author liubaixing
 * @date 2020-06-11 11:46:11
 */
@Slf4j
@Validated
@Api(tags = "销退单管理")
@RestController
@RequestMapping("orderXt")
public class OrderXtController extends BaseController {

    @Autowired
    private IOrderXtService orderXtService;

    @Autowired
    private OrderXtBiz xtBiz;


    @GetMapping("")
    @RequiresPermissions("orderXt:list")
    public FebsResponse getAllOrderXts(OrderXtReq orderXt) {
        return new FebsResponse().success().data(orderXtService.findOrderXts(orderXt));
    }

    @GetMapping("/list")
    @RequiresPermissions("orderXt:list")
    public FebsResponse orderXtList(QueryRequest request, OrderXtReq orderXt) {
        Map<String, Object> dataTable = getDataTable(this.xtBiz.findByPage(request, orderXt));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增销退单", exceptionMessage = "新增销退单失败")
    @PostMapping("")
    @RequiresPermissions("orderXt:add")
    public FebsResponse addOrderXt(@Valid OrderXtReq orderXt) {
        this.xtBiz.create(orderXt);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除销退单", exceptionMessage = "删除销退单失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("orderXt:delete")
    public FebsResponse deleteOrderXt(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.xtBiz.delete(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改销退单", exceptionMessage = "修改销退单失败")
    @PostMapping("/update")
    @RequiresPermissions("orderXt:update")
    public FebsResponse updateOrderXt(OrderXt orderXt) {
        this.xtBiz.update(orderXt);
        return new FebsResponse().success();
    }

    @ApiOperation("确认")
    @ControllerEndpoint(operation = "确认销退单", exceptionMessage = "确认销退单失败")
    @PostMapping("/confirm/{id}")
    @RequiresPermissions("orderXs:confirm")
    public FebsResponse orderXsConfirm(@PathVariable Long id){
        User user = getCurrentUser();
        OrderXs req = new OrderXs();
        req.setId(id);
        req.setQr((byte)1);
        req.setQrr(user.getUsername());
        this.xtBiz.confirmOrderXs(req,true);
        return new FebsResponse().success();
    }

    @ApiOperation("反确认")
    @ControllerEndpoint(operation = "反确销退单单", exceptionMessage = "反确认销退单失败")
    @PostMapping("/unConfirm/{id}")
    @RequiresPermissions("orderXs:unConfirm")
    public FebsResponse orderXsUnConfirm(@PathVariable Long id){
        User user = getCurrentUser();
        OrderXs req = new OrderXs();
        req.setId(id);
        req.setQr((byte)0);
        req.setQrr(user.getUsername());
        this.xtBiz.confirmOrderXs(req,false);
        return new FebsResponse().success();
    }

    @ApiOperation("审核")
    @ControllerEndpoint(operation = "审核销退单", exceptionMessage = "审核销退单失败")
    @PostMapping("/check/{id}")
    @RequiresPermissions("orderXs:check")
    public FebsResponse orderXsCheck(@PathVariable Long id ){
        User user = getCurrentUser();
        OrderXs req = new OrderXs();
        req.setId(id);
        req.setSh((byte)1);
        req.setShr(user.getUsername());
        this.xtBiz.checkOrderXs(req,true);
        return new FebsResponse().success();
    }

    @ApiOperation("反审核")
    @ControllerEndpoint(operation = "反审销退单单", exceptionMessage = "反审核销退单失败")
    @PostMapping("/unCheck/{id}")
    @RequiresPermissions("orderXs:unCheck")
    public FebsResponse orderXsUnCheck(@PathVariable Long id ){
        User user = getCurrentUser();
        OrderXs req = new OrderXs();
        req.setId(id);
        req.setSh((byte)0);
        req.setShr(user.getUsername());
        this.xtBiz.checkOrderXs(req,false);
        return new FebsResponse().success();
    }

    @ApiOperation("执行")
    @ControllerEndpoint(operation = "执行销退单", exceptionMessage = "执行销退单失败")
    @PostMapping("/execute/{id}")
    @RequiresPermissions("orderXs:execute")
    public FebsResponse orderXsExecute(@PathVariable Long id, OrderXsReq req){
        User user = getCurrentUser();
        req.setMxId(id);
        req.setZx((byte)1);
        req.setZxr(user.getUsername());
        this.xtBiz.executeOrderXs(req,true);
        return new FebsResponse().success();
    }

    @ApiOperation("反执行")
    @ControllerEndpoint(operation = "反执行销退单", exceptionMessage = "反执行销退单失败")
    @PostMapping("/unExecute/{id}")
    @RequiresPermissions("orderXs:unExecute")
    public FebsResponse orderXsUnExecute(@PathVariable Long id,OrderXsReq req){
        User user = getCurrentUser();
        req.setMxId(id);
        req.setZx((byte)1);
        req.setZxr(user.getUsername());
        this.xtBiz.executeOrderXs(req,false);
        return new FebsResponse().success();
    }

    @ApiOperation("作废")
    @ControllerEndpoint(operation = "作废销退单", exceptionMessage = "作废销退单失败")
    @PostMapping("/invalid/{id}/{status}")
    @RequiresPermissions("orderXs:invalid")
    public FebsResponse orderXsInvalid(
            @PathVariable Long id,
            @PathVariable boolean status
    ){
        User user = getCurrentUser();
        OrderXt orderXt = new OrderXt();
        orderXt.setZf((byte)1);
        orderXt.setZfr(user.getUsername());
        orderXt.setZfrq(new Date());
        xtBiz.update(orderXt);
        return new FebsResponse().success();
    }


    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("orderXt:export")
    public void export(QueryRequest queryRequest, OrderXtReq orderXt, HttpServletResponse response) throws IOException {
        List<OrderXtResp> orderXts = this.orderXtService.findOrderXts(queryRequest, orderXt).getRecords();
        ExcelUtil.export(orderXts, OrderXtResp.class,"销退单",response);
    }
}
