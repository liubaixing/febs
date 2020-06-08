package com.febs.system.controller;

import ControllerEndpoint;
import FebsUtil;
import FebsConstant;
import BaseController;
import FebsResponse;
import QueryRequest;
import ${basePackage}.${entityPackage}.${className};
import ${basePackage}.${servicePackage}.I${className}Service;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
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
 * ${tableComment} Controller
 *
 * @author ${author}
 * @date ${date}
 */
@Slf4j
@Validated
@RestController
@RequestMapping("${className?uncap_first}")
public class ${className}Controller extends BaseController {

    @Autowired
    private I${className}Service ${className?uncap_first}Service;


    @GetMapping("")
    @RequiresPermissions("${className?uncap_first}:list")
    public FebsResponse getAll${className}s(${className} ${className?uncap_first}) {
        return new FebsResponse().success().data(${className?uncap_first}Service.find${className}s(${className?uncap_first}));
    }

    @GetMapping("/list")
    @RequiresPermissions("${className?uncap_first}:list")
    public FebsResponse ${className?uncap_first}List(QueryRequest request, ${className} ${className?uncap_first}) {
        Map<String, Object> dataTable = getDataTable(this.${className?uncap_first}Service.find${className}s(request, ${className?uncap_first}));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增${tableComment}", exceptionMessage = "新增${tableComment}失败")
    @PostMapping("")
    @RequiresPermissions("${className?uncap_first}:add")
    public FebsResponse add${className}(@Valid ${className} ${className?uncap_first}) {
        this.${className?uncap_first}Service.create${className}(${className?uncap_first});
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除${tableComment}", exceptionMessage = "删除${tableComment}失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("${className?uncap_first}:delete")
    public FebsResponse delete${className}(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.${className?uncap_first}Service.delete${className}(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改${tableComment}", exceptionMessage = "修改${tableComment}失败")
    @PostMapping("/update")
    @RequiresPermissions("${className?uncap_first}:update")
    public FebsResponse update${className}(${className} ${className?uncap_first}) {
        this.${className?uncap_first}Service.update${className}(${className?uncap_first});
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("${className?uncap_first}:export")
    public void export(QueryRequest queryRequest, ${className} ${className?uncap_first}, HttpServletResponse response) {
        List<${className}> ${className?uncap_first}s = this.${className?uncap_first}Service.find${className}s(queryRequest, ${className?uncap_first}).getRecords();
        ExcelKit.$Export(${className}.class, response).downXlsx(${className?uncap_first}s, false);
    }
}
