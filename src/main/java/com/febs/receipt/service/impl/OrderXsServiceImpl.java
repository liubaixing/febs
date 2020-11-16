package com.febs.receipt.service.impl;

import com.febs.common.constant.OrderConstant;
import com.febs.common.entity.QueryRequest;
import com.febs.common.entity.excel.OrderXsExcelModel;
import com.febs.common.enums.DeletedEnum;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.BeanUtils;
import com.febs.common.utils.DateUtil;
import com.febs.common.utils.StringUtil;
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
import java.util.stream.Collectors;

/**
 * 销售单 Service实现
 *
 * @author liubaixing
 * @date 2020-06-11 11:36:56
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OrderXsServiceImpl extends ServiceImpl<OrderXsMapper, OrderXs> implements IOrderXsService {

    @Resource
    private OrderXsMapper orderXsMapper;

    @Override
    public IPage<OrderXsResp> findOrderXss(QueryRequest request, OrderXsReq orderXs) {
        Page<OrderXs> page = new Page<>(request.getPageNum(), request.getPageSize());
        return orderXsMapper.selectPageByQuery(page,orderXs);
    }

    @Override
    public List<OrderXsResp> findOrderXss(OrderXsReq orderXs) {
		return this.orderXsMapper.selectByQuery(orderXs);
    }

    @Override
    public OrderXs findOrderXs(OrderXsExample example){
        List<OrderXs> orderXs = this.orderXsMapper.selectByExample(example);
        return CollectionUtils.isNotEmpty(orderXs) ? orderXs.get(0) : null;
    }

    public OrderXsResp selectOneByQuery(OrderXsReq req){
        return this.orderXsMapper.selectOneByQuery(req);
    }

    @Override
    public OrderXsResp findOrderXsDetail(OrderXsReq req) {
        return this.orderXsMapper.selectOneByQuery(req);
    }

    @Override
    public List<OrderXs> selectByExample(OrderXsExample example) {
        return this.orderXsMapper.selectByExample(example);
    }

    @Override
    public OrderXs findById(Long id){
        return this.orderXsMapper.selectByPrimaryKey(id);
    }

    @Override
    @Transactional
    public Long createOrderXs(OrderXs orderXs) {
        this.orderXsMapper.insertSelective(orderXs);
        orderXsMapper.updateByPrimaryKeySelective(orderXs);
        return orderXs.getId();
    }

    @Override
    @Transactional
    public OrderXsResp updateOrderXs(OrderXs orderXs) {
        OrderXs order = this.orderXsMapper.selectByPrimaryKey(orderXs.getId());
        if(order == null){
            throw new FebsException("订单不存在");
        }
        this.orderXsMapper.updateByPrimaryKeySelective(orderXs);
        OrderXsReq req = new OrderXsReq();
        req.setId(orderXs.getId());
        return findOrderXss(req).get(0);
    }

    @Override
    @Transactional
    public void updateByExample(OrderXs orderXs,OrderXsExample example) {
        this.orderXsMapper.updateByExampleSelective(orderXs,example);
    }

    @Override
    @Transactional
    public void deleteOrderXs(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

    @Override
    @Transactional
	public void deleteByPrimaryKey(Long id){
        orderXsMapper.deleteByPrimaryKey(id);
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

    @Override
    public List<OrderXsExcelModel> upload(Collection<OrderXsExcelModel> list) {

//        List<OrderXsExcelModel> date = Arrays.asList((OrderXsExcelModel[])list.toArray());

        return null;
    }
}
