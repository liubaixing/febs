package com.febs.purchase.biz;

import com.febs.purchase.entity.PurchaseCgfpmx;
import com.febs.purchase.service.IPurchaseCgfpService;
import com.febs.purchase.service.IPurchaseCgfpmxService;
import com.febs.purchase.vo.resp.PurchaseCgfpResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseCgfpBiz {

    @Autowired
    private IPurchaseCgfpService cgfpService;

    @Autowired
    private IPurchaseCgfpmxService cgfpmxService;


    public PurchaseCgfpResp view(Long id) {
        PurchaseCgfpResp cgfpResp = cgfpService.findById(id);
        PurchaseCgfpmx cgfpmx = new PurchaseCgfpmx();
        cgfpmx.setPid(cgfpResp.getId());
        cgfpResp.setCgfpmxListl(cgfpmxService.findPurchaseCgfpmxs(cgfpmx));
        return cgfpResp;
    }
}
