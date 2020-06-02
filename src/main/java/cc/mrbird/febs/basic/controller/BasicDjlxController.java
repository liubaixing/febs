package cc.mrbird.febs.basic.controller;

import cc.mrbird.febs.basic.entity.BasicDjlx;
import cc.mrbird.febs.basic.service.IBasicDjlxService;
import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
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
 * 单据类型 Controller
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:22
 */
@Slf4j
@Validated
@RestController
@RequestMapping("basicDjlx")
public class BasicDjlxController extends BaseController {

    @Autowired
    private IBasicDjlxService basicDjlxService;


    @GetMapping("")
    @RequiresPermissions("basicDjlx:list")
    public FebsResponse getAllBasicDjlxs(BasicDjlx basicDjlx) {
        return new FebsResponse().success().data(basicDjlxService.findBasicDjlxs(basicDjlx));
    }

    @GetMapping("/list")
    @RequiresPermissions("basicDjlx:list")
    public FebsResponse basicDjlxList(QueryRequest request, BasicDjlx basicDjlx) {
        Map<String, Object> dataTable = getDataTable(this.basicDjlxService.findBasicDjlxs(request, basicDjlx));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增BasicDjlx", exceptionMessage = "新增BasicDjlx失败")
    @PostMapping("")
    @RequiresPermissions("basicDjlx:add")
    public FebsResponse addBasicDjlx(@Valid BasicDjlx basicDjlx) {
        this.basicDjlxService.createBasicDjlx(basicDjlx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除BasicDjlx", exceptionMessage = "删除BasicDjlx失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("basicDjlx:delete")
    public FebsResponse deleteBasicDjlx(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.basicDjlxService.deleteBasicDjlx(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改BasicDjlx", exceptionMessage = "修改BasicDjlx失败")
    @PostMapping("/update")
    @RequiresPermissions("basicDjlx:update")
    public FebsResponse updateBasicDjlx(BasicDjlx basicDjlx) {
        this.basicDjlxService.updateBasicDjlx(basicDjlx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("basicDjlx:export")
    public void export(QueryRequest queryRequest, BasicDjlx basicDjlx, HttpServletResponse response) {
        List<BasicDjlx> basicDjlxs = this.basicDjlxService.findBasicDjlxs(queryRequest, basicDjlx).getRecords();
        ExcelKit.$Export(BasicDjlx.class, response).downXlsx(basicDjlxs, false);
    }
}
