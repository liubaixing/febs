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
        LambdaQueryWrapper<OrderqtYsfdmx> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<OrderqtYsfdmx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<OrderqtYsfdmx> findOrderqtYsfdmxs(OrderqtYsfdmx orderqtYsfdmx) {
	    LambdaQueryWrapper<OrderqtYsfdmx> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createOrderqtYsfdmx(OrderqtYsfdmx orderqtYsfdmx) {
        LambdaQueryWrapper<OrderqtYsfdmx> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
        throw new FebsException("数据已存在，添加失败");
        }
        this.save(orderqtYsfdmx);
    }

    @Override
    @Transactional
    public void updateOrderqtYsfdmx(OrderqtYsfdmx orderqtYsfdmx) {
        LambdaQueryWrapper<OrderqtYsfdmx> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
            throw new FebsException("数据已存在，添加失败");
        }
        this.saveOrUpdate(orderqtYsfdmx);
    }

    @Override
    @Transactional
    public void deleteOrderqtYsfdmx(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
