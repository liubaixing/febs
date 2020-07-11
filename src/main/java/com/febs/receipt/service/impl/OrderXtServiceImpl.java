package com.febs.receipt.service.impl;

import com.febs.common.constant.OrderConstant;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.DateUtil;
import com.febs.common.utils.StringUtil;
import com.febs.receipt.entity.OrderXt;
import com.febs.receipt.mapper.OrderXtMapper;
import com.febs.receipt.service.IOrderXtService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.receipt.vo.req.OrderXtReq;
import com.febs.receipt.vo.resp.OrderXtResp;
import org.apache.commons.collections4.CollectionUtils;
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
    public IPage<OrderXtResp> findOrderXts(QueryRequest request, OrderXtReq orderXt) {
        Page<OrderXt> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.orderXtMapper.selectPageByQuery(page,orderXt);
    }

    @Override
    public List<OrderXtResp> findOrderXts(OrderXtReq orderXt) {
		return this.orderXtMapper.selectByQuery(orderXt);
    }

    @Override
    public OrderXtResp findById(Long id){
        OrderXtReq orderXt = new OrderXtReq();
        orderXt.setId(id);
        List<OrderXtResp> orderXtList = findOrderXts(orderXt);
        return CollectionUtils.isEmpty(orderXtList) ? null : orderXtList.get(0);
    }

    @Override
    @Transactional
    public Long createOrderXt(OrderXt orderXt) {
        this.orderXtMapper.insertSelective(orderXt);
        String orderXtNo = OrderConstant.ORDER_XT_PREFIX + DateUtil.getYear() + StringUtil.padStart(orderXt.getId());
        orderXt.setDjbh(orderXtNo);
        this.orderXtMapper.updateByPrimaryKeySelective(orderXt);
        return orderXt.getId();
    }

    @Override
    @Transactional
    public void updateOrderXt(OrderXt orderXt) {
        this.orderXtMapper.updateByPrimaryKeySelective(orderXt);
    }

    @Override
    @Transactional
    public void deleteOrderXt(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
