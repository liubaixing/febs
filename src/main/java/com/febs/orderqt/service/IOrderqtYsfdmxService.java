package com.febs.orderqt.service;

import com.febs.common.entity.QueryRequest;
import com.febs.orderqt.entity.OrderqtYsfdmx;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 印刷费单明细 Service接口
 *
 * @author liubaixing
 * @date 2020-07-29 14:14:26
 */
public interface IOrderqtYsfdmxService extends IService<OrderqtYsfdmx> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param orderqtYsfdmx orderqtYsfdmx
     * @return IPage<OrderqtYsfdmx>
     */
    IPage<OrderqtYsfdmx> findOrderqtYsfdmxs(QueryRequest request, OrderqtYsfdmx orderqtYsfdmx);

    /**
     * 查询（所有）
     *
     * @param orderqtYsfdmx orderqtYsfdmx
     * @return List<OrderqtYsfdmx>
     */
    List<OrderqtYsfdmx> findOrderqtYsfdmxs(OrderqtYsfdmx orderqtYsfdmx);

    /**
     * 新增
     *
     * @param orderqtYsfdmx orderqtYsfdmx
     */
    void createOrderqtYsfdmx(OrderqtYsfdmx orderqtYsfdmx);

    /**
     * 修改
     *
     * @param orderqtYsfdmx orderqtYsfdmx
     */
    void updateOrderqtYsfdmx(OrderqtYsfdmx orderqtYsfdmx);

    /**
     * 删除
     */
    void deleteOrderqtYsfdmx(String[] ids);
}
