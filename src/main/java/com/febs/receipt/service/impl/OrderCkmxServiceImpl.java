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
    public IPage<OrderCkmx> findOrderCkmxs(QueryRequest request, OrderCkmx orderCkmx) {
        LambdaQueryWrapper<OrderCkmx> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<OrderCkmx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<OrderCkmx> findOrderCkmxs(OrderCkmx orderCkmx) {
	    LambdaQueryWrapper<OrderCkmx> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
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
