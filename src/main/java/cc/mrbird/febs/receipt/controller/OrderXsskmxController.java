package cc.mrbird.febs.receipt.controller;

import cc.mrbird.febs.common.annotation.ControllerEndpoint;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.receipt.entity.OrderXsskmx;
import cc.mrbird.febs.receipt.service.IOrderXsskmxService;
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
 * 销售收款明细 Controller
 *
 * @author liubaixing
 * @date 2020-06-02 13:37:33
 */
@Slf4j
@Validated
@RestController
@RequestMapping("orderXsskmx")
public class OrderXsskmxController extends BaseController {

    @Autowired
    private IOrderXsskmxService orderXsskmxService;


    @GetMapping("")
    @RequiresPermissions("orderXsskmx:list")
    public FebsResponse getAllOrderXsskmxs(OrderXsskmx orderXsskmx) {
        return new FebsResponse().success().data(orderXsskmxService.findOrderXsskmxs(orderXsskmx));
    }

    @GetMapping("/list")
    @RequiresPermissions("orderXsskmx:list")
    public FebsResponse orderXsskmxList(QueryRequest request, OrderXsskmx orderXsskmx) {
        Map<String, Object> dataTable = getDataTable(this.orderXsskmxService.findOrderXsskmxs(request, orderXsskmx));
        return new FebsResponse().success().data(dataTable);
    }

    @ControllerEndpoint(operation = "新增OrderXsskmx", exceptionMessage = "新增OrderXsskmx失败")
    @PostMapping("")
    @RequiresPermissions("orderXsskmx:add")
    public FebsResponse addOrderXsskmx(@Valid OrderXsskmx orderXsskmx) {
        this.orderXsskmxService.createOrderXsskmx(orderXsskmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "删除OrderXsskmx", exceptionMessage = "删除OrderXsskmx失败")
    @GetMapping("delete/{ids}")
    @RequiresPermissions("orderXsskmx:delete")
    public FebsResponse deleteOrderXsskmx(@NotBlank(message = "{required}") @PathVariable String ids) {
        String[] id = ids.split(StringPool.COMMA);
        this.orderXsskmxService.deleteOrderXsskmx(id);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(operation = "修改OrderXsskmx", exceptionMessage = "修改OrderXsskmx失败")
    @PostMapping("/update")
    @RequiresPermissions("orderXsskmx:update")
    public FebsResponse updateOrderXsskmx(OrderXsskmx orderXsskmx) {
        this.orderXsskmxService.updateOrderXsskmx(orderXsskmx);
        return new FebsResponse().success();
    }

    @ControllerEndpoint(exceptionMessage = "导出Excel失败")
    @GetMapping("excel")
    @RequiresPermissions("orderXsskmx:export")
    public void export(QueryRequest queryRequest, OrderXsskmx orderXsskmx, HttpServletResponse response) {
        List<OrderXsskmx> orderXsskmxs = this.orderXsskmxService.findOrderXsskmxs(queryRequest, orderXsskmx).getRecords();
        ExcelKit.$Export(OrderXsskmx.class, response).downXlsx(orderXsskmxs, false);
    }
}
