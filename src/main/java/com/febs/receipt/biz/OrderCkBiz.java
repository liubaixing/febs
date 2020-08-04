package com.febs.receipt.biz;


import com.febs.common.exception.FebsException;
import com.febs.receipt.entity.OrderCk;
import com.febs.receipt.entity.OrderCkmx;
import com.febs.receipt.entity.OrderXsmx;
import com.febs.receipt.service.IOrderCkService;
import com.febs.receipt.service.IOrderCkmxService;
import com.febs.receipt.service.IOrderXsService;
import com.febs.receipt.service.IOrderXsmxService;
import com.febs.receipt.vo.req.OrderCkReq;
import com.febs.receipt.vo.req.OrderXsReq;
import com.febs.receipt.vo.resp.OrderCkResp;
import com.febs.receipt.vo.resp.OrderXsResp;
import com.febs.receipt.vo.resp.OrderXsmxResp;
import com.febs.system.entity.User;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class OrderCkBiz {

    @Autowired
    private IOrderCkService ckService;

    @Autowired
    private IOrderCkmxService ckmxService;

    @Autowired
    private IOrderXsService xsService;
    @Autowired
    private IOrderXsmxService xsmxService;


    public OrderCkResp view(Long id) {
        OrderCkResp ckResp =  ckService.findById(id);
        OrderCkmx orderCkmx = new OrderCkmx();
        orderCkmx.setPid(ckResp.getId());
        ckResp.setCkmxList(ckmxService.findOrderCkmxs(orderCkmx));
        return ckResp;
    }

    public void add(OrderCkReq req){
        if(CollectionUtils.isEmpty(req.getCkmxList())){
            throw new FebsException("出库明细不能为空");
        }

        OrderCk ck = new OrderCk();
        BeanUtils.copyProperties(req,ck);

        List<OrderCkmx> ckmxList = req.getCkmxList();
        Integer zsl = ckmxList.stream().mapToInt(OrderCkmx::getSl).sum();
        BigDecimal zje = ckmxList.stream().map(OrderCkmx::getJe).reduce(BigDecimal.ZERO,BigDecimal::add);

        ck.setSl(zsl);
        ck.setJe(zje);
        Long id = ckService.createOrderCk(ck);

        for(OrderCkmx ckmx : ckmxList){
            ckmx.setPid(id);
            ckmxService.createOrderCkmx(ckmx);
        }

    }

    @Transactional
    public void bhfh(OrderCkReq req, User user) {
        OrderXsReq orderXs = new OrderXsReq();
        orderXs.setDjbh(req.getYdjh());
        OrderXsResp orderXsResp = xsService.findOrderXss(orderXs).get(0);

        if (orderXsResp == null) {
            throw new FebsException("销售单不存在");
        }

        orderXsResp.setWldh(req.getWldh());
        xsService.updateOrderXs(orderXsResp);

        OrderXsmx orderXsmx = new OrderXsmx();
        orderXsmx.setPid(orderXsResp.getId());
        orderXsmx.setSpId(req.getSpId());
        OrderXsmxResp xsmxResp = xsmxService.findOrderXsmxs(orderXsmx).get(0);

        xsmxResp.setCksl(req.getSl());
        xsmxService.updateOrderXsmx(xsmxResp);

        OrderCk ck = new OrderCk();
        ck.setId(req.getId());
        ck.setBhfh((byte)1);
        ck.setBhfhr(user.getUsername());
        ck.setBhfhrq(new Date());
        ckService.updateOrderCk(ck);

    }
}
