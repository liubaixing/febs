package com.febs.basic.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.basic.entity.BasicLlly;
import com.febs.basic.service.IBasicLllyService;
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
 * 流量来源 Controller
 *
 * @author liubaixing
 * @date 2020-05-22 01:40:04
 */
@Slf4j
@Validated
@RestController
@RequestMapping("basicLlly")
public class BasicLllyController extends BaseController {

    @Autowired
    private IBasicLllyService basicLllyService;


    @GetMapping("")
    @RequiresPermissions("basicLlly:list")
    public FebsResponse getAllBasicLllys(BasicLlly basicLlly) {
        return new FebsResponse().success().data(basicLllyService.findBasicLllys(basicLlly));
    }

    @GetMapping("/list")
    @RequiresPermissions("basicLlly:list")
    public FebsResponse basicLllyList(QueryRequest request, BasicLlly basicLlly) {
        Map<String, Object> dataTable = getDataTable(this.basicLllyService.findBasicLllys(request, basicLlly));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增流量来源", exceptionMessage = "新增流量来源失败")
    @PostMapping("")
    @RequiresPermissions("basicLlly:add")
    public FebsResponse addBasicLlly(@Valid BasicLlly basicLlly) {
        this.basicLllyService.createBasicLlly(basicLlly);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除流量来源", exceptionMessage = "删除流量来源失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("basicLlly:delete")
    public FebsResponse deleteBasicLlly(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.basicLllyService.deleteBasicLlly(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改流量来源", exceptionMessage = "修改流量来源失败")
    @PostMapping("/update")
    @RequiresPermissions("basicLlly:update")
    public FebsResponse updateBasicLlly(BasicLlly basicLlly) {
        this.basicLllyService.updateBasicLlly(basicLlly);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("basicLlly:export")
    public void export(QueryRequest queryRequest, BasicLlly basicLlly, HttpServletResponse response) {
        List<BasicLlly> basicLllys = this.basicLllyService.findBasicLllys(queryRequest, basicLlly).getRecords();
        ExcelKit.$Export(BasicLlly.class, response).downXlsx(basicLllys, false);
    }
}
