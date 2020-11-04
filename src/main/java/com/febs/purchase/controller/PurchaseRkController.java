package com.febs.purchase.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.purchase.biz.PurchaseRkBiz;
import com.febs.purchase.entity.PurchaseRk;
import com.febs.purchase.service.IPurchaseRkService;

import com.febs.purchase.vo.req.PurchaseRkReq;
import com.febs.purchase.vo.resp.PurchaseRkResp;
import com.febs.system.entity.User;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * 入库单 Controller
 *
 * @author liubaixing
 * @date 2020-06-27 19:56:08
 */
@Slf4j
@Validated
@RestController
@RequestMapping("purchaseRk")
public class PurchaseRkController extends BaseController {

    @Autowired
    private IPurchaseRkService purchaseRkService;

    @Autowired
    private PurchaseRkBiz purchaseRkBiz;

    @GetMapping("")
//    @RequiresPermissions("purchaseRk:list")
    public FebsResponse getAllPurchaseRks(PurchaseRkReq purchaseRk) {
        return new FebsResponse().success().data(purchaseRkService.findPurchaseRks(purchaseRk));
    }

    @GetMapping("/list")
//    @RequiresPermissions("purchaseRk:list")
    public FebsResponse purchaseRkList(QueryRequest request, PurchaseRkReq purchaseRk) {
        Map<String, Object> dataTable = getDataTable(this.purchaseRkService.findPurchaseRks(request, purchaseRk));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增入库单", exceptionMessage = "新增入库单失败")
    @PostMapping("")
//    @RequiresPermissions("purchaseRk:add")
    public FebsResponse addPurchaseRk(PurchaseRkReq req) {
//        this.purchaseRkService.createPurchaseRk(purchaseRk);
        User user = getCurrentUser();
        req.setZdr(user.getUsername());
        req.setZdrq(new Date());
        req.setCreateTime(new Date());
        purchaseRkBiz.create(req);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除入库单", exceptionMessage = "删除入库单失败")
    @GetMapping("delete/{ids}")
//    @RequiresPermissions("purchaseRk:delete")
    public FebsResponse deletePurchaseRk(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.purchaseRkService.deletePurchaseRk(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改入库单", exceptionMessage = "修改入库单失败")
    @PostMapping("/update")
//    @RequiresPermissions("purchaseRk:update")
    public FebsResponse updatePurchaseRk(PurchaseRk purchaseRk) {
        this.purchaseRkService.updatePurchaseRk(purchaseRk);
        return new FebsResponse().success();
    }



    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
//    @RequiresPermissions("purchaseRk:export")
    public void export(QueryRequest queryRequest, PurchaseRkReq purchaseRk, HttpServletResponse response) throws IOException {
        List<PurchaseRkResp> purchaseRks = this.purchaseRkService.findPurchaseRks(queryRequest, purchaseRk).getRecords();
        ExcelUtil.export(purchaseRks, PurchaseRkResp.class,"入库单",response);
    }

    @ApiOperation("查看")
    @GetMapping("view/{id}")
//    @RequiresPermissions("purchaseRk:view")
    public FebsResponse view(@PathVariable("id") Long id) throws IOException {
        return new FebsResponse().success().data(purchaseRkBiz.view(id));
    }


    @ApiOperation("确认")
    @GetMapping("qr/{id}")
//    @RequiresPermissions("purchaseRk:qr")
    public FebsResponse qr(@PathVariable("id") Long id) throws IOException {
        User user = getCurrentUser();
        purchaseRkBiz.qr(id,user);
        return new FebsResponse().success();
    }

    @ApiOperation("关闭")
    @GetMapping("gb/{id}")
//    @RequiresPermissions("purchaseRk:gb")
    public FebsResponse gb(@PathVariable("id") Long id) throws IOException {
        User user = getCurrentUser();
        PurchaseRk purchaseRk = new PurchaseRk();
        purchaseRk.setId(id);
        purchaseRk.setGb((byte)1);
        purchaseRk.setGbr(user.getUsername());
        purchaseRk.setGbrq(new Date());
        purchaseRkBiz.updateByPrimaryKey(purchaseRk);
        return new FebsResponse().success();
    }

    @ApiOperation("作废")
    @GetMapping("zf/{id}")
//    @RequiresPermissions("purchaseRk:zf")
    public FebsResponse zf(@PathVariable("id") Long id) throws IOException {
        User user = getCurrentUser();
        PurchaseRk purchaseRk = new PurchaseRk();
        purchaseRk.setId(id);
        purchaseRk.setZf((byte)1);
        purchaseRk.setZfr(user.getUsername());
        purchaseRk.setZfrq(new Date());
        purchaseRkBiz.updateByPrimaryKey(purchaseRk);
        return new FebsResponse().success();
    }

    @ApiOperation("审核入库")
    @GetMapping("shrk/{id}")
//    @RequiresPermissions("purchaseRk:shrk")
    public FebsResponse shrk(@PathVariable("id") Long id) throws IOException {
        User user = getCurrentUser();
        PurchaseRk purchaseRk = new PurchaseRk();
        purchaseRk.setId(id);
        purchaseRk.setShrkr(user.getUsername());
        purchaseRkBiz.shrk(purchaseRk);
        return new FebsResponse().success();
    }

}
