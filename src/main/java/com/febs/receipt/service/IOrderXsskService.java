package com.febs.receipt.service;

import com.febs.common.entity.QueryRequest;
import com.febs.receipt.entity.OrderXssk;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 销售收款 Service接口
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:18
 */
public interface IOrderXsskService extends IService<OrderXssk> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param orderXssk orderXssk
     * @return IPage<OrderXssk>
     */
    IPage<OrderXssk> findOrderXssks(QueryRequest request, OrderXssk orderXssk);

    /**
     * 查询（所有）
     *
     * @param orderXssk orderXssk
     * @return List<OrderXssk>
     */
    List<OrderXssk> findOrderXssks(OrderXssk orderXssk);

    /**
     * 新增
     *
     * @param orderXssk orderXssk
     */
    void createOrderXssk(OrderXssk orderXssk);

    /**
     * 修改
     *
     * @param orderXssk orderXssk
     */
    void updateOrderXssk(OrderXssk orderXssk);

    /**
     * 删除
     */
    void deleteOrderXssk(String[] ids);
}
