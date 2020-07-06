package com.febs.receipt.service;

import com.febs.common.entity.QueryRequest;
import com.febs.receipt.entity.OrderCk;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.receipt.vo.req.OrderCkReq;
import com.febs.receipt.vo.resp.OrderCkResp;

import java.util.List;

/**
 * 出库单 Service接口
 *
 * @author liubaixing
 * @date 2020-07-03 22:44:01
 */
public interface IOrderCkService extends IService<OrderCk> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param orderCk orderCk
     * @return IPage<OrderCk>
     */
    IPage<OrderCkResp> findOrderCks(QueryRequest request, OrderCkReq orderCk);

    /**
     * 查询（所有）
     *
     * @param orderCk orderCk
     * @return List<OrderCk>
     */
    List<OrderCk> findOrderCks(OrderCk orderCk);

    /**
     * 新增
     *
     * @param orderCk orderCk
     */
    Long createOrderCk(OrderCk orderCk);

    /**
     * 修改
     *
     * @param orderCk orderCk
     */
    void updateOrderCk(OrderCk orderCk);

    /**
     * 删除
     */
    void deleteOrderCk(String[] ids);
}
