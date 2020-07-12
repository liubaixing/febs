package com.febs.purchase.service;

import com.febs.common.entity.QueryRequest;
import com.febs.purchase.entity.PurchaseCgfp;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.purchase.vo.req.PurchaseCgfpReq;
import com.febs.purchase.vo.resp.PurchaseCgfpResp;

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
    IPage<PurchaseCgfpResp> findPurchaseCgfps(QueryRequest request, PurchaseCgfpReq purchaseCgfp);

    /**
     * 查询（所有）
     *
     * @param purchaseCgfp purchaseCgfp
     * @return List<PurchaseCgfp>
     */
    List<PurchaseCgfpResp> findPurchaseCgfps(PurchaseCgfpReq purchaseCgfp);


    PurchaseCgfpResp findById(Long id);

    /**
     * 新增
     *
     * @param purchaseCgfp purchaseCgfp
     */
    Long createPurchaseCgfp(PurchaseCgfp purchaseCgfp);

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
