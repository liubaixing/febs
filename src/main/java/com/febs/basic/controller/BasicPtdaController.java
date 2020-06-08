package com.febs.basic.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.basic.entity.BasicPtda;
import com.febs.basic.service.IBasicPtdaService;
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
 * 平台档案 Controller
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:40
 */
@Slf4j
@Validated
@RestController
@RequestMapping("basicPtda")
public class BasicPtdaController extends BaseController {

    @Autowired
    private IBasicPtdaService basicPtdaService;


    @GetMapping("")
    @RequiresPermissions("basicPtda:list")
    public FebsResponse getAllBasicPtdas(BasicPtda basicPtda) {
        return new FebsResponse().success().data(basicPtdaService.findBasicPtdas(basicPtda));
    }

    @GetMapping("/list")
    @RequiresPermissions("basicPtda:list")
    public FebsResponse basicPtdaList(QueryRequest request, BasicPtda basicPtda) {
        Map<String, Object> dataTable = getDataTable(this.basicPtdaService.findBasicPtdas(request, basicPtda));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增平台档案", exceptionMessage = "新增平台档案失败")
    @PostMapping("")
    @RequiresPermissions("basicPtda:add")
    public FebsResponse addBasicPtda(@Valid BasicPtda basicPtda) {
        this.basicPtdaService.createBasicPtda(basicPtda);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除平台档案", exceptionMessage = "删除平台档案失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("basicPtda:delete")
    public FebsResponse deleteBasicPtda(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.basicPtdaService.deleteBasicPtda(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改平台档案", exceptionMessage = "修改平台档案失败")
    @PostMapping("/update")
    @RequiresPermissions("basicPtda:update")
    public FebsResponse updateBasicPtda(BasicPtda basicPtda) {
        this.basicPtdaService.updateBasicPtda(basicPtda);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("basicPtda:export")
    public void export(QueryRequest queryRequest, BasicPtda basicPtda, HttpServletResponse response) {
        List<BasicPtda> basicPtdas = this.basicPtdaService.findBasicPtdas(queryRequest, basicPtda).getRecords();
        ExcelKit.$Export(BasicPtda.class, response).downXlsx(basicPtdas, false);
    }
}
