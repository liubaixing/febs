package com.febs.receipt.service.impl;

import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.receipt.entity.OrderXt;
import com.febs.receipt.mapper.OrderXtMapper;
import com.febs.receipt.service.IOrderXtService;
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
 * 销退单 Service实现
 *
 * @author liubaixing
 * @date 2020-06-11 11:46:11
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OrderXtServiceImpl extends ServiceImpl<OrderXtMapper, OrderXt> implements IOrderXtService {

    @Autowired
    private OrderXtMapper orderXtMapper;

    @Override
    public IPage<OrderXt> findOrderXts(QueryRequest request, OrderXt orderXt) {
        LambdaQueryWrapper<OrderXt> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<OrderXt> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<OrderXt> findOrderXts(OrderXt orderXt) {
	    LambdaQueryWrapper<OrderXt> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createOrderXt(OrderXt orderXt) {
        LambdaQueryWrapper<OrderXt> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
        throw new FebsException("数据已存在，添加失败");
        }
        this.save(orderXt);
    }

    @Override
    @Transactional
    public void updateOrderXt(OrderXt orderXt) {
        LambdaQueryWrapper<OrderXt> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
            throw new FebsException("数据已存在，添加失败");
        }
        this.saveOrUpdate(orderXt);
    }

    @Override
    @Transactional
    public void deleteOrderXt(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
