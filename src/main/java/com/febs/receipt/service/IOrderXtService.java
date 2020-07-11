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
    List<OrderXtResp> findOrderXts(OrderXtReq orderXt);

    OrderXtResp findById(Long id);

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
    void updateOrderXt(OrderXt orderXt);

    /**
     * 删除
     */
    void deleteOrderXt(String[] ids);
}
