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
import com.febs.receipt.biz.OrderXsfpBiz;
import com.febs.receipt.entity.OrderXsfp;
import com.febs.receipt.service.IOrderXsService;
import com.febs.receipt.service.IOrderXsfpService;
import com.febs.receipt.service.IOrderXtService;
import com.febs.receipt.view.OrderXskpView;
import com.febs.receipt.vo.req.OrderXsReq;
import com.febs.receipt.vo.req.OrderXsfpReq;
import com.febs.receipt.vo.req.OrderXtReq;
import com.febs.receipt.vo.req.XsfpCreateReq;
import com.febs.receipt.vo.resp.OrderXsResp;
import com.febs.receipt.vo.resp.OrderXsfpResp;
import com.febs.receipt.vo.resp.OrderXtResp;
import com.febs.system.entity.User;
import com.febs.system.service.IUserOrgService;
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
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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

    @Autowired
    private IOrderXsService orderXsService;
    @Autowired
    private IOrderXtService orderXtService;

    @Autowired
    private IUserOrgService userOrgService;

    @GetMapping("")
//    @RequiresPermissions("orderXsfp:list")
    public FebsResponse getAllOrderXsfps(OrderXsfpReq orderXsfp) {
        return new FebsResponse().success().data(orderXsfpService.findOrderXsfps(orderXsfp));
    }

    @GetMapping("/list")
//    @RequiresPermissions("orderXsfp:list")
    public FebsResponse orderXsfpList(QueryRequest request, OrderXsfpReq orderXsfp) {
        Map<String, Object> dataTable = getDataTable(this.orderXsfpService.findOrderXsfps(request, orderXsfp));
        return new FebsResponse().success().data(dataTable);
    }


    @ApiOperation("导入查询")
    @PostMapping("/list/import")
    public FebsResponse importQuery(@RequestParam MultipartFile file) throws IOException {
        User user = getCurrentUser();
        CommonExcelListener<CommonExcelEntity> listener = new CommonExcelListener<CommonExcelEntity>();
        EasyExcel.read(file.getInputStream(),CommonExcelEntity.class,listener).sheet().doRead();

        List<CommonExcelEntity> datas = listener.getDatas();

        if (CollectionUtils.isEmpty(datas)){
            return new FebsResponse().success();
        }

        List<String> orderXsNoList = datas.stream().filter(i -> i.getRow() != null).map(CommonExcelEntity::getRow).collect(Collectors.toList());
        List<String> orderXtNoList = datas.stream().filter(i -> i.getRow1() != null).map(CommonExcelEntity::getRow1).collect(Collectors.toList());

        List<Long> orgList = userOrgService.getUserOrg(user.getUserId());

        List<OrderXsResp> orderXsRespList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(orderXsNoList)){
            OrderXsReq orderXs = new OrderXsReq();
            orderXs.setOrgList(orgList);
            orderXs.setDjbhList(orderXsNoList);
            orderXsRespList = orderXsService.findByXskp(orderXs);
        }

        List<OrderXtResp>  orderXtRespList = new ArrayList<>();
        if (CollectionUtils.isNotEmpty(orderXtNoList)){
            OrderXtReq orderXtReq = new OrderXtReq();
            orderXtReq.setDjbhList(orderXtNoList);
            orderXtRespList = orderXtService.findOrderXts(orderXtReq);
        }


        OrderXskpView orderXskpView = new OrderXskpView();
        orderXskpView.setOrderXsRespList(orderXsRespList);
        orderXskpView.setOrderXtRespList(orderXtRespList);

        return new FebsResponse().success().data(orderXskpView);
    }

    @ApiOperation("开始生成")
    @ControllerEndpoint(operation = "生成", exceptionMessage = "生成失败")
    @PostMapping("")
//    @RequiresPermissions("orderXsfp:create")
    public FebsResponse addOrderXsfp(XsfpCreateReq req) {
        User user = getCurrentUser();
        xsfpBiz.createOrderXsfp(req,user);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除销售发票", exceptionMessage = "删除销售发票失败")
    @GetMapping("delete/{ids}")
//    @RequiresPermissions("orderXsfp:delete")
    public FebsResponse deleteOrderXsfp(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderXsfpService.deleteOrderXsfp(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改销售发票", exceptionMessage = "修改销售发票失败")
    @PostMapping("/update")
//    @RequiresPermissions("orderXsfp:update")
    public FebsResponse updateOrderXsfp(OrderXsfp orderXsfp) {
        this.orderXsfpService.updateOrderXsfp(orderXsfp);
        return new FebsResponse().success();
    }


    @ApiOperation("确认")
    @ControllerEndpoint(operation = "确认销售发票", exceptionMessage = "确认销售发票失败")
    @GetMapping("/confirm/{id}")
//    @RequiresPermissions("orderXsfp:confirm")
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
    @GetMapping("/check/{id}")
//    @RequiresPermissions("orderXsfp:check")
    public FebsResponse orderXsfpCheck(@PathVariable Long id ){
        User user = getCurrentUser();
        OrderXsfp xsfp = new OrderXsfp();
        xsfp.setId(id);
        xsfp.setSh((byte)1);
        xsfp.setAuditor(user.getUsername());
        xsfp.setShrq(new Date());
        xsfpBiz.update(xsfp);
        return new FebsResponse().success();
    }

    @ApiOperation("作废")
    @ControllerEndpoint(operation = "作废", exceptionMessage = "作废失败")
    @GetMapping("/zf/{id}")
//    @RequiresPermissions("orderXsfp:zf")
    public FebsResponse zf(@PathVariable Long id ){
        User user = getCurrentUser();
        OrderXsfp xsfp = new OrderXsfp();
        xsfp.setId(id);
        xsfp.setZf((byte)1);
        xsfp.setZfr(user.getUsername());
        xsfp.setZfrq(new Date());
        xsfpBiz.zf(xsfp);
        return new FebsResponse().success();
    }

    @ApiOperation("开票")
    @ControllerEndpoint(operation = "开票", exceptionMessage = "开票失败")
    @GetMapping("/kp/{djbh}")
//    @RequiresPermissions("orderXsfp:kp")
    public FebsResponse kp(@PathVariable String djbh){
        User user = getCurrentUser();
        xsfpBiz.kp(djbh,user);
        return new FebsResponse().success();
    }

    @ApiOperation("查看")
    @ControllerEndpoint(operation = "查看", exceptionMessage = "查看失败")
    @GetMapping("/view/{id}")
//    @RequiresPermissions("orderXsfp:view")
    public FebsResponse view(@PathVariable Long id ){
        return new FebsResponse().success().data(xsfpBiz.view(id));
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("orderXsfp:export")
    public void export(QueryRequest queryRequest, OrderXsfpReq orderXsfp, HttpServletResponse response) throws IOException {
        List<OrderXsfpResp> orderXsfps = this.orderXsfpService.findOrderXsfps(queryRequest, orderXsfp).getRecords();
        ExcelUtil.export(orderXsfps, OrderXsfpResp.class,"销售发票",response);
    }


}
