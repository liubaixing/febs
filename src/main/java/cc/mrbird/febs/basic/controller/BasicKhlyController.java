package cc.mrbird.febs.basic.controller;

import cc.mrbird.febs.basic.entity.BasicKhly;
import cc.mrbird.febs.basic.service.IBasicKhlyService;
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
 * 客户来源 Controller
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:54
 */
@Slf4j
@Validated
@RestController
@RequestMapping("basicKhly")
public class BasicKhlyController extends BaseController {

    @Autowired
    private IBasicKhlyService basicKhlyService;


    @GetMapping("")
    @RequiresPermissions("basicKhly:list")
    public FebsResponse getAllBasicKhlys(BasicKhly basicKhly) {
        return new FebsResponse().success().data(basicKhlyService.findBasicKhlys(basicKhly));
    }

    @GetMapping("/list")
    @RequiresPermissions("basicKhly:list")
    public FebsResponse basicKhlyList(QueryRequest request, BasicKhly basicKhly) {
        Map<String, Object> dataTable = getDataTable(this.basicKhlyService.findBasicKhlys(request, basicKhly));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增BasicKhly", exceptionMessage = "新增BasicKhly失败")
    @PostMapping("")
    @RequiresPermissions("basicKhly:add")
    public FebsResponse addBasicKhly(@Valid BasicKhly basicKhly) {
        this.basicKhlyService.createBasicKhly(basicKhly);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除BasicKhly", exceptionMessage = "删除BasicKhly失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("basicKhly:delete")
    public FebsResponse deleteBasicKhly(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.basicKhlyService.deleteBasicKhly(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改BasicKhly", exceptionMessage = "修改BasicKhly失败")
    @PostMapping("/update")
    @RequiresPermissions("basicKhly:update")
    public FebsResponse updateBasicKhly(BasicKhly basicKhly) {
        this.basicKhlyService.updateBasicKhly(basicKhly);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("basicKhly:export")
    public void export(QueryRequest queryRequest, BasicKhly basicKhly, HttpServletResponse response) {
        List<BasicKhly> basicKhlys = this.basicKhlyService.findBasicKhlys(queryRequest, basicKhly).getRecords();
        ExcelKit.$Export(BasicKhly.class, response).downXlsx(basicKhlys, false);
    }
}
