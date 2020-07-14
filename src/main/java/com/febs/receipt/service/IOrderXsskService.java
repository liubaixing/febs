package com.febs.receipt.service;

import com.febs.common.entity.QueryRequest;
import com.febs.receipt.entity.OrderXssk;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.receipt.entity.OrderXsskExample;
import com.febs.receipt.vo.req.OrderXsskReq;
import com.febs.receipt.vo.resp.OrderXsskResp;

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
    IPage<OrderXsskResp> findOrderXssks(QueryRequest request, OrderXsskReq orderXssk);

    /**
     * 查询（所有）
     *
     * @param orderXssk orderXssk
     * @return List<OrderXssk>
     */
    List<OrderXsskResp> findOrderXssks(OrderXsskReq orderXssk);

    OrderXsskResp findById(Long id);

    /**
     * 新增
     *
     * @param orderXssk orderXssk
     */
    Long createOrderXssk(OrderXssk orderXssk);

    /**
     * 修改
     *
     * @param orderXssk orderXssk
     */
    void updateOrderXssk(OrderXssk orderXssk);

    void updateByExample(OrderXssk orderXssk, OrderXsskExample example);

    /**
     * 删除
     */
    void deleteOrderXssk(String[] ids);
}
