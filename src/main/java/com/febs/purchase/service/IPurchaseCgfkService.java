package com.febs.purchase.service;

import com.febs.common.entity.QueryRequest;
import com.febs.purchase.entity.PurchaseCgfk;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 采购付款 Service接口
 *
 * @author liubaixing
 * @date 2020-06-27 19:46:20
 */
public interface IPurchaseCgfkService extends IService<PurchaseCgfk> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param purchaseCgfk purchaseCgfk
     * @return IPage<PurchaseCgfk>
     */
    IPage<PurchaseCgfk> findPurchaseCgfks(QueryRequest request, PurchaseCgfk purchaseCgfk);

    /**
     * 查询（所有）
     *
     * @param purchaseCgfk purchaseCgfk
     * @return List<PurchaseCgfk>
     */
    List<PurchaseCgfk> findPurchaseCgfks(PurchaseCgfk purchaseCgfk);

    /**
     * 新增
     *
     * @param purchaseCgfk purchaseCgfk
     */
    void createPurchaseCgfk(PurchaseCgfk purchaseCgfk);

    /**
     * 修改
     *
     * @param purchaseCgfk purchaseCgfk
     */
    void updatePurchaseCgfk(PurchaseCgfk purchaseCgfk);

    /**
     * 删除
     */
    void deletePurchaseCgfk(String[] ids);
}
