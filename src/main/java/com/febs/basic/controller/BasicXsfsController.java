package com.febs.basic.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.basic.entity.BasicXsfs;
import com.febs.basic.service.IBasicXsfsService;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;
import java.util.Map;

/**
 * 销售方式 Controller
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:45
 */
@Slf4j
@Validated
@RestController
@RequestMapping("basicXsfs")
public class BasicXsfsController extends BaseController {

    @Autowired
    private IBasicXsfsService basicXsfsService;


    @GetMapping("")
    @RequiresPermissions("basicXsfs:list")
    public FebsResponse getAllBasicXsfss(BasicXsfs basicXsfs) {
        return new FebsResponse().success().data(basicXsfsService.findBasicXsfss(basicXsfs));
    }

    @GetMapping("/list")
    @RequiresPermissions("basicXsfs:list")
    public FebsResponse basicXsfsList(QueryRequest request, BasicXsfs basicXsfs) {
        Map<String, Object> dataTable = getDataTable(this.basicXsfsService.findBasicXsfss(request, basicXsfs));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增销售方式", exceptionMessage = "新增销售方式失败")
    @PostMapping("")
    @RequiresPermissions("basicXsfs:add")
    public FebsResponse addBasicXsfs(@Valid BasicXsfs basicXsfs) {
        this.basicXsfsService.createBasicXsfs(basicXsfs);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除销售方式", exceptionMessage = "删除销售方式失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("basicXsfs:delete")
    public FebsResponse deleteBasicXsfs(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.basicXsfsService.deleteBasicXsfs(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改销售方式", exceptionMessage = "修改销售方式失败")
    @PostMapping("/update")
    @RequiresPermissions("basicXsfs:update")
    public FebsResponse updateBasicXsfs(BasicXsfs basicXsfs) {
        this.basicXsfsService.updateBasicXsfs(basicXsfs);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("basicXsfs:export")
    public void export(QueryRequest queryRequest, BasicXsfs basicXsfs, HttpServletResponse response) {
        List<BasicXsfs> basicXsfss = this.basicXsfsService.findBasicXsfss(queryRequest, basicXsfs).getRecords();
        ExcelKit.$Export(BasicXsfs.class, response).downXlsx(basicXsfss, false);
    }
}
