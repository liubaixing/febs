package com.febs.receipt.service.impl;

import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.receipt.entity.OrderXsskmx;
import com.febs.receipt.mapper.OrderXsskmxMapper;
import com.febs.receipt.service.IOrderXsskmxService;
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
 * 销售收款明细 Service实现
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:11
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OrderXsskmxServiceImpl extends ServiceImpl<OrderXsskmxMapper, OrderXsskmx> implements IOrderXsskmxService {

    @Autowired
    private OrderXsskmxMapper orderXsskmxMapper;

    @Override
    public IPage<OrderXsskmx> findOrderXsskmxs(QueryRequest request, OrderXsskmx orderXsskmx) {
        LambdaQueryWrapper<OrderXsskmx> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<OrderXsskmx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<OrderXsskmx> findOrderXsskmxs(OrderXsskmx orderXsskmx) {
	    LambdaQueryWrapper<OrderXsskmx> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createOrderXsskmx(OrderXsskmx orderXsskmx) {
        LambdaQueryWrapper<OrderXsskmx> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
        throw new FebsException("数据已存在，添加失败");
        }
        this.save(orderXsskmx);
    }

    @Override
    @Transactional
    public void updateOrderXsskmx(OrderXsskmx orderXsskmx) {
        LambdaQueryWrapper<OrderXsskmx> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
            throw new FebsException("数据已存在，添加失败");
        }
        this.saveOrUpdate(orderXsskmx);
    }

    @Override
    @Transactional
    public void deleteOrderXsskmx(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
