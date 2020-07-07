package com.febs.purchase.biz;

import com.febs.common.enums.DeletedEnum;
import com.febs.purchase.entity.PurchaseCg;
import com.febs.purchase.service.IPurchaseCgService;
import com.febs.purchase.service.IPurchaseCgmxService;
import com.febs.receipt.entity.OrderXstk;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PurchaseCgBiz {

    @Autowired
    private IPurchaseCgService cgService;

    @Autowired
    private IPurchaseCgmxService cgmxService;


    public void update(PurchaseCg cg){
        cgService.updatePurchaseCg(cg);
    }

}
