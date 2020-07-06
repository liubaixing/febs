package com.febs.receipt.service.impl;

import com.febs.common.constant.OrderConstant;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.DateUtil;
import com.febs.common.utils.StringUtil;
import com.febs.receipt.entity.OrderCk;
import com.febs.receipt.mapper.OrderCkMapper;
import com.febs.receipt.service.IOrderCkService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.receipt.vo.req.OrderCkReq;
import com.febs.receipt.vo.resp.OrderCkResp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 出库单 Service实现
 *
 * @author liubaixing
 * @date 2020-07-03 22:44:01
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OrderCkServiceImpl extends ServiceImpl<OrderCkMapper, OrderCk> implements IOrderCkService {

    @Autowired
    private OrderCkMapper orderCkMapper;

    @Override
    public IPage<OrderCkResp> findOrderCks(QueryRequest request, OrderCkReq orderCk) {
        Page<OrderCk> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.orderCkMapper.selectPageByQuery(page,orderCk);
    }

    @Override
    public List<OrderCk> findOrderCks(OrderCk orderCk) {
	    LambdaQueryWrapper<OrderCk> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public Long createOrderCk(OrderCk orderCk) {
        this.orderCkMapper.insertSelective(orderCk);
        String orderXsNo = OrderConstant.ORDER_CK_PREFIX + DateUtil.getYear() + StringUtil.padStart(orderCk.getId());
        orderCk.setDjbh(orderXsNo);
        this.orderCkMapper.updateByPrimaryKeySelective(orderCk);
        return orderCk.getId();
    }

    @Override
    @Transactional
    public void updateOrderCk(OrderCk orderCk) {
        this.orderCkMapper.updateByPrimaryKeySelective(orderCk);
    }

    @Override
    @Transactional
    public void deleteOrderCk(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
