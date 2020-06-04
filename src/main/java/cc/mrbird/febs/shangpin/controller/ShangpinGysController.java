package cc.mrbird.febs.shangpin.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.utils.MapUtil;
import cc.mrbird.febs.shangpin.entity.Shangpin;
import cc.mrbird.febs.shangpin.entity.ShangpinGys;
import cc.mrbird.febs.shangpin.service.IShangpinGysService;
import cc.mrbird.febs.shangpin.vo.resp.ShangpinGysResp;
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

    @ApiOperation("审核商品")
    @ControllerEndpoint(operation = "审核商品", exceptionMessage = "审核商品失败")
    @PostMapping("/checkGoods")
//    @RequiresPermissions("shangpinGys:checkGoods")
    public FebsResponse checkGoods(ShangpinGys shangpinGys){
        this.shangpinGysService.checkGoods(shangpinGys);
        return new FebsResponse().success();
    }

    @ApiOperation("导出")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
//    @RequiresPermissions("shangpinGys:export")
    public void export(QueryRequest queryRequest, ShangpinGysResp shangpinGys, HttpServletResponse response) throws IOException {
        List<ShangpinGysResp> shangpinGyss = this.shangpinGysService.findShangpinGyss(queryRequest, shangpinGys).getRecords();
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("供应商商品", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), ShangpinGysResp.class).sheet("sheet1").doWrite(shangpinGyss);

    }

    @ApiOperation("导入")
    @ControllerEndpoint(exceptionMessage = "导入Excel失败")
    @PostMapping("import")
    public ResponseEntity<?> excelImport(@RequestParam MultipartFile file) throws IOException {
        long beginMillis = System.currentTimeMillis();

        List<ShangpinGysResp> successList = Lists.newArrayList();
        List<Map<String, Object>> errorList = Lists.newArrayList();

        ExcelKit.$Import(ShangpinGysResp.class)
                .readXlsx(file.getInputStream(), new ExcelReadHandler<ShangpinGysResp>() {
                    @Override
                    public void onSuccess(int sheetIndex, int rowIndex, ShangpinGysResp entity) {
                        successList.add(entity); // 单行读取成功，加入入库队列。
                    }
                    @Override
                    public void onError(int sheetIndex, int rowIndex,
                                        List<ExcelErrorField> errorFields) {
                        // 读取数据失败，记录了当前行所有失败的数据
                        errorList.add(MapUtil.newHashMap
                                ("sheetIndex", sheetIndex,
                                        "rowIndex", rowIndex,
                                        "errorFields", errorFields
                                ));
                    }
                });

        // TODO: 执行successList的入库操作。
        shangpinGysService.saveImport(successList);
        return ResponseEntity.ok(MapUtil.newHashMap(
                "data",successList
                ,"haveError", CollectionUtils.isNotEmpty(errorList)
                ,"error", errorList
                ,"timeConsuming", (System.currentTimeMillis() - beginMillis) / 1000L
        ));
    }

}
