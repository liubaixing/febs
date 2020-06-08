package com.febs.basic.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.basic.entity.BasicJldw;
import com.febs.basic.service.IBasicJldwService;
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
 * 计量单位 Controller
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:11
 */
@Slf4j
@Validated
@RestController
@RequestMapping("basicJldw")
public class BasicJldwController extends BaseController {

    @Autowired
    private IBasicJldwService basicJldwService;


    @GetMapping("")
    @RequiresPermissions("basicJldw:list")
    public FebsResponse getAllBasicJldws(BasicJldw basicJldw) {
        return new FebsResponse().success().data(basicJldwService.findBasicJldws(basicJldw));
    }

    @GetMapping("/list")
    @RequiresPermissions("basicJldw:list")
    public FebsResponse basicJldwList(QueryRequest request, BasicJldw basicJldw) {
        Map<String, Object> dataTable = getDataTable(this.basicJldwService.findBasicJldws(request, basicJldw));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增计量单位", exceptionMessage = "新增计量单位失败")
    @PostMapping("")
    @RequiresPermissions("basicJldw:add")
    public FebsResponse addBasicJldw(@Valid BasicJldw basicJldw) {
        this.basicJldwService.createBasicJldw(basicJldw);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除计量单位", exceptionMessage = "删除计量单位失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("basicJldw:delete")
    public FebsResponse deleteBasicJldw(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.basicJldwService.deleteBasicJldw(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改计量单位", exceptionMessage = "修改计量单位失败")
    @PostMapping("/update")
    @RequiresPermissions("basicJldw:update")
    public FebsResponse updateBasicJldw(BasicJldw basicJldw) {
        this.basicJldwService.updateBasicJldw(basicJldw);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("basicJldw:export")
    public void export(QueryRequest queryRequest, BasicJldw basicJldw, HttpServletResponse response) {
        List<BasicJldw> basicJldws = this.basicJldwService.findBasicJldws(queryRequest, basicJldw).getRecords();
        ExcelKit.$Export(BasicJldw.class, response).downXlsx(basicJldws, false);
    }
}
