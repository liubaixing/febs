package com.febs.receipt.biz;

import com.febs.common.enums.DeletedEnum;
import com.febs.common.exception.FebsException;
import com.febs.receipt.entity.*;
import com.febs.receipt.mapper.OrderXsMapper;
import com.febs.receipt.mapper.OrderXtMapper;
import com.febs.receipt.service.*;
import com.febs.receipt.vo.req.OrderXsReq;
import com.febs.receipt.vo.req.OrderXsfpReq;
import com.febs.receipt.vo.req.XsfpCreateReq;
import com.febs.receipt.vo.resp.*;
import com.febs.system.entity.User;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
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

    @Resource
    private OrderXsMapper xsMapper;

    @Autowired
    private IOrderXsmxService xsmxService;

    @Autowired
    private IOrderXtService xtService;

    @Resource
    private OrderXtMapper xtMapper;

    @Autowired
    private IOrderXtmxService xtmxService;

    public void update(OrderXsfp xsfp){
        xsfpService.updateOrderXsfp(xsfp);
    }

    @Transactional
    public void zf(OrderXsfp xsfp){
        xsfpService.updateOrderXsfp(xsfp);

        OrderXsfpmx orderXsfpmx = new OrderXsfpmx();
        orderXsfpmx.setPid(xsfp.getId());
        List<OrderXsfpmxResp> xsfpmxResps = xsfpmxService.findOrderXsfpmxs(orderXsfpmx);

        for (OrderXsfpmxResp xsfpmx : xsfpmxResps){

            if (StringUtils.isNotBlank(xsfpmx.getYdjh())){

                String orderType = xsfpmx.getYdjh().substring(0,2);

                if ("xs".equals(orderType)) {

                    OrderXsReq orderXs = new OrderXsReq();
                    orderXs.setDjbh(xsfpmx.getYdjh());
                    OrderXsResp xsResp = xsService.findOrderXsDetail(orderXs);

                    OrderXsmx orderXsmx = new OrderXsmx();
                    orderXsmx.setPid(xsResp.getId());
                    orderXsmx.setSpId(xsfpmx.getSpId());
                    List<OrderXsmxResp> xsmxResps = xsmxService.findOrderXsmxs(orderXsmx);

                    OrderXsmxResp xsmx = xsmxResps.get(0);
                    xsmx.setKpsl(xsmx.getKpsl() - xsfpmx.getSl());
                    xsmxService.updateOrderXsmx(xsmx);

                } else if ("xt".equals(orderType)) {

                    OrderXtExample example = new OrderXtExample();
                    example.createCriteria().andDjbhEqualTo(xsfpmx.getYdjh());
                    List<OrderXt> orderXts = xtService.selectByExample(example);

                    if (CollectionUtils.isEmpty(orderXts)) {
                        throw new FebsException("销退单查询失败");
                    }
                    OrderXt orderXt = orderXts.get(0);

                    OrderXtmx orderXtmx = new OrderXtmx();
                    orderXtmx.setPid(orderXt.getId());
                    orderXtmx.setSpId(xsfpmx.getSpId());
                    List<OrderXtmxResp>  xtmxResps = xtmxService.findOrderXtmxs(orderXtmx);

                    OrderXtmxResp xtmx = xtmxResps.get(0);
                    xtmx.setKpsl(xtmx.getKpsl() - xsfpmx.getSl());
                    xtmxService.updateOrderXtmx(xtmx);

                }
            }
        }
    }

    @Transactional
    public void createOrderXsfp(XsfpCreateReq req, User user){

        if (CollectionUtils.isEmpty(req.getXsfpReqs())) throw new FebsException("开票单据不能为空");

        List<OrderXsfpReq> xsfpReqs = req.getXsfpReqs();

        Integer ghdwId = xsfpReqs.get(0).getGhdwId();

        BigDecimal zje = xsfpReqs.stream().map(OrderXsfpReq::getJe).reduce(BigDecimal.ZERO,BigDecimal::add);

        OrderXsfp xsfp = new OrderXsfp();
        xsfp.setDjrq(new Date());
        xsfp.setJe(zje);
        xsfp.setBz(req.getBz());
        xsfp.setGhdwId(ghdwId);
        xsfp.setZdr(user.getUsername());
        xsfp.setZdrq(new Date());
        Long id = xsfpService.createOrderXsfp(xsfp);

        for (OrderXsfpReq xsfpReq : xsfpReqs ){
            OrderXsfpmx orderXsfpmx = new OrderXsfpmx();
            orderXsfpmx.setPid(id);
            orderXsfpmx.setYdjh(xsfpReq.getYdjh());
            orderXsfpmx.setSpId(xsfpReq.getSpId());
            orderXsfpmx.setSl(xsfpReq.getSl());
            orderXsfpmx.setJe(xsfpReq.getJe());
            orderXsfpmx.setCreateTime(new Date());
            xsfpmxService.createOrderXsfpmx(orderXsfpmx);

            if("xs".equals(xsfpReq.getOrderType())){
                OrderXsExample example = new OrderXsExample();
                example.createCriteria().andDjbhEqualTo(xsfpReq.getYdjh());
                OrderXs orderXs = xsMapper.selectByExample(example).get(0);

                OrderXsmx orderXsmx = new OrderXsmx();
                orderXsmx.setPid(orderXs.getId());
                orderXsmx.setSpId(xsfpReq.getSpId());
                OrderXsmxResp xsmxResp = xsmxService.findOrderXsmxs(orderXsmx).get(0);

                if(xsmxResp.getKpsl() + xsfpReq.getSl() > xsmxResp.getJhsl()){
                    throw new FebsException("开票数超出计划数");
                }

                OrderXsmx xsmx = new OrderXsmx();
                xsmx.setId(xsmxResp.getId());
                xsmx.setKpsl(xsmxResp.getKpsl() + xsfpReq.getSl());
                xsmx.setKpje(xsmxResp.getKpje().add(xsfpReq.getJe()));
                xsmxService.updateOrderXsmx(xsmx);

            } else if ("xt".equals(xsfpReq.getOrderType())) {
                OrderXtExample example = new OrderXtExample();
                example.createCriteria().andDjbhEqualTo(xsfpReq.getYdjh());
                OrderXt orderXt = xtMapper.selectByExample(example).get(0);

                OrderXtmx orderXtmx = new OrderXtmx();
                orderXtmx.setPid(orderXt.getId());
                orderXtmx.setSpId(xsfpReq.getSpId());
                OrderXtmxResp xtmxResp = xtmxService.findOrderXtmxs(orderXtmx).get(0);
                if (xtmxResp.getTksl() + xsfpReq.getSl() > xtmxResp.getJhsl()) {
                    throw new FebsException("退款数超出计划数");
                }
                OrderXtmx xtmx = new OrderXtmx();
                xtmx.setId(xtmxResp.getId());
                xtmx.setKpsl(xtmxResp.getKpsl() + xsfpReq.getSl());
                xtmx.setKpje(xtmxResp.getKpje().add(xsfpReq.getJe()));
                xtmxService.updateOrderXtmx(xtmx);

            }

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

    public void kp(String djbh,User user) {

        OrderXsfp orderXsfp = new OrderXsfp();
        orderXsfp.setKp((byte)1);
        orderXsfp.setKpr(user.getUsername());
        orderXsfp.setKprq(new Date());

        OrderXsfpExample example = new OrderXsfpExample();
        example.createCriteria().andDjbhEqualTo(djbh);
        xsfpService.updateByExample(orderXsfp,example);
        /*OrderXsfpReq xsfpReq = new OrderXsfpReq();
        xsfpReq.setDjbh(xsfp.getDjbh());
        List<OrderXsfpResp> xsfpRespList = xsfpService.findOrderXsfps(xsfpReq);

        if (CollectionUtils.isEmpty(xsfpRespList)) throw new FebsException("发票单不存在");

        for (OrderXsfpResp fp : xsfpRespList){
            String orderType = fp.getYdjh().substring(0,2);

            if ("xs".equals(orderType)) {

                OrderXsExample example = new OrderXsExample();
                example.createCriteria().andDjbhEqualTo(fp.getYdjh());
                OrderXs orderXs = xsMapper.selectByExample(example).get(0);

                OrderXs xs = new OrderXs();
                xs.setId(orderXs.getId());
                xs.setSksl(orderXs.getKpsl() + fp.getSl());
                xs.setSkje(orderXs.getKpje().add(fp.getJe()));
                xsService.updateOrderXs(xs);

            } else if ("xt".equals(orderType)) {

                OrderXtExample example = new OrderXtExample();
                example.createCriteria().andDjbhEqualTo(fp.getYdjh());
                OrderXt orderXt = xtMapper.selectByExample(example).get(0);

                OrderXt xt = new OrderXt();
                xt.setId(orderXt.getId());
                xt.setTksl(orderXt.getTksl() + fp.getSl());
                xt.setTkje(orderXt.getTkje().add(fp.getJe()));
                xtService.updateOrderXt(xt);

            }
        }
        OrderXsfpExample example = new OrderXsfpExample();
        example.createCriteria().andDjbhEqualTo(xsfp.getDjbh());
        xsfpService.updateByExample(xsfp,example);*/

    }
}
