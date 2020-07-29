package com.febs.orderqt.service;

import com.febs.common.entity.QueryRequest;
import com.febs.orderqt.entity.OrderqtYfd;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.orderqt.vo.req.YfdReq;
import com.febs.orderqt.vo.resp.YfdResp;

import java.util.List;

/**
 * 运费单 Service接口
 *
 * @author liubaixing
 * @date 2020-07-29 14:14:12
 */
public interface IOrderqtYfdService extends IService<OrderqtYfd> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param req YfdReq
     * @return IPage<OrderqtYfd>
     */
    IPage<YfdResp> findOrderqtYfds(QueryRequest request, YfdReq req);

    /**
     * 查询（所有）
     *
     * @param req YfdReq
     * @return List<OrderqtYfd>
     */
    List<YfdResp> findOrderqtYfds(YfdReq req);

    YfdResp findById(Long id);

    /**
     * 新增
     *
     * @param orderqtYfd orderqtYfd
     */
    void createOrderqtYfd(OrderqtYfd orderqtYfd);

    /**
     * 修改
     *
     * @param orderqtYfd orderqtYfd
     */
    void updateOrderqtYfd(OrderqtYfd orderqtYfd);

    /**
     * 删除
     */
    void deleteOrderqtYfd(String[] ids);
}
