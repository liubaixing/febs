package com.febs.system.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.listener.system.KehuDataListener;
import com.febs.common.utils.ExcelUtil;
import com.febs.system.entity.Kehu;
import com.febs.system.service.IKehuService;
import com.febs.system.vo.resp.KehuResp;
import io.swagger.annotations.ApiOperation;
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
 * 客户管理 Controller
 *
 * @author MrBird
 * @date 2020-05-21 21:25:04
 */
@Slf4j
@Validated
@RestController
@RequestMapping("kehu")
public class KehuController extends BaseController {

    @Autowired
    private IKehuService kehuService;
    @GetMapping("")
    @RequiresPermissions("kehu:list")
    public FebsResponse getAllKehus(KehuResp kehu) {
        return new FebsResponse().success().data(kehuService.findKehus(kehu));
    }

    @GetMapping("/list")
    @RequiresPermissions("kehu:list")
    public FebsResponse kehuList(QueryRequest request, KehuResp kehu) {
        Map<String, Object> dataTable = getDataTable(this.kehuService.findKehus(request, kehu));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增客户", exceptionMessage = "新增客户失败")
    @PostMapping("")
    @RequiresPermissions("kehu:add")
    public FebsResponse addKehu(@Valid Kehu kehu) {
        this.kehuService.createKehu(kehu);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除客户", exceptionMessage = "删除客户失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("kehu:delete")
    public FebsResponse deleteKehu(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.kehuService.deleteKehu(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改客户", exceptionMessage = "修改客户失败")
    @PostMapping("/update")
    @RequiresPermissions("kehu:update")
    public FebsResponse updateKehu(Kehu kehu) {
        this.kehuService.updateKehu(kehu);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "导出Excel", exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
//    @RequiresPermissions("kehu:export")
    public void export(QueryRequest queryRequest, KehuResp kehu, HttpServletResponse response)  throws IOException {
        List<KehuResp> kehus = this.kehuService.findKehus(queryRequest, kehu).getRecords();
        ExcelUtil.export(kehus,KehuResp.class,"客户管理",response);
    }

    @ApiOperation("导入")
    @ControllerEndpoint(operation = "导入Excel", exceptionMessage = "导入Excel失败")
    @PostMapping("upload")
    @ResponseBody
    public void upload(@RequestParam MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), KehuResp.class, new KehuDataListener(kehuService)).sheet().doRead();
    }

}
