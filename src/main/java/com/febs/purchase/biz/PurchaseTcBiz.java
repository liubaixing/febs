package com.febs.purchase.biz;

import com.febs.common.exception.FebsException;
import com.febs.common.utils.BeanUtils;
import com.febs.purchase.entity.*;
import com.febs.purchase.service.IPurchaseTcService;
import com.febs.purchase.service.IPurchaseTcmxService;
import com.febs.purchase.vo.req.PurchaseTcReq;
import com.febs.purchase.vo.resp.PurchaseTcResp;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

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

    public void update(PurchaseTcReq req){

        PurchaseTcResp resp = tcService.findById(req.getId());

        if (resp == null) {
            throw new FebsException("退仓单不存在");
        }

        //保存商品明细
        if(CollectionUtils.isEmpty(req.getTcmxList())){
            throw new FebsException("销退单明细不能为空");
        }

        List<PurchaseTcmx> tcmxList = req.getTcmxList();

        Integer zsl = tcmxList.stream().mapToInt(PurchaseTcmx::getSl).sum();
        BigDecimal zje = tcmxList.stream().map(PurchaseTcmx::getJe).reduce(BigDecimal.ZERO,BigDecimal::add);

        PurchaseTc tc = BeanUtils.transformFrom(req,PurchaseTc.class);
        tc.setSl(zsl);
        tc.setJe(zje);
        tcService.updatePurchaseTc(tc);

        PurchaseTcmxExample example = new PurchaseTcmxExample();
        example.createCriteria().andPidEqualTo(tc.getId());
        tcmxService.deleteByExample(example);

        for (PurchaseTcmx tcmx : tcmxList){
            tcmx.setPid(tc.getId());
            tcmxService.createPurchaseTcmx(tcmx);
        }
    }

    public void create(PurchaseTcReq req) {

        if (CollectionUtils.isEmpty(req.getTcmxList())) {
            throw new FebsException("未选择采购单");
        }

        List<PurchaseTcmx> tcmxList = req.getTcmxList();

        Integer zsl = tcmxList.stream().mapToInt(PurchaseTcmx::getSl).sum();
        BigDecimal zje = tcmxList.stream().map(PurchaseTcmx::getJe).reduce(BigDecimal.ZERO,BigDecimal::add);

        PurchaseTc tc = BeanUtils.transformFrom(req,PurchaseTc.class);
        tc.setSl(zsl);
        tc.setJe(zje);

        Long pid = tcService.createPurchaseTc(tc);

        for (PurchaseTcmx tcmx : tcmxList){
            tcmx.setPid(pid);
            tcmxService.createPurchaseTcmx(tcmx);
        }

    }
}
