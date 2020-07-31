package com.febs.orderqt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.orderqt.entity.OrderqtYsfdmx;
import com.febs.orderqt.mapper.OrderqtYsfdmxMapper;
import com.febs.orderqt.service.IOrderqtYsfdmxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 印刷费单明细 Service实现
 *
 * @author liubaixing
 * @date 2020-07-29 14:14:26
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OrderqtYsfdmxServiceImpl extends ServiceImpl<OrderqtYsfdmxMapper, OrderqtYsfdmx> implements IOrderqtYsfdmxService {

    @Autowired
    private OrderqtYsfdmxMapper orderqtYsfdmxMapper;

    @Override
    public IPage<OrderqtYsfdmx> findOrderqtYsfdmxs(QueryRequest request, OrderqtYsfdmx orderqtYsfdmx) {
        Page<OrderqtYsfdmx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.orderqtYsfdmxMapper.selectPageByQuery(page, orderqtYsfdmx);
    }

    @Override
    public List<OrderqtYsfdmx> findOrderqtYsfdmxs(OrderqtYsfdmx orderqtYsfdmx) {
		return this.orderqtYsfdmxMapper.selectByQuery(orderqtYsfdmx);
    }

    @Override
    @Transactional
    public void createOrderqtYsfdmx(OrderqtYsfdmx orderqtYsfdmx) {
        this.orderqtYsfdmxMapper.insertSelective(orderqtYsfdmx);
    }

    @Override
    @Transactional
    public void updateOrderqtYsfdmx(OrderqtYsfdmx orderqtYsfdmx) {
        this.orderqtYsfdmxMapper.updateByPrimaryKeySelective(orderqtYsfdmx);
    }

    @Override
    @Transactional
    public void deleteOrderqtYsfdmx(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
