package com.febs.basic.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.basic.entity.BasicKhqy;
import com.febs.basic.service.IBasicKhqyService;
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
 * 客户区域 Controller
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:58
 */
@Slf4j
@Validated
@RestController
@RequestMapping("basicKhqy")
public class BasicKhqyController extends BaseController {

    @Autowired
    private IBasicKhqyService basicKhqyService;


    @GetMapping("")
    @RequiresPermissions("basicKhqy:list")
    public FebsResponse getAllBasicKhqys(BasicKhqy basicKhqy) {
        return new FebsResponse().success().data(basicKhqyService.findBasicKhqys(basicKhqy));
    }

    @GetMapping("/list")
    @RequiresPermissions("basicKhqy:list")
    public FebsResponse basicKhqyList(QueryRequest request, BasicKhqy basicKhqy) {
        Map<String, Object> dataTable = getDataTable(this.basicKhqyService.findBasicKhqys(request, basicKhqy));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增客户区域", exceptionMessage = "新增客户区域失败")
    @PostMapping("")
    @RequiresPermissions("basicKhqy:add")
    public FebsResponse addBasicKhqy(@Valid BasicKhqy basicKhqy) {
        this.basicKhqyService.createBasicKhqy(basicKhqy);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除客户区域", exceptionMessage = "删除客户区域失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("basicKhqy:delete")
    public FebsResponse deleteBasicKhqy(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.basicKhqyService.deleteBasicKhqy(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改客户区域", exceptionMessage = "修改客户区域失败")
    @PostMapping("/update")
    @RequiresPermissions("basicKhqy:update")
    public FebsResponse updateBasicKhqy(BasicKhqy basicKhqy) {
        this.basicKhqyService.updateBasicKhqy(basicKhqy);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("basicKhqy:export")
    public void export(QueryRequest queryRequest, BasicKhqy basicKhqy, HttpServletResponse response) {
        List<BasicKhqy> basicKhqys = this.basicKhqyService.findBasicKhqys(queryRequest, basicKhqy).getRecords();
        ExcelKit.$Export(BasicKhqy.class, response).downXlsx(basicKhqys, false);
    }
}
