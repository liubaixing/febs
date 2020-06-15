package com.febs.receipt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.common.entity.QueryRequest;
import com.febs.common.enums.DeletedEnum;
import com.febs.common.exception.FebsException;
import com.febs.receipt.entity.OrderXsmx;
import com.febs.receipt.entity.OrderXsmxExample;
import com.febs.receipt.mapper.OrderXsmxMapper;
import com.febs.receipt.service.IOrderXsmxService;
import com.febs.receipt.vo.req.OrderXsmxReq;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 销售单明细 Service实现
 *
 * @author liubaixing
 * @date 2020-06-11 13:59:06
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OrderXsmxServiceImpl extends ServiceImpl<OrderXsmxMapper, OrderXsmx> implements IOrderXsmxService {

    @Autowired
    private OrderXsmxMapper orderXsmxMapper;

    @Override
    public IPage<OrderXsmx> findOrderXsmxs(QueryRequest request, OrderXsmxReq orderXsmx) {
        Page<OrderXsmx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.orderXsmxMapper.selectPageByQuery(page,orderXsmx);
    }

    @Override
    public List<OrderXsmx> findOrderXsmxs(OrderXsmx orderXsmx) {
        OrderXsmxExample example = buildQueryExample(orderXsmx);
		return this.orderXsmxMapper.selectByExample(example);
    }

    @Override
    @Transactional
    public void createOrderXsmx(OrderXsmx orderXsmx) {
        this.orderXsmxMapper.insertSelective(orderXsmx);
    }

    @Override
    @Transactional
    public void updateOrderXsmx(OrderXsmx orderXsmx) {
        LambdaQueryWrapper<OrderXsmx> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        this.orderXsmxMapper.updateByPrimaryKeySelective(orderXsmx);
    }

    @Override
    @Transactional
    public void deleteOrderXsmx(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

    private OrderXsmxExample buildQueryExample(OrderXsmx query) {
        OrderXsmxExample example = new OrderXsmxExample();
        OrderXsmxExample.Criteria criteria = example.createCriteria();
        criteria.andDeletedEqualTo(DeletedEnum.NORMAL.getCode());
        return example;
    }

}
