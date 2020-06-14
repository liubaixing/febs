package com.febs.system.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.listener.system.BumengDataListener;
import com.febs.common.listener.system.CangkuDataListener;
import com.febs.common.utils.ExcelUtil;
import com.febs.system.entity.Bumeng;
import com.febs.system.entity.Cangku;
import com.febs.system.service.IBumengService;

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
 * 部门管理 Controller
 *
 * @author liubaixing
 * @date 2020-06-14 17:15:53
 */
@Slf4j
@Validated
@RestController
@RequestMapping("bumeng")
public class BumengController extends BaseController {

    @Autowired
    private IBumengService bumengService;


    @GetMapping("")
    @RequiresPermissions("bumeng:list")
    public FebsResponse getAllBumengs(Bumeng bumeng) {
        return new FebsResponse().success().data(bumengService.findBumengs(bumeng));
    }

    @GetMapping("/list")
    @RequiresPermissions("bumeng:list")
    public FebsResponse bumengList(QueryRequest request, Bumeng bumeng) {
        Map<String, Object> dataTable = getDataTable(this.bumengService.findBumengs(request, bumeng));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增部门管理", exceptionMessage = "新增部门管理失败")
    @PostMapping("")
    @RequiresPermissions("bumeng:add")
    public FebsResponse addBumeng(@Valid Bumeng bumeng) {
        this.bumengService.createBumeng(bumeng);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除部门管理", exceptionMessage = "删除部门管理失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("bumeng:delete")
    public FebsResponse deleteBumeng(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.bumengService.deleteBumeng(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改部门管理", exceptionMessage = "修改部门管理失败")
    @PostMapping("/update")
    @RequiresPermissions("bumeng:update")
    public FebsResponse updateBumeng(Bumeng bumeng) {
        this.bumengService.updateBumeng(bumeng);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("bumeng:export")
    public void export(QueryRequest queryRequest, Bumeng bumeng, HttpServletResponse response) throws IOException {
        List<Bumeng> bumengs = this.bumengService.findBumengs(queryRequest, bumeng).getRecords();
        ExcelUtil.export(bumengs,Bumeng.class,"部门管理",response);
    }

    @PostMapping("upload")
    @ResponseBody
    public void upload(@RequestParam MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), Bumeng.class, new BumengDataListener(bumengService)).sheet().doRead();
    }
}
