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
    public IPage<OrderXtmx> findOrderXtmxs(QueryRequest request, OrderXtmx orderXtmx) {
        LambdaQueryWrapper<OrderXtmx> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<OrderXtmx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<OrderXtmx> findOrderXtmxs(OrderXtmx orderXtmx) {
	    LambdaQueryWrapper<OrderXtmx> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createOrderXtmx(OrderXtmx orderXtmx) {
        LambdaQueryWrapper<OrderXtmx> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
        throw new FebsException("数据已存在，添加失败");
        }
        this.save(orderXtmx);
    }

    @Override
    @Transactional
    public void updateOrderXtmx(OrderXtmx orderXtmx) {
        LambdaQueryWrapper<OrderXtmx> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
            throw new FebsException("数据已存在，添加失败");
        }
        this.saveOrUpdate(orderXtmx);
    }

    @Override
    @Transactional
    public void deleteOrderXtmx(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
