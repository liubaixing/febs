package com.febs.receipt.service.impl;

import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.receipt.entity.OrderXtmx;
import com.febs.receipt.mapper.OrderXtmxMapper;
import com.febs.receipt.service.IOrderXtmxService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.receipt.vo.resp.OrderXtmxResp;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 销退单明细 Service实现
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:04
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OrderXtmxServiceImpl extends ServiceImpl<OrderXtmxMapper, OrderXtmx> implements IOrderXtmxService {

    @Autowired
    private OrderXtmxMapper orderXtmxMapper;

    @Override
    public IPage<OrderXtmxResp> findOrderXtmxs(QueryRequest request, OrderXtmx orderXtmx) {
        Page<OrderXtmx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.orderXtmxMapper.selectPageByQuery(page, orderXtmx);
    }

    @Override
    public List<OrderXtmxResp> findOrderXtmxs(OrderXtmx orderXtmx) {
		return this.orderXtmxMapper.selectByQuery(orderXtmx);
    }

    @Override
    public OrderXtmxResp findById(Long id){
        OrderXtmx orderXtmx = new OrderXtmx();
        orderXtmx.setId(id);
        List<OrderXtmxResp> orderXtmxList = findOrderXtmxs(orderXtmx);
        return CollectionUtils.isEmpty(orderXtmxList) ? null : orderXtmxList.get(0);
    }

    @Override
    @Transactional
    public void createOrderXtmx(OrderXtmx orderXtmx) {
        orderXtmxMapper.insertSelective(orderXtmx);
    }

    @Override
    @Transactional
    public void updateOrderXtmx(OrderXtmx orderXtmx) {
        orderXtmxMapper.updateByPrimaryKeySelective(orderXtmx);
    }

    @Override
    @Transactional
    public void deleteOrderXtmx(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
