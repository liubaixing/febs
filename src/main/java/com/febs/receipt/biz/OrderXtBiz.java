package com.febs.receipt.biz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.febs.common.entity.QueryRequest;
import com.febs.common.enums.DeletedEnum;
import com.febs.common.exception.FebsException;
import com.febs.receipt.entity.*;
import com.febs.receipt.service.IOrderXtService;
import com.febs.receipt.service.IOrderXtmxService;
import com.febs.receipt.vo.req.OrderXsReq;
import com.febs.receipt.vo.req.OrderXtReq;
import com.febs.receipt.vo.resp.OrderXtResp;
import com.febs.system.entity.Cangku;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderXtBiz {

    @Autowired
    private IOrderXtService xtService;

    @Autowired
    private IOrderXtmxService xtmxService;

    public IPage<OrderXtResp> findByPage(QueryRequest request, OrderXtReq orderXt){
        return xtService.findOrderXts(request,orderXt);
    }

    public void create(OrderXtReq orderXtReq) {
        //保存商品明细
        if(CollectionUtils.isEmpty(orderXtReq.getOrderXtmxList())){
            throw new FebsException("销退单明细不能为空");
        }
        orderXtReq.setXdrq(new Date());
        Long orderXtId = xtService.createOrderXt(orderXtReq);
        for (OrderXtmx mx : orderXtReq.getOrderXtmxList()){
            mx.setPid(orderXtId);
            xtmxService.createOrderXtmx(mx);
        }

    }

    public void update(OrderXt orderXt) {
        xtService.updateOrderXt(orderXt);
    }


    public void delete(String[] ids) {
        OrderXt orderXt = new OrderXt();
        for (String id : ids) {
            orderXt.setId(Long.valueOf(id));
            orderXt.setDeleted(DeletedEnum.DELETED.getCode());
            xtService.updateOrderXt(orderXt);
        }
    }


    public void confirmOrderXs(OrderXs req, boolean status){
        OrderXt orderXt = xtService.findById(req.getId());
        if (orderXt == null) {
            throw new FebsException("销退单不存在");
        }
        if (status == true && orderXt.getQr() == 1) throw new FebsException("销退单已确认");
        if (status == false && orderXt.getQr() == 0) throw new FebsException("销退单未确认");

        orderXt.setQr(req.getQr());
        orderXt.setQrr(req.getQrr());
        orderXt.setQrrq(new Date());
        xtService.updateOrderXt(orderXt);
    }


    public void checkOrderXs(OrderXs req,boolean status){
        OrderXt orderXt = xtService.findById(req.getId());
        if (orderXt == null) {
            throw new FebsException("销退单不存在");
        }
        if (status == true && orderXt.getSh() == 1) throw new FebsException("销退单已审核");
        if (status == false && orderXt.getSh() == 0) throw new FebsException("销退单未审核");
        orderXt.setSh(req.getSh());
        orderXt.setShr(req.getShr());
        orderXt.setShrq(new Date());
        xtService.updateOrderXt(orderXt);
    }

    public void executeOrderXs(OrderXsReq req,boolean status){
        OrderXtmx xtmx = xtmxService.findById(req.getMxId());
        if (xtmx == null) {
            throw new FebsException("销售单不存在");
        }
        if (xtmx.getJhsl() == (xtmx.getTzsl()+xtmx.getCksl())) {
            throw new FebsException("订单已执行完毕");
        }


    }

    public void closeOrderXs(OrderXs req,boolean status){
        OrderXt orderXt = xtService.findById(req.getId());
        if (orderXt == null) {
            throw new FebsException("销售单不存在");
        }

    }



}
