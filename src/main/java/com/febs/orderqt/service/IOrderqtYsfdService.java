package com.febs.orderqt.service;

import com.febs.common.entity.QueryRequest;
import com.febs.orderqt.entity.OrderqtYsfd;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.orderqt.vo.req.YsfdReq;
import com.febs.orderqt.vo.resp.YsfdResp;

import java.util.List;

/**
 * 印刷费单 Service接口
 *
 * @author liubaixing
 * @date 2020-07-29 14:14:23
 */
public interface IOrderqtYsfdService extends IService<OrderqtYsfd> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param req YsfdReq
     * @return IPage<OrderqtYsfd>
     */
    IPage<YsfdResp> findOrderqtYsfds(QueryRequest request, YsfdReq req);

    /**
     * 查询（所有）
     *
     * @param req YsfdReq
     * @return List<OrderqtYsfd>
     */
    List<YsfdResp> findOrderqtYsfds(YsfdReq req);

    YsfdResp findById(Long id);

    /**
     * 新增
     *
     * @param orderqtYsfd orderqtYsfd
     */
    Long createOrderqtYsfd(OrderqtYsfd orderqtYsfd);

    /**
     * 修改
     *
     * @param orderqtYsfd orderqtYsfd
     */
    void updateOrderqtYsfd(OrderqtYsfd orderqtYsfd);

    /**
     * 删除
     */
    void deleteOrderqtYsfd(String[] ids);
}
