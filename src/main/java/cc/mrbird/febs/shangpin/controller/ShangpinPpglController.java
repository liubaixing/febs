package cc.mrbird.febs.shangpin.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.listener.PpglDataListener;
import cc.mrbird.febs.common.listener.ShangpinDataListener;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.MapUtil;
import cc.mrbird.febs.shangpin.entity.Shangpin;
import cc.mrbird.febs.shangpin.entity.ShangpinPpgl;
import cc.mrbird.febs.shangpin.service.IShangpinPpglService;
import cc.mrbird.febs.shangpin.vo.resp.ShangpinResp;
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
 * 品牌管理 Controller
 *
 * @author liubaixing1
 * @date 2020-05-22 01:10:37
 */
@Slf4j
@Validated
@RestController
@Api(tags = "品牌管理")
@RequestMapping("shangpinPpgl")
public class ShangpinPpglController extends BaseController {

    @Autowired
    private IShangpinPpglService shangpinPpglService;


    @GetMapping("")
    @RequiresPermissions("shangpinPpgl:list")
    public FebsResponse getAllShangpinPpgls(ShangpinPpgl shangpinPpgl) {
        return new FebsResponse().success().data(shangpinPpglService.findShangpinPpgls(shangpinPpgl));
    }

    @ApiOperation("查询品牌")
    @GetMapping("/list")
    @RequiresPermissions("shangpinPpgl:list")
    public FebsResponse shangpinPpglList(QueryRequest request, ShangpinPpgl shangpinPpgl) {
        Map<String, Object> dataTable = getDataTable(this.shangpinPpglService.findShangpinPpgls(request, shangpinPpgl));
        return new FebsResponse().success().data(dataTable);
    }

    @ApiOperation("添加品牌")
    @ControllerEndpoint(operation = "新增ShangpinPpgl", exceptionMessage = "新增ShangpinPpgl失败")
    @PostMapping("")
    @RequiresPermissions("shangpinPpgl:add")
    public FebsResponse addShangpinPpgl(@Valid ShangpinPpgl shangpinPpgl) {
        this.shangpinPpglService.createShangpinPpgl(shangpinPpgl);
        return new FebsResponse().success();
    }

    @ApiOperation("删除品牌")
    @ControllerEndpoint(operation = "删除ShangpinPpgl", exceptionMessage = "删除ShangpinPpgl失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("shangpinPpgl:delete")
    public FebsResponse deleteShangpinPpgl(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.shangpinPpglService.deleteShangpinPpgl(id);
        return new FebsResponse().success();
    }

    @ApiOperation("修改品牌")
    @ControllerEndpoint(operation = "修改ShangpinPpgl", exceptionMessage = "修改ShangpinPpgl失败")
    @PostMapping("/update")
    @RequiresPermissions("shangpinPpgl:update")
    public FebsResponse updateShangpinPpgl(ShangpinPpgl shangpinPpgl) {
        this.shangpinPpglService.updateShangpinPpgl(shangpinPpgl);
        return new FebsResponse().success();
    }

    @ApiOperation("导出")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("shangpinPpgl:export")
    public void export(QueryRequest queryRequest, ShangpinPpgl shangpinPpgl, HttpServletResponse response) throws IOException {
        List<ShangpinPpgl> shangpinPpgls = this.shangpinPpglService.findShangpinPpgls(queryRequest, shangpinPpgl).getRecords();
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("商品", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), ShangpinPpgl.class).sheet("sheet1").doWrite(shangpinPpgls);

    }

    @ApiOperation("导入")
    @ControllerEndpoint(exceptionMessage = "导入Excel失败")
    @GetMapping("import")
    public void excelImport(@RequestParam MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), ShangpinPpgl.class, new PpglDataListener(shangpinPpglService)).sheet().doRead();
    }
}
