package com.febs.receipt.biz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.febs.common.entity.QueryRequest;
import com.febs.common.enums.DeletedEnum;
import com.febs.common.exception.FebsException;
import com.febs.receipt.entity.OrderXsmx;
import com.febs.receipt.entity.OrderXt;
import com.febs.receipt.entity.OrderXtmx;
import com.febs.receipt.service.IOrderXtService;
import com.febs.receipt.service.IOrderXtmxService;
import com.febs.receipt.vo.req.OrderXsReq;
import com.febs.receipt.vo.req.OrderXtReq;
import com.febs.receipt.vo.resp.OrderXtResp;
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


    public OrderXtResp orderXtStatusCheck(Long id, String type, boolean status, String user){
        byte sta = 0;//状态
        if (status)
            sta =1;
        OrderXt orderXt = new OrderXt();
        orderXt.setId(id);
        switch (type){
            case "CONFIRM" :
                //确认
                orderXt.setQr(sta);
                orderXt.setQrr(user);
                orderXt.setQrrq(new Date());
                break;
            case "CHECK" :
                //审核
                orderXt.setSh(sta);
                orderXt.setShr(user);
                orderXt.setShrq(new Date());
                break;
            case "EXECUTE" :
                //执行
                orderXt.setZx(sta);
                orderXt.setZxr(user);
                orderXt.setZxrq(new Date());
                break;
            default:
                throw new FebsException("接口状态不存在");
        }
        return xtService.updateOrderXt(orderXt);
    }

}
