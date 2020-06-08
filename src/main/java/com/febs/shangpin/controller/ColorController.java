package com.febs.shangpin.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.shangpin.entity.Color;
import com.febs.shangpin.service.IColorService;
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
 * 颜色 Controller
 *
 * @author liubaixing
 * @date 2020-05-22 00:59:30
 */
@Slf4j
@Validated
@RestController
@RequestMapping("color")
public class ColorController extends BaseController {

    @Autowired
    private IColorService colorService;


    @GetMapping("")
    @RequiresPermissions("color:list")
    public FebsResponse getAllColors(Color color) {
        return new FebsResponse().success().data(colorService.findColors(color));
    }

    @GetMapping("/list")
    @RequiresPermissions("color:list")
    public FebsResponse colorList(QueryRequest request, Color color) {
        Map<String, Object> dataTable = getDataTable(this.colorService.findColors(request, color));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Color", exceptionMessage = "新增Color失败")
    @PostMapping("")
    @RequiresPermissions("color:add")
    public FebsResponse addColor(@Valid Color color) {
        this.colorService.createColor(color);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Color", exceptionMessage = "删除Color失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("color:delete")
    public FebsResponse deleteColor(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.colorService.deleteColor(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Color", exceptionMessage = "修改Color失败")
    @PostMapping("/update")
    @RequiresPermissions("color:update")
    public FebsResponse updateColor(Color color) {
        this.colorService.updateColor(color);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("color:export")
    public void export(QueryRequest queryRequest, Color color, HttpServletResponse response) {
        List<Color> colors = this.colorService.findColors(queryRequest, color).getRecords();
        ExcelKit.$Export(Color.class, response).downXlsx(colors, false);
    }
}
