package com.febs.receipt.biz;

import com.febs.common.enums.DeletedEnum;
import com.febs.common.exception.FebsException;
import com.febs.receipt.entity.*;
import com.febs.receipt.mapper.OrderXsMapper;
import com.febs.receipt.service.IOrderXsService;
import com.febs.receipt.service.IOrderXsmxService;
import com.febs.receipt.service.IOrderXsskService;
import com.febs.receipt.service.IOrderXsskmxService;
import com.febs.receipt.vo.req.OrderXsskReq;
import com.febs.receipt.vo.req.XsskCreateReq;
import com.febs.receipt.vo.resp.OrderXsResp;
import com.febs.receipt.vo.resp.OrderXsmxResp;
import com.febs.receipt.vo.resp.OrderXsskResp;
import com.febs.system.entity.User;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    /*public void createOrderXssk(OrderXsskReq req){

        List<OrderXsmxReq> xsmxList = req.getOrderXsmxList();
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

    }*/

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

    public void sk(String djbh,User user) {

        OrderXssk orderXssk = new OrderXssk();
        orderXssk.setSk((byte)1);
        orderXssk.setSkr(user.getUsername());
        orderXssk.setSkrq(new Date());

        OrderXsskExample example = new OrderXsskExample();
        example.createCriteria().andDjbhEqualTo(djbh);
        xsskService.updateByExample(orderXssk,example);

        /*OrderXsskReq orderXssk = new OrderXsskReq();
        orderXssk.setDjbh(xssk.getDjbh());
        List<OrderXsskResp> orderXsskList = xsskService.findOrderXssks(orderXssk);
        if (CollectionUtils.isEmpty(orderXsskList))throw new FebsException("收款单不存在");

        for (OrderXsskResp sk : orderXsskList){

            OrderXsExample example = new OrderXsExample();
            example.createCriteria().andDjbhEqualTo(sk.getYdjh());
            OrderXs orderXs = xsMapper.selectByExample(example).get(0);

            OrderXs xs = new OrderXs();
            xs.setId(orderXs.getId());
            xs.setSksl(orderXs.getSksl() + sk.getSl());
            xs.setSkje(orderXs.getSkje().add(sk.getJe()));
            xsService.updateOrderXs(xs);

        }


        OrderXsskExample example = new OrderXsskExample();
        example.createCriteria().andDjbhEqualTo(xssk.getDjbh());
        xsskService.updateByExample(xssk,example);*/

    }

    @Transactional
    public void create(XsskCreateReq req, User user) {
        if (CollectionUtils.isEmpty(req.getXsskList())) {
            throw new FebsException("单据不能为空");
        }

        List<OrderXsskReq> xsskList = req.getXsskList();

        OrderXssk xssk = new OrderXssk();

        BigDecimal zje = xsskList.stream().map(OrderXsskReq::getJe).reduce(BigDecimal.ZERO,BigDecimal::add);

        xssk.setDjrq(new Date());
        xssk.setGhdwId(xsskList.get(0).getGhdwId());
        xssk.setJe(zje);
        xssk.setBz(req.getBz());
        xssk.setZdr(user.getUsername());
        xssk.setZdrq(new Date());
        Long pid = xsskService.createOrderXssk(xssk);

        for (OrderXsskReq xsskReq : xsskList) {
            OrderXsskmx skmx = new OrderXsskmx();
            skmx.setPid(pid);
            skmx.setYdjh(xsskReq.getDjbh());
            skmx.setSpId(xsskReq.getSpId());
            skmx.setSl(xsskReq.getSl());
            skmx.setJe(xsskReq.getJe());
            xsskmxService.createOrderXsskmx(skmx);

            OrderXsExample example = new OrderXsExample();
            example.createCriteria().andDjbhEqualTo(xsskReq.getYdjh());
            OrderXs orderXs = xsMapper.selectByExample(example).get(0);

            OrderXsmx orderXsmx = new OrderXsmx();
            orderXsmx.setPid(orderXs.getId());
            orderXsmx.setSpId(xsskReq.getSpId());
            OrderXsmxResp xsmxResp = xsmxService.findOrderXsmxs(orderXsmx).get(0);

            if (xsmxResp.getTksl() + xsskReq.getSl() > xsmxResp.getJhsl()) {
                throw new FebsException("收款数超出计划数");
            }

            OrderXsmx xsmx = new OrderXsmx();
            xsmx.setId(xsmxResp.getId());
            xsmx.setSksl(xsmxResp.getSksl() + xsskReq.getSl());
            xsmx.setSkje(xsmxResp.getSkje().add(xsskReq.getJe()));
            xsmxService.updateOrderXsmx(xsmx);
        }

    }
}
