package com.febs.receipt.service.impl;

import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.receipt.entity.OrderXsfpmx;
import com.febs.receipt.mapper.OrderXsfpmxMapper;
import com.febs.receipt.service.IOrderXsfpmxService;
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
 * 销售发票明细 Service实现
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:07
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OrderXsfpmxServiceImpl extends ServiceImpl<OrderXsfpmxMapper, OrderXsfpmx> implements IOrderXsfpmxService {

    @Autowired
    private OrderXsfpmxMapper orderXsfpmxMapper;

    @Override
    public IPage<OrderXsfpmx> findOrderXsfpmxs(QueryRequest request, OrderXsfpmx orderXsfpmx) {
        LambdaQueryWrapper<OrderXsfpmx> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<OrderXsfpmx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<OrderXsfpmx> findOrderXsfpmxs(OrderXsfpmx orderXsfpmx) {
	    LambdaQueryWrapper<OrderXsfpmx> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createOrderXsfpmx(OrderXsfpmx orderXsfpmx) {
        LambdaQueryWrapper<OrderXsfpmx> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
        throw new FebsException("数据已存在，添加失败");
        }
        this.save(orderXsfpmx);
    }

    @Override
    @Transactional
    public void updateOrderXsfpmx(OrderXsfpmx orderXsfpmx) {
        LambdaQueryWrapper<OrderXsfpmx> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
            throw new FebsException("数据已存在，添加失败");
        }
        this.saveOrUpdate(orderXsfpmx);
    }

    @Override
    @Transactional
    public void deleteOrderXsfpmx(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
