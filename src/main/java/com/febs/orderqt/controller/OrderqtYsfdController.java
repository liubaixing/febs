package com.febs.orderqt.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.entity.excel.YfdExcelModel;
import com.febs.common.listener.UploadDataListener;
import com.febs.common.utils.ExcelUtil;
import com.febs.orderqt.biz.OrderqtYsfdBiz;
import com.febs.orderqt.entity.OrderqtYsfd;
import com.febs.orderqt.service.IOrderqtYsfdService;
import com.febs.orderqt.vo.req.YsfdReq;
import com.febs.orderqt.vo.resp.YsfdResp;
import com.febs.system.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
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
 * 印刷费单 Controller
 *
 * @author liubaixing
 * @date 2020-07-29 14:14:23
 */
@Slf4j
@Api(tags = "印刷费单")
@Validated
@RestController
@RequestMapping("orderqtYsfd")
public class OrderqtYsfdController extends BaseController {

    @Autowired
    private IOrderqtYsfdService orderqtYsfdService;

    @Autowired
    private OrderqtYsfdBiz ysfdBiz;

    @GetMapping("")
//    @RequiresPermissions("orderqtYsfd:list")
    public FebsResponse getAllOrderqtYsfds(YsfdReq req) {
        return new FebsResponse().success().data(orderqtYsfdService.findOrderqtYsfds(req));
    }

    @GetMapping("/list")
//    @RequiresPermissions("orderqtYsfd:list")
    public FebsResponse orderqtYsfdList(QueryRequest request, YsfdReq req) {
        Map<String, Object> dataTable = getDataTable(this.orderqtYsfdService.findOrderqtYsfds(request, req));
        return new FebsResponse().success().data(dataTable);
    }


    @GetMapping("/view/{id}")
//    @RequiresPermissions("orderqtYfd:list")
    public FebsResponse view(@PathVariable("id")Long id) {
        return new FebsResponse().success().data(ysfdBiz.view(id));
    }

    @ApiOperation("新增")
    @ControllerEndpoint(operation = "新增印刷费单", exceptionMessage = "新增印刷费单失败")
    @PostMapping("")
//    @RequiresPermissions("orderqtYsfd:add")
    public FebsResponse addOrderqtYsfd(@Valid YsfdReq req) {
        ysfdBiz.create(req);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除印刷费单", exceptionMessage = "删除印刷费单失败")
    @GetMapping("delete/{ids}")
//    @RequiresPermissions("orderqtYsfd:delete")
    public FebsResponse deleteOrderqtYsfd(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderqtYsfdService.deleteOrderqtYsfd(id);
        return new FebsResponse().success();
    }

    @ApiOperation("修改")
    @ControllerEndpoint(operation = "修改印刷费单", exceptionMessage = "修改印刷费单失败")
    @PostMapping("/update")
//    @RequiresPermissions("orderqtYsfd:update")
    public FebsResponse updateOrderqtYsfd(YsfdReq req) {
        ysfdBiz.update(req);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
//    @RequiresPermissions("orderqtYsfd:export")
    public void export(QueryRequest queryRequest, YsfdReq req, HttpServletResponse response) throws IOException {
        List<YsfdResp> orderqtYsfds = this.orderqtYsfdService.findOrderqtYsfds(queryRequest, req).getRecords();
        ExcelUtil.export(orderqtYsfds, YsfdResp.class,"印刷费单",response);
    }

    @ApiOperation("导入")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @PostMapping("upload")
    public void upload(@RequestParam MultipartFile file) throws IOException{
        EasyExcel.read(file.getInputStream(), YfdExcelModel.class,new UploadDataListener(orderqtYsfdService)).sheet().doRead();
    }

    @ControllerEndpoint(exceptionMessage = "审核失败")
    @GetMapping("/sh/{id}")
//    @RequiresPermissions("orderqtYfd:export")
    public FebsResponse sh(@PathVariable("id")Long id) throws IOException {
        User user = getCurrentUser();
        OrderqtYsfd orderqtYsfd = new OrderqtYsfd();
        orderqtYsfd.setId(id);
        orderqtYsfd.setSh((byte)1);
        orderqtYsfd.setAuditor(user.getUsername());
        orderqtYsfd.setShrq(new Date());
        this.orderqtYsfdService.updateOrderqtYsfd(orderqtYsfd);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "作废失败")
    @GetMapping("/zf/{id}")
//    @RequiresPermissions("orderqtYfd:export")
    public FebsResponse zf(@PathVariable("id")Long id) throws IOException {
        User user = getCurrentUser();
        OrderqtYsfd orderqtYsfd = new OrderqtYsfd();
        orderqtYsfd.setId(id);
        orderqtYsfd.setZf((byte) 1);
        orderqtYsfd.setZfr(user.getUsername());
        orderqtYsfd.setZfrq(new Date());
        this.orderqtYsfdService.updateOrderqtYsfd(orderqtYsfd);
        return new FebsResponse().success();
    }
}
