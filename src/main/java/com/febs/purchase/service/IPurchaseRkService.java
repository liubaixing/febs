package com.febs.purchase.service;

import com.febs.common.entity.QueryRequest;
import com.febs.purchase.entity.PurchaseRk;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 入库单 Service接口
 *
 * @author liubaixing
 * @date 2020-06-27 19:56:08
 */
public interface IPurchaseRkService extends IService<PurchaseRk> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param purchaseRk purchaseRk
     * @return IPage<PurchaseRk>
     */
    IPage<PurchaseRk> findPurchaseRks(QueryRequest request, PurchaseRk purchaseRk);

    /**
     * 查询（所有）
     *
     * @param purchaseRk purchaseRk
     * @return List<PurchaseRk>
     */
    List<PurchaseRk> findPurchaseRks(PurchaseRk purchaseRk);

    /**
     * 新增
     *
     * @param purchaseRk purchaseRk
     */
    Long createPurchaseRk(PurchaseRk purchaseRk);

    /**
     * 修改
     *
     * @param purchaseRk purchaseRk
     */
    void updatePurchaseRk(PurchaseRk purchaseRk);

    /**
     * 删除
     */
    void deletePurchaseRk(String[] ids);
}
