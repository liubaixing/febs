package com.febs.receipt.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.receipt.biz.OrderXstkBiz;
import com.febs.receipt.entity.OrderXstk;
import com.febs.receipt.service.IOrderXstkService;

import com.febs.receipt.vo.req.OrderXstkReq;
import com.febs.receipt.vo.resp.OrderXstkResp;
import com.febs.system.entity.User;
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
 * 销售退款 Controller
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:20
 */
@Slf4j
@Validated
@RestController
@RequestMapping("orderXstk")
public class OrderXstkController extends BaseController {

    @Autowired
    private IOrderXstkService orderXstkService;

    @Autowired
    private OrderXstkBiz xstkBiz;

    @GetMapping("")
    @RequiresPermissions("orderXstk:list")
    public FebsResponse getAllOrderXstks(OrderXstk orderXstk) {
        return new FebsResponse().success().data(orderXstkService.findOrderXstks(orderXstk));
    }

    @GetMapping("/list")
    @RequiresPermissions("orderXstk:list")
    public FebsResponse orderXstkList(QueryRequest request, OrderXstkReq orderXstk) {
        Map<String, Object> dataTable = getDataTable(this.orderXstkService.findOrderXstks(request, orderXstk));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增销售退款", exceptionMessage = "新增销售退款失败")
    @PostMapping("")
    @RequiresPermissions("orderXstk:add")
    public FebsResponse addOrderXstk(@Valid OrderXstk orderXstk) {
        this.orderXstkService.createOrderXstk(orderXstk);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除销售退款", exceptionMessage = "删除销售退款失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("orderXstk:delete")
    public FebsResponse deleteOrderXstk(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderXstkService.deleteOrderXstk(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改销售退款", exceptionMessage = "修改销售退款失败")
    @PostMapping("/update")
    @RequiresPermissions("orderXstk:update")
    public FebsResponse updateOrderXstk(OrderXstk orderXstk) {
        this.orderXstkService.updateOrderXstk(orderXstk);
        return new FebsResponse().success();
    }


    @ApiOperation("确认")
    @ControllerEndpoint(operation = "确认销售收款单", exceptionMessage = "确认销售收款单失败")
    @PostMapping("/confirm/{id}")
    @RequiresPermissions("orderXssk:confirm")
    public FebsResponse OrderXsskConfirm(@PathVariable Long id){
        User user = getCurrentUser();
        OrderXstk xstk = new OrderXstk();
        xstk.setId(id);
        xstk.setQr((byte)1);
        xstk.setQrr(user.getUsername());
        xstk.setQrrq(new Date());
        xstkBiz.update(xstk);
        return new FebsResponse().success();
    }

    @ApiOperation("审核")
    @ControllerEndpoint(operation = "审核销售收款单", exceptionMessage = "审核销售收款单失败")
    @PostMapping("/check/{id}")
    @RequiresPermissions("orderXssk:check")
    public FebsResponse orderXsskCheck(@PathVariable Long id ){
        User user = getCurrentUser();
        OrderXstk xstk = new OrderXstk();
        xstk.setId(id);
        xstk.setSh((byte)1);
        xstk.setShr(user.getUsername());
        xstk.setShrq(new Date());
        xstkBiz.update(xstk);
        return new FebsResponse().success();
    }

    @ApiOperation("生成")
    @ControllerEndpoint(operation = "生成销售收款单", exceptionMessage = "生成销售收款单失败")
    @PostMapping("/create/{id}")
    @RequiresPermissions("orderXssk:create")
    public FebsResponse createorderXssk(@RequestBody OrderXstkReq req ){
        User user = getCurrentUser();
        req.setZdr(user.getUsername());
        xstkBiz.createOrderXstk(req);
        return new FebsResponse().success();
    }

    @ApiOperation("收款")
    @ControllerEndpoint(operation = "收款", exceptionMessage = "收款失败")
    @PostMapping("/kp/{id}")
    @RequiresPermissions("orderXssk:kp")
    public FebsResponse sk(@PathVariable Long id ){
        User user = getCurrentUser();

        return new FebsResponse().success();
    }


    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("orderXstk:export")
    public void export(QueryRequest queryRequest, OrderXstkReq orderXstk, HttpServletResponse response) throws IOException {
        List<OrderXstkResp> orderXstks = this.orderXstkService.findOrderXstks(queryRequest, orderXstk).getRecords();
        ExcelUtil.export(orderXstks, OrderXstkResp.class,"销售退款",response);
    }
}
