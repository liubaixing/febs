package com.febs.receipt.service;

import com.febs.common.entity.QueryRequest;
import com.febs.receipt.entity.OrderXsfpmx;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 销售发票明细 Service接口
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:07
 */
public interface IOrderXsfpmxService extends IService<OrderXsfpmx> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param orderXsfpmx orderXsfpmx
     * @return IPage<OrderXsfpmx>
     */
    IPage<OrderXsfpmx> findOrderXsfpmxs(QueryRequest request, OrderXsfpmx orderXsfpmx);

    /**
     * 查询（所有）
     *
     * @param orderXsfpmx orderXsfpmx
     * @return List<OrderXsfpmx>
     */
    List<OrderXsfpmx> findOrderXsfpmxs(OrderXsfpmx orderXsfpmx);

    /**
     * 新增
     *
     * @param orderXsfpmx orderXsfpmx
     */
    void createOrderXsfpmx(OrderXsfpmx orderXsfpmx);

    /**
     * 修改
     *
     * @param orderXsfpmx orderXsfpmx
     */
    void updateOrderXsfpmx(OrderXsfpmx orderXsfpmx);

    /**
     * 删除
     */
    void deleteOrderXsfpmx(String[] ids);
}
