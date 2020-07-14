package com.febs.receipt.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.receipt.biz.OrderXsskBiz;
import com.febs.receipt.entity.OrderXssk;
import com.febs.receipt.service.IOrderXsskService;

import com.febs.receipt.vo.req.OrderXsskCreateReq;
import com.febs.receipt.vo.req.OrderXsskReq;
import com.febs.receipt.vo.resp.OrderXsResp;
import com.febs.receipt.vo.resp.OrderXsskResp;
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
 * 销售收款 Controller
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:18
 */
@Slf4j
@Validated
@Api(tags = "销售收款管理")
@RestController
@RequestMapping("orderXssk")
public class OrderXsskController extends BaseController {

    @Autowired
    private IOrderXsskService orderXsskService;

    @Autowired
    private OrderXsskBiz xsskBiz;

    @GetMapping("")
    @RequiresPermissions("orderXssk:list")
    public FebsResponse getAllOrderXssks(OrderXsskReq orderXssk) {
        return new FebsResponse().success().data(orderXsskService.findOrderXssks(orderXssk));
    }

    @GetMapping("/list")
    @RequiresPermissions("orderXssk:list")
    public FebsResponse orderXsskList(QueryRequest request, OrderXsskReq orderXssk) {
        Map<String, Object> dataTable = getDataTable(this.orderXsskService.findOrderXssks(request, orderXssk));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增销售收款", exceptionMessage = "新增销售收款失败")
    @PostMapping("")
    @RequiresPermissions("orderXssk:add")
    public FebsResponse addOrderXssk(@Valid OrderXsskReq req) {
        User user = getCurrentUser();
        req.setZdr(user.getUsername());
        xsskBiz.createOrderXssk(req);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除销售收款", exceptionMessage = "删除销售收款失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("orderXssk:delete")
    public FebsResponse deleteOrderXssk(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderXsskService.deleteOrderXssk(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改销售收款", exceptionMessage = "修改销售收款失败")
    @PostMapping("/update")
    @RequiresPermissions("orderXssk:update")
    public FebsResponse updateOrderXssk(OrderXssk orderXssk) {
        this.orderXsskService.updateOrderXssk(orderXssk);
        return new FebsResponse().success();
    }

    @ApiOperation("确认")
    @ControllerEndpoint(operation = "确认", exceptionMessage = "确认失败")
    @GetMapping("/confirm/{id}")
    @RequiresPermissions("orderXssk:confirm")
    public FebsResponse OrderXsskConfirm(@PathVariable Long id){
        User user = getCurrentUser();
        OrderXssk xssk = new OrderXssk();
        xssk.setId(id);
        xssk.setQr((byte)1);
        xssk.setQrr(user.getUsername());
        xssk.setQrrq(new Date());
        xsskBiz.update(xssk);
        return new FebsResponse().success();
    }

    @ApiOperation("审核")
    @ControllerEndpoint(operation = "审核", exceptionMessage = "审核失败")
    @GetMapping("/check/{id}")
    @RequiresPermissions("orderXssk:check")
    public FebsResponse orderXsskCheck(@PathVariable Long id ){
        User user = getCurrentUser();
        OrderXssk xssk = new OrderXssk();
        xssk.setId(id);
        xssk.setSh((byte)1);
        xssk.setAuditor(user.getUsername());
        xssk.setShrq(new Date());
        xsskBiz.update(xssk);
        return new FebsResponse().success();
    }

    @ApiOperation("生成")
    @ControllerEndpoint(operation = "生成", exceptionMessage = "生成失败")
    @PostMapping("/create")
    @RequiresPermissions("orderXssk:create")
    public FebsResponse createorderXssk(OrderXsskCreateReq req){
        User user = getCurrentUser();
        xsskBiz.create(req,user);
        return new FebsResponse().success();
    }

    @ApiOperation("收款(收款单号)")
    @ControllerEndpoint(operation = "收款", exceptionMessage = "收款失败")
    @GetMapping("/kp/{djbh}")
    @RequiresPermissions("orderXssk:kp")
    public FebsResponse sk(@PathVariable String djbh ){
        User user = getCurrentUser();
        OrderXssk xssk = new OrderXssk();
        xssk.setDjbh(djbh);
        xssk.setSk((byte)1);
        xssk.setSkr(user.getUsername());
        xssk.setSkrq(new Date());
        xsskBiz.sk(xssk);
        return new FebsResponse().success();
    }

    @ApiOperation("查看")
    @ControllerEndpoint(operation = "查看", exceptionMessage = "查看失败")
    @GetMapping("/view/{id}")
    @RequiresPermissions("orderXssk:view")
    public FebsResponse view(@PathVariable Long id ){
        return new FebsResponse().data(xsskBiz.view(id));
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("orderXssk:export")
    public void export(QueryRequest queryRequest, OrderXsskReq orderXssk, HttpServletResponse response) throws IOException {
        List<OrderXsskResp> orderXssks = this.orderXsskService.findOrderXssks(queryRequest, orderXssk).getRecords();
        ExcelUtil.export(orderXssks, OrderXsskResp.class,"销售收款",response);
    }
}
