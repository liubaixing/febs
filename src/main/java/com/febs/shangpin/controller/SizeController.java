package com.febs.shangpin.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.shangpin.entity.Size;
import com.febs.shangpin.service.ISizeService;
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
 * 尺码 Controller
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:58
 */
@Slf4j
@Validated
@RestController
@RequestMapping("size")
public class SizeController extends BaseController {

    @Autowired
    private ISizeService sizeService;


    @GetMapping("")
    @RequiresPermissions("size:list")
    public FebsResponse getAllSizes(Size size) {
        return new FebsResponse().success().data(sizeService.findSizes(size));
    }

    @GetMapping("/list")
    @RequiresPermissions("size:list")
    public FebsResponse sizeList(QueryRequest request, Size size) {
        Map<String, Object> dataTable = getDataTable(this.sizeService.findSizes(request, size));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Size", exceptionMessage = "新增Size失败")
    @PostMapping("")
    @RequiresPermissions("size:add")
    public FebsResponse addSize(@Valid Size size) {
        this.sizeService.createSize(size);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Size", exceptionMessage = "删除Size失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("size:delete")
    public FebsResponse deleteSize(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.sizeService.deleteSize(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Size", exceptionMessage = "修改Size失败")
    @PostMapping("/update")
    @RequiresPermissions("size:update")
    public FebsResponse updateSize(Size size) {
        this.sizeService.updateSize(size);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("size:export")
    public void export(QueryRequest queryRequest, Size size, HttpServletResponse response) {
        List<Size> sizes = this.sizeService.findSizes(queryRequest, size).getRecords();
        ExcelKit.$Export(Size.class, response).downXlsx(sizes, false);
    }
}
