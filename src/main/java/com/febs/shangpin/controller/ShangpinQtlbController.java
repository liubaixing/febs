package com.febs.shangpin.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.listener.goods.QtlbDataListener;
import com.febs.common.listener.goods.ZlDataListener;
import com.febs.common.utils.ExcelUtil;
import com.febs.shangpin.entity.ShangpinQtlb;
import com.febs.shangpin.entity.ShangpinXl;
import com.febs.shangpin.entity.ShangpinZl;
import com.febs.shangpin.service.IShangpinQtlbService;
import com.wuwenze.poi.ExcelKit;
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
 * 其他类别 Controller
 *
 * @author liubaixing1
 * @date 2020-05-22 01:10:44
 */
@Slf4j
@Validated
@RestController
@RequestMapping("shangpinQtlb")
public class ShangpinQtlbController extends BaseController {

    @Autowired
    private IShangpinQtlbService shangpinQtlbService;


    @GetMapping("")
    @RequiresPermissions("shangpinQtlb:list")
    public FebsResponse getAllShangpinQtlbs(ShangpinQtlb shangpinQtlb) {
        return new FebsResponse().success().data(shangpinQtlbService.findShangpinQtlbs(shangpinQtlb));
    }

    @GetMapping("/list")
    @RequiresPermissions("shangpinQtlb:list")
    public FebsResponse shangpinQtlbList(QueryRequest request, ShangpinQtlb shangpinQtlb) {
        Map<String, Object> dataTable = getDataTable(this.shangpinQtlbService.findShangpinQtlbs(request, shangpinQtlb));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增ShangpinQtlb", exceptionMessage = "新增ShangpinQtlb失败")
    @PostMapping("")
    @RequiresPermissions("shangpinQtlb:add")
    public FebsResponse addShangpinQtlb(@Valid ShangpinQtlb shangpinQtlb) {
        this.shangpinQtlbService.createShangpinQtlb(shangpinQtlb);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除ShangpinQtlb", exceptionMessage = "删除ShangpinQtlb失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("shangpinQtlb:delete")
    public FebsResponse deleteShangpinQtlb(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.shangpinQtlbService.deleteShangpinQtlb(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改ShangpinQtlb", exceptionMessage = "修改ShangpinQtlb失败")
    @PostMapping("/update")
    @RequiresPermissions("shangpinQtlb:update")
    public FebsResponse updateShangpinQtlb(ShangpinQtlb shangpinQtlb) {
        this.shangpinQtlbService.updateShangpinQtlb(shangpinQtlb);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
//    @RequiresPermissions("shangpinQtlb:export")
    public void export(QueryRequest queryRequest, ShangpinQtlb shangpinQtlb, HttpServletResponse response) throws IOException {
        List<ShangpinQtlb> shangpinQtlbs = this.shangpinQtlbService.findShangpinQtlbs(queryRequest, shangpinQtlb).getRecords();
        ExcelUtil.export(shangpinQtlbs, ShangpinQtlb.class,"其他类别",response);
    }

    @ApiOperation("导入")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @PostMapping("import")
    public void excelImport(@RequestParam MultipartFile file) throws IOException{
        EasyExcel.read(file.getInputStream(), ShangpinQtlb.class, new QtlbDataListener(shangpinQtlbService)).sheet().doRead();
    }
}
