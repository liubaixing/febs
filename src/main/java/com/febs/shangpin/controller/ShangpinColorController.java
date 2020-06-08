package com.febs.shangpin.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.shangpin.entity.ShangpinColor;
import com.febs.shangpin.service.IShangpinColorService;
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
 * 商品颜色 Controller
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:53
 */
@Slf4j
@Validated
@RestController
@RequestMapping("shangpinColor")
public class ShangpinColorController extends BaseController {

    @Autowired
    private IShangpinColorService shangpinColorService;


    @GetMapping("")
    @RequiresPermissions("shangpinColor:list")
    public FebsResponse getAllShangpinColors(ShangpinColor shangpinColor) {
        return new FebsResponse().success().data(shangpinColorService.findShangpinColors(shangpinColor));
    }

    @GetMapping("/list")
    @RequiresPermissions("shangpinColor:list")
    public FebsResponse shangpinColorList(QueryRequest request, ShangpinColor shangpinColor) {
        Map<String, Object> dataTable = getDataTable(this.shangpinColorService.findShangpinColors(request, shangpinColor));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增ShangpinColor", exceptionMessage = "新增ShangpinColor失败")
    @PostMapping("")
    @RequiresPermissions("shangpinColor:add")
    public FebsResponse addShangpinColor(@Valid ShangpinColor shangpinColor) {
        this.shangpinColorService.createShangpinColor(shangpinColor);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除ShangpinColor", exceptionMessage = "删除ShangpinColor失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("shangpinColor:delete")
    public FebsResponse deleteShangpinColor(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.shangpinColorService.deleteShangpinColor(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改ShangpinColor", exceptionMessage = "修改ShangpinColor失败")
    @PostMapping("/update")
    @RequiresPermissions("shangpinColor:update")
    public FebsResponse updateShangpinColor(ShangpinColor shangpinColor) {
        this.shangpinColorService.updateShangpinColor(shangpinColor);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("shangpinColor:export")
    public void export(QueryRequest queryRequest, ShangpinColor shangpinColor, HttpServletResponse response) {
        List<ShangpinColor> shangpinColors = this.shangpinColorService.findShangpinColors(queryRequest, shangpinColor).getRecords();
        ExcelKit.$Export(ShangpinColor.class, response).downXlsx(shangpinColors, false);
    }
}
