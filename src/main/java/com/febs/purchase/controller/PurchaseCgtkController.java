package com.febs.purchase.controller;

import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.febs.common.annotation.ControllerEndpoint;
import com.febs.common.controller.BaseController;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.ExcelUtil;
import com.febs.purchase.biz.PurchaseCgtkBiz;
import com.febs.purchase.entity.PurchaseCgtk;
import com.febs.purchase.service.IPurchaseCgtkService;

import com.febs.purchase.vo.req.PurchaseCgtkReq;
import com.febs.purchase.vo.resp.PurchaseCgtkResp;
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
 * 采购退款 Controller
 *
 * @author liubaixing
 * @date 2020-06-27 19:54:56
 */
@Slf4j
@Validated
@RestController
@RequestMapping("purchaseCgtk")
public class PurchaseCgtkController extends BaseController {

    @Autowired
    private IPurchaseCgtkService purchaseCgtkService;

    @Autowired
    private PurchaseCgtkBiz cgtkBiz;

    @GetMapping("")
    @RequiresPermissions("purchaseCgtk:list")
    public FebsResponse getAllPurchaseCgtks(PurchaseCgtkReq purchaseCgtk) {
        return new FebsResponse().success().data(purchaseCgtkService.findPurchaseCgtks(purchaseCgtk));
    }

    @GetMapping("/list")
    @RequiresPermissions("purchaseCgtk:list")
    public FebsResponse purchaseCgtkList(QueryRequest request, PurchaseCgtkReq purchaseCgtk) {
        Map<String, Object> dataTable = getDataTable(this.purchaseCgtkService.findPurchaseCgtks(request, purchaseCgtk));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增采购退款", exceptionMessage = "新增采购退款失败")
    @PostMapping("")
    @RequiresPermissions("purchaseCgtk:add")
    public FebsResponse addPurchaseCgtk(@Valid PurchaseCgtk purchaseCgtk) {
        this.purchaseCgtkService.createPurchaseCgtk(purchaseCgtk);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除采购退款", exceptionMessage = "删除采购退款失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("purchaseCgtk:delete")
    public FebsResponse deletePurchaseCgtk(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.purchaseCgtkService.deletePurchaseCgtk(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改采购退款", exceptionMessage = "修改采购退款失败")
    @PostMapping("/update")
    @RequiresPermissions("purchaseCgtk:update")
    public FebsResponse updatePurchaseCgtk(PurchaseCgtk purchaseCgtk) {
        this.purchaseCgtkService.updatePurchaseCgtk(purchaseCgtk);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("purchaseCgtk:export")
    public void export(QueryRequest queryRequest, PurchaseCgtkReq purchaseCgtk, HttpServletResponse response) throws IOException {
        List<PurchaseCgtkResp> purchaseCgtks = this.purchaseCgtkService.findPurchaseCgtks(queryRequest, purchaseCgtk).getRecords();
        ExcelUtil.export(purchaseCgtks, PurchaseCgtkResp.class,"采购退款",response);
    }

    @ApiOperation("作废")
    @ControllerEndpoint(operation = "作废", exceptionMessage = "作废失败")
    @GetMapping("/zf/{id}")
    @RequiresPermissions("purchaseCgtk:zf")
    public FebsResponse zf(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseCgtk purchaseCgtk = new PurchaseCgtk();
        purchaseCgtk.setId(id);
        purchaseCgtk.setZf((byte)1);
        purchaseCgtk.setZfr(user.getUsername());
        purchaseCgtk.setZfrq(new Date());
        this.purchaseCgtkService.updatePurchaseCgtk(purchaseCgtk);
        return new FebsResponse().success();
    }

    @ApiOperation("确认")
    @ControllerEndpoint(operation = "确认", exceptionMessage = "确认失败")
    @GetMapping("/qr/{id}")
    @RequiresPermissions("purchaseCgtk:qr")
    public FebsResponse qr(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseCgtk purchaseCgtk = new PurchaseCgtk();
        purchaseCgtk.setId(id);
        purchaseCgtk.setQr((byte)1);
        purchaseCgtk.setQrr(user.getUsername());
        purchaseCgtk.setQrrq(new Date());
        this.purchaseCgtkService.updatePurchaseCgtk(purchaseCgtk);
        return new FebsResponse().success();
    }

    @ApiOperation("审核")
    @ControllerEndpoint(operation = "审核", exceptionMessage = "审核失败")
    @GetMapping("/sh/{id}")
    @RequiresPermissions("purchaseCgtk:sh")
    public FebsResponse sh(@PathVariable Long id){
        User user = getCurrentUser();
        PurchaseCgtk purchaseCgtk = new PurchaseCgtk();
        purchaseCgtk.setId(id);
        purchaseCgtk.setSh((byte)1);
        purchaseCgtk.setAuditor(user.getUsername());
        purchaseCgtk.setShrq(new Date());
        this.purchaseCgtkService.updatePurchaseCgtk(purchaseCgtk);
        return new FebsResponse().success();
    }


    @ApiOperation("付款")
    @ControllerEndpoint(operation = "付款", exceptionMessage = "付款失败")
    @GetMapping("/fk/{id}")
    @RequiresPermissions("purchaseCgtk:fk")
    public FebsResponse fk(@PathVariable Long id){
        User user = getCurrentUser();
        return new FebsResponse().success();
    }

    @ApiOperation("查看")
    @ControllerEndpoint(operation = "查看", exceptionMessage = "查看失败")
    @GetMapping("/view/{id}")
    @RequiresPermissions("purchaseCgtk:view")
    public FebsResponse view(@PathVariable Long id){
        return new FebsResponse().data(cgtkBiz.view(id));
    }

    @ApiOperation("开始生成")
    @ControllerEndpoint(operation = "生成", exceptionMessage = "生成失败")
    @PostMapping("/kssc")
    @RequiresPermissions("purchaseCgtk:kssc")
    public FebsResponse kssc(@RequestBody Long id){
        User user = getCurrentUser();
        return new FebsResponse().success();
    }

}
