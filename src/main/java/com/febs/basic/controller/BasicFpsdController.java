package com.febs.basic.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.basic.entity.BasicFpsd;
import com.febs.basic.service.IBasicFpsdService;
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
 * 发票税点 Controller
 *
 * @author liubaixing
 * @date 2020-05-22 01:27:27
 */
@Slf4j
@Validated
@RestController
@RequestMapping("basicFpsd")
public class BasicFpsdController extends BaseController {

    @Autowired
    private IBasicFpsdService basicFpsdService;


    @GetMapping("")
    @RequiresPermissions("basicFpsd:list")
    public FebsResponse getAllBasicFpsds(BasicFpsd basicFpsd) {
        return new FebsResponse().success().data(basicFpsdService.findBasicFpsds(basicFpsd));
    }

    @GetMapping("/list")
    @RequiresPermissions("basicFpsd:list")
    public FebsResponse basicFpsdList(QueryRequest request, BasicFpsd basicFpsd) {
        Map<String, Object> dataTable = getDataTable(this.basicFpsdService.findBasicFpsds(request, basicFpsd));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增发票税点", exceptionMessage = "新增发票税点失败")
    @PostMapping("")
    @RequiresPermissions("basicFpsd:add")
    public FebsResponse addBasicFpsd(@Valid BasicFpsd basicFpsd) {
        this.basicFpsdService.createBasicFpsd(basicFpsd);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除发票税点", exceptionMessage = "删除发票税点失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("basicFpsd:delete")
    public FebsResponse deleteBasicFpsd(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.basicFpsdService.deleteBasicFpsd(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改发票税点", exceptionMessage = "修改发票税点失败")
    @PostMapping("/update")
    @RequiresPermissions("basicFpsd:update")
    public FebsResponse updateBasicFpsd(BasicFpsd basicFpsd) {
        this.basicFpsdService.updateBasicFpsd(basicFpsd);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("basicFpsd:export")
    public void export(QueryRequest queryRequest, BasicFpsd basicFpsd, HttpServletResponse response) {
        List<BasicFpsd> basicFpsds = this.basicFpsdService.findBasicFpsds(queryRequest, basicFpsd).getRecords();
        ExcelKit.$Export(BasicFpsd.class, response).downXlsx(basicFpsds, false);
    }
}
