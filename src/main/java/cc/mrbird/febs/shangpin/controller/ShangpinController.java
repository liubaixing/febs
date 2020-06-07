package cc.mrbird.febs.shangpin.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.listener.ShangpinDataListener;
import cc.mrbird.febs.common.utils.MapUtil;
import cc.mrbird.febs.shangpin.entity.Shangpin;
import cc.mrbird.febs.shangpin.service.IShangpinService;
import cc.mrbird.febs.shangpin.vo.resp.ShangpinResp;
import cc.mrbird.febs.system.vo.resp.KehuResp;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.google.common.collect.Lists;
import com.wuwenze.poi.ExcelKit;
import com.wuwenze.poi.handler.ExcelReadHandler;
import com.wuwenze.poi.pojo.ExcelErrorField;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * 商品 Controller
 *
 * @author liubaixing
 * @date 2020-05-22 01:06:25
 */
@Slf4j
@Validated
@RestController
@Api(tags = "商品管理")
@RequestMapping("shangpin")
public class ShangpinController extends BaseController {

    @Autowired
    private IShangpinService shangpinService;

    @ApiOperation("全部查询")
    @GetMapping("")
    @RequiresPermissions("shangpin:list")
    public FebsResponse getAllShangpins(ShangpinResp shangpin) {
        return new FebsResponse().success().data(shangpinService.findShangpins(shangpin));
    }

    @ApiOperation("分页查询")
    @GetMapping("/list")
    @RequiresPermissions("shangpin:list")
    public FebsResponse shangpinList(QueryRequest request, ShangpinResp shangpin) {
        Map<String, Object> dataTable = getDataTable(this.shangpinService.findShangpins(request, shangpin));
        return new FebsResponse().success().data(dataTable);
    }

    @ApiOperation("添加商品")
    @ControllerEndpoint(operation = "新增Shangpin", exceptionMessage = "新增Shangpin失败")
    @PostMapping("")
    @RequiresPermissions("shangpin:add")
    public FebsResponse addShangpin(@Valid Shangpin shangpin) {
        this.shangpinService.createShangpin(shangpin);
        return new FebsResponse().success();
    }

    @ApiOperation("删除商品")
    @ControllerEndpoint(operation = "删除Shangpin", exceptionMessage = "删除Shangpin失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("shangpin:delete")
    public FebsResponse deleteShangpin(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.shangpinService.deleteShangpin(id);
        return new FebsResponse().success();
    }

    @ApiOperation("修改商品")
    @ControllerEndpoint(operation = "修改Shangpin", exceptionMessage = "修改Shangpin失败")
    @PostMapping("/update")
    @RequiresPermissions("shangpin:update")
    public FebsResponse updateShangpin(Shangpin shangpin) {
        this.shangpinService.updateShangpin(shangpin);
        return new FebsResponse().success();
    }

    @ApiOperation("导出")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("shangpin:export")
    public void export(QueryRequest queryRequest, ShangpinResp shangpin, HttpServletResponse response) throws IOException {
        List<ShangpinResp> shangpins = this.shangpinService.findShangpins(queryRequest, shangpin).getRecords();
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("商品", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), ShangpinResp.class).sheet("sheet1").doWrite(shangpins);
    }

    @ApiOperation("导入")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @PostMapping("import")
    public void excelImport(@RequestParam MultipartFile file) throws IOException{
        EasyExcel.read(file.getInputStream(), ShangpinResp.class, new ShangpinDataListener(shangpinService)).sheet().doRead();
    }

}
