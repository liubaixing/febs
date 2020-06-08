package com.febs.shangpin.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.shangpin.entity.ShangpinBarcode;
import com.febs.shangpin.service.IShangpinBarcodeService;
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
 * 商品条码 Controller
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:50
 */
@Slf4j
@Validated
@RestController
@RequestMapping("shangpinBarcode")
public class ShangpinBarcodeController extends BaseController {

    @Autowired
    private IShangpinBarcodeService shangpinBarcodeService;


    @GetMapping("")
    @RequiresPermissions("shangpinBarcode:list")
    public FebsResponse getAllShangpinBarcodes(ShangpinBarcode shangpinBarcode) {
        return new FebsResponse().success().data(shangpinBarcodeService.findShangpinBarcodes(shangpinBarcode));
    }

    @GetMapping("/list")
    @RequiresPermissions("shangpinBarcode:list")
    public FebsResponse shangpinBarcodeList(QueryRequest request, ShangpinBarcode shangpinBarcode) {
        Map<String, Object> dataTable = getDataTable(this.shangpinBarcodeService.findShangpinBarcodes(request, shangpinBarcode));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增ShangpinBarcode", exceptionMessage = "新增ShangpinBarcode失败")
    @PostMapping("")
    @RequiresPermissions("shangpinBarcode:add")
    public FebsResponse addShangpinBarcode(@Valid ShangpinBarcode shangpinBarcode) {
        this.shangpinBarcodeService.createShangpinBarcode(shangpinBarcode);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除ShangpinBarcode", exceptionMessage = "删除ShangpinBarcode失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("shangpinBarcode:delete")
    public FebsResponse deleteShangpinBarcode(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.shangpinBarcodeService.deleteShangpinBarcode(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改ShangpinBarcode", exceptionMessage = "修改ShangpinBarcode失败")
    @PostMapping("/update")
    @RequiresPermissions("shangpinBarcode:update")
    public FebsResponse updateShangpinBarcode(ShangpinBarcode shangpinBarcode) {
        this.shangpinBarcodeService.updateShangpinBarcode(shangpinBarcode);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("shangpinBarcode:export")
    public void export(QueryRequest queryRequest, ShangpinBarcode shangpinBarcode, HttpServletResponse response) {
        List<ShangpinBarcode> shangpinBarcodes = this.shangpinBarcodeService.findShangpinBarcodes(queryRequest, shangpinBarcode).getRecords();
        ExcelKit.$Export(ShangpinBarcode.class, response).downXlsx(shangpinBarcodes, false);
    }
}
