package com.febs.purchase.biz;

import com.febs.common.exception.FebsException;
import com.febs.orderqt.entity.OrderqtYfdmx;
import com.febs.orderqt.entity.OrderqtYsfdmx;
import com.febs.orderqt.service.IOrderqtYfdService;
import com.febs.orderqt.service.IOrderqtYfdmxService;
import com.febs.orderqt.service.IOrderqtYsfdService;
import com.febs.orderqt.service.IOrderqtYsfdmxService;
import com.febs.orderqt.vo.req.YfdReq;
import com.febs.orderqt.vo.req.YsfdReq;
import com.febs.orderqt.vo.resp.YfdResp;
import com.febs.orderqt.vo.resp.YsfdResp;
import com.febs.purchase.entity.*;
import com.febs.purchase.service.*;
import com.febs.purchase.vo.req.*;
import com.febs.purchase.vo.resp.PurchaseCgResp;
import com.febs.purchase.vo.resp.PurchaseCgfpResp;
import com.febs.purchase.vo.resp.PurchaseTcResp;
import com.febs.purchase.vo.resp.PurchaseTcmxResp;
import com.febs.system.entity.User;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseCgfpBiz {

    @Autowired
    private IPurchaseCgfpService cgfpService;

    @Autowired
    private IPurchaseCgfpmxService cgfpmxService;


    @Autowired
    private IPurchaseCgService cgService;
    @Autowired
    private IPurchaseCgmxService cgmxService;
    @Autowired
    private IPurchaseTcService tcService;
    @Autowired
    private IPurchaseTcmxService tcmxService;
    @Autowired
    private IOrderqtYfdService yfdService;
    @Autowired
    private IOrderqtYfdmxService yfdmxService;
    @Autowired
    private IOrderqtYsfdService ysfdService;
    @Autowired
    private IOrderqtYsfdmxService ysfdmxService;

    public PurchaseCgfpResp view(Long id) {
        PurchaseCgfpResp cgfpResp = cgfpService.findById(id);
        PurchaseCgfpmx cgfpmx = new PurchaseCgfpmx();
        cgfpmx.setPid(cgfpResp.getId());
        cgfpResp.setCgfpmxListl(cgfpmxService.findPurchaseCgfpmxs(cgfpmx));
        return cgfpResp;
    }

    @Transactional
    public void kssc(CgfpCreateReq req, User user) {

        if (CollectionUtils.isEmpty(req.getCgfpList())) {
            throw new FebsException("未勾选单据");
        }

        List<PurchaseCgfpReq> cgfpList = req.getCgfpList();

        BigDecimal zje = cgfpList.stream().map(PurchaseCgfpReq::getJe).reduce(BigDecimal.ZERO,BigDecimal::add);

        PurchaseCgfp cgfp = new PurchaseCgfp();

        cgfp.setDjrq(new Date());
        cgfp.setGysId(req.getGysId());
        cgfp.setJe(zje);
        cgfp.setBz(req.getBz());
        cgfp.setZdr(user.getUsername());
        cgfp.setZdrq(new Date());
        Long pid = cgfpService.createPurchaseCgfp(cgfp);

        cgfpList.stream().forEach(one->{
            PurchaseCgfpmx cgfpmx = new PurchaseCgfpmx();
            cgfpmx.setPid(pid);
            cgfpmx.setYdjh(one.getYdjh());
            cgfpmx.setSpId(one.getSpId());
            cgfpmx.setSl(one.getSl());
            cgfpmx.setJe(one.getJe());
            cgfpmxService.createPurchaseCgfpmx(cgfpmx);

            if ("cg".equals(one.getOrderType())) {
                //采购
                PurchaseCgReq purchaseCgReq = new PurchaseCgReq();
                purchaseCgReq.setDjbh(one.getYdjh());
                PurchaseCgResp purchaseCgResp = cgService.findPurchaseCgs(purchaseCgReq).get(0);
                if (purchaseCgResp == null) throw new FebsException("采购单不存在");

                PurchaseCgmx purchaseCgmx = new PurchaseCgmx();
                purchaseCgmx.setPid(purchaseCgResp.getId());
                purchaseCgmx.setSpId(one.getSpId());
                purchaseCgmx = cgmxService.findPurchaseCgmxs(purchaseCgmx).get(0);
                if (purchaseCgmx == null) throw new FebsException("采购单不存在");
                if (purchaseCgmx.getKpsl() + one.getSl() > purchaseCgmx.getSl())
                    throw new FebsException("开票数量大于采购单数量");

                purchaseCgmx.setKpsl(purchaseCgmx.getKpsl() + one.getSl());
                purchaseCgmx.setKpje(purchaseCgmx.getKpje().add(one.getJe()));
                cgmxService.updatePurchaseCgmx(purchaseCgmx);

                purchaseCgResp.setKpsl(purchaseCgResp.getKpsl()+ one.getSl());
                purchaseCgResp.setKpje(purchaseCgResp.getKpje().add(one.getJe()));
                cgService.updatePurchaseCg(purchaseCgResp);


            } else if ("tc".equals(one.getOrderType())) {
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
            } else if ("yf".equals(one.getOrderType())) {
                YfdReq yfdReq = new YfdReq();
                yfdReq.setDjbh(one.getYdjh());
                YfdResp yfdResp = yfdService.findOrderqtYfds(yfdReq).get(0);
                if (yfdResp == null) throw new FebsException("运费单不存在");

                OrderqtYfdmx orderqtYfdmx = new OrderqtYfdmx();
                orderqtYfdmx.setPid(yfdResp.getId());
                orderqtYfdmx.setSpId(one.getSpId());
                orderqtYfdmx = yfdmxService.findOrderqtYfdmxs(orderqtYfdmx).get(0);
                if (orderqtYfdmx == null) throw new FebsException("运费单不存在");
                if (orderqtYfdmx.getKpsl() + one.getSl() > orderqtYfdmx.getSl())
                    throw new FebsException("开票数量大于运费单数量");

                orderqtYfdmx.setKpsl(orderqtYfdmx.getKpsl() + one.getSl());
                orderqtYfdmx.setKpje(orderqtYfdmx.getKpje().add(one.getJe()));
                yfdmxService.updateOrderqtYfdmx(orderqtYfdmx);


            } else if ("ys".equals(one.getOrderType())) {

                YsfdReq ysfdReq = new YsfdReq();
                ysfdReq.setDjbh(one.getYdjh());
                YsfdResp ysfdResp = ysfdService.findOrderqtYsfds(ysfdReq).get(0);
                if (ysfdResp == null)
                    throw new FebsException("印刷费单不存在");

                OrderqtYsfdmx ysfdmx = new OrderqtYsfdmx();
                ysfdmx.setPid(ysfdReq.getId());
                ysfdmx.setSpId(one.getSpId());
                ysfdmx = ysfdmxService.findOrderqtYsfdmxs(ysfdmx).get(0);
                if (ysfdmx == null) throw new FebsException("印刷费单不存在");
                if (ysfdmx.getKpsl() + one.getSl() > ysfdmx.getSl())
                    throw new FebsException("开票数量大于印刷费单数量");

                ysfdmx.setKpsl(ysfdmx.getKpsl() + one.getSl());
                ysfdmx.setKpje(ysfdmx.getKpje().add(one.getJe()));
                ysfdmxService.updateOrderqtYsfdmx(ysfdmx);

            }
        });
    }

    public void kp(String djbh, User user) {

        PurchaseCgfp record = new PurchaseCgfp();
        record.setKp((byte)1);
        record.setKpr(user.getUsername());
        record.setKprq(new Date());

        PurchaseCgfpExample example = new PurchaseCgfpExample();
        example.createCriteria().andDjbhEqualTo(djbh);
        cgfpService.updateByExample(record,example);


    }
}
