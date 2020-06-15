package com.febs.receipt.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.listener.TempDataListener;
import com.febs.common.listener.receipt.OrderXslistener;
import com.febs.common.utils.ExcelUtil;
import com.febs.receipt.biz.OrderXsmxBiz;
import com.febs.receipt.entity.OrderXsmx;
import com.febs.receipt.entity.Temp;
import com.febs.receipt.service.IOrderXsmxService;

import com.febs.receipt.vo.req.OrderXsmxReq;
import com.febs.receipt.vo.resp.OrderXsResp;
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
import java.util.List;
import java.util.Map;

/**
 * 销售单明细 Controller
 *
 * @author liubaixing
 * @date 2020-06-11 13:59:06
 */
@Slf4j
@Validated
@RestController
@RequestMapping("orderXsmx")
public class OrderXsmxController extends BaseController {

    @Autowired
    private IOrderXsmxService orderXsmxService;

    @Autowired
    private OrderXsmxBiz xsmxBiz;

    @GetMapping("")
    @RequiresPermissions("orderXsmx:list")
    public FebsResponse getAllOrderXsmxs(OrderXsmx orderXsmx) {
        return new FebsResponse().success().data(orderXsmxService.findOrderXsmxs(orderXsmx));
    }

    @GetMapping("/list")
    @RequiresPermissions("orderXsmx:list")
    public FebsResponse orderXsmxList(QueryRequest request, OrderXsmxReq orderXsmx) {
        Map<String, Object> dataTable = getDataTable(this.xsmxBiz.findPage(request, orderXsmx));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增销售单明细", exceptionMessage = "新增销售单明细失败")
    @PostMapping("")
    @RequiresPermissions("orderXsmx:add")
    public FebsResponse addOrderXsmx(@Valid OrderXsmx orderXsmx) {
        this.xsmxBiz.create(orderXsmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除销售单明细", exceptionMessage = "删除销售单明细失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("orderXsmx:delete")
    public FebsResponse deleteOrderXsmx(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.xsmxBiz.delete(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改销售单明细", exceptionMessage = "修改销售单明细失败")
    @PostMapping("/update")
    @RequiresPermissions("orderXsmx:update")
    public FebsResponse updateOrderXsmx(OrderXsmx orderXsmx) {
        this.xsmxBiz.update(orderXsmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("orderXsmx:export")
    public void export(QueryRequest queryRequest, OrderXsmxReq orderXsmx, HttpServletResponse response) throws IOException {
        List<OrderXsmx> orderXsmxs = this.orderXsmxService.findOrderXsmxs(queryRequest, orderXsmx).getRecords();
        ExcelUtil.export(orderXsmxs, OrderXsmx.class,"销售单明细",response);
    }

    @ApiOperation("导入")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @PostMapping("import")
    public void excelImport(@RequestParam MultipartFile file) throws IOException{
        EasyExcel.read(file.getInputStream(), Temp.class, new TempDataListener()).sheet().doRead();
    }

}
