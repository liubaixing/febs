package cc.mrbird.febs.system.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.system.entity.Gys;
import cc.mrbird.febs.system.service.IGysService;
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
 * 供应商 Controller
 *
 * @author MrBird
 * @date 2020-05-22 00:06:57
 */
@Slf4j
@Validated
@RestController
@RequestMapping("gys")
public class GysController extends BaseController {

    @Autowired
    private IGysService gysService;


    @GetMapping("")
    @RequiresPermissions("gys:list")
    public FebsResponse getAllGyss(Gys gys) {
        return new FebsResponse().success().data(gysService.findGyss(gys));
    }

    @GetMapping("/list")
    @RequiresPermissions("gys:list")
    public FebsResponse gysList(QueryRequest request, Gys gys) {
        Map<String, Object> dataTable = getDataTable(this.gysService.findGyss(request, gys));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增Gys", exceptionMessage = "新增Gys失败")
    @PostMapping("")
    @RequiresPermissions("gys:add")
    public FebsResponse addGys(@Valid Gys gys) {
        this.gysService.createGys(gys);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除Gys", exceptionMessage = "删除Gys失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("gys:delete")
    public FebsResponse deleteGys(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.gysService.deleteGys(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改Gys", exceptionMessage = "修改Gys失败")
    @PostMapping("/update")
    @RequiresPermissions("gys:update")
    public FebsResponse updateGys(Gys gys) {
        this.gysService.updateGys(gys);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("gys:export")
    public void export(QueryRequest queryRequest, Gys gys, HttpServletResponse response) {
        List<Gys> gyss = this.gysService.findGyss(queryRequest, gys).getRecords();
        ExcelKit.$Export(Gys.class, response).downXlsx(gyss, false);
    }
}
