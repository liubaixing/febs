package com.febs.purchase.service;

import com.febs.common.entity.QueryRequest;
import com.febs.purchase.entity.PurchaseTc;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.purchase.entity.PurchaseTcExample;
import com.febs.purchase.vo.req.PurchaseTcReq;
import com.febs.purchase.vo.resp.PurchaseTcResp;

import java.util.List;

/**
 * 退仓单 Service接口
 *
 * @author liubaixing
 * @date 2020-06-27 19:55:32
 */
public interface IPurchaseTcService extends IService<PurchaseTc> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param purchaseTc purchaseTc
     * @return IPage<PurchaseTc>
     */
    IPage<PurchaseTcResp> findPurchaseTcs(QueryRequest request, PurchaseTcReq purchaseTc);

    /**
     * 查询（所有）
     *
     * @param purchaseTc purchaseTc
     * @return List<PurchaseTc>
     */
    List<PurchaseTcResp> findPurchaseTcs(PurchaseTcReq purchaseTc);

    PurchaseTcResp findById(Long id);

    /**
     * 新增
     *
     * @param purchaseTc purchaseTc
     */
    Long createPurchaseTc(PurchaseTc purchaseTc);

    /**
     * 修改
     *
     * @param purchaseTc purchaseTc
     */
    void updatePurchaseTc(PurchaseTc purchaseTc);

    /**
     * 删除
     */
    void deletePurchaseTc(String[] ids);

    void deleteByExample(PurchaseTcExample example);
}
