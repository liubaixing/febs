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
import com.febs.receipt.vo.req.OrderXsReq;
import com.febs.receipt.vo.resp.OrderXsResp;
import org.apache.commons.lang3.StringUtils;
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
    public IPage<OrderXsResp> findOrderXss(QueryRequest request, OrderXsReq orderXs) {
        Page<OrderXs> page = new Page<>(request.getPageNum(), request.getPageSize());
        return orderXsMapper.selectPageByQuery(page,orderXs);
    }

    @Override
    public List<OrderXs> findOrderXss(OrderXsReq orderXs) {
        OrderXsExample example = buildQueryExample(orderXs);
		return this.orderXsMapper.selectByExample(example);
    }

    @Override
    @Transactional
    public void createOrderXs(OrderXs orderXs) {
        this.orderXsMapper.insertSelective(orderXs);
    }

    @Override
    @Transactional
    public OrderXsResp updateOrderXs(OrderXs orderXs) {
        OrderXsReq req = new OrderXsReq();
        OrderXsResp resp = this.orderXsMapper.selectOneByQuery(req);
        if(resp == null){
            throw new FebsException("订单不存在");
        }
        if(resp.getQr() == 1 || resp.getSh() == 1){
            throw new FebsException("订单已确定或已审核");
        }
        this.orderXsMapper.updateByPrimaryKeySelective(orderXs);

        return this.orderXsMapper.selectOneByQuery(req);
    }

    @Override
    @Transactional
    public void deleteOrderXs(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

    private OrderXsExample buildQueryExample(OrderXsReq query) {
        OrderXsExample example = new OrderXsExample();
        OrderXsExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(DeletedEnum.NORMAL.getCode());
        if (StringUtils.isNotBlank(query.getDjbh())){
            criteria.andDjbhLike(query.getDjbh());
        }
        if(query.getStartTime()!=null && query.getEndTime()!=null){
            criteria.andXdrqBetween(query.getStartTime(),query.getEndTime());
        }
        if(query.getSctk()!=null){
            criteria.andSctkEqualTo(query.getSctk());
        }
        if(query.getOrgId()!=null){
            criteria.andOrgIdEqualTo(query.getOrgId());
        }
        if(query.getSfjj()!=null){
            criteria.andSfjjEqualTo(query.getSfjj());
        }
        if(query.getQr()!=null){
            criteria.andQrEqualTo(query.getQr());
        }
        if (query.getZx()!=null){
            criteria.andZxEqualTo(query.getZx());
        }
        if (query.getZf()!=null){
            criteria.andZfEqualTo(query.getZf());
        }
        return example;
    }

}
