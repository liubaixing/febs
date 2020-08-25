package com.febs.orderqt.biz;

import com.febs.common.exception.FebsException;
import com.febs.common.utils.BeanUtils;
import com.febs.orderqt.entity.*;
import com.febs.orderqt.service.IOrderqtYsfdService;
import com.febs.orderqt.service.IOrderqtYsfdmxService;
import com.febs.orderqt.vo.req.YsfdReq;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName: OrderqtYsfdBiz
 * @Description:
 * @Author:
 * @Date 2020/8/24
 * @Version 1.0
 */
@Service
public class OrderqtYsfdBiz {

    @Autowired
    private IOrderqtYsfdService orderqtYsfdService;
    @Autowired
    private IOrderqtYsfdmxService ysfdmxService;

    public void create(YsfdReq req) {

        if (CollectionUtils.isEmpty(req.getYsfdmxeList())) {
            throw new FebsException("印刷费单明细为空");
        }

        List<OrderqtYsfdmx> ysfdmxeList =  req.getYsfdmxeList();

        BigDecimal zje = ysfdmxeList.stream().map(OrderqtYsfdmx::getJe).reduce(BigDecimal.ZERO,BigDecimal::add);

        OrderqtYsfd ysfd = BeanUtils.transformFrom(req,OrderqtYsfd.class);
        ysfd.setJe(zje);
        Long pid = orderqtYsfdService.createOrderqtYsfd(ysfd);

        for (OrderqtYsfdmx ysfdmx : ysfdmxeList){
            ysfdmx.setPid(pid);
            ysfdmxService.createOrderqtYsfdmx(ysfdmx);
        }

    }

    public void update(YsfdReq req) {

        OrderqtYsfdExample example = new OrderqtYsfdExample();
        example.createCriteria().andIdEqualTo(req.getId());
        orderqtYsfdService.deleteByExample(example);

        OrderqtYsfdmxExample ysfdmxExample = new OrderqtYsfdmxExample();
        ysfdmxExample.createCriteria().andPidEqualTo(req.getId());
        ysfdmxService.deleteByExample(ysfdmxExample);

        create(req);

    }
}
