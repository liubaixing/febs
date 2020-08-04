package com.febs.receipt.biz;

import com.febs.common.enums.DeletedEnum;
import com.febs.common.exception.FebsException;
import com.febs.receipt.entity.*;
import com.febs.receipt.mapper.OrderXtMapper;
import com.febs.receipt.service.IOrderXstkService;
import com.febs.receipt.service.IOrderXstkmxService;
import com.febs.receipt.service.IOrderXtService;
import com.febs.receipt.service.IOrderXtmxService;
import com.febs.receipt.vo.req.OrderXstkReq;
import com.febs.receipt.vo.req.XstkCreateReq;
import com.febs.receipt.vo.resp.OrderXstkResp;
import com.febs.receipt.vo.resp.OrderXtResp;
import com.febs.receipt.vo.resp.OrderXtmxResp;
import com.febs.system.entity.User;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class OrderXstkBiz {

    @Autowired
    private IOrderXstkService xstkService;

    @Autowired
    private IOrderXstkmxService xstkmxService;

    @Autowired
    private IOrderXtService xtService;

    @Autowired
    private OrderXtMapper xtMapper;

    @Autowired
    private IOrderXtmxService xtmxService;

    public void update(OrderXstk xstk){
        xstkService.updateOrderXstk(xstk);
    }


    /*public void createOrderXstk(OrderXstkReq req){

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

    }*/

    public void delete(String[] ids) {
        OrderXstk xstk = new OrderXstk();
        for (String id : ids) {
            xstk.setId(Long.valueOf(id));
            xstk.setDeleted(DeletedEnum.DELETED.getCode());
            xstkService.updateOrderXstk(xstk);
        }
    }

    public OrderXstkResp view(Long id) {
        OrderXstkResp xstkResp = xstkService.findById(id);
        OrderXstkmx orderXstkmx = new OrderXstkmx();
        orderXstkmx.setPid(xstkResp.getId());
        xstkResp.setXstkmxList(xstkmxService.findOrderXstkmxs(orderXstkmx));
        return  xstkResp;
    }

    public void tk(String djbh,User user) {
        OrderXstk orderXstk = new OrderXstk();
        orderXstk.setTk((byte)1);
        orderXstk.setTkr(user.getUsername());
        orderXstk.setTkrq(new Date());

        OrderXstkExample example = new OrderXstkExample();
        example.createCriteria().andDjbhEqualTo(djbh);
        xstkService.updateByExample(orderXstk,example);
        /*OrderXstkReq xstkReq = new OrderXstkReq();
        xstkReq.setDjbh(xstk.getDjbh());
        List<OrderXstkResp> xstkRespList = xstkService.findOrderXstks(xstkReq);

        if (CollectionUtils.isEmpty(xstkRespList)) throw new FebsException("销退单不存在");

        for (OrderXstkResp xstkResp : xstkRespList){
            OrderXtExample example = new OrderXtExample();
            example.createCriteria().andDjbhEqualTo(xstkResp.getYdjh());
            OrderXt orderXt = xtMapper.selectByExample(example).get(0);

            OrderXt xt = new OrderXt();
            xt.setId(orderXt.getId());
            xt.setTksl(orderXt.getTksl() + xstkResp.getSl());
            xt.setTkje(orderXt.getTkje().add(xstkResp.getJe()));
            xtService.updateOrderXt(xt);
        }

        OrderXstkExample example = new OrderXstkExample();
        example.createCriteria().andDjbhEqualTo(xstk.getDjbh());
        xstkService.updateByExample(xstk,example);*/

    }

    @Transactional
    public void create(XstkCreateReq req, User user) {

        if (CollectionUtils.isEmpty(req.getXstkList())) {
            throw new FebsException("退款单不能为空");
        }
        List<OrderXstkReq> xstkList = req.getXstkList();

        Integer orgId = xstkList.get(0).getGhdwId();
        OrderXstk xstk = new OrderXstk();

        BigDecimal zje = xstkList.stream().map(OrderXstkReq::getJe).reduce(BigDecimal.ZERO,BigDecimal::add);

        xstk.setDjrq(new Date());
        xstk.setGhdwId(orgId);
        xstk.setJe(zje);
        xstk.setBz(req.getBz());
        xstk.setZdr(user.getUsername());
        xstk.setZdrq(new Date());
        Long pid = xstkService.createOrderXstk(xstk);

        for (OrderXstkReq orderXstk : xstkList){
            OrderXstkmx tkmx = new OrderXstkmx();
            tkmx.setPid(pid);
            tkmx.setYdjh(orderXstk.getDjbh());
            tkmx.setSpId(orderXstk.getSpId());
            tkmx.setSl(orderXstk.getSl());
            tkmx.setJe(orderXstk.getJe());
            xstkmxService.createOrderXstkmx(tkmx);

            OrderXtExample example = new OrderXtExample();
            example.createCriteria().andDjbhEqualTo(orderXstk.getYdjh());
            OrderXt orderXt = xtMapper.selectByExample(example).get(0);

            OrderXtmx orderXtmx = new OrderXtmx();
            orderXtmx.setPid(orderXt.getId());
            orderXtmx.setSpId(orderXstk.getSpId());
            OrderXtmxResp xtmxResp = xtmxService.findOrderXtmxs(orderXtmx).get(0);

            if (xtmxResp.getTksl() + orderXstk.getSl() > xtmxResp.getJhsl()) {
                throw new FebsException("退款数超出计划数");
            }

            OrderXtmx xtmx = new OrderXtmx();
            xtmx.setId(xtmxResp.getId());
            xtmx.setTksl(xtmxResp.getTksl() + orderXstk.getSl());
            xtmx.setTkje(xtmxResp.getTkje().add(orderXstk.getJe()));
            xtmxService.updateOrderXtmx(xtmx);

        }


    }
}
