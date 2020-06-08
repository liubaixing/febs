package com.febs.basic.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.basic.entity.BasicFklx;
import com.febs.basic.service.IBasicFklxService;
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
 * 付款类型 Controller
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:34
 */
@Slf4j
@Validated
@RestController
@RequestMapping("basicFklx")
public class BasicFklxController extends BaseController {

    @Autowired
    private IBasicFklxService basicFklxService;


    @GetMapping("")
    @RequiresPermissions("basicFklx:list")
    public FebsResponse getAllBasicFklxs(BasicFklx basicFklx) {
        return new FebsResponse().success().data(basicFklxService.findBasicFklxs(basicFklx));
    }

    @GetMapping("/list")
    @RequiresPermissions("basicFklx:list")
    public FebsResponse basicFklxList(QueryRequest request, BasicFklx basicFklx) {
        Map<String, Object> dataTable = getDataTable(this.basicFklxService.findBasicFklxs(request, basicFklx));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增付款类型", exceptionMessage = "新增付款类型失败")
    @PostMapping("")
    @RequiresPermissions("basicFklx:add")
    public FebsResponse addBasicFklx(@Valid BasicFklx basicFklx) {
        this.basicFklxService.createBasicFklx(basicFklx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除付款类型", exceptionMessage = "删除付款类型失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("basicFklx:delete")
    public FebsResponse deleteBasicFklx(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.basicFklxService.deleteBasicFklx(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改付款类型", exceptionMessage = "修改付款类型失败")
    @PostMapping("/update")
    @RequiresPermissions("basicFklx:update")
    public FebsResponse updateBasicFklx(BasicFklx basicFklx) {
        this.basicFklxService.updateBasicFklx(basicFklx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("basicFklx:export")
    public void export(QueryRequest queryRequest, BasicFklx basicFklx, HttpServletResponse response) {
        List<BasicFklx> basicFklxs = this.basicFklxService.findBasicFklxs(queryRequest, basicFklx).getRecords();
        ExcelKit.$Export(BasicFklx.class, response).downXlsx(basicFklxs, false);
    }
}
