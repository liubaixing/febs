package com.febs.receipt.service;

import com.febs.common.entity.QueryRequest;
import com.febs.receipt.entity.OrderXtmx;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 销退单明细 Service接口
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:04
 */
public interface IOrderXtmxService extends IService<OrderXtmx> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param orderXtmx orderXtmx
     * @return IPage<OrderXtmx>
     */
    IPage<OrderXtmx> findOrderXtmxs(QueryRequest request, OrderXtmx orderXtmx);

    /**
     * 查询（所有）
     *
     * @param orderXtmx orderXtmx
     * @return List<OrderXtmx>
     */
    List<OrderXtmx> findOrderXtmxs(OrderXtmx orderXtmx);

    /**
     * 新增
     *
     * @param orderXtmx orderXtmx
     */
    void createOrderXtmx(OrderXtmx orderXtmx);

    /**
     * 修改
     *
     * @param orderXtmx orderXtmx
     */
    void updateOrderXtmx(OrderXtmx orderXtmx);

    /**
     * 删除
     */
    void deleteOrderXtmx(String[] ids);
}
