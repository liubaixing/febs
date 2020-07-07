package com.febs.purchase.service;

import com.febs.common.entity.QueryRequest;
import com.febs.purchase.entity.PurchaseCgtkmx;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 采购退款明细 Service接口
 *
 * @author liubaixing
 * @date 2020-06-27 19:54:49
 */
public interface IPurchaseCgtkmxService extends IService<PurchaseCgtkmx> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param purchaseCgtkmx purchaseCgtkmx
     * @return IPage<PurchaseCgtkmx>
     */
    IPage<PurchaseCgtkmx> findPurchaseCgtkmxs(QueryRequest request, PurchaseCgtkmx purchaseCgtkmx);

    /**
     * 查询（所有）
     *
     * @param purchaseCgtkmx purchaseCgtkmx
     * @return List<PurchaseCgtkmx>
     */
    List<PurchaseCgtkmx> findPurchaseCgtkmxs(PurchaseCgtkmx purchaseCgtkmx);

    /**
     * 新增
     *
     * @param purchaseCgtkmx purchaseCgtkmx
     */
    Long createPurchaseCgtkmx(PurchaseCgtkmx purchaseCgtkmx);

    /**
     * 修改
     *
     * @param purchaseCgtkmx purchaseCgtkmx
     */
    void updatePurchaseCgtkmx(PurchaseCgtkmx purchaseCgtkmx);

    /**
     * 删除
     */
    void deletePurchaseCgtkmx(String[] ids);
}
