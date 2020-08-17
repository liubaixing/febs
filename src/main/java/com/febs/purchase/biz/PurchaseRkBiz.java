package com.febs.purchase.biz;

import com.febs.common.exception.FebsException;
import com.febs.purchase.entity.PurchaseRk;
import com.febs.purchase.entity.PurchaseRkmx;
import com.febs.purchase.service.IPurchaseRkService;
import com.febs.purchase.service.IPurchaseRkmxService;
import com.febs.purchase.vo.resp.PurchaseRkResp;
import com.febs.receipt.service.IOrderXsService;
import com.febs.receipt.service.IOrderXtService;
import com.febs.receipt.vo.req.OrderXtReq;
import com.febs.receipt.vo.resp.OrderXtResp;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class PurchaseRkBiz {

    @Autowired
    private IPurchaseRkService rkService;

    @Autowired
    private IPurchaseRkmxService rkmxService;

    @Autowired
    private IOrderXtService xtService;

    public PurchaseRkResp view(Long id){

        PurchaseRkResp rkResp = rkService.findById(id);
        if (rkResp == null) {
            throw new FebsException("入库单不存在");
        }

        PurchaseRkmx purchaseRkmx = new PurchaseRkmx();
        rkResp.setRkmxlist(rkmxService.findPurchaseRkmxs(purchaseRkmx));

        return rkResp;
    }

    public void updateByPrimaryKey(PurchaseRk purchaseRk){
        PurchaseRkResp rkResp = rkService.findById(purchaseRk.getId());
        if (rkResp == null) {
            throw new FebsException("入库单不存在");
        }
        rkService.updatePurchaseRk(purchaseRk);
    }

    public void shrk(PurchaseRk purchaseRk){
        PurchaseRkResp rkResp = rkService.findById(purchaseRk.getId());
        if (rkResp == null) {
            throw new FebsException("入库单不存在");
        }

        OrderXtReq orderXt = new OrderXtReq();
        orderXt.setDjbh(rkResp.getYdbh());
        List<OrderXtResp> xtList = xtService.findOrderXts(orderXt);
        if (CollectionUtils.isEmpty(xtList)) {
            throw new FebsException("销退单不存在");
        }

        purchaseRk.setShrk((byte)1);
        purchaseRk.setShrkrq(new Date());
        rkService.updatePurchaseRk(purchaseRk);
    }

}