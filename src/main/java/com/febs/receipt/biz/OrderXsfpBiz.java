package com.febs.receipt.biz;

import com.febs.common.enums.DeletedEnum;
import com.febs.common.exception.FebsException;
import com.febs.receipt.entity.*;
import com.febs.receipt.mapper.OrderXsMapper;
import com.febs.receipt.mapper.OrderXtMapper;
import com.febs.receipt.service.*;
import com.febs.receipt.vo.req.OrderXsfpReq;
import com.febs.receipt.vo.req.OrderXsmxReq;
import com.febs.receipt.vo.resp.OrderXsfpResp;
import com.febs.receipt.vo.resp.OrderXsmxResp;
import com.febs.receipt.vo.resp.OrderXsskResp;
import org.apache.commons.collections4.CollectionUtils;
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


    @Autowired
    private IOrderXsService xsService;

    @Autowired
    private OrderXsMapper xsMapper;

    @Autowired
    private IOrderXsmxService xsmxService;

    @Autowired
    private IOrderXtService xtService;

    @Autowired
    private OrderXtMapper xtMapper;

    @Autowired
    private IOrderXtmxService xtmxService;

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

    public void delete(String[] ids) {
        OrderXsfp xsfp = new OrderXsfp();
        for (String id : ids) {
            xsfp.setId(Long.valueOf(id));
            xsfp.setDeleted(DeletedEnum.DELETED.getCode());
            xsfpService.updateOrderXsfp(xsfp);
        }
    }

    public OrderXsfpResp view(Long id) {

        OrderXsfpResp xsfpResp = xsfpService.findById(id);
        OrderXsfpmx orderXsfpmx = new OrderXsfpmx();
        orderXsfpmx.setPid(xsfpResp.getId());
        xsfpResp.setXsfpmxList(xsfpmxService.findOrderXsfpmxs(orderXsfpmx));
        return xsfpResp;
    }

    public void kp(OrderXsfp xsfp) {
        OrderXsfpReq xsfpReq = new OrderXsfpReq();
        xsfpReq.setDjbh(xsfp.getDjbh());
        List<OrderXsfpResp> xsfpRespList = xsfpService.findOrderXsfps(xsfpReq);

        if (CollectionUtils.isEmpty(xsfpRespList)) throw new FebsException("发票单不存在");

        String djbh = xsfpRespList.get(0).getYdjh();
        String orderType = djbh.substring(0,2);

        if ("xs".equals(orderType)) {
            for (OrderXsfpResp fp : xsfpRespList){

                OrderXsExample example = new OrderXsExample();
                example.createCriteria().andDjbhEqualTo(fp.getYdjh());
                OrderXs orderXs = xsMapper.selectByExample(example).get(0);

                OrderXsmxReq orderXsmx = new OrderXsmxReq();
                orderXsmx.setPid(orderXs.getId());
                orderXsmx.setSpId(fp.getSpId());
                OrderXsmxResp xsmxResp = xsmxService.findOrderXsmxs(orderXsmx).get(0);

                if(xsmxResp.getSksl() + fp.getSl() > xsmxResp.getJhsl()){
                    throw new FebsException("收款数超出计划数");
                }

                OrderXsmx xsmx = new OrderXsmx();
                xsmx.setId(xsmxResp.getId());
                xsmx.setSksl(xsmxResp.getSksl() + fp.getSl());
                xsmx.setSkje(xsmxResp.getSkje().add(fp.getJe()));
                xsmxService.updateOrderXsmx(xsmx);

                OrderXs xs = new OrderXs();
                xs.setId(orderXs.getId());
                xs.setSksl(orderXs.getSksl() + fp.getSl());
                xs.setSkje(orderXs.getSkje().add(fp.getJe()));
                xsService.updateOrderXs(xs);

            }


        } else if ("xt".equals(orderType)) {



        }

        OrderXsfpExample example = new OrderXsfpExample();
        example.createCriteria().andDjbhEqualTo(xsfp.getDjbh());
        xsfpService.updateByExample(xsfp,example);

    }
}
