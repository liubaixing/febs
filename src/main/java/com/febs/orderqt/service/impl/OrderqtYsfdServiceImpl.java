package com.febs.orderqt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.orderqt.entity.OrderqtYsfd;
import com.febs.orderqt.mapper.OrderqtYsfdMapper;
import com.febs.orderqt.service.IOrderqtYsfdService;
import com.febs.orderqt.vo.req.YsfdReq;
import com.febs.orderqt.vo.resp.YsfdResp;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 印刷费单 Service实现
 *
 * @author liubaixing
 * @date 2020-07-29 14:14:23
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OrderqtYsfdServiceImpl extends ServiceImpl<OrderqtYsfdMapper, OrderqtYsfd> implements IOrderqtYsfdService {

    @Autowired
    private OrderqtYsfdMapper orderqtYsfdMapper;

    @Override
    public IPage<YsfdResp> findOrderqtYsfds(QueryRequest request, YsfdReq req) {
        Page<OrderqtYsfd> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.orderqtYsfdMapper.selectPageByQuery(page, req);
    }

    @Override
    public List<YsfdResp> findOrderqtYsfds(YsfdReq req) {
		return this.orderqtYsfdMapper.selectByQuery(req);
    }

    @Override
    public YsfdResp findById(Long id){
        YsfdReq req = new YsfdReq();
        req.setId(id);
        List<YsfdResp> ysfdList = findOrderqtYsfds(req);
        return CollectionUtils.isEmpty(ysfdList) ? null : ysfdList.get(0);
    }

    @Override
    @Transactional
    public void createOrderqtYsfd(OrderqtYsfd orderqtYsfd) {
        this.orderqtYsfdMapper.insertSelective(orderqtYsfd);
    }

    @Override
    @Transactional
    public void updateOrderqtYsfd(OrderqtYsfd orderqtYsfd) {
        this.orderqtYsfdMapper.updateByPrimaryKeySelective(orderqtYsfd);
    }

    @Override
    @Transactional
    public void deleteOrderqtYsfd(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}