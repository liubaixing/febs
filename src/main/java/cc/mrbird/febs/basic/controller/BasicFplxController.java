package cc.mrbird.febs.basic.controller;

import cc.mrbird.febs.basic.entity.BasicFplx;
import cc.mrbird.febs.basic.service.IBasicFplxService;
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
 * 发票类型 Controller
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:37
 */
@Slf4j
@Validated
@RestController
@RequestMapping("basicFplx")
public class BasicFplxController extends BaseController {

    @Autowired
    private IBasicFplxService basicFplxService;


    @GetMapping("")
    @RequiresPermissions("basicFplx:list")
    public FebsResponse getAllBasicFplxs(BasicFplx basicFplx) {
        return new FebsResponse().success().data(basicFplxService.findBasicFplxs(basicFplx));
    }

    @GetMapping("/list")
    @RequiresPermissions("basicFplx:list")
    public FebsResponse basicFplxList(QueryRequest request, BasicFplx basicFplx) {
        Map<String, Object> dataTable = getDataTable(this.basicFplxService.findBasicFplxs(request, basicFplx));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增BasicFplx", exceptionMessage = "新增BasicFplx失败")
    @PostMapping("")
    @RequiresPermissions("basicFplx:add")
    public FebsResponse addBasicFplx(@Valid BasicFplx basicFplx) {
        this.basicFplxService.createBasicFplx(basicFplx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除BasicFplx", exceptionMessage = "删除BasicFplx失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("basicFplx:delete")
    public FebsResponse deleteBasicFplx(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.basicFplxService.deleteBasicFplx(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改BasicFplx", exceptionMessage = "修改BasicFplx失败")
    @PostMapping("/update")
    @RequiresPermissions("basicFplx:update")
    public FebsResponse updateBasicFplx(BasicFplx basicFplx) {
        this.basicFplxService.updateBasicFplx(basicFplx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("basicFplx:export")
    public void export(QueryRequest queryRequest, BasicFplx basicFplx, HttpServletResponse response) {
        List<BasicFplx> basicFplxs = this.basicFplxService.findBasicFplxs(queryRequest, basicFplx).getRecords();
        ExcelKit.$Export(BasicFplx.class, response).downXlsx(basicFplxs, false);
    }
}
