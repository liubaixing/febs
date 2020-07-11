package com.febs.purchase.biz;

import com.febs.purchase.entity.PurchaseTcmx;
import com.febs.purchase.service.IPurchaseTcService;
import com.febs.purchase.service.IPurchaseTcmxService;
import com.febs.purchase.vo.resp.PurchaseTcResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseTcBiz {

    @Autowired
    private IPurchaseTcService tcService;

    @Autowired
    private IPurchaseTcmxService tcmxService;

    public PurchaseTcResp view(Long id){
        PurchaseTcResp tcResp = tcService.findById(id);
        PurchaseTcmx purchaseTcmx = new PurchaseTcmx();
        purchaseTcmx.setPid(tcResp.getId());
        tcResp.setTcmxList(tcmxService.findPurchaseTcmxs(purchaseTcmx));
        return tcResp;
    }

}
