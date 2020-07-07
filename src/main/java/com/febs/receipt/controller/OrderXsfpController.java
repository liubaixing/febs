package com.febs.receipt.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.receipt.biz.OrderXsfpBiz;
import com.febs.receipt.entity.OrderXs;
import com.febs.receipt.entity.OrderXsfp;
import com.febs.receipt.entity.OrderXsmx;
import com.febs.receipt.service.IOrderXsfpService;

import com.febs.receipt.vo.req.OrderXsfpReq;
import com.febs.receipt.vo.req.OrderXsmxReq;
import com.febs.receipt.vo.resp.OrderXsfpResp;
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
 * 销售发票 Controller
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:16
 */
@Slf4j
@Validated
@Api(tags = "销售开票管理")
@RestController
@RequestMapping("orderXsfp")
public class OrderXsfpController extends BaseController {

    @Autowired
    private IOrderXsfpService orderXsfpService;

    @Autowired
    private OrderXsfpBiz xsfpBiz;

    @GetMapping("")
    @RequiresPermissions("orderXsfp:list")
    public FebsResponse getAllOrderXsfps(OrderXsfp orderXsfp) {
        return new FebsResponse().success().data(orderXsfpService.findOrderXsfps(orderXsfp));
    }

    @GetMapping("/list")
    @RequiresPermissions("orderXsfp:list")
    public FebsResponse orderXsfpList(QueryRequest request, OrderXsfpReq orderXsfp) {
        Map<String, Object> dataTable = getDataTable(this.orderXsfpService.findOrderXsfps(request, orderXsfp));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增销售发票", exceptionMessage = "新增销售发票失败")
    @PostMapping("")
    @RequiresPermissions("orderXsfp:add")
    public FebsResponse addOrderXsfp(@Valid OrderXsfp orderXsfp) {
        this.orderXsfpService.createOrderXsfp(orderXsfp);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除销售发票", exceptionMessage = "删除销售发票失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("orderXsfp:delete")
    public FebsResponse deleteOrderXsfp(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderXsfpService.deleteOrderXsfp(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改销售发票", exceptionMessage = "修改销售发票失败")
    @PostMapping("/update")
    @RequiresPermissions("orderXsfp:update")
    public FebsResponse updateOrderXsfp(OrderXsfp orderXsfp) {
        this.orderXsfpService.updateOrderXsfp(orderXsfp);
        return new FebsResponse().success();
    }


    @ApiOperation("确认")
    @ControllerEndpoint(operation = "确认销售发票", exceptionMessage = "确认销售发票失败")
    @PostMapping("/confirm/{id}")
    @RequiresPermissions("orderXsfp:confirm")
    public FebsResponse orderXsfpConfirm(@PathVariable Long id){
        User user = getCurrentUser();
        OrderXsfp xsfp = new OrderXsfp();
        xsfp.setId(id);
        xsfp.setQr((byte)1);
        xsfp.setQrr(user.getUsername());
        xsfp.setQrrq(new Date());
        xsfpBiz.update(xsfp);
        return new FebsResponse().success();
    }

    @ApiOperation("审核")
    @ControllerEndpoint(operation = "审核销售发票", exceptionMessage = "审核销售发票失败")
    @PostMapping("/check/{id}")
    @RequiresPermissions("orderXsfp:check")
    public FebsResponse orderXsfpCheck(@PathVariable Long id ){
        User user = getCurrentUser();
        OrderXsfp xsfp = new OrderXsfp();
        xsfp.setId(id);
        xsfp.setSh((byte)1);
        xsfp.setShr(user.getUsername());
        xsfp.setShrq(new Date());
        xsfpBiz.update(xsfp);
        return new FebsResponse().success();
    }

    @ApiOperation("生成")
    @ControllerEndpoint(operation = "生成销售发票", exceptionMessage = "生成销售发票失败")
    @PostMapping("/create/{id}")
    @RequiresPermissions("orderXsfp:create")
    public FebsResponse createOrderXsfp(@RequestBody OrderXsfpReq req){
        User user = getCurrentUser();
        req.setZdr(user.getUsername());
        xsfpBiz.createOrderXsfp(req);
        return new FebsResponse().success();
    }

    @ApiOperation("开票")
    @ControllerEndpoint(operation = "开票", exceptionMessage = "开票失败")
    @PostMapping("/kp/{id}")
    @RequiresPermissions("orderXsfp:kp")
    public FebsResponse kp(@PathVariable Long id ){
        User user = getCurrentUser();

        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("orderXsfp:export")
    public void export(QueryRequest queryRequest, OrderXsfpReq orderXsfp, HttpServletResponse response) throws IOException {
        List<OrderXsfpResp> orderXsfps = this.orderXsfpService.findOrderXsfps(queryRequest, orderXsfp).getRecords();
        ExcelUtil.export(orderXsfps, OrderXsfpResp.class,"销售发票",response);
    }


}
