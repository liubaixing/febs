package com.febs.shangpin.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.shangpin.entity.ShangpinDl;
import com.febs.shangpin.service.IShangpinDlService;
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
 * 大类 Controller
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:00
 */
@Slf4j
@Validated
@RestController
@RequestMapping("shangpinDl")
public class ShangpinDlController extends BaseController {

    @Autowired
    private IShangpinDlService shangpinDlService;


    @GetMapping("")
    @RequiresPermissions("shangpinDl:list")
    public FebsResponse getAllShangpinDls(ShangpinDl shangpinDl) {
        return new FebsResponse().success().data(shangpinDlService.findShangpinDls(shangpinDl));
    }

    @GetMapping("/list")
    @RequiresPermissions("shangpinDl:list")
    public FebsResponse shangpinDlList(QueryRequest request, ShangpinDl shangpinDl) {
        Map<String, Object> dataTable = getDataTable(this.shangpinDlService.findShangpinDls(request, shangpinDl));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增ShangpinDl", exceptionMessage = "新增ShangpinDl失败")
    @PostMapping("")
    @RequiresPermissions("shangpinDl:add")
    public FebsResponse addShangpinDl(@Valid ShangpinDl shangpinDl) {
        this.shangpinDlService.createShangpinDl(shangpinDl);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除ShangpinDl", exceptionMessage = "删除ShangpinDl失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("shangpinDl:delete")
    public FebsResponse deleteShangpinDl(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.shangpinDlService.deleteShangpinDl(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改ShangpinDl", exceptionMessage = "修改ShangpinDl失败")
    @PostMapping("/update")
    @RequiresPermissions("shangpinDl:update")
    public FebsResponse updateShangpinDl(ShangpinDl shangpinDl) {
        this.shangpinDlService.updateShangpinDl(shangpinDl);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("shangpinDl:export")
    public void export(QueryRequest queryRequest, ShangpinDl shangpinDl, HttpServletResponse response) {
        List<ShangpinDl> shangpinDls = this.shangpinDlService.findShangpinDls(queryRequest, shangpinDl).getRecords();
        ExcelKit.$Export(ShangpinDl.class, response).downXlsx(shangpinDls, false);
    }
}
