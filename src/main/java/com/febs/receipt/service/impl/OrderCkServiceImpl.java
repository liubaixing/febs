package com.febs.receipt.service.impl;

import com.febs.common.constant.OrderConstant;
import com.febs.common.entity.QueryRequest;
import com.febs.common.entity.excel.CkExcel;
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
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.Collection;
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

    @Resource
    private OrderCkMapper orderCkMapper;

    @Override
    public IPage<OrderCkResp> findOrderCks(QueryRequest request, OrderCkReq orderCk) {
        Page<OrderCk> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.orderCkMapper.selectPageByQuery(page,orderCk);
    }

    @Override
    public List<OrderCkResp> findOrderCks(OrderCkReq orderCk) {
		return this.orderCkMapper.selectByQuery(orderCk);
    }

    @Override
    public OrderCkResp findById(Long id) {
        OrderCkReq orderCk = new OrderCkReq();
        orderCk.setId(id);
        List<OrderCkResp> orderCkList = findOrderCks(orderCk);
        return CollectionUtils.isEmpty(orderCkList) ? null : orderCkList.get(0);
    }

    @Override
    @Transactional
    public Long createOrderCk(OrderCk orderCk) {
        this.orderCkMapper.insertSelective(orderCk);

        String orderXsNo = "";
        if (StringUtils.isEmpty(orderCk.getDjbh())){
            orderXsNo = OrderConstant.ORDER_CK_PREFIX + DateUtil.getYear() + StringUtil.padStart(orderCk.getId());
        }else{
            orderXsNo = orderCk.getDjbh() + DateUtil.getYear() + StringUtil.padStart(orderCk.getId());
        }
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

    @Override
    public List<CkExcel> upload(List<CkExcel> data) {

        data.stream().forEach(one->{
            System.out.println(one);
        });
        return null;
    }
}
