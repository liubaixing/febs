package com.febs.receipt.service;

import com.febs.common.entity.QueryRequest;
import com.febs.receipt.entity.OrderXstk;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.receipt.entity.OrderXstkExample;
import com.febs.receipt.vo.req.OrderXstkReq;
import com.febs.receipt.vo.resp.OrderXstkResp;

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
    IPage<OrderXstkResp> findOrderXstks(QueryRequest request, OrderXstkReq orderXstk);

    /**
     * 查询（所有）
     *
     * @param orderXstk orderXstk
     * @return List<OrderXstk>
     */
    List<OrderXstkResp> findOrderXstks(OrderXstkReq orderXstk);

    OrderXstkResp findById(Long id);

    /**
     * 新增
     *
     * @param orderXstk orderXstk
     */
    Long createOrderXstk(OrderXstk orderXstk);

    /**
     * 修改
     *
     * @param orderXstk orderXstk
     */
    void updateOrderXstk(OrderXstk orderXstk);

    void updateByExample(OrderXstk orderXstk,OrderXstkExample example);

    /**
     * 删除
     */
    void deleteOrderXstk(String[] ids);
}
