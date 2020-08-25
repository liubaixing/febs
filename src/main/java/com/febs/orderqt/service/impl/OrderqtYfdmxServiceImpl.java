package com.febs.orderqt.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.orderqt.entity.OrderqtYfdmx;
import com.febs.orderqt.entity.OrderqtYfdmxExample;
import com.febs.orderqt.mapper.OrderqtYfdmxMapper;
import com.febs.orderqt.service.IOrderqtYfdmxService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 运费单明细 Service实现
 *
 * @author liubaixing
 * @date 2020-07-29 14:14:20
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OrderqtYfdmxServiceImpl extends ServiceImpl<OrderqtYfdmxMapper, OrderqtYfdmx> implements IOrderqtYfdmxService {

    @Autowired
    private OrderqtYfdmxMapper orderqtYfdmxMapper;

    @Override
    public IPage<OrderqtYfdmx> findOrderqtYfdmxs(QueryRequest request, OrderqtYfdmx orderqtYfdmx) {
        Page<OrderqtYfdmx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.orderqtYfdmxMapper.selectPageByQuery(page, orderqtYfdmx);
    }

    @Override
    public List<OrderqtYfdmx> findOrderqtYfdmxs(OrderqtYfdmx orderqtYfdmx) {
		return this.orderqtYfdmxMapper.selectByQuery(orderqtYfdmx);
    }

    @Override
    @Transactional
    public void createOrderqtYfdmx(OrderqtYfdmx orderqtYfdmx) {
        this.orderqtYfdmxMapper.insertSelective(orderqtYfdmx);
    }

    @Override
    @Transactional
    public void updateOrderqtYfdmx(OrderqtYfdmx orderqtYfdmx) {
        this.orderqtYfdmxMapper.updateByPrimaryKeySelective(orderqtYfdmx);
    }

    @Override
    @Transactional
    public void deleteOrderqtYfdmx(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

    @Override
    @Transactional
	public void deleteByExample(OrderqtYfdmxExample example){
        this.orderqtYfdmxMapper.deleteByExample(example);
    }
}
