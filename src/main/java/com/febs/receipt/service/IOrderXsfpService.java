package com.febs.receipt.service;

import com.febs.common.entity.QueryRequest;
import com.febs.receipt.entity.OrderXsfp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 销售发票 Service接口
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:16
 */
public interface IOrderXsfpService extends IService<OrderXsfp> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param orderXsfp orderXsfp
     * @return IPage<OrderXsfp>
     */
    IPage<OrderXsfp> findOrderXsfps(QueryRequest request, OrderXsfp orderXsfp);

    /**
     * 查询（所有）
     *
     * @param orderXsfp orderXsfp
     * @return List<OrderXsfp>
     */
    List<OrderXsfp> findOrderXsfps(OrderXsfp orderXsfp);

    /**
     * 新增
     *
     * @param orderXsfp orderXsfp
     */
    void createOrderXsfp(OrderXsfp orderXsfp);

    /**
     * 修改
     *
     * @param orderXsfp orderXsfp
     */
    void updateOrderXsfp(OrderXsfp orderXsfp);

    /**
     * 删除
     */
    void deleteOrderXsfp(String[] ids);
}
