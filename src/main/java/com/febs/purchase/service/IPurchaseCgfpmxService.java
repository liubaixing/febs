package com.febs.purchase.service;

import com.febs.common.entity.QueryRequest;
import com.febs.purchase.entity.PurchaseCgfpmx;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 采购发票明细 Service接口
 *
 * @author liubaixing
 * @date 2020-06-27 19:55:24
 */
public interface IPurchaseCgfpmxService extends IService<PurchaseCgfpmx> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param purchaseCgfpmx purchaseCgfpmx
     * @return IPage<PurchaseCgfpmx>
     */
    IPage<PurchaseCgfpmx> findPurchaseCgfpmxs(QueryRequest request, PurchaseCgfpmx purchaseCgfpmx);

    /**
     * 查询（所有）
     *
     * @param purchaseCgfpmx purchaseCgfpmx
     * @return List<PurchaseCgfpmx>
     */
    List<PurchaseCgfpmx> findPurchaseCgfpmxs(PurchaseCgfpmx purchaseCgfpmx);

    /**
     * 新增
     *
     * @param purchaseCgfpmx purchaseCgfpmx
     */
    void createPurchaseCgfpmx(PurchaseCgfpmx purchaseCgfpmx);

    /**
     * 修改
     *
     * @param purchaseCgfpmx purchaseCgfpmx
     */
    void updatePurchaseCgfpmx(PurchaseCgfpmx purchaseCgfpmx);

    /**
     * 删除
     */
    void deletePurchaseCgfpmx(String[] ids);
}
