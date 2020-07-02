package com.febs.receipt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.common.constant.OrderConstant;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.DateUtil;
import com.febs.common.utils.StringUtil;
import com.febs.receipt.entity.OrderXsfp;
import com.febs.receipt.mapper.OrderXsfpMapper;
import com.febs.receipt.service.IOrderXsfpService;
import com.febs.receipt.vo.req.OrderXsfpReq;
import com.febs.receipt.vo.resp.OrderXsfpResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 销售发票 Service实现
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:16
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OrderXsfpServiceImpl extends ServiceImpl<OrderXsfpMapper, OrderXsfp> implements IOrderXsfpService {

    @Autowired
    private OrderXsfpMapper orderXsfpMapper;

    @Override
    public IPage<OrderXsfpResp> findOrderXsfps(QueryRequest request, OrderXsfpReq orderXsfp) {
        Page<OrderXsfp> page = new Page<>(request.getPageNum(), request.getPageSize());
        return orderXsfpMapper.selectPageByQuery(page,orderXsfp);
    }

    @Override
    public List<OrderXsfp> findOrderXsfps(OrderXsfp orderXsfp) {
	    LambdaQueryWrapper<OrderXsfp> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public Long createOrderXsfp(OrderXsfp orderXsfp) {
        this.orderXsfpMapper.insertSelective(orderXsfp);
        String orderXsNo = OrderConstant.ORDER_FP_PREFIX + DateUtil.getYear() + StringUtil.padStart(orderXsfp.getId());
        orderXsfp.setDjbh(orderXsNo);
        orderXsfpMapper.updateByPrimaryKeySelective(orderXsfp);
        return orderXsfp.getId();
    }

    @Override
    @Transactional
    public void updateOrderXsfp(OrderXsfp orderXsfp) {
        this.orderXsfpMapper.updateByPrimaryKeySelective(orderXsfp);
    }

    @Override
    @Transactional
    public void deleteOrderXsfp(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
