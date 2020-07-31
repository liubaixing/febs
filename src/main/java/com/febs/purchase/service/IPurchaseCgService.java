package com.febs.purchase.service;

import com.febs.common.entity.QueryRequest;
import com.febs.purchase.entity.PurchaseCg;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.purchase.vo.req.PurchaseCgReq;
import com.febs.purchase.vo.resp.PurchaseCgResp;

import java.util.List;

/**
 * 采购单 Service接口
 *
 * @author liubaixing
 * @date 2020-06-27 19:45:59
 */
public interface IPurchaseCgService extends IService<PurchaseCg> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param purchaseCg purchaseCg
     * @return IPage<PurchaseCg>
     */
    IPage<PurchaseCgResp> findPurchaseCgs(QueryRequest request, PurchaseCgReq purchaseCg);

    /**
     * 查询（所有）
     *
     * @param purchaseCg purchaseCg
     * @return List<PurchaseCg>
     */
    List<PurchaseCgResp> findPurchaseCgs(PurchaseCgReq purchaseCg);

    PurchaseCgResp findById(Long id);

    /**
     * 新增
     *
     * @param purchaseCg purchaseCg
     */
    Long createPurchaseCg(PurchaseCg purchaseCg);

    /**
     * 修改
     *
     * @param purchaseCg purchaseCg
     */
    void updatePurchaseCg(PurchaseCg purchaseCg);

    /**
     * 删除
     */
    void deletePurchaseCg(String[] ids);
}
