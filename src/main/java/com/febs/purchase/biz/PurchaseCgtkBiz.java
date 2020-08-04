package com.febs.purchase.biz;

import com.febs.common.exception.FebsException;
import com.febs.purchase.entity.PurchaseCgtk;
import com.febs.purchase.entity.PurchaseCgtkExample;
import com.febs.purchase.entity.PurchaseCgtkmx;
import com.febs.purchase.entity.PurchaseTcmx;
import com.febs.purchase.service.IPurchaseCgtkService;
import com.febs.purchase.service.IPurchaseCgtkmxService;
import com.febs.purchase.service.IPurchaseTcService;
import com.febs.purchase.service.IPurchaseTcmxService;
import com.febs.purchase.vo.req.CgtkCreateReq;
import com.febs.purchase.vo.req.PurchaseCgfpReq;
import com.febs.purchase.vo.req.PurchaseCgtkReq;
import com.febs.purchase.vo.req.PurchaseTcReq;
import com.febs.purchase.vo.resp.PurchaseCgtkResp;
import com.febs.purchase.vo.resp.PurchaseTcResp;
import com.febs.system.entity.User;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseCgtkBiz {

    @Autowired
    private IPurchaseCgtkService cgtkService;

    @Autowired
    private IPurchaseCgtkmxService cgtkmxService;

    @Autowired
    private IPurchaseTcService tcService;
    @Autowired
    private IPurchaseTcmxService tcmxService;


    public PurchaseCgtkResp view(Long id) {
        PurchaseCgtkResp cgtkResp = cgtkService.findById(id);
        PurchaseCgtkmx purchaseCgtkmx = new PurchaseCgtkmx();
        purchaseCgtkmx.setPid(cgtkResp.getId());
        cgtkResp.setCgtkmxList(cgtkmxService.findPurchaseCgtkmxs(purchaseCgtkmx));
        return cgtkResp;
    }

    public void kssc(CgtkCreateReq req, User user) {

        if (CollectionUtils.isEmpty(req.getCgtkList())) {
            throw new FebsException("未勾选单据");
        }

        List<PurchaseCgtkReq> cgtkList = req.getCgtkList();

        BigDecimal zje = cgtkList.stream().map(PurchaseCgtkReq::getJe).reduce(BigDecimal.ZERO,BigDecimal::add);

        PurchaseCgtk cgtk = new PurchaseCgtk();
        cgtk.setDjrq(new Date());
        cgtk.setGysId(req.getGysId());
        cgtk.setJe(zje);
        cgtk.setBz(req.getBz());
        cgtk.setZdr(user.getUsername());
        cgtk.setZdrq(new Date());
        Long pid = cgtkService.createPurchaseCgtk(cgtk);

        cgtkList.stream().forEach(one->{
            PurchaseCgtkmx cgtkmx = new PurchaseCgtkmx();
            cgtkmx.setPid(pid);
            cgtkmx.setYdjh(one.getYdjh());
            cgtkmx.setSpId(one.getSpId());
            cgtkmx.setSl(one.getSl());
            cgtkmx.setJe(one.getJe());
            cgtkmxService.createPurchaseCgtkmx(cgtkmx);

            PurchaseTcReq tc = new PurchaseTcReq();
            tc.setDjbh(one.getYdjh());
            PurchaseTcResp tcResp = tcService.findPurchaseTcs(tc).get(0);
            if (tcResp == null) throw new FebsException("退仓单不存在");

            PurchaseTcmx tcmx = new PurchaseTcmx();
            tcmx.setPid(tcResp.getId());
            tcmx.setSpId(one.getSpId());
            tcmx = tcmxService.findPurchaseTcmxs(tcmx).get(0);
            if (tcmx == null) throw new FebsException("退仓单不存在");
            if (tcmx.getKpsl() + one.getSl() > tcmx.getSl())
                throw new FebsException("开票数量大于运费单数量");

            tcmx.setKpsl(tcmx.getKpsl() + one.getSl());
            tcmx.setKpje(tcmx.getKpje().add(one.getJe()));
            tcmxService.updatePurchaseTcmx(tcmx);

            tcResp.setKpsl(tcResp.getKpsl()+ one.getSl());
            tcResp.setKpje(tcResp.getKpje().add(one.getJe()));
            tcService.updatePurchaseTc(tcResp);

        });

    }

    public void tk(String djbh, User user) {
        PurchaseCgtk record = new PurchaseCgtk();
        record.setTk((byte)1);
        record.setTkr(user.getUsername());
        record.setTkrq(new Date());

        PurchaseCgtkExample example = new PurchaseCgtkExample();
        example.createCriteria().andDjbhEqualTo(djbh);
        cgtkService.updateByExample(record,example);
    }
}
