package com.febs.basic.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.basic.entity.BasicKhlb;
import com.febs.basic.service.IBasicKhlbService;
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
 * 客户类别 Controller
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:16
 */
@Slf4j
@Validated
@RestController
@RequestMapping("basicKhlb")
public class BasicKhlbController extends BaseController {

    @Autowired
    private IBasicKhlbService basicKhlbService;


    @GetMapping("")
    @RequiresPermissions("basicKhlb:list")
    public FebsResponse getAllBasicKhlbs(BasicKhlb basicKhlb) {
        return new FebsResponse().success().data(basicKhlbService.findBasicKhlbs(basicKhlb));
    }

    @GetMapping("/list")
    @RequiresPermissions("basicKhlb:list")
    public FebsResponse basicKhlbList(QueryRequest request, BasicKhlb basicKhlb) {
        Map<String, Object> dataTable = getDataTable(this.basicKhlbService.findBasicKhlbs(request, basicKhlb));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增客户类别", exceptionMessage = "新增客户类别失败")
    @PostMapping("")
    @RequiresPermissions("basicKhlb:add")
    public FebsResponse addBasicKhlb(@Valid BasicKhlb basicKhlb) {
        this.basicKhlbService.createBasicKhlb(basicKhlb);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除客户类别", exceptionMessage = "删除客户类别失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("basicKhlb:delete")
    public FebsResponse deleteBasicKhlb(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.basicKhlbService.deleteBasicKhlb(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改客户类别", exceptionMessage = "修改客户类别失败")
    @PostMapping("/update")
    @RequiresPermissions("basicKhlb:update")
    public FebsResponse updateBasicKhlb(BasicKhlb basicKhlb) {
        this.basicKhlbService.updateBasicKhlb(basicKhlb);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("basicKhlb:export")
    public void export(QueryRequest queryRequest, BasicKhlb basicKhlb, HttpServletResponse response) {
        List<BasicKhlb> basicKhlbs = this.basicKhlbService.findBasicKhlbs(queryRequest, basicKhlb).getRecords();
        ExcelKit.$Export(BasicKhlb.class, response).downXlsx(basicKhlbs, false);
    }
}
