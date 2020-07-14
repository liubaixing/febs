package com.febs.receipt.service.impl;

import com.febs.common.constant.OrderConstant;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.DateUtil;
import com.febs.common.utils.StringUtil;
import com.febs.receipt.entity.OrderXsfp;
import com.febs.receipt.entity.OrderXssk;
import com.febs.receipt.entity.OrderXsskExample;
import com.febs.receipt.mapper.OrderXsskMapper;
import com.febs.receipt.service.IOrderXsskService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.receipt.vo.req.OrderXsskReq;
import com.febs.receipt.vo.resp.OrderXsskResp;
import org.apache.commons.collections4.CollectionUtils;
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
    public IPage<OrderXsskResp> findOrderXssks(QueryRequest request, OrderXsskReq orderXssk) {
        Page<OrderXssk> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.orderXsskMapper.selectPageByQuery(page,orderXssk);
    }

    @Override
    public List<OrderXsskResp> findOrderXssks(OrderXsskReq orderXssk) {
		return this.orderXsskMapper.selectByQuery(orderXssk);
    }

    @Override
    public OrderXsskResp findById(Long id) {
        OrderXsskReq orderXssk = new OrderXsskReq();
        orderXssk.setId(id);
        List<OrderXsskResp> xsskList = findOrderXssks(orderXssk);
        return CollectionUtils.isEmpty(xsskList) ? null : xsskList.get(0);
    }

    @Override
    @Transactional
    public Long createOrderXssk(OrderXssk orderXssk) {
        this.orderXsskMapper.insertSelective(orderXssk);
        String orderXsNo = OrderConstant.ORDER_SK_PREFIX + DateUtil.getYear() + StringUtil.padStart(orderXssk.getId());
        orderXssk.setDjbh(orderXsNo);
        orderXsskMapper.updateByPrimaryKeySelective(orderXssk);
        return orderXssk.getId();
    }

    @Override
    @Transactional
    public void updateOrderXssk(OrderXssk orderXssk) {
        this.orderXsskMapper.updateByPrimaryKeySelective(orderXssk);
    }

    @Override
    @Transactional
    public void updateByExample(OrderXssk orderXssk,OrderXsskExample example) {
        this.orderXsskMapper.updateByExampleSelective(orderXssk,example);
    }

    @Override
    @Transactional
    public void deleteOrderXssk(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
