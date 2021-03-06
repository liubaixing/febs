package com.febs.purchase.service;

import com.febs.common.entity.QueryRequest;
import com.febs.purchase.entity.PurchaseCgtk;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.purchase.entity.PurchaseCgtkExample;
import com.febs.purchase.vo.req.PurchaseCgtkReq;
import com.febs.purchase.vo.resp.PurchaseCgtkResp;

import java.util.List;

/**
 * 采购退款 Service接口
 *
 * @author liubaixing
 * @date 2020-06-27 19:54:56
 */
public interface IPurchaseCgtkService extends IService<PurchaseCgtk> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param purchaseCgtk purchaseCgtk
     * @return IPage<PurchaseCgtk>
     */
    IPage<PurchaseCgtkResp> findPurchaseCgtks(QueryRequest request, PurchaseCgtkReq purchaseCgtk);

    /**
     * 查询（所有）
     *
     * @param purchaseCgtk purchaseCgtk
     * @return List<PurchaseCgtk>
     */
    List<PurchaseCgtkResp> findPurchaseCgtks(PurchaseCgtkReq purchaseCgtk);

    PurchaseCgtkResp findById(Long id);

    /**
     * 新增
     *
     * @param purchaseCgtk purchaseCgtk
     */
    Long createPurchaseCgtk(PurchaseCgtk purchaseCgtk);

    /**
     * 修改
     *
     * @param purchaseCgtk purchaseCgtk
     */
    void updatePurchaseCgtk(PurchaseCgtk purchaseCgtk);

    void updateByExample(PurchaseCgtk record, PurchaseCgtkExample example);

    /**
     * 删除
     */
    void deletePurchaseCgtk(String[] ids);
}
