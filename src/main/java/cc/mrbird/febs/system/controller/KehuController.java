package cc.mrbird.febs.system.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.system.entity.Kehu;
import cc.mrbird.febs.system.service.IKehuService;
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
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

/**
 * 客户管理 Controller
 *
 * @author MrBird
 * @date 2020-05-21 21:25:04
 */
@Slf4j
@Validated
@RestController
@RequestMapping("kehu")
public class KehuController extends BaseController {

    @Autowired
    private IKehuService kehuService;
    @GetMapping("")
    @RequiresPermissions("kehu:list")
    public FebsResponse getAllKehus(KehuResp kehu) {
        return new FebsResponse().success().data(kehuService.findKehus(kehu));
    }

    @GetMapping("/list")
    @RequiresPermissions("kehu:list")
    public FebsResponse kehuList(QueryRequest request, KehuResp kehu) {
        Map<String, Object> dataTable = getDataTable(this.kehuService.findKehus(request, kehu));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增客户", exceptionMessage = "新增客户失败")
    @PostMapping("")
    @RequiresPermissions("kehu:add")
    public FebsResponse addKehu(@Valid Kehu kehu) {
        this.kehuService.createKehu(kehu);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除客户", exceptionMessage = "删除客户失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("kehu:delete")
    public FebsResponse deleteKehu(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.kehuService.deleteKehu(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改客户", exceptionMessage = "修改客户失败")
    @PostMapping("/update")
    @RequiresPermissions("kehu:update")
    public FebsResponse updateKehu(Kehu kehu) {
        this.kehuService.updateKehu(kehu);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
//    @RequiresPermissions("kehu:export")
    public void export(QueryRequest queryRequest, KehuResp kehu, HttpServletResponse response)  throws IOException {
        List<KehuResp> kehus = this.kehuService.findKehus(queryRequest, kehu).getRecords();
        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("utf-8");
        String fileName = URLEncoder.encode("客户管理", "UTF-8");
        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), KehuResp.class).sheet("sheet1").doWrite(kehus);
    }

    /*@PostMapping("upload")
    @ResponseBody
    public String upload(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), KehuResp.class, new UploadDataListener(uploadDAO)).sheet().doRead();
        return "success";
    }*/

}
