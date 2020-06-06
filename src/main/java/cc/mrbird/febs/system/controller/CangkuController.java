package cc.mrbird.febs.system.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.listener.CangkuDataListener;
import cc.mrbird.febs.common.listener.KehuDataListener;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.system.entity.Cangku;
import cc.mrbird.febs.system.service.ICangkuService;
import cc.mrbird.febs.system.vo.resp.KehuResp;
import com.alibaba.excel.EasyExcel;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.wuwenze.poi.ExcelKit;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
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
 * 仓库管理 Controller
 *
 * @author MrBird
 * @date 2020-05-22 00:06:45
 */
@Slf4j
@Validated
@RestController
@RequestMapping("cangku")
public class CangkuController extends BaseController {

    @Autowired
    private ICangkuService cangkuService;


    @GetMapping("")
    @RequiresPermissions("cangku:list")
    public FebsResponse getAllCangkus(Cangku cangku) {
        return new FebsResponse().success().data(cangkuService.findCangkus(cangku));
    }

    @GetMapping("/list")
    @RequiresPermissions("cangku:list")
    public FebsResponse cangkuList(QueryRequest request, Cangku cangku) {
        Map<String, Object> dataTable = getDataTable(this.cangkuService.findCangkus(request, cangku));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增仓库", exceptionMessage = "新增仓库失败")
    @PostMapping("")
    @RequiresPermissions("cangku:add")
    public FebsResponse addCangku(@Valid Cangku cangku) {
        this.cangkuService.createCangku(cangku);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除仓库", exceptionMessage = "删除仓库失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("cangku:delete")
    public FebsResponse deleteCangku(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.cangkuService.deleteCangku(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改仓库", exceptionMessage = "修改仓库失败")
    @PostMapping("/update")
    @RequiresPermissions("cangku:update")
    public FebsResponse updateCangku(Cangku cangku) {
        this.cangkuService.updateCangku(cangku);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
//    @RequiresPermissions("cangku:export")
    public void export(QueryRequest queryRequest, Cangku cangku, HttpServletResponse response) throws IOException {
        List<Cangku> cangkus = this.cangkuService.findCangkus(queryRequest, cangku).getRecords();
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("仓库管理", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Cangku.class).sheet("sheet1").doWrite(cangkus);
    }

    @PostMapping("upload")
    @ResponseBody
    public String upload(@RequestParam MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), Cangku.class, new CangkuDataListener(cangkuService)).sheet().doRead();
        return "success";
    }
}
