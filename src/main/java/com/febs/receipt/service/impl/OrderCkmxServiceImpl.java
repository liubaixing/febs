package com.febs.receipt.service.impl;

import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.receipt.entity.OrderCkmx;
import com.febs.receipt.mapper.OrderCkmxMapper;
import com.febs.receipt.service.IOrderCkmxService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.receipt.vo.resp.OrderCkmxResp;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 出库单明细 Service实现
 *
 * @author liubaixing
 * @date 2020-07-03 22:44:06
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OrderCkmxServiceImpl extends ServiceImpl<OrderCkmxMapper, OrderCkmx> implements IOrderCkmxService {

    @Autowired
    private OrderCkmxMapper orderCkmxMapper;

    @Override
    public IPage<OrderCkmxResp> findOrderCkmxs(QueryRequest request, OrderCkmx orderCkmx) {
        Page<OrderCkmx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.orderCkmxMapper.selectPageByQuery(page, orderCkmx);
    }

    @Override
    public List<OrderCkmxResp> findOrderCkmxs(OrderCkmx orderCkmx) {
		return this.orderCkmxMapper.selectByQuery(orderCkmx);
    }

    @Override
    public OrderCkmxResp findById(Long id) {
        OrderCkmx orderCkmx = new OrderCkmx();
        orderCkmx.setId(id);
        List<OrderCkmxResp> ckmxList = findOrderCkmxs(orderCkmx);
        return CollectionUtils.isEmpty(ckmxList) ? null : ckmxList.get(0);
    }

    @Override
    @Transactional
    public void createOrderCkmx(OrderCkmx orderCkmx) {
        this.orderCkmxMapper.insertSelective(orderCkmx);
    }

    @Override
    @Transactional
    public void updateOrderCkmx(OrderCkmx orderCkmx) {
        this.orderCkmxMapper.updateByPrimaryKeySelective(orderCkmx);
    }

    @Override
    @Transactional
    public void deleteOrderCkmx(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
