package com.febs.receipt.biz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.febs.common.entity.QueryRequest;
import com.febs.common.enums.DeletedEnum;
import com.febs.common.enums.order.OrderStatusEnum;
import com.febs.common.exception.FebsException;
import com.febs.receipt.entity.OrderXs;
import com.febs.receipt.service.IOrderXsService;
import com.febs.receipt.vo.req.OrderXsReq;
import com.febs.receipt.vo.resp.OrderXsResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class OrderXsBiz {

    @Autowired
    private IOrderXsService xsService;

    /**
     * @param request
     * @param orderXs
     * @return
     */
    public IPage<OrderXsResp> findByPage(QueryRequest request, OrderXsReq orderXs) {
        return xsService.findOrderXss(request, orderXs);
    }

    public void create(OrderXs orderXs) {
        xsService.createOrderXs(orderXs);
    }

    public void update(OrderXs orderXs) {
        xsService.updateOrderXs(orderXs);
    }

    public void delete(String[] ids) {
        OrderXs orderXs = new OrderXs();
        for (String id : ids) {
            orderXs.setId(Long.valueOf(id));
            orderXs.setDeleted(DeletedEnum.DELETED.getCode());
            xsService.updateOrderXs(orderXs);
        }
    }

    public OrderXsResp orderXsStatusCheck(Long id, String type,boolean status,String user){
        byte sta = 0;//状态
        if (status)
            sta =1;
        OrderXs orderXs = new OrderXs();
        orderXs.setId(id);
        switch (type){
            case "CONFIRM" :
                //确认
                orderXs.setQr(sta);
                orderXs.setQrr(user);
                orderXs.setQrrq(new Date());
                break;
            case "CHECK" :
                //审核
                orderXs.setSh(sta);
                orderXs.setShr(user);
                orderXs.setShrq(new Date());
                break;
            case "EXECUTE" :
                //执行
                orderXs.setZx(sta);
                orderXs.setZxr(user);
                orderXs.setZxrq(new Date());
                break;
            default:
                throw new FebsException("接口状态不存在");
        }
       return xsService.updateOrderXs(orderXs);
    }

}
