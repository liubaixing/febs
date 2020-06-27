package com.febs.purchase.service;

import com.febs.common.entity.QueryRequest;
import com.febs.purchase.entity.PurchaseCgfkmx;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 采购付款明细 Service接口
 *
 * @author liubaixing
 * @date 2020-06-27 20:02:41
 */
public interface IPurchaseCgfkmxService extends IService<PurchaseCgfkmx> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param purchaseCgfkmx purchaseCgfkmx
     * @return IPage<PurchaseCgfkmx>
     */
    IPage<PurchaseCgfkmx> findPurchaseCgfkmxs(QueryRequest request, PurchaseCgfkmx purchaseCgfkmx);

    /**
     * 查询（所有）
     *
     * @param purchaseCgfkmx purchaseCgfkmx
     * @return List<PurchaseCgfkmx>
     */
    List<PurchaseCgfkmx> findPurchaseCgfkmxs(PurchaseCgfkmx purchaseCgfkmx);

    /**
     * 新增
     *
     * @param purchaseCgfkmx purchaseCgfkmx
     */
    void createPurchaseCgfkmx(PurchaseCgfkmx purchaseCgfkmx);

    /**
     * 修改
     *
     * @param purchaseCgfkmx purchaseCgfkmx
     */
    void updatePurchaseCgfkmx(PurchaseCgfkmx purchaseCgfkmx);

    /**
     * 删除
     */
    void deletePurchaseCgfkmx(String[] ids);
}
