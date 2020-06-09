package com.febs.shangpin.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.listener.goods.ZlDataListener;
import com.febs.common.utils.ExcelUtil;
import com.febs.shangpin.entity.ShangpinZl;
import com.febs.shangpin.service.IShangpinZlService;
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
import java.util.List;
import java.util.Map;

/**
 * 总类 Controller
 *
 * @author liubaixing1
 * @date 2020-05-22 01:10:57
 */
@Slf4j
@Validated
@RestController
@RequestMapping("shangpinZl")
public class ShangpinZlController extends BaseController {

    @Autowired
    private IShangpinZlService shangpinZlService;


    @GetMapping("")
    @RequiresPermissions("shangpinZl:list")
    public FebsResponse getAllShangpinZls(ShangpinZl shangpinZl) {
        return new FebsResponse().success().data(shangpinZlService.findShangpinZls(shangpinZl));
    }

    @GetMapping("/list")
    @RequiresPermissions("shangpinZl:list")
    public FebsResponse shangpinZlList(QueryRequest request, ShangpinZl shangpinZl) {
        Map<String, Object> dataTable = getDataTable(this.shangpinZlService.findShangpinZls(request, shangpinZl));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增ShangpinZl", exceptionMessage = "新增ShangpinZl失败")
    @PostMapping("")
    @RequiresPermissions("shangpinZl:add")
    public FebsResponse addShangpinZl(@Valid ShangpinZl shangpinZl) {
        this.shangpinZlService.createShangpinZl(shangpinZl);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除ShangpinZl", exceptionMessage = "删除ShangpinZl失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("shangpinZl:delete")
    public FebsResponse deleteShangpinZl(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.shangpinZlService.deleteShangpinZl(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改ShangpinZl", exceptionMessage = "修改ShangpinZl失败")
    @PostMapping("/update")
    @RequiresPermissions("shangpinZl:update")
    public FebsResponse updateShangpinZl(ShangpinZl shangpinZl) {
        this.shangpinZlService.updateShangpinZl(shangpinZl);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
//    @RequiresPermissions("shangpinZl:export")
    public void export(QueryRequest queryRequest, ShangpinZl shangpinZl, HttpServletResponse response) throws IOException {
        List<ShangpinZl> shangpinZls = this.shangpinZlService.findShangpinZls(queryRequest, shangpinZl).getRecords();
        ExcelUtil.export(shangpinZls,ShangpinZl.class,"总类",response);
    }

    @ApiOperation("导入")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @PostMapping("import")
    public void excelImport(@RequestParam MultipartFile file) throws IOException{
        EasyExcel.read(file.getInputStream(), ShangpinZl.class, new ZlDataListener(shangpinZlService)).sheet().doRead();
    }

}
