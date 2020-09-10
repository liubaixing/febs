package com.febs.purchase.biz;

import com.febs.common.exception.FebsException;
import com.febs.common.utils.BeanUtils;
import com.febs.purchase.entity.*;
import com.febs.purchase.mapper.PurchaseCgMapper;
import com.febs.purchase.mapper.PurchaseCgmxMapper;
import com.febs.purchase.service.IPurchaseCgService;
import com.febs.purchase.service.IPurchaseCgmxService;
import com.febs.purchase.service.IPurchaseTcService;
import com.febs.purchase.service.IPurchaseTcmxService;
import com.febs.purchase.vo.req.PurchaseCgReq;
import com.febs.purchase.vo.resp.PurchaseCgResp;
import com.febs.purchase.vo.resp.PurchaseCgmxResp;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseCgBiz {

    @Autowired
    private IPurchaseCgService cgService;

    @Autowired
    private IPurchaseCgmxService cgmxService;

    @Autowired
    private IPurchaseTcService tcService;
    @Autowired
    private IPurchaseTcmxService tcmxService;

    @Resource
    private PurchaseCgMapper cgMapper;
    @Resource
    private PurchaseCgmxMapper cgmxMapper;

    public PurchaseCgResp view(Long id){
        PurchaseCgResp cgResp = cgService.findById(id);
        PurchaseCgmx purchaseCgmx = new PurchaseCgmx();
        purchaseCgmx.setPid(cgResp.getId());
        List<PurchaseCgmxResp> cgmxList = cgmxService.findPurchaseCgmxs(purchaseCgmx);
        cgResp.setCgmxList(cgmxList);
        return cgResp;
    }

    public void update(PurchaseCg cg){
        cgService.updatePurchaseCg(cg);
    }

    public void sctc(PurchaseCgReq req){
        PurchaseCgResp cgResp = cgService.findById(req.getId());
        PurchaseCgmxResp cgmxResp = cgmxService.findById(req.getMxId());
        if(cgResp == null) throw new FebsException("采购单不存在");
        if (cgmxResp == null) throw new FebsException("采购详情单不存在");

        if(req.getTkje().add(cgResp.getTkje()).compareTo(cgResp.getJe()) == 1)throw new FebsException("退仓金额不能大于采购金额！");
        if(req.getTkje().add(cgmxResp.getTkje()).compareTo(cgmxResp.getJe()) == 1)throw new FebsException("退仓金额不能大于采购金额！");

        PurchaseCg purchaseCg = new PurchaseCg();
        purchaseCg.setId(req.getId());
        purchaseCg.setTksl(req.getTksl() + cgResp.getTksl());
        purchaseCg.setTkje(req.getTkje().add(cgResp.getTkje()));
        purchaseCg.setSctc((byte)1);
        purchaseCg.setSctcr(req.getSctcr());
        purchaseCg.setSctcrq(new Date());
        cgService.updatePurchaseCg(purchaseCg);

        PurchaseCgmx purchaseCgmx = new PurchaseCgmx();
        purchaseCgmx.setId(req.getMxId());
        purchaseCgmx.setTksl(req.getTksl() + cgmxResp.getTksl());
        purchaseCgmx.setTkje(req.getTkje().add(cgmxResp.getTkje()));
        cgmxService.updatePurchaseCgmx(purchaseCgmx);

        PurchaseTc tc = new PurchaseTc();
        tc.setXdrq(new Date());
        tc.setXtdh(cgResp.getDjbh());
        tc.setUserId(cgResp.getUserId());
        tc.setBmId(cgResp.getBmId());
        tc.setGysId(cgResp.getGysId());
        tc.setCangkuId(cgResp.getCangkuId());
        tc.setFplxId(cgResp.getFplxId());
        tc.setFpslId(cgResp.getFpslId());
        tc.setDjlxId(cgResp.getDjlxId());
        tc.setCgfzr(cgResp.getCgfzr());
        tc.setXdfzr(cgResp.getXdfzr());
        tc.setSl(req.getTksl());
        tc.setJe(req.getTkje());
        tc.setZdr(req.getSctcr());
        tc.setZdrq(new Date());
        Long tcId = tcService.createPurchaseTc(tc);
        PurchaseTcmx tcmx = new PurchaseTcmx();
        tcmx.setPid(tcId);
        tcmx.setSl(req.getTksl());
        tcmx.setJe(req.getTkje());
        tcmx.setDj(cgmxResp.getDj());
        tcmxService.createPurchaseTcmx(tcmx);
    }

    public void create(PurchaseCgReq req) {

        if (CollectionUtils.isEmpty(req.getCgmxList())) {
            throw new FebsException("未选择采购单");
        }

        List<PurchaseCgmx> cgmxList = req.getCgmxList();

        Integer zsl = cgmxList.stream().mapToInt(PurchaseCgmx::getSl).sum();
        BigDecimal zje = cgmxList.stream().map(PurchaseCgmx::getJe).reduce(BigDecimal.ZERO,BigDecimal::add);

        PurchaseCg cg = BeanUtils.transformFrom(req,PurchaseCg.class);
        cg.setSl(zsl);
        cg.setJe(zje);

        Long pid = cgService.createPurchaseCg(cg);

        for (PurchaseCgmx cgmx : cgmxList){
            cgmx.setPid(pid);
            cgmxService.createPurchaseCgmx(cgmx);
        }
    }

    public void update(PurchaseCgReq req){

        PurchaseCgResp resp = cgService.findById(req.getId());

        if (resp == null) {
            throw new FebsException("采购但不存在");
        }

        if (CollectionUtils.isEmpty(req.getCgmxList())) {
            throw new FebsException("未选择采购单明细");
        }

        List<PurchaseCgmx> cgmxList = req.getCgmxList();

        Integer zsl = cgmxList.stream().mapToInt(PurchaseCgmx::getSl).sum();
        BigDecimal zje = cgmxList.stream().map(PurchaseCgmx::getJe).reduce(BigDecimal.ZERO,BigDecimal::add);

        PurchaseCg cg = BeanUtils.transformFrom(req,PurchaseCg.class);
        cg.setSl(zsl);
        cg.setJe(zje);
        cgService.updatePurchaseCg(cg);

        PurchaseCgmxExample cgmxExample = new PurchaseCgmxExample();
        cgmxExample.createCriteria().andPidEqualTo(req.getId());
        cgmxMapper.deleteByExample(cgmxExample);

        for (PurchaseCgmx cgmx : cgmxList){
            cgmx.setPid(req.getId());
            cgmxService.createPurchaseCgmx(cgmx);
        }

    }

}
