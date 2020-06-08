package com.febs.basic.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.basic.entity.BasicCklb;
import com.febs.basic.service.IBasicCklbService;
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
 * 仓库类别 Controller
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:18
 */
@Slf4j
@Validated
@RestController
@RequestMapping("basicCklb")
public class BasicCklbController extends BaseController {

    @Autowired
    private IBasicCklbService basicCklbService;


    @GetMapping("")
    @RequiresPermissions("basicCklb:list")
    public FebsResponse getAllBasicCklbs(BasicCklb basicCklb) {
        return new FebsResponse().success().data(basicCklbService.findBasicCklbs(basicCklb));
    }

    @GetMapping("/list")
    @RequiresPermissions("basicCklb:list")
    public FebsResponse basicCklbList(QueryRequest request, BasicCklb basicCklb) {
        Map<String, Object> dataTable = getDataTable(this.basicCklbService.findBasicCklbs(request, basicCklb));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增仓库类别", exceptionMessage = "新增仓库类别失败")
    @PostMapping("")
    @RequiresPermissions("basicCklb:add")
    public FebsResponse addBasicCklb(@Valid BasicCklb basicCklb) {
        this.basicCklbService.createBasicCklb(basicCklb);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除仓库类别", exceptionMessage = "删除仓库类别失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("basicCklb:delete")
    public FebsResponse deleteBasicCklb(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.basicCklbService.deleteBasicCklb(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改仓库类别", exceptionMessage = "修改仓库类别失败")
    @PostMapping("/update")
    @RequiresPermissions("basicCklb:update")
    public FebsResponse updateBasicCklb(BasicCklb basicCklb) {
        this.basicCklbService.updateBasicCklb(basicCklb);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("basicCklb:export")
    public void export(QueryRequest queryRequest, BasicCklb basicCklb, HttpServletResponse response) {
        List<BasicCklb> basicCklbs = this.basicCklbService.findBasicCklbs(queryRequest, basicCklb).getRecords();
        ExcelKit.$Export(BasicCklb.class, response).downXlsx(basicCklbs, false);
    }
}
