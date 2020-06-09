package com.febs.shangpin.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.listener.goods.XlDataListener;
import com.febs.common.utils.ExcelUtil;
import com.febs.shangpin.entity.ShangpinXl;
import com.febs.shangpin.service.IShangpinXlService;
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
 * 小类 Controller
 *
 * @author liubaixing1
 * @date 2020-05-22 01:10:54
 */
@Slf4j
@Validated
@RestController
@RequestMapping("shangpinXl")
public class ShangpinXlController extends BaseController {

    @Autowired
    private IShangpinXlService shangpinXlService;


    @GetMapping("")
    @RequiresPermissions("shangpinXl:list")
    public FebsResponse getAllShangpinXls(ShangpinXl shangpinXl) {
        return new FebsResponse().success().data(shangpinXlService.findShangpinXls(shangpinXl));
    }

    @GetMapping("/list")
    @RequiresPermissions("shangpinXl:list")
    public FebsResponse shangpinXlList(QueryRequest request, ShangpinXl shangpinXl) {
        Map<String, Object> dataTable = getDataTable(this.shangpinXlService.findShangpinXls(request, shangpinXl));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增ShangpinXl", exceptionMessage = "新增ShangpinXl失败")
    @PostMapping("")
    @RequiresPermissions("shangpinXl:add")
    public FebsResponse addShangpinXl(@Valid ShangpinXl shangpinXl) {
        this.shangpinXlService.createShangpinXl(shangpinXl);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除ShangpinXl", exceptionMessage = "删除ShangpinXl失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("shangpinXl:delete")
    public FebsResponse deleteShangpinXl(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.shangpinXlService.deleteShangpinXl(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改ShangpinXl", exceptionMessage = "修改ShangpinXl失败")
    @PostMapping("/update")
    @RequiresPermissions("shangpinXl:update")
    public FebsResponse updateShangpinXl(ShangpinXl shangpinXl) {
        this.shangpinXlService.updateShangpinXl(shangpinXl);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
//    @RequiresPermissions("shangpinXl:export")
    public void export(QueryRequest queryRequest, ShangpinXl shangpinXl, HttpServletResponse response) throws IOException {
        List<ShangpinXl> shangpinXls = this.shangpinXlService.findShangpinXls(queryRequest, shangpinXl).getRecords();
        ExcelUtil.export(shangpinXls, ShangpinXl.class,"小类",response);
    }

    @ApiOperation("导入")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @PostMapping("import")
    public void excelImport(@RequestParam MultipartFile file) throws IOException{
        EasyExcel.read(file.getInputStream(), ShangpinXl.class, new XlDataListener(shangpinXlService)).sheet().doRead();
    }
}
