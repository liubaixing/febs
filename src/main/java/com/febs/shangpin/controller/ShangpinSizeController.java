package com.febs.shangpin.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.shangpin.entity.ShangpinSize;
import com.febs.shangpin.service.IShangpinSizeService;
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
 * 商品尺码 Controller
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:46
 */
@Slf4j
@Validated
@RestController
@RequestMapping("shangpinSize")
public class ShangpinSizeController extends BaseController {

    @Autowired
    private IShangpinSizeService shangpinSizeService;


    @GetMapping("")
    @RequiresPermissions("shangpinSize:list")
    public FebsResponse getAllShangpinSizes(ShangpinSize shangpinSize) {
        return new FebsResponse().success().data(shangpinSizeService.findShangpinSizes(shangpinSize));
    }

    @GetMapping("/list")
    @RequiresPermissions("shangpinSize:list")
    public FebsResponse shangpinSizeList(QueryRequest request, ShangpinSize shangpinSize) {
        Map<String, Object> dataTable = getDataTable(this.shangpinSizeService.findShangpinSizes(request, shangpinSize));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增ShangpinSize", exceptionMessage = "新增ShangpinSize失败")
    @PostMapping("")
    @RequiresPermissions("shangpinSize:add")
    public FebsResponse addShangpinSize(@Valid ShangpinSize shangpinSize) {
        this.shangpinSizeService.createShangpinSize(shangpinSize);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除ShangpinSize", exceptionMessage = "删除ShangpinSize失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("shangpinSize:delete")
    public FebsResponse deleteShangpinSize(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.shangpinSizeService.deleteShangpinSize(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改ShangpinSize", exceptionMessage = "修改ShangpinSize失败")
    @PostMapping("/update")
    @RequiresPermissions("shangpinSize:update")
    public FebsResponse updateShangpinSize(ShangpinSize shangpinSize) {
        this.shangpinSizeService.updateShangpinSize(shangpinSize);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("shangpinSize:export")
    public void export(QueryRequest queryRequest, ShangpinSize shangpinSize, HttpServletResponse response) {
        List<ShangpinSize> shangpinSizes = this.shangpinSizeService.findShangpinSizes(queryRequest, shangpinSize).getRecords();
        ExcelKit.$Export(ShangpinSize.class, response).downXlsx(shangpinSizes, false);
    }
}
