package com.febs.receipt.biz;

import com.febs.common.enums.DeletedEnum;
import com.febs.receipt.entity.OrderXsfp;
import com.febs.receipt.entity.OrderXsfpmx;
import com.febs.receipt.entity.OrderXssk;
import com.febs.receipt.entity.OrderXsskmx;
import com.febs.receipt.service.IOrderXsskService;
import com.febs.receipt.service.IOrderXsskmxService;
import com.febs.receipt.vo.req.OrderXsmxReq;
import com.febs.receipt.vo.req.OrderXsskReq;
import com.febs.receipt.vo.resp.OrderXsskResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class OrderXsskBiz {

    @Autowired
    private IOrderXsskService xsskService;

    @Autowired
    private IOrderXsskmxService xsskmxService;

    public void update(OrderXssk xssk){
        xsskService.updateOrderXssk(xssk);
    }

    public void createOrderXssk(OrderXsskReq req){

        List<OrderXsmxReq> xsmxList = req.getOrderXsmxeList();
        BigDecimal zje = xsmxList.stream().map(OrderXsmxReq::getKpje).reduce(BigDecimal.ZERO,BigDecimal::add);

        OrderXssk xssk = new OrderXssk();
        xssk.setDjrq(new Date());
        xssk.setJe(zje);
        xssk.setGhdwId(req.getGhdwId());
        xssk.setZdr(req.getZdr());
        xssk.setZdrq(req.getZdrq());
        Long id = xsskService.createOrderXssk(xssk);

        for (OrderXsmxReq xsmx : xsmxList ){
            OrderXsskmx orderXsskmx = new OrderXsskmx();
            orderXsskmx.setPid(id);
            orderXsskmx.setYdjh(xsmx.getPno());
            orderXsskmx.setSpId(xsmx.getSpId());
            orderXsskmx.setJe(xsmx.getSkje());
            orderXsskmx.setCreateTime(new Date());
            xsskmxService.createOrderXsskmx(orderXsskmx);
        }

    }

    public void delete(String[] ids) {
        OrderXssk xssk = new OrderXssk();
        for (String id : ids) {
            xssk.setId(Long.valueOf(id));
            xssk.setDeleted(DeletedEnum.DELETED.getCode());
            xsskService.updateOrderXssk(xssk);
        }
    }

    public OrderXsskResp view(Long id) {
        OrderXsskResp xsskResp = xsskService.findById(id);
        OrderXsskmx orderXsskmx = new OrderXsskmx();
        orderXsskmx.setPid(xsskResp.getId());
        xsskResp.setXsskmxList(xsskmxService.findOrderXsskmxs(orderXsskmx));
        return xsskResp;
    }
}
