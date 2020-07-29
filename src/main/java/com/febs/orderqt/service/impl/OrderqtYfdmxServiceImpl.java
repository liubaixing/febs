package com.febs.orderqt.service.impl;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.orderqt.entity.OrderqtYfdmx;
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
        LambdaQueryWrapper<OrderqtYfdmx> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<OrderqtYfdmx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<OrderqtYfdmx> findOrderqtYfdmxs(OrderqtYfdmx orderqtYfdmx) {
	    LambdaQueryWrapper<OrderqtYfdmx> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createOrderqtYfdmx(OrderqtYfdmx orderqtYfdmx) {
        LambdaQueryWrapper<OrderqtYfdmx> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
        throw new FebsException("数据已存在，添加失败");
        }
        this.save(orderqtYfdmx);
    }

    @Override
    @Transactional
    public void updateOrderqtYfdmx(OrderqtYfdmx orderqtYfdmx) {
        LambdaQueryWrapper<OrderqtYfdmx> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
            throw new FebsException("数据已存在，添加失败");
        }
        this.saveOrUpdate(orderqtYfdmx);
    }

    @Override
    @Transactional
    public void deleteOrderqtYfdmx(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
