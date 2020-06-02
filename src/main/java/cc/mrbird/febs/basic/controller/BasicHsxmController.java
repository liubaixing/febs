package cc.mrbird.febs.basic.controller;

import cc.mrbird.febs.basic.entity.BasicHsxm;
import cc.mrbird.febs.basic.service.IBasicHsxmService;
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
 * 核算项目 Controller
 *
 * @author liubaixing
 * @date 2020-05-22 01:38:13
 */
@Slf4j
@Validated
@RestController
@RequestMapping("basicHsxm")
public class BasicHsxmController extends BaseController {

    @Autowired
    private IBasicHsxmService basicHsxmService;


    @GetMapping("")
    @RequiresPermissions("basicHsxm:list")
    public FebsResponse getAllBasicHsxms(BasicHsxm basicHsxm) {
        return new FebsResponse().success().data(basicHsxmService.findBasicHsxms(basicHsxm));
    }

    @GetMapping("/list")
    @RequiresPermissions("basicHsxm:list")
    public FebsResponse basicHsxmList(QueryRequest request, BasicHsxm basicHsxm) {
        Map<String, Object> dataTable = getDataTable(this.basicHsxmService.findBasicHsxms(request, basicHsxm));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增BasicHsxm", exceptionMessage = "新增BasicHsxm失败")
    @PostMapping("")
    @RequiresPermissions("basicHsxm:add")
    public FebsResponse addBasicHsxm(@Valid BasicHsxm basicHsxm) {
        this.basicHsxmService.createBasicHsxm(basicHsxm);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除BasicHsxm", exceptionMessage = "删除BasicHsxm失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("basicHsxm:delete")
    public FebsResponse deleteBasicHsxm(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.basicHsxmService.deleteBasicHsxm(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改BasicHsxm", exceptionMessage = "修改BasicHsxm失败")
    @PostMapping("/update")
    @RequiresPermissions("basicHsxm:update")
    public FebsResponse updateBasicHsxm(BasicHsxm basicHsxm) {
        this.basicHsxmService.updateBasicHsxm(basicHsxm);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("basicHsxm:export")
    public void export(QueryRequest queryRequest, BasicHsxm basicHsxm, HttpServletResponse response) {
        List<BasicHsxm> basicHsxms = this.basicHsxmService.findBasicHsxms(queryRequest, basicHsxm).getRecords();
        ExcelKit.$Export(BasicHsxm.class, response).downXlsx(basicHsxms, false);
    }
}
