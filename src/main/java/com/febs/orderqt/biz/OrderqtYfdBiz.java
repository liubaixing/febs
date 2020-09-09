package com.febs.orderqt.biz;

import com.febs.common.exception.FebsException;
import com.febs.common.utils.BeanUtils;
import com.febs.orderqt.entity.OrderqtYfd;
import com.febs.orderqt.entity.OrderqtYfdExample;
import com.febs.orderqt.entity.OrderqtYfdmx;
import com.febs.orderqt.entity.OrderqtYfdmxExample;
import com.febs.orderqt.service.IOrderqtYfdService;
import com.febs.orderqt.service.IOrderqtYfdmxService;
import com.febs.orderqt.vo.req.YfdReq;
import com.febs.orderqt.vo.resp.YfdResp;
import com.febs.purchase.vo.req.PurchaseCgfpReq;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderqtYfdBiz {

    @Autowired
    private IOrderqtYfdService orderqtYfdService;

    @Autowired
    private IOrderqtYfdmxService orderqtYfdmxService;

    public YfdResp view(Long id){
        YfdResp yfdResp = orderqtYfdService.findById(id);

        OrderqtYfdmx yfdmx = new OrderqtYfdmx();
        yfdmx.setPid(yfdResp.getId());
        yfdResp.setMxList(orderqtYfdmxService.findOrderqtYfdmxs(yfdmx));
        return  yfdResp;
    }

    public void create(YfdReq req) {

        if (CollectionUtils.isEmpty(req.getYfdmxeList())) {
            throw new FebsException("运费单明细为空");
        }

        List<OrderqtYfdmx> yfdmxeList =  req.getYfdmxeList();

        BigDecimal zje = yfdmxeList.stream().map(OrderqtYfdmx::getJe).reduce(BigDecimal.ZERO,BigDecimal::add);

        OrderqtYfd orderqtYfd = BeanUtils.transformFrom(req,OrderqtYfd.class);
        orderqtYfd.setJe(zje);
        Long pid = orderqtYfdService.createOrderqtYfd(orderqtYfd);

        for (OrderqtYfdmx yfdmx : yfdmxeList){
            yfdmx.setPid(pid);
            orderqtYfdmxService.createOrderqtYfdmx(yfdmx);
        }

    }

    public void update(YfdReq req){

        OrderqtYfdExample example = new OrderqtYfdExample();
        example.createCriteria().andIdEqualTo(req.getId());
        orderqtYfdService.deleteByExample(example);

        OrderqtYfdmxExample yfdmxExample = new OrderqtYfdmxExample();
        yfdmxExample.createCriteria().andPidEqualTo(req.getId());
        orderqtYfdmxService.deleteByExample(yfdmxExample);

        create(req);
    }
}
