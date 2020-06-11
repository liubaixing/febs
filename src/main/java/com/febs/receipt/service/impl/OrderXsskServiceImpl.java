package com.febs.receipt.service.impl;

import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.receipt.entity.OrderXssk;
import com.febs.receipt.mapper.OrderXsskMapper;
import com.febs.receipt.service.IOrderXsskService;
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
 * 销售收款 Service实现
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:18
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OrderXsskServiceImpl extends ServiceImpl<OrderXsskMapper, OrderXssk> implements IOrderXsskService {

    @Autowired
    private OrderXsskMapper orderXsskMapper;

    @Override
    public IPage<OrderXssk> findOrderXssks(QueryRequest request, OrderXssk orderXssk) {
        LambdaQueryWrapper<OrderXssk> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<OrderXssk> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<OrderXssk> findOrderXssks(OrderXssk orderXssk) {
	    LambdaQueryWrapper<OrderXssk> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createOrderXssk(OrderXssk orderXssk) {
        LambdaQueryWrapper<OrderXssk> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
        throw new FebsException("数据已存在，添加失败");
        }
        this.save(orderXssk);
    }

    @Override
    @Transactional
    public void updateOrderXssk(OrderXssk orderXssk) {
        LambdaQueryWrapper<OrderXssk> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
            throw new FebsException("数据已存在，添加失败");
        }
        this.saveOrUpdate(orderXssk);
    }

    @Override
    @Transactional
    public void deleteOrderXssk(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
