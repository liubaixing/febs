package com.febs.shangpin.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.shangpin.entity.ShangpinSku;
import com.febs.shangpin.service.IShangpinSkuService;
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
 * 商品SKU Controller
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:56
 */
@Slf4j
@Validated
@RestController
@RequestMapping("shangpinSku")
public class ShangpinSkuController extends BaseController {

    @Autowired
    private IShangpinSkuService shangpinSkuService;


    @GetMapping("")
    @RequiresPermissions("shangpinSku:list")
    public FebsResponse getAllShangpinSkus(ShangpinSku shangpinSku) {
        return new FebsResponse().success().data(shangpinSkuService.findShangpinSkus(shangpinSku));
    }

    @GetMapping("/list")
    @RequiresPermissions("shangpinSku:list")
    public FebsResponse shangpinSkuList(QueryRequest request, ShangpinSku shangpinSku) {
        Map<String, Object> dataTable = getDataTable(this.shangpinSkuService.findShangpinSkus(request, shangpinSku));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增ShangpinSku", exceptionMessage = "新增ShangpinSku失败")
    @PostMapping("")
    @RequiresPermissions("shangpinSku:add")
    public FebsResponse addShangpinSku(@Valid ShangpinSku shangpinSku) {
        this.shangpinSkuService.createShangpinSku(shangpinSku);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除ShangpinSku", exceptionMessage = "删除ShangpinSku失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("shangpinSku:delete")
    public FebsResponse deleteShangpinSku(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.shangpinSkuService.deleteShangpinSku(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改ShangpinSku", exceptionMessage = "修改ShangpinSku失败")
    @PostMapping("/update")
    @RequiresPermissions("shangpinSku:update")
    public FebsResponse updateShangpinSku(ShangpinSku shangpinSku) {
        this.shangpinSkuService.updateShangpinSku(shangpinSku);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("shangpinSku:export")
    public void export(QueryRequest queryRequest, ShangpinSku shangpinSku, HttpServletResponse response) {
        List<ShangpinSku> shangpinSkus = this.shangpinSkuService.findShangpinSkus(queryRequest, shangpinSku).getRecords();
        ExcelKit.$Export(ShangpinSku.class, response).downXlsx(shangpinSkus, false);
    }
}
