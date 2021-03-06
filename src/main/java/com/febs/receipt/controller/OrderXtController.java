package com.febs.receipt.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.entity.excel.CommonExcelEntity;
import com.febs.common.listener.CommonExcelListener;
import com.febs.common.utils.ExcelUtil;
import com.febs.receipt.biz.OrderXtBiz;
import com.febs.receipt.entity.OrderXs;
import com.febs.receipt.entity.OrderXt;
import com.febs.receipt.service.IOrderXtService;

import com.febs.receipt.vo.req.OrderXsReq;
import com.febs.receipt.vo.req.OrderXtReq;
import com.febs.receipt.vo.resp.OrderXsResp;
import com.febs.receipt.vo.resp.OrderXtResp;
import com.febs.system.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
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
import java.util.stream.Collectors;

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
//    @RequiresPermissions("orderXt:list")
    public FebsResponse getAllOrderXts(OrderXtReq orderXt) {
        return new FebsResponse().success().data(orderXtService.findOrderXts(orderXt));
    }

    @GetMapping("/list")
//    @RequiresPermissions("orderXt:list")
    public FebsResponse orderXtList(QueryRequest request, OrderXtReq orderXt) {
        Map<String, Object> dataTable = getDataTable(this.xtBiz.findByPage(request, orderXt));
        return new FebsResponse().success().data(dataTable);
    }

    @ApiOperation("导入查询")
    @PostMapping("/list/import")
    public FebsResponse orderXsList(@RequestParam MultipartFile file) throws IOException {

        CommonExcelListener<CommonExcelEntity> listener = new CommonExcelListener<CommonExcelEntity>();
        EasyExcel.read(file.getInputStream(),CommonExcelEntity.class,listener).sheet().doRead();

        List<CommonExcelEntity> datas = listener.getDatas();

        if (CollectionUtils.isEmpty(datas)){
            return new FebsResponse().success();
        }

        List<String> orderXtNoList = datas.stream().filter(i -> i.getRow1() != null).map(CommonExcelEntity::getRow1).collect(Collectors.toList());

        List<OrderXtResp> orderXtRespList = new ArrayList<>();

        if (CollectionUtils.isNotEmpty(orderXtNoList)){
            OrderXtReq req = new OrderXtReq();

            req.setDjbhList(orderXtNoList);
            orderXtRespList = orderXtService.findOrderXts(req);
        }


        return new FebsResponse().success().data(orderXtRespList);
    }

    @ControllerEndpoint(operation = "新增销退单", exceptionMessage = "新增销退单失败")
    @PostMapping("")
//    @RequiresPermissions("orderXt:add")
    public FebsResponse addOrderXt(@Valid OrderXtReq orderXt) {
        User user = getCurrentUser();
        orderXt.setZdr(user.getUsername());
        orderXt.setZdrq(new Date());
        this.xtBiz.create(orderXt);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除销退单", exceptionMessage = "删除销退单失败")
    @GetMapping("delete/{ids}")
//    @RequiresPermissions("orderXt:delete")
    public FebsResponse deleteOrderXt(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.xtBiz.delete(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改销退单", exceptionMessage = "修改销退单失败")
    @PostMapping("/update")
//    @RequiresPermissions("orderXt:update")
    public FebsResponse updateOrderXt(OrderXtReq orderXt) {
        this.xtBiz.update(orderXt);
        return new FebsResponse().success();
    }


    @ApiOperation("查看")
    @GetMapping("view/{id}")
//    @RequiresPermissions("orderXt:view")
    public FebsResponse view(@PathVariable Long id) {
        return new FebsResponse().success().data(xtBiz.view(id));
    }

    @ApiOperation("确认")
    @ControllerEndpoint(operation = "确认销退单", exceptionMessage = "确认销退单失败")
    @GetMapping("/confirm/{id}")
//    @RequiresPermissions("orderXt:confirm")
    public FebsResponse orderXsConfirm(@PathVariable Long id){
        User user = getCurrentUser();
        OrderXs req = new OrderXs();
        req.setId(id);
        req.setQr((byte)1);
        req.setQrr(user.getUsername());
        this.xtBiz.confirmOrderXt(req,true);
        return new FebsResponse().success();
    }

    @ApiOperation("反确认")
    @ControllerEndpoint(operation = "反确销退单单", exceptionMessage = "反确认销退单失败")
    @GetMapping("/unConfirm/{id}")
//    @RequiresPermissions("orderXt:unConfirm")
    public FebsResponse orderXsUnConfirm(@PathVariable Long id){
        User user = getCurrentUser();
        OrderXs req = new OrderXs();
        req.setId(id);
        req.setQr((byte)0);
        req.setQrr(user.getUsername());
        this.xtBiz.confirmOrderXt(req,false);
        return new FebsResponse().success();
    }

    @ApiOperation("审核")
    @ControllerEndpoint(operation = "审核销退单", exceptionMessage = "审核销退单失败")
    @GetMapping("/check/{id}")
//    @RequiresPermissions("orderXt:check")
    public FebsResponse orderXsCheck(@PathVariable Long id ){
        User user = getCurrentUser();
        OrderXs req = new OrderXs();
        req.setId(id);
        req.setSh((byte)1);
        req.setAuditor(user.getUsername());
        this.xtBiz.checkOrderXt(req,true);
        return new FebsResponse().success();
    }

    @ApiOperation("反审核")
    @ControllerEndpoint(operation = "反审销退单单", exceptionMessage = "反审核销退单失败")
    @GetMapping("/unCheck/{id}")
//    @RequiresPermissions("orderXt:unCheck")
    public FebsResponse orderXsUnCheck(@PathVariable Long id ){
        User user = getCurrentUser();
        OrderXs req = new OrderXs();
        req.setId(id);
        req.setSh((byte)0);
        req.setAuditor(user.getUsername());
        this.xtBiz.checkOrderXt(req,false);
        return new FebsResponse().success();
    }

    @ApiOperation("执行")
    @ControllerEndpoint(operation = "执行", exceptionMessage = "执行失败")
    @PostMapping("/execute")
//    @RequiresPermissions("orderXt:execute")
    public FebsResponse orderXsExecute(OrderXtReq req){
        User user = getCurrentUser();
        req.setZx((byte)1);
        req.setZxr(user.getUsername());
        this.xtBiz.executeOrderXt(req);
        return new FebsResponse().success();
    }

    @ApiOperation("作废")
    @ControllerEndpoint(operation = "作废", exceptionMessage = "作废失败")
    @GetMapping("/invalid/{id}")
//    @RequiresPermissions("orderXt:invalid")
    public FebsResponse orderXsInvalid(@PathVariable Long id){
        User user = getCurrentUser();
        OrderXt orderXt = new OrderXt();
        orderXt.setId(id);
        orderXt.setZf((byte)1);
        orderXt.setZfr(user.getUsername());
        orderXt.setZfrq(new Date());
        xtBiz.zf(orderXt);
        return new FebsResponse().success();
    }

    @ApiOperation("关闭")
    @ControllerEndpoint(operation = "关闭", exceptionMessage = "关闭失败")
    @GetMapping("/close/{id}")
//    @RequiresPermissions("orderXt:close")
    public FebsResponse close(@PathVariable Long id){
        User user = getCurrentUser();
        OrderXt orderXt = new OrderXt();
        orderXt.setId(id);
        orderXt.setZs((byte)1);
        orderXt.setZsr(user.getUsername());
        orderXt.setZsrq(new Date());
        orderXtService.updateOrderXt(orderXt);
        return new FebsResponse().success();
    }

    @ApiOperation("反关闭")
    @ControllerEndpoint(operation = "反关闭", exceptionMessage = "反关闭失败")
    @GetMapping("/unClose/{id}")
//    @RequiresPermissions("orderXt:unClose")
    public FebsResponse unClose(@PathVariable Long id){
        User user = getCurrentUser();
        OrderXt orderXt = new OrderXt();
        orderXt.setId(id);
        orderXt.setZs((byte)0);
        orderXt.setZsr(user.getUsername());
        orderXt.setZsrq(new Date());
        orderXtService.updateOrderXt(orderXt);
        return new FebsResponse().success();
    }


    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
//    @RequiresPermissions("orderXt:export")
    public void export(QueryRequest queryRequest, OrderXtReq orderXt, HttpServletResponse response) throws IOException {
        List<OrderXtResp> orderXts = this.orderXtService.findOrderXts(queryRequest, orderXt).getRecords();
        ExcelUtil.export(orderXts, OrderXtResp.class,"销退单",response);
    }
}
