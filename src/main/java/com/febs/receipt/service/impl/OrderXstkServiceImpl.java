package com.febs.receipt.service.impl;

import com.febs.common.constant.OrderConstant;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.DateUtil;
import com.febs.common.utils.StringUtil;
import com.febs.receipt.entity.OrderXstk;
import com.febs.receipt.mapper.OrderXstkMapper;
import com.febs.receipt.service.IOrderXstkService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.receipt.vo.req.OrderXstkReq;
import com.febs.receipt.vo.resp.OrderXstkResp;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 销售退款 Service实现
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:20
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OrderXstkServiceImpl extends ServiceImpl<OrderXstkMapper, OrderXstk> implements IOrderXstkService {

    @Autowired
    private OrderXstkMapper orderXstkMapper;

    @Override
    public IPage<OrderXstkResp> findOrderXstks(QueryRequest request, OrderXstkReq orderXstk) {
        Page<OrderXstk> page = new Page<>(request.getPageNum(), request.getPageSize());
        return orderXstkMapper.selectPageByQuery(page,orderXstk);
    }

    @Override
    public List<OrderXstkResp> findOrderXstks(OrderXstkReq orderXstk) {
		return this.orderXstkMapper.selectByQuery(orderXstk);
    }

    @Override
    public OrderXstkResp findById(Long id) {
        OrderXstkReq orderXstk = new OrderXstkReq();
        orderXstk.setId(id);
        List<OrderXstkResp> xstkList = findOrderXstks(orderXstk);
        return CollectionUtils.isEmpty(xstkList) ? null : xstkList.get(0);
    }

    @Override
    @Transactional
    public Long createOrderXstk(OrderXstk orderXstk) {
        this.orderXstkMapper.insertSelective(orderXstk);
        String orderXsNo = OrderConstant.ORDER_TK_PREFIX + DateUtil.getYear() + StringUtil.padStart(orderXstk.getId());
        orderXstk.setDjbh(orderXsNo);
        orderXstkMapper.updateByPrimaryKeySelective(orderXstk);
        return orderXstk.getId();
    }

    @Override
    @Transactional
    public void updateOrderXstk(OrderXstk orderXstk) {
        this.orderXstkMapper.updateByPrimaryKeySelective(orderXstk);
    }

    @Override
    @Transactional
    public void deleteOrderXstk(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
