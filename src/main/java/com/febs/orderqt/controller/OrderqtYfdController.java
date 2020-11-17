package com.febs.orderqt.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.orderqt.biz.OrderqtYfdBiz;
import com.febs.orderqt.entity.OrderqtYfd;
import com.febs.orderqt.service.IOrderqtYfdService;
import com.febs.orderqt.vo.req.YfdReq;
import com.febs.orderqt.vo.resp.YfdResp;
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
 * 运费单 Controller
 *
 * @author liubaixing
 * @date 2020-07-29 14:14:12
 */
@Slf4j
@Api(tags = "运费单")
@Validated
@RestController
@RequestMapping("orderqtYfd")
public class OrderqtYfdController extends BaseController {

    @Autowired
    private IOrderqtYfdService orderqtYfdService;

    @Autowired
    private OrderqtYfdBiz yfdBiz;


    @GetMapping("")
//    @RequiresPermissions("orderqtYfd:list")
    public FebsResponse getAllOrderqtYfds(YfdReq req) {
        return new FebsResponse().success().data(orderqtYfdService.findOrderqtYfds(req));
    }

    @GetMapping("/list")
//    @RequiresPermissions("orderqtYfd:list")
    public FebsResponse orderqtYfdList(QueryRequest request, YfdReq req) {
        Map<String, Object> dataTable = getDataTable(this.orderqtYfdService.findOrderqtYfds(request, req));
        return new FebsResponse().success().data(dataTable);
    }

    @GetMapping("/view/{id}")
//    @RequiresPermissions("orderqtYfd:list")
    public FebsResponse view(@PathVariable("id")Long id) {
        return new FebsResponse().success().data(yfdBiz.view(id));
    }

    @ApiOperation("新增")
    @ControllerEndpoint(operation = "新增运费单", exceptionMessage = "新增运费单失败")
    @PostMapping("")
//    @RequiresPermissions("orderqtYfd:add")
    public FebsResponse addOrderqtYfd(YfdReq req) {
        User user = getCurrentUser();
        req.setZdr(user.getUsername());
        req.setZdrq(new Date());
        yfdBiz.create(req);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除运费单", exceptionMessage = "删除运费单失败")
    @GetMapping("delete/{ids}")
//    @RequiresPermissions("orderqtYfd:delete")
    public FebsResponse deleteOrderqtYfd(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderqtYfdService.deleteOrderqtYfd(id);
        return new FebsResponse().success();
    }

    @ApiOperation("修改")
    @ControllerEndpoint(operation = "修改运费单", exceptionMessage = "修改运费单失败")
    @PostMapping("/update")
//    @RequiresPermissions("orderqtYfd:update")
    public FebsResponse updateOrderqtYfd(YfdReq req) {
        yfdBiz.update(req);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
//    @RequiresPermissions("orderqtYfd:export")
    public void export(QueryRequest queryRequest, YfdReq req, HttpServletResponse response) throws IOException {
        List<YfdResp> orderqtYfds = this.orderqtYfdService.findOrderqtYfds(queryRequest, req).getRecords();
        ExcelUtil.export(orderqtYfds, YfdResp.class,"运费单",response);
    }

    @ApiOperation("审核")
    @ControllerEndpoint(exceptionMessage = "审核失败")
    @GetMapping("/sh/{id}")
//    @RequiresPermissions("orderqtYfd:export")
    public FebsResponse sh(@PathVariable("id")Long id) throws IOException {
        User user = getCurrentUser();
        OrderqtYfd orderqtYfd = new OrderqtYfd();
        orderqtYfd.setId(id);
        orderqtYfd.setSh((byte)1);
        orderqtYfd.setAuditor(user.getUsername());
        orderqtYfd.setShrq(new Date());
        this.orderqtYfdService.updateOrderqtYfd(orderqtYfd);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "作废失败")
    @GetMapping("/zf/{id}")
//    @RequiresPermissions("orderqtYfd:export")
    public FebsResponse zf(@PathVariable("id")Long id) throws IOException {
        User user = getCurrentUser();
        OrderqtYfd orderqtYfd = new OrderqtYfd();
        orderqtYfd.setId(id);
        orderqtYfd.setZf((byte)1);
        orderqtYfd.setZfr(user.getUsername());
        orderqtYfd.setZfrq(new Date());
        this.orderqtYfdService.updateOrderqtYfd(orderqtYfd);
        return new FebsResponse().success();
    }

    @ApiOperation("导入")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @PostMapping("upload")
    public void upload(@RequestParam MultipartFile file) throws IOException{
//        EasyExcel.read(file.getInputStream(), OrderXsResp.class, new OrderXslistener(orderXsBiz)).sheet().doRead();//http://47.114.158.77/
    }

}
