package com.febs.receipt.biz;

import com.febs.common.utils.StringUtil;
import com.febs.receipt.entity.OrderXsfp;
import com.febs.receipt.entity.OrderXsfpmx;
import com.febs.receipt.service.IOrderXsfpService;
import com.febs.receipt.service.IOrderXsfpmxService;
import com.febs.receipt.vo.req.OrderXsfpReq;
import com.febs.receipt.vo.req.OrderXsmxReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class OrderXsfpBiz {

    @Autowired
    private IOrderXsfpService xsfpService;

    @Autowired
    private IOrderXsfpmxService xsfpmxService;

    public void update(OrderXsfp xsfp){
        xsfpService.updateOrderXsfp(xsfp);
    }

    public void createOrderXsfp(OrderXsfpReq req){
        List<OrderXsmxReq> xsmxList = req.getOrderXsmxeList();
        BigDecimal zje = xsmxList.stream().map(OrderXsmxReq::getKpje).reduce(BigDecimal.ZERO,BigDecimal::add);

        OrderXsfp xsfp = new OrderXsfp();
        xsfp.setDjrq(new Date());
        xsfp.setJe(zje);
        xsfp.setGhdwId(req.getGhdwId());
        xsfp.setZdr(req.getZdr());
        xsfp.setZdrq(req.getZdrq());
        Long id = xsfpService.createOrderXsfp(xsfp);

        for (OrderXsmxReq xsmx : xsmxList ){
            OrderXsfpmx orderXsfpmx = new OrderXsfpmx();
            orderXsfpmx.setPid(id);
            orderXsfpmx.setYdjh(xsmx.getPno());
            orderXsfpmx.setSpId(xsmx.getSpId());
            orderXsfpmx.setSl(xsmx.getKpsl());
            orderXsfpmx.setJe(xsmx.getKpje());
            orderXsfpmx.setCreateTime(new Date());
            xsfpmxService.createOrderXsfpmx(orderXsfpmx);
        }

    }

}
