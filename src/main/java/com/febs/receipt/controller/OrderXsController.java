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
import io.swagger.annotations.Api;
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
import java.util.Date;
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
@Api(tags = "销售单管理")
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

    @ApiOperation("查询销售单")
    @GetMapping("/list")
    @RequiresPermissions("orderXs:list")
    public FebsResponse orderXsList(QueryRequest request, OrderXsReq orderXs) {
        Map<String, Object> dataTable = getDataTable(this.orderXsBiz.findByPage(request, orderXs));
        return new FebsResponse().success().data(dataTable);
    }

    @ApiOperation("查询销售单详情")
    @GetMapping("/{id}")
    @RequiresPermissions("orderXs:list")
    public FebsResponse orderXsDetail(@PathVariable Long id) {
        OrderXsReq req = new OrderXsReq();
        req.setId(id);
        return new FebsResponse().success().data(orderXsService.findOrderXsDetail(req));
    }

    @ApiOperation("新增销售单")
    @ControllerEndpoint(operation = "新增销售单", exceptionMessage = "新增销售单失败")
    @PostMapping("")
    @RequiresPermissions("orderXs:add")
    public FebsResponse addOrderXs(@Valid OrderXsReq orderXs) {
        User user = getCurrentUser();
        orderXs.setUserId(user.getUserId());
        this.orderXsBiz.create(orderXs);
        return new FebsResponse().success();
    }

    @ApiOperation("删除销售单")
    @ControllerEndpoint(operation = "删除销售单", exceptionMessage = "删除销售单失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("orderXs:delete")
    public FebsResponse deleteOrderXs(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderXsBiz.delete(id);
        return new FebsResponse().success();
    }

    @ApiOperation("修改销售单")
    @ControllerEndpoint(operation = "修改销售单", exceptionMessage = "修改销售单失败")
    @PostMapping("/update")
    @RequiresPermissions("orderXs:update")
    public FebsResponse updateOrderXs(OrderXs orderXs) {
        this.orderXsBiz.update(orderXs);
        return new FebsResponse().success();
    }

    @ApiOperation("确认")
    @ControllerEndpoint(operation = "确认销售单", exceptionMessage = "确认销售单失败")
    @PostMapping("/confirm/{id}")
    @RequiresPermissions("orderXs:confirm")
    public FebsResponse orderXsConfirm(@PathVariable Long id){
        User user = getCurrentUser();
        OrderXs req = new OrderXs();
        req.setId(id);
        req.setQr((byte)1);
        req.setQrr(user.getUsername());
        this.orderXsBiz.confirmOrderXs(req,true);
        return new FebsResponse().success();
    }

    @ApiOperation("反确认")
    @ControllerEndpoint(operation = "反确认销售单", exceptionMessage = "反确认销售单失败")
    @PostMapping("/unConfirm/{id}")
    @RequiresPermissions("orderXs:unConfirm")
    public FebsResponse orderXsUnConfirm(@PathVariable Long id){
        User user = getCurrentUser();
        OrderXs req = new OrderXs();
        req.setId(id);
        req.setQr((byte)1);
        req.setQrr(user.getUsername());
        this.orderXsBiz.confirmOrderXs(req,false);
        return new FebsResponse().success();
    }

    @ApiOperation("审核")
    @ControllerEndpoint(operation = "审核销售单", exceptionMessage = "审核销售单失败")
    @PostMapping("/check/{id}")
    @RequiresPermissions("orderXs:check")
    public FebsResponse orderXsCheck(@PathVariable Long id ){
        User user = getCurrentUser();
        OrderXs req = new OrderXs();
        req.setId(id);
        req.setSh((byte)1);
        req.setShr(user.getUsername());
        this.orderXsBiz.checkOrderXs(req,true);
        return new FebsResponse().success();
    }

    @ApiOperation("反审核")
    @ControllerEndpoint(operation = "反审核销售单", exceptionMessage = "反审核销售单失败")
    @PostMapping("/unCheck/{id}")
    @RequiresPermissions("orderXs:unCheck")
    public FebsResponse orderXsUnCheck(@PathVariable Long id ){
        User user = getCurrentUser();
        OrderXs req = new OrderXs();
        req.setId(id);
        req.setSh((byte)1);
        req.setShr(user.getUsername());
        this.orderXsBiz.checkOrderXs(req,false);
        return new FebsResponse().success();
    }

    @ApiOperation("执行")
    @ControllerEndpoint(operation = "执行销售单", exceptionMessage = "执行销售单失败")
    @PostMapping("/execute/{id}")
    @RequiresPermissions("orderXs:execute")
    public FebsResponse orderXsExecute(@PathVariable Long id,OrderXs req){
        User user = getCurrentUser();
        req.setId(id);
        req.setZx((byte)1);
        req.setZxr(user.getUsername());
        this.orderXsBiz.executeOrderXs(req,true);
        return new FebsResponse().success();
    }

    @ApiOperation("反执行")
    @ControllerEndpoint(operation = "反执行销售单", exceptionMessage = "反执行销售单失败")
    @PostMapping("/unExecute/{id}")
    @RequiresPermissions("orderXs:unExecute")
    public FebsResponse orderXsUnExecute(@PathVariable Long id,OrderXs req){
        User user = getCurrentUser();
        req.setId(id);
        req.setZx((byte)1);
        req.setZxr(user.getUsername());
        this.orderXsBiz.executeOrderXs(req,false);
        return new FebsResponse().success();
    }

    @ApiOperation("作废")
    @ControllerEndpoint(operation = "作废销售单", exceptionMessage = "作废销售单失败")
    @PostMapping("/invalid/{id}/{status}")
    @RequiresPermissions("orderXs:invalid")
    public FebsResponse orderXsInvalid(
            @PathVariable Long id,
            @PathVariable boolean status
    ){
        User user = getCurrentUser();
        OrderXs orderXs = new OrderXs();
        orderXs.setZf((byte)1);
        orderXs.setZfr(user.getUsername());
        orderXs.setZfrq(new Date());
        orderXsBiz.update(orderXs);
        return new FebsResponse().success();
    }

    @ApiOperation("关闭")
    @ControllerEndpoint(operation = "关闭销售单", exceptionMessage = "关闭销售单失败")
    @PostMapping("/close/{id}")
    @RequiresPermissions("orderXs:close")
    public FebsResponse orderXsClose(@PathVariable Long id,OrderXs req){
        User user = getCurrentUser();
        req.setId(id);
        req.setGb((byte)1);
        req.setGbr(user.getUsername());
        this.orderXsBiz.closeOrderXs(req,true);
        return new FebsResponse().success();
    }

    @ApiOperation("反关闭")
    @ControllerEndpoint(operation = "反关闭销售单", exceptionMessage = "反关闭销售单失败")
    @PostMapping("/unClose/{id}")
    @RequiresPermissions("orderXs:unClose")
    public FebsResponse orderXsUnClose(@PathVariable Long id,OrderXs req){
        User user = getCurrentUser();
        req.setId(id);
        req.setGb((byte)1);
        req.setGbr(user.getUsername());
        this.orderXsBiz.closeOrderXs(req,false);
        return new FebsResponse().success();
    }

    @ApiOperation("生成销退单")
    @ControllerEndpoint(operation = "生成销退单", exceptionMessage = "生成销退单失败")
    @PostMapping("/return/{id}")
    @RequiresPermissions("orderXs:return")
    public FebsResponse orderXsReturn(@PathVariable Long id,OrderXsReq req){

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
