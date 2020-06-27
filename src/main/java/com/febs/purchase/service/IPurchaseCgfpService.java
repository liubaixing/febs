package com.febs.purchase.service;

import com.febs.common.entity.QueryRequest;
import com.febs.purchase.entity.PurchaseCgfp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 采购发票 Service接口
 *
 * @author liubaixing
 * @date 2020-06-27 19:55:27
 */
public interface IPurchaseCgfpService extends IService<PurchaseCgfp> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param purchaseCgfp purchaseCgfp
     * @return IPage<PurchaseCgfp>
     */
    IPage<PurchaseCgfp> findPurchaseCgfps(QueryRequest request, PurchaseCgfp purchaseCgfp);

    /**
     * 查询（所有）
     *
     * @param purchaseCgfp purchaseCgfp
     * @return List<PurchaseCgfp>
     */
    List<PurchaseCgfp> findPurchaseCgfps(PurchaseCgfp purchaseCgfp);

    /**
     * 新增
     *
     * @param purchaseCgfp purchaseCgfp
     */
    void createPurchaseCgfp(PurchaseCgfp purchaseCgfp);

    /**
     * 修改
     *
     * @param purchaseCgfp purchaseCgfp
     */
    void updatePurchaseCgfp(PurchaseCgfp purchaseCgfp);

    /**
     * 删除
     */
    void deletePurchaseCgfp(String[] ids);
}
