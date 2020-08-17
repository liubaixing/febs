package com.febs.purchase.service;

import com.febs.common.entity.QueryRequest;
import com.febs.purchase.entity.PurchaseCgmx;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.purchase.entity.PurchaseCgmxExample;
import com.febs.purchase.vo.resp.PurchaseCgmxResp;

import java.util.List;

/**
 * 采购单明细 Service接口
 *
 * @author liubaixing
 * @date 2020-06-27 19:46:14
 */
public interface IPurchaseCgmxService extends IService<PurchaseCgmx> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param purchaseCgmx purchaseCgmx
     * @return IPage<PurchaseCgmx>
     */
    IPage<PurchaseCgmxResp> findPurchaseCgmxs(QueryRequest request, PurchaseCgmx purchaseCgmx);

    /**
     * 查询（所有）
     *
     * @param purchaseCgmx purchaseCgmx
     * @return List<PurchaseCgmx>
     */
    List<PurchaseCgmxResp> findPurchaseCgmxs(PurchaseCgmx purchaseCgmx);

    PurchaseCgmxResp findById(Long id);

    /**
     * 新增
     *
     * @param purchaseCgmx purchaseCgmx
     */
    Long createPurchaseCgmx(PurchaseCgmx purchaseCgmx);

    /**
     * 修改
     *
     * @param purchaseCgmx purchaseCgmx
     */
    void updatePurchaseCgmx(PurchaseCgmx purchaseCgmx);

    void updateByExample(PurchaseCgmx record, PurchaseCgmxExample example);

    /**
     * 删除
     */
    void deletePurchaseCgmx(String[] ids);
}
