package com.febs.receipt.service;

import com.febs.common.entity.QueryRequest;
import com.febs.receipt.entity.OrderXsmx;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.receipt.vo.req.OrderXsmxReq;

import java.util.List;

/**
 * 销售单明细 Service接口
 *
 * @author liubaixing
 * @date 2020-06-11 13:59:06
 */
public interface IOrderXsmxService extends IService<OrderXsmx> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param orderXsmx orderXsmx
     * @return IPage<OrderXsmx>
     */
    IPage<OrderXsmx> findOrderXsmxs(QueryRequest request, OrderXsmxReq orderXsmx);

    /**
     * 查询（所有）
     *
     * @param orderXsmx orderXsmx
     * @return List<OrderXsmx>
     */
    List<OrderXsmx> findOrderXsmxs(OrderXsmx orderXsmx);

    /**
     * 新增
     *
     * @param orderXsmx orderXsmx
     */
    void createOrderXsmx(OrderXsmx orderXsmx);

    /**
     * 修改
     *
     * @param orderXsmx orderXsmx
     */
    void updateOrderXsmx(OrderXsmx orderXsmx);

    /**
     * 删除
     */
    void deleteOrderXsmx(String[] ids);
}
