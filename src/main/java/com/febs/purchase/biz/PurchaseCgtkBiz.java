package com.febs.purchase.biz;

import com.febs.purchase.entity.PurchaseCgtkmx;
import com.febs.purchase.service.IPurchaseCgtkService;
import com.febs.purchase.service.IPurchaseCgtkmxService;
import com.febs.purchase.vo.req.CgtkCreateReq;
import com.febs.purchase.vo.resp.PurchaseCgtkResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseCgtkBiz {

    @Autowired
    private IPurchaseCgtkService cgtkService;

    @Autowired
    private IPurchaseCgtkmxService cgtkmxService;

    public PurchaseCgtkResp view(Long id) {
        PurchaseCgtkResp cgtkResp = cgtkService.findById(id);
        PurchaseCgtkmx purchaseCgtkmx = new PurchaseCgtkmx();
        purchaseCgtkmx.setPid(cgtkResp.getId());
        cgtkResp.setCgtkmxList(cgtkmxService.findPurchaseCgtkmxs(purchaseCgtkmx));
        return cgtkResp;
    }

    public void kssc(CgtkCreateReq req) {

    }
}
