package com.febs.receipt.service;

import com.febs.common.entity.QueryRequest;
import com.febs.receipt.entity.OrderXstk;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 销售退款 Service接口
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:20
 */
public interface IOrderXstkService extends IService<OrderXstk> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param orderXstk orderXstk
     * @return IPage<OrderXstk>
     */
    IPage<OrderXstk> findOrderXstks(QueryRequest request, OrderXstk orderXstk);

    /**
     * 查询（所有）
     *
     * @param orderXstk orderXstk
     * @return List<OrderXstk>
     */
    List<OrderXstk> findOrderXstks(OrderXstk orderXstk);

    /**
     * 新增
     *
     * @param orderXstk orderXstk
     */
    void createOrderXstk(OrderXstk orderXstk);

    /**
     * 修改
     *
     * @param orderXstk orderXstk
     */
    void updateOrderXstk(OrderXstk orderXstk);

    /**
     * 删除
     */
    void deleteOrderXstk(String[] ids);
}
