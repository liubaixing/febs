package com.febs.receipt.service;

import com.febs.common.entity.QueryRequest;
import com.febs.receipt.entity.OrderCkmx;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 出库单明细 Service接口
 *
 * @author liubaixing
 * @date 2020-07-03 22:44:06
 */
public interface IOrderCkmxService extends IService<OrderCkmx> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param orderCkmx orderCkmx
     * @return IPage<OrderCkmx>
     */
    IPage<OrderCkmx> findOrderCkmxs(QueryRequest request, OrderCkmx orderCkmx);

    /**
     * 查询（所有）
     *
     * @param orderCkmx orderCkmx
     * @return List<OrderCkmx>
     */
    List<OrderCkmx> findOrderCkmxs(OrderCkmx orderCkmx);

    /**
     * 新增
     *
     * @param orderCkmx orderCkmx
     */
    void createOrderCkmx(OrderCkmx orderCkmx);

    /**
     * 修改
     *
     * @param orderCkmx orderCkmx
     */
    void updateOrderCkmx(OrderCkmx orderCkmx);

    /**
     * 删除
     */
    void deleteOrderCkmx(String[] ids);
}
