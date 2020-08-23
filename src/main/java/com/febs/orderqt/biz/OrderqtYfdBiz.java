package com.febs.orderqt.biz;

import com.febs.common.exception.FebsException;
import com.febs.orderqt.entity.OrderqtYfdmx;
import com.febs.orderqt.service.IOrderqtYfdService;
import com.febs.orderqt.vo.req.YfdReq;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderqtYfdBiz {

    @Autowired
    private IOrderqtYfdService orderqtYfdService;


    public void add(YfdReq req) {

        if (CollectionUtils.isEmpty(req.getYfdmxeList())) {
            throw new FebsException("运费单明细为空");
        }

        List<OrderqtYfdmx> yfdmxeList =  req.getYfdmxeList();


    }
}
