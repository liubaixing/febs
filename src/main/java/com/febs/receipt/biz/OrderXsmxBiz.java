package com.febs.receipt.biz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.febs.common.entity.QueryRequest;
import com.febs.common.enums.DeletedEnum;
import com.febs.receipt.entity.OrderXsmx;
import com.febs.receipt.service.IOrderXsmxService;
import com.febs.receipt.vo.req.OrderXsmxReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderXsmxBiz {

    @Autowired
    private IOrderXsmxService xsmxService;

    public IPage<OrderXsmx> findPage(QueryRequest request, OrderXsmxReq orderXsmx){
        return this.xsmxService.findOrderXsmxs(request,orderXsmx);
    }


    public void create(OrderXsmx orderXsmx){
        this.xsmxService.createOrderXsmx(orderXsmx);
    }

    public void update(OrderXsmx orderXsmx){
        this.xsmxService.updateOrderXsmx(orderXsmx);
    }

    public void delete(String[] ids){
        OrderXsmx xsmx = new OrderXsmx();
        for (String id : ids){
            xsmx.setId(Long.valueOf(id));
            xsmx.setDeleted(DeletedEnum.DELETED.getCode());
            this.xsmxService.updateOrderXsmx(xsmx);
        }
    }

}
