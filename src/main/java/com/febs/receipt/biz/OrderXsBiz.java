package com.febs.receipt.biz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.febs.common.entity.QueryRequest;
import com.febs.common.enums.DeletedEnum;
import com.febs.receipt.entity.OrderXs;
import com.febs.receipt.service.IOrderXsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class OrderXsBiz {

    @Autowired
    private IOrderXsService xsService;

    /**
     *
     * @param request
     * @param orderXs
     * @return
     */
    public IPage<OrderXs> findByPage(QueryRequest request, OrderXs orderXs){
        return xsService.findOrderXss(request,orderXs);
    }

    public void create(OrderXs orderXs){
        xsService.createOrderXs(orderXs);
    }

    public void update(OrderXs orderXs){
        xsService.updateOrderXs(orderXs);
    }

    public void delete(String[] ids){
        OrderXs orderXs = new OrderXs();
        for (String id : ids){
            orderXs.setId(Long.valueOf(id));
            orderXs.setDeleted(DeletedEnum.DELETED.getCode());
            xsService.updateOrderXs(orderXs);
        }
    }

}
