package com.febs.shangpin.controller;

import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.listener.goods.ShangpinGysDataListener;
import com.febs.common.utils.ExcelUtil;
import com.febs.shangpin.entity.ShangpinGys;
import com.febs.shangpin.service.IShangpinGysService;
import com.febs.shangpin.vo.resp.ShangpinGysResp;
import io.swagger.annotations.Api;
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
 * 供应商商品 Controller
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:05
 */
@Slf4j
@Validated
@RestController
@Api(tags = "供应商商品管理")
@RequestMapping("shangpinGys")
public class ShangpinGysController extends BaseController {

    @Autowired
    private IShangpinGysService shangpinGysService;


    @GetMapping("")
    @RequiresPermissions("shangpinGys:list")
    public FebsResponse getAllShangpinGyss(ShangpinGysResp shangpinGys) {
        return new FebsResponse().success().data(shangpinGysService.findShangpinGyss(shangpinGys));
    }

    @ApiOperation("全部查询")
    @GetMapping("/list")
    @RequiresPermissions("shangpinGys:list")
    public FebsResponse shangpinGysList(QueryRequest request, ShangpinGysResp shangpinGys) {
        Map<String, Object> dataTable = getDataTable(this.shangpinGysService.findShangpinGyss(request, shangpinGys));
        return new FebsResponse().success().data(dataTable);
    }

    @ApiOperation("添加商品")
    @ControllerEndpoint(operation = "新增ShangpinGys", exceptionMessage = "新增ShangpinGys失败")
    @PostMapping("")
    @RequiresPermissions("shangpinGys:add")
    public FebsResponse addShangpinGys(@Valid ShangpinGys shangpinGys) {
        this.shangpinGysService.createShangpinGys(shangpinGys);
        return new FebsResponse().success();
    }

    @ApiOperation("删除商品")
    @ControllerEndpoint(operation = "删除ShangpinGys", exceptionMessage = "删除ShangpinGys失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("shangpinGys:delete")
    public FebsResponse deleteShangpinGys(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.shangpinGysService.deleteShangpinGys(id);
        return new FebsResponse().success();
    }

    @ApiOperation("修改商品")
    @ControllerEndpoint(operation = "修改ShangpinGys", exceptionMessage = "修改ShangpinGys失败")
    @PostMapping("/update")
    @RequiresPermissions("shangpinGys:update")
    public FebsResponse updateShangpinGys(ShangpinGys shangpinGys) {
        this.shangpinGysService.updateShangpinGys(shangpinGys);
        return new FebsResponse().success();
    }

    @ApiOperation("审核商品，权限 shangpinGys:checkGoods")
    @ControllerEndpoint(operation = "审核商品", exceptionMessage = "审核商品失败")
    @GetMapping("/checkGoods/{id}")
//    @RequiresPermissions("shangpinGys:checkGoods")
    public FebsResponse checkGoods(@PathVariable Integer id,@RequestParam boolean check){
        return new FebsResponse().data(this.shangpinGysService.checkGoods(id,check));
    }

    @ApiOperation("打回商品，权限 shangpinGys:returnGoods")
    @ControllerEndpoint(operation = "打回商品", exceptionMessage = "打回商品失败")
    @GetMapping("/returnGoods/{id}")
//    @RequiresPermissions("shangpinGys:returnGoods")
    public FebsResponse returnGoods(@PathVariable Integer id){
        ShangpinGys shangpinGys = new ShangpinGys();
        shangpinGys.setId(id);
        shangpinGys.setLyxt((byte)3);
        this.shangpinGysService.updateShangpinGys(shangpinGys);
        return new FebsResponse().success();
    }

    @ApiOperation("导出")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
//    @RequiresPermissions("shangpinGys:export")
    public void export(QueryRequest queryRequest, ShangpinGysResp shangpinGys, HttpServletResponse response) throws IOException {
        List<ShangpinGysResp> shangpinGyss = this.shangpinGysService.findShangpinGyss(queryRequest, shangpinGys).getRecords();
        ExcelUtil.export(shangpinGyss, ShangpinGysResp.class,"供应商商品",response);
    }

    @ApiOperation("导入")
    @ControllerEndpoint(exceptionMessage = "导入Excel失败")
    @PostMapping("import")
    public void excelImport(@RequestParam MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), ShangpinGysResp.class, new ShangpinGysDataListener(shangpinGysService)).sheet().doRead();
    }

}
