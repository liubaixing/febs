package cc.mrbird.febs.system.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.listener.CangkuDataListener;
import cc.mrbird.febs.common.listener.GongsiDataListener;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.system.entity.Cangku;
import cc.mrbird.febs.system.entity.Gongsi;
import cc.mrbird.febs.system.service.IGongsiService;
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
 * 公司管理 Controller
 *
 * @author MrBird
 * @date 2020-05-21 22:34:42
 */
@Slf4j
@Validated
@RestController
@RequestMapping("gongsi")
public class GongsiController extends BaseController {

    @Autowired
    private IGongsiService gongsiService;

    @GetMapping("")
    @RequiresPermissions("gongsi:list")
    public FebsResponse getAllGongsis(Gongsi gongsi) {
        return new FebsResponse().success().data(gongsiService.findGongsis(gongsi));
    }

    @GetMapping("/list")
    @RequiresPermissions("gongsi:list")
    public FebsResponse gongsiList(QueryRequest request, Gongsi gongsi) {
        Map<String, Object> dataTable = getDataTable(this.gongsiService.findGongsis(request, gongsi));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增公司", exceptionMessage = "新增公司失败")
    @PostMapping("")
    @RequiresPermissions("gongsi:add")
    public FebsResponse addGongsi(@Valid Gongsi gongsi) {
        this.gongsiService.createGongsi(gongsi);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除公司", exceptionMessage = "删除公司失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("gongsi:delete")
    public FebsResponse deleteGongsi(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.gongsiService.deleteGongsi(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改公司", exceptionMessage = "修改公司失败")
    @PostMapping("/update")
    @RequiresPermissions("gongsi:update")
    public FebsResponse updateGongsi(Gongsi gongsi) {
        this.gongsiService.updateGongsi(gongsi);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("gongsi:export")
    public void export(QueryRequest queryRequest, Gongsi gongsi, HttpServletResponse response) throws IOException {
        List<Gongsi> gongsis = this.gongsiService.findGongsis(queryRequest, gongsi).getRecords();
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("公司管理", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), Gongsi.class).sheet("sheet1").doWrite(gongsis);
    }

    @ControllerEndpoint(operation = "导入", exceptionMessage = "导入失败")
    @PostMapping("upload")
    @ResponseBody
    public void upload(@RequestParam MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), Gongsi.class, new GongsiDataListener(gongsiService)).sheet().doRead();
    }

}
