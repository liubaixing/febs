package com.febs.purchase.service;

import com.febs.common.entity.QueryRequest;
import com.febs.purchase.entity.PurchaseTcmx;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.purchase.entity.PurchaseTcmxExample;
import com.febs.purchase.vo.resp.PurchaseTcmxResp;

import java.util.List;

/**
 * 退仓单明细 Service接口
 *
 * @author liubaixing
 * @date 2020-06-27 19:55:35
 */
public interface IPurchaseTcmxService extends IService<PurchaseTcmx> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param purchaseTcmx purchaseTcmx
     * @return IPage<PurchaseTcmx>
     */
    IPage<PurchaseTcmxResp> findPurchaseTcmxs(QueryRequest request, PurchaseTcmx purchaseTcmx);

    /**
     * 查询（所有）
     *
     * @param purchaseTcmx purchaseTcmx
     * @return List<PurchaseTcmx>
     */
    List<PurchaseTcmxResp> findPurchaseTcmxs(PurchaseTcmx purchaseTcmx);

    /**
     * 新增
     *
     * @param purchaseTcmx purchaseTcmx
     */
    Long createPurchaseTcmx(PurchaseTcmx purchaseTcmx);

    /**
     * 修改
     *
     * @param purchaseTcmx purchaseTcmx
     */
    void updatePurchaseTcmx(PurchaseTcmx purchaseTcmx);

    /**
     * 删除
     */
    void deletePurchaseTcmx(String[] ids);

    void deleteByExample(PurchaseTcmxExample example);
}
