package com.febs.purchase.biz;

import com.febs.purchase.entity.PurchaseCgfk;
import com.febs.purchase.entity.PurchaseCgfkmx;
import com.febs.purchase.service.IPurchaseCgfkService;
import com.febs.purchase.service.IPurchaseCgfkmxService;
import com.febs.purchase.vo.resp.PurchaseCgfkResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseCgfkBiz {

    @Autowired
    private IPurchaseCgfkService cgfkService;

    @Autowired
    private IPurchaseCgfkmxService cgfkmxService;

    public PurchaseCgfkResp view(Long id){
        PurchaseCgfkResp cgfkResp = cgfkService.findById(id);
        PurchaseCgfkmx purchaseCgfkmx = new PurchaseCgfkmx();
        purchaseCgfkmx.setPid(cgfkResp.getId());
        cgfkResp.setCgfkmxList(cgfkmxService.findPurchaseCgfkmxs(purchaseCgfkmx));
        return  cgfkResp;
    }

}
