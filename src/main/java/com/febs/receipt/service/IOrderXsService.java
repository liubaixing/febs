package com.febs.receipt.service;

import com.febs.common.entity.QueryRequest;
import com.febs.receipt.entity.OrderXs;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.receipt.entity.OrderXsExample;

import java.util.List;

/**
 * 销售单 Service接口
 *
 * @author liubaixing
 * @date 2020-06-11 11:36:56
 */
public interface IOrderXsService extends IService<OrderXs> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param orderXs orderXs
     * @return IPage<OrderXs>
     */
    IPage<OrderXs> findOrderXss(QueryRequest request, OrderXs orderXs);

    /**
     * 查询（所有）
     *
     * @param orderXs orderXs
     * @return List<OrderXs>
     */
    List<OrderXs> findOrderXss(OrderXs orderXs);

    /**
     * 新增
     *
     * @param orderXs orderXs
     */
    void createOrderXs(OrderXs orderXs);

    /**
     * 修改
     *
     * @param orderXs orderXs
     */
    void updateOrderXs(OrderXs orderXs);

    /**
     * 删除
     */
    void deleteOrderXs(String[] ids);
}
