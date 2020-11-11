package com.febs.shangpin.controller;

import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.shangpin.biz.StockTzBiz;
import com.febs.shangpin.entity.StockTz;
import com.febs.shangpin.service.IStockTzService;
import com.febs.shangpin.vo.req.StockTzReq;
import com.febs.system.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
        stockTzBiz.qr(id,user);

        return new FebsResponse().success();
    }

    @GetMapping("/sh/{id}")
    public FebsResponse sh(@PathVariable("id")Long id){
        User user = getCurrentUser();
        StockTz stockTz = new StockTz();
        stockTz.setId(id);
        stockTz.setSh((byte)1);
        stockTz.setShr(user.getUsername());
        stockTz.setShrq(new Date());
        stockTzService.updateObject(stockTz);
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
}
