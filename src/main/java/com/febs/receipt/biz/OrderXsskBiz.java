package com.febs.receipt.biz;

import com.febs.common.enums.DeletedEnum;
import com.febs.common.exception.FebsException;
import com.febs.receipt.entity.*;
import com.febs.receipt.mapper.OrderXsMapper;
import com.febs.receipt.service.IOrderXsService;
import com.febs.receipt.service.IOrderXsmxService;
import com.febs.receipt.service.IOrderXsskService;
import com.febs.receipt.service.IOrderXsskmxService;
import com.febs.receipt.vo.req.OrderXsReq;
import com.febs.receipt.vo.req.OrderXsmxReq;
import com.febs.receipt.vo.req.OrderXsskCreateReq;
import com.febs.receipt.vo.req.OrderXsskReq;
import com.febs.receipt.vo.resp.OrderXsResp;
import com.febs.receipt.vo.resp.OrderXsmxResp;
import com.febs.receipt.vo.resp.OrderXsskResp;
import com.febs.system.entity.User;
import org.apache.commons.collections4.CollectionUtils;
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

    @Autowired
    private IOrderXsService xsService;

    @Autowired
    private OrderXsMapper xsMapper;

    @Autowired
    private IOrderXsmxService xsmxService;

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

    public void sk(OrderXssk xssk) {
        OrderXsskReq orderXssk = new OrderXsskReq();
        orderXssk.setDjbh(xssk.getDjbh());
        List<OrderXsskResp> orderXsskList = xsskService.findOrderXssks(orderXssk);
        if (CollectionUtils.isEmpty(orderXsskList))throw new FebsException("收款单不存在");


        for (OrderXsskResp sk : orderXsskList){

            OrderXsExample example = new OrderXsExample();
            example.createCriteria().andDjbhEqualTo(sk.getYdjh());
            OrderXs orderXs = xsMapper.selectByExample(example).get(0);

            OrderXsmxReq orderXsmx = new OrderXsmxReq();
            orderXsmx.setPid(orderXs.getId());
            orderXsmx.setSpId(sk.getSpId());
            OrderXsmxResp xsmxResp = xsmxService.findOrderXsmxs(orderXsmx).get(0);

            if(xsmxResp.getSksl() + sk.getSl() > xsmxResp.getJhsl()){
                throw new FebsException("收款数超出计划数");
            }

            OrderXsmx xsmx = new OrderXsmx();
            xsmx.setId(xsmxResp.getId());
            xsmx.setSksl(xsmxResp.getSksl() + sk.getSl());
            xsmx.setSkje(xsmxResp.getSkje().add(sk.getJe()));
            xsmxService.updateOrderXsmx(xsmx);

            OrderXs xs = new OrderXs();
            xs.setId(orderXs.getId());
            xs.setSksl(orderXs.getSksl() + sk.getSl());
            xs.setSkje(orderXs.getSkje().add(sk.getJe()));
            xsService.updateOrderXs(xs);

        }


        OrderXsskExample example = new OrderXsskExample();
        example.createCriteria().andDjbhEqualTo(xssk.getDjbh());
        xsskService.updateByExample(xssk,example);

    }

    public void create(OrderXsskCreateReq req, User user) {
        List<OrderXsResp> orderXsList = req.getOrderXsList();
        if (CollectionUtils.isEmpty(orderXsList)) {
            throw new FebsException("单据不能为空");
        }

        Integer orgId = orderXsList.get(0).getOrgId();
        OrderXssk xssk = new OrderXssk();

        BigDecimal zje = orderXsList.stream().map(OrderXsResp::getJe).reduce(BigDecimal.ZERO,BigDecimal::add);
        xssk.setDjrq(new Date());
        xssk.setGhdwId(orgId);
        xssk.setJe(zje);
        xssk.setBz(req.getBz());
        xssk.setZdr(user.getUsername());
        xssk.setZdrq(new Date());
        Long pid = xsskService.createOrderXssk(xssk);

        for (OrderXsResp xsResp : orderXsList) {
            OrderXsskmx skmx = new OrderXsskmx();
            skmx.setPid(pid);
            skmx.setYdjh(xsResp.getDjbh());
            skmx.setSpId(xsResp.getSpId());
            skmx.setSl(xsResp.getSl());
            skmx.setJe(xsResp.getJe());
            xsskmxService.createOrderXsskmx(skmx);
        }

    }
}
