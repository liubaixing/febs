package com.febs.orderqt.service;

import com.febs.common.entity.QueryRequest;
import com.febs.orderqt.entity.OrderqtYfdmx;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.orderqt.entity.OrderqtYfdmxExample;

import java.util.List;

/**
 * 运费单明细 Service接口
 *
 * @author liubaixing
 * @date 2020-07-29 14:14:20
 */
public interface IOrderqtYfdmxService extends IService<OrderqtYfdmx> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param orderqtYfdmx orderqtYfdmx
     * @return IPage<OrderqtYfdmx>
     */
    IPage<OrderqtYfdmx> findOrderqtYfdmxs(QueryRequest request, OrderqtYfdmx orderqtYfdmx);

    /**
     * 查询（所有）
     *
     * @param orderqtYfdmx orderqtYfdmx
     * @return List<OrderqtYfdmx>
     */
    List<OrderqtYfdmx> findOrderqtYfdmxs(OrderqtYfdmx orderqtYfdmx);

    /**
     * 新增
     *
     * @param orderqtYfdmx orderqtYfdmx
     */
    void createOrderqtYfdmx(OrderqtYfdmx orderqtYfdmx);

    /**
     * 修改
     *
     * @param orderqtYfdmx orderqtYfdmx
     */
    void updateOrderqtYfdmx(OrderqtYfdmx orderqtYfdmx);

    /**
     * 删除
     */
    void deleteOrderqtYfdmx(String[] ids);

    void deleteByExample(OrderqtYfdmxExample example);
}
