package com.febs.receipt.service;

import com.febs.common.entity.QueryRequest;
import com.febs.receipt.entity.OrderXt;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.receipt.vo.req.OrderXtReq;
import com.febs.receipt.vo.resp.OrderXtResp;

import java.util.List;

/**
 * 销退单 Service接口
 *
 * @author liubaixing
 * @date 2020-06-11 11:46:11
 */
public interface IOrderXtService extends IService<OrderXt> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param orderXt orderXt
     * @return IPage<OrderXt>
     */
    IPage<OrderXtResp> findOrderXts(QueryRequest request, OrderXtReq orderXt);

    /**
     * 查询（所有）
     *
     * @param orderXt orderXt
     * @return List<OrderXt>
     */
    List<OrderXt> findOrderXts(OrderXtReq orderXt);

    OrderXt findById(Long id);

    /**
     * 新增
     *
     * @param orderXt orderXt
     */
    Long createOrderXt(OrderXt orderXt);

    /**
     * 修改
     *
     * @param orderXt orderXt
     */
    OrderXtResp updateOrderXt(OrderXt orderXt);

    /**
     * 删除
     */
    void deleteOrderXt(String[] ids);
}
