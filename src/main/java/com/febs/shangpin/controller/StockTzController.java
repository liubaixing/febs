package com.febs.shangpin.controller;

import com.alibaba.excel.EasyExcel;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.entity.excel.StockTzExcelModel;
import com.febs.common.entity.excel.YfdExcelModel;
import com.febs.common.listener.UploadDataListener;
import com.febs.shangpin.biz.StockTzBiz;
import com.febs.shangpin.entity.StockTz;
import com.febs.shangpin.service.IStockTzService;
import com.febs.shangpin.vo.req.StockTzReq;
import com.febs.system.entity.User;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;

@Slf4j
@RestController
@RequestMapping("stockTz")
public class StockTzController extends BaseController {

    @Autowired
    private IStockTzService stockTzService;

    @Autowired
    private StockTzBiz stockTzBiz;

    @GetMapping("/list")
    public FebsResponse list(QueryRequest request, StockTzReq req){
        return new FebsResponse().success().data(stockTzService.findStockTzPage(request,req));
    }

    @GetMapping("")
    public FebsResponse list(StockTzReq req){
        return new FebsResponse().success().data(stockTzService.findStockTzList(req));
    }

    @GetMapping("view/{id}")
    public FebsResponse view(@PathVariable("id")Long id){
        return new FebsResponse().success().data(stockTzBiz.view(id));
    }

    @PostMapping("")
    public FebsResponse save(StockTzReq req){
        User user = getCurrentUser();
        req.setZdr(user.getUsername());
        stockTzBiz.save(req);
        return new FebsResponse().success();
    }

    @PostMapping("/update")
    public FebsResponse update(StockTzReq req){
        stockTzBiz.update(req);
        return new FebsResponse().success();
    }

    @DeleteMapping("/{id}")
    public FebsResponse update(@PathVariable("id")Long id){
        stockTzService.delete(id);
        return new FebsResponse().success();
    }

    @GetMapping("/qr/{id}")
    public FebsResponse qr(@PathVariable("id")Long id){
        User user = getCurrentUser();
        StockTz stockTz = new StockTz();
        stockTz.setId(id);
        stockTz.setQr((byte)1);
        stockTz.setQrr(user.getUsername());
        stockTz.setQrrq(new Date());
        stockTzService.updateObject(stockTz);
        return new FebsResponse().success();
    }

    @GetMapping("/sh/{id}")
    public FebsResponse sh(@PathVariable("id")Long id){
        User user = getCurrentUser();
        stockTzBiz.sh(id,user);
        return new FebsResponse().success();
    }

    @GetMapping("/zx/{id}")
    public FebsResponse zx(@PathVariable("id")Long id){
        User user = getCurrentUser();
        StockTz stockTz = new StockTz();
        stockTz.setId(id);
        stockTz.setZx((byte)1);
        stockTz.setZxr(user.getUsername());
        stockTz.setZxrq(new Date());
        stockTzService.updateObject(stockTz);
        return new FebsResponse().success();
    }

    @GetMapping("/zs/{id}")
    public FebsResponse zs(@PathVariable("id")Long id){
        User user = getCurrentUser();
        StockTz stockTz = new StockTz();
        stockTz.setId(id);
        stockTz.setZs((byte)1);
        stockTz.setZsr(user.getUsername());
        stockTz.setZsrq(new Date());
        stockTzService.updateObject(stockTz);
        return new FebsResponse().success();
    }

    @GetMapping("/zf/{id}")
    public FebsResponse zf(@PathVariable("id")Long id){
        User user = getCurrentUser();
        StockTz stockTz = new StockTz();
        stockTz.setId(id);
        stockTz.setZf((byte)1);
        stockTz.setZfr(user.getUsername());
        stockTz.setZfrq(new Date());
        stockTzService.updateObject(stockTz);
        return new FebsResponse().success();
    }


    @ApiOperation("导入")
    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @PostMapping("upload")
    public void upload(@RequestParam MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), StockTzExcelModel.class,new UploadDataListener(stockTzService)).sheet().doRead();
    }

}
