package com.febs.purchase.service;

import com.febs.common.entity.QueryRequest;
import com.febs.purchase.entity.PurchaseRkmx;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 入库单明细 Service接口
 *
 * @author liubaixing
 * @date 2020-06-27 19:56:10
 */
public interface IPurchaseRkmxService extends IService<PurchaseRkmx> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param purchaseRkmx purchaseRkmx
     * @return IPage<PurchaseRkmx>
     */
    IPage<PurchaseRkmx> findPurchaseRkmxs(QueryRequest request, PurchaseRkmx purchaseRkmx);

    /**
     * 查询（所有）
     *
     * @param purchaseRkmx purchaseRkmx
     * @return List<PurchaseRkmx>
     */
    List<PurchaseRkmx> findPurchaseRkmxs(PurchaseRkmx purchaseRkmx);

    /**
     * 新增
     *
     * @param purchaseRkmx purchaseRkmx
     */
    Long createPurchaseRkmx(PurchaseRkmx purchaseRkmx);

    /**
     * 修改
     *
     * @param purchaseRkmx purchaseRkmx
     */
    void updatePurchaseRkmx(PurchaseRkmx purchaseRkmx);

    /**
     * 删除
     */
    void deletePurchaseRkmx(String[] ids);
}
