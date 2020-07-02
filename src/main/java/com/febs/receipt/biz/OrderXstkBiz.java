package com.febs.receipt.biz;

import com.febs.receipt.entity.OrderXstk;
import com.febs.receipt.entity.OrderXstkmx;
import com.febs.receipt.service.IOrderXstkService;
import com.febs.receipt.service.IOrderXstkmxService;
import com.febs.receipt.vo.req.OrderXsmxReq;
import com.febs.receipt.vo.req.OrderXstkReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class OrderXstkBiz {

    @Autowired
    private IOrderXstkService xstkService;

    @Autowired
    private IOrderXstkmxService xstkmxService;

    public void update(OrderXstk xstk){
        xstkService.updateOrderXstk(xstk);
    }


    public void createOrderXstk(OrderXstkReq req){

        List<OrderXsmxReq> xsmxList = req.getOrderXsmxeList();
        BigDecimal zje = xsmxList.stream().map(OrderXsmxReq::getKpje).reduce(BigDecimal.ZERO,BigDecimal::add);

        OrderXstk xstk = new OrderXstk();
        xstk.setDjrq(new Date());
        xstk.setJe(zje);
        xstk.setGhdwId(req.getGhdwId());
        xstk.setZdr(req.getZdr());
        xstk.setZdrq(req.getZdrq());
        Long id = xstkService.createOrderXstk(xstk);

        for (OrderXsmxReq xsmx : xsmxList ){
            OrderXstkmx orderXstkmx = new OrderXstkmx();
            orderXstkmx.setPid(id);
            orderXstkmx.setYdjh(xsmx.getPno());
            orderXstkmx.setSpId(xsmx.getSpId());
            orderXstkmx.setJe(xsmx.getSkje());
            orderXstkmx.setCreateTime(new Date());
            xstkmxService.createOrderXstkmx(orderXstkmx);
        }

    }

}
