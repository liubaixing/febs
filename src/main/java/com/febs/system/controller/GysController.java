package com.febs.system.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.listener.system.GysDataListener;
import com.febs.common.utils.ExcelUtil;
import com.febs.system.entity.Gys;
import com.febs.system.service.IGysService;
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
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * 供应商 Controller
 *
 * @author MrBird
 * @date 2020-05-22 00:06:57
 */
@Slf4j
@Validated
@RestController
@RequestMapping("gys")
public class GysController extends BaseController {

    @Autowired
    private IGysService gysService;


    @GetMapping("")
    @RequiresPermissions("gys:list")
    public FebsResponse getAllGyss(Gys gys) {
        return new FebsResponse().success().data(gysService.findGyss(gys));
    }

    @GetMapping("/list")
    @RequiresPermissions("gys:list")
    public FebsResponse gysList(QueryRequest request, Gys gys) {
        Map<String, Object> dataTable = getDataTable(this.gysService.findGyss(request, gys));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增供应商", exceptionMessage = "新增供应商失败")
    @PostMapping("")
    @RequiresPermissions("gys:add")
    public FebsResponse addGys(@Valid Gys gys) {
        this.gysService.createGys(gys);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除供应商", exceptionMessage = "删除供应商失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("gys:delete")
    public FebsResponse deleteGys(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.gysService.deleteGys(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改供应商", exceptionMessage = "修改供应商失败")
    @PostMapping("/update")
    @RequiresPermissions("gys:update")
    public FebsResponse updateGys(Gys gys) {
        this.gysService.updateGys(gys);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("gys:export")
    public void export(QueryRequest queryRequest, Gys gys, HttpServletResponse response) throws IOException {
        List<Gys> gyss = this.gysService.findGyss(queryRequest, gys).getRecords();
        ExcelUtil.export(gyss,Gys.class,"供应商管理",response);
    }

    @PostMapping("upload")
    @ResponseBody
    public void upload(@RequestParam MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), Gys.class, new GysDataListener(gysService)).sheet().doRead();
    }
}
