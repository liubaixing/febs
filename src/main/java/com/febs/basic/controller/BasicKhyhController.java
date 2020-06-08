package com.febs.basic.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.basic.entity.BasicKhyh;
import com.febs.basic.service.IBasicKhyhService;
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
 * 开户银行 Controller
 *
 * @author liubaixing
 * @date 2020-05-22 01:40:01
 */
@Slf4j
@Validated
@RestController
@RequestMapping("basicKhyh")
public class BasicKhyhController extends BaseController {

    @Autowired
    private IBasicKhyhService basicKhyhService;


    @GetMapping("")
    @RequiresPermissions("basicKhyh:list")
    public FebsResponse getAllBasicKhyhs(BasicKhyh basicKhyh) {
        return new FebsResponse().success().data(basicKhyhService.findBasicKhyhs(basicKhyh));
    }

    @GetMapping("/list")
    @RequiresPermissions("basicKhyh:list")
    public FebsResponse basicKhyhList(QueryRequest request, BasicKhyh basicKhyh) {
        Map<String, Object> dataTable = getDataTable(this.basicKhyhService.findBasicKhyhs(request, basicKhyh));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增开户银行", exceptionMessage = "新增开户银行失败")
    @PostMapping("")
    @RequiresPermissions("basicKhyh:add")
    public FebsResponse addBasicKhyh(@Valid BasicKhyh basicKhyh) {
        this.basicKhyhService.createBasicKhyh(basicKhyh);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除开户银行", exceptionMessage = "删除开户银行失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("basicKhyh:delete")
    public FebsResponse deleteBasicKhyh(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.basicKhyhService.deleteBasicKhyh(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改开户银行", exceptionMessage = "修改开户银行失败")
    @PostMapping("/update")
    @RequiresPermissions("basicKhyh:update")
    public FebsResponse updateBasicKhyh(BasicKhyh basicKhyh) {
        this.basicKhyhService.updateBasicKhyh(basicKhyh);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("basicKhyh:export")
    public void export(QueryRequest queryRequest, BasicKhyh basicKhyh, HttpServletResponse response) {
        List<BasicKhyh> basicKhyhs = this.basicKhyhService.findBasicKhyhs(queryRequest, basicKhyh).getRecords();
        ExcelKit.$Export(BasicKhyh.class, response).downXlsx(basicKhyhs, false);
    }
}
