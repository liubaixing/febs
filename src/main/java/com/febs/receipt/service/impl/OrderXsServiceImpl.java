package com.febs.receipt.service.impl;

import com.febs.common.entity.QueryRequest;
import com.febs.common.enums.DeletedEnum;
import com.febs.common.exception.FebsException;
import com.febs.receipt.entity.OrderXs;
import com.febs.receipt.entity.OrderXsExample;
import com.febs.receipt.mapper.OrderXsMapper;
import com.febs.receipt.service.IOrderXsService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 销售单 Service实现
 *
 * @author liubaixing
 * @date 2020-06-11 11:36:56
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OrderXsServiceImpl extends ServiceImpl<OrderXsMapper, OrderXs> implements IOrderXsService {

    @Autowired
    private OrderXsMapper orderXsMapper;

    @Override
    public IPage<OrderXs> findOrderXss(QueryRequest request, OrderXs orderXs) {
        Page<OrderXs> page = new Page<>(request.getPageNum(), request.getPageSize());
        OrderXsExample example = buildQueryExample(orderXs);
        return orderXsMapper.selectPageByExample(page,example);
    }

    @Override
    public List<OrderXs> findOrderXss(OrderXs orderXs) {
        OrderXsExample example = buildQueryExample(orderXs);
		return this.orderXsMapper.selectByExample(example);
    }

    @Override
    @Transactional
    public void createOrderXs(OrderXs orderXs) {
        LambdaQueryWrapper<OrderXs> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);

        this.orderXsMapper.insertSelective(orderXs);
    }

    @Override
    @Transactional
    public void updateOrderXs(OrderXs orderXs) {
        LambdaQueryWrapper<OrderXs> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
            throw new FebsException("数据已存在，添加失败");
        }
        this.orderXsMapper.updateByPrimaryKeySelective(orderXs);
    }

    @Override
    @Transactional
    public void deleteOrderXs(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

    private OrderXsExample buildQueryExample(OrderXs query) {
        OrderXsExample example = new OrderXsExample();
        OrderXsExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(DeletedEnum.NORMAL.getCode());
        return example;
    }

}
