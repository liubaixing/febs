package com.febs.purchase.biz;

import com.febs.common.exception.FebsException;
import com.febs.orderqt.entity.OrderqtYfdmx;
import com.febs.orderqt.entity.OrderqtYsfd;
import com.febs.orderqt.entity.OrderqtYsfdmx;
import com.febs.orderqt.service.IOrderqtYfdService;
import com.febs.orderqt.service.IOrderqtYfdmxService;
import com.febs.orderqt.service.IOrderqtYsfdService;
import com.febs.orderqt.service.IOrderqtYsfdmxService;
import com.febs.orderqt.vo.req.YfdReq;
import com.febs.orderqt.vo.req.YsfdReq;
import com.febs.orderqt.vo.resp.YfdResp;
import com.febs.orderqt.vo.resp.YsfdResp;
import com.febs.purchase.entity.PurchaseCg;
import com.febs.purchase.entity.PurchaseCgfk;
import com.febs.purchase.entity.PurchaseCgfkmx;
import com.febs.purchase.entity.PurchaseCgmx;
import com.febs.purchase.service.IPurchaseCgService;
import com.febs.purchase.service.IPurchaseCgfkService;
import com.febs.purchase.service.IPurchaseCgfkmxService;
import com.febs.purchase.service.IPurchaseCgmxService;
import com.febs.purchase.vo.req.CgfkCreateReq;
import com.febs.purchase.vo.req.PurchaseCgReq;
import com.febs.purchase.vo.req.PurchaseCgfkReq;
import com.febs.purchase.vo.resp.PurchaseCgResp;
import com.febs.purchase.vo.resp.PurchaseCgfkResp;
import com.febs.purchase.vo.resp.PurchaseCgfkmxResp;
import com.febs.system.entity.User;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class PurchaseCgfkBiz {

    @Autowired
    private IPurchaseCgfkService cgfkService;

    @Autowired
    private IPurchaseCgfkmxService cgfkmxService;

    @Autowired
    private IPurchaseCgService cgService;
    @Autowired
    private IPurchaseCgmxService cgmxService;
    @Autowired
    private IOrderqtYfdService yfdService;
    @Autowired
    private IOrderqtYfdmxService yfdmxService;
    @Autowired
    private IOrderqtYsfdService ysfdService;
    @Autowired
    private IOrderqtYsfdmxService ysfdmxService;

    public PurchaseCgfkResp view(Long id){
        PurchaseCgfkResp cgfkResp = cgfkService.findById(id);
        PurchaseCgfkmx purchaseCgfkmx = new PurchaseCgfkmx();
        purchaseCgfkmx.setPid(cgfkResp.getId());
        cgfkResp.setCgfkmxList(cgfkmxService.findPurchaseCgfkmxs(purchaseCgfkmx));
        return  cgfkResp;
    }

    public void kssc(CgfkCreateReq req, User user) {

        if (CollectionUtils.isEmpty(req.getCgfkList())) {
            throw new FebsException("未勾选单据");
        }

        List<PurchaseCgfkReq> cgfkList = req.getCgfkList();

        BigDecimal zje = cgfkList.stream().map(PurchaseCgfkReq::getJe).reduce(BigDecimal.ZERO,BigDecimal::add);

        PurchaseCgfk cgfk = new PurchaseCgfk();
        cgfk.setDjrq(new Date());
        cgfk.setGysId(req.getGysId());
        cgfk.setJe(zje);
        cgfk.setBz(req.getBz());
        cgfk.setZdr(user.getUsername());
        cgfk.setZdrq(new Date());
        Long pid = cgfkService.createPurchaseCgfk(cgfk);

        cgfkList.stream().forEach(one->{
            PurchaseCgfkmx cgfkmx = new PurchaseCgfkmx();
            cgfkmx.setPid(pid);
            cgfkmx.setSpId(one.getSpId());
            cgfkmx.setYdjh(one.getYdjh());
            cgfkmx.setSl(one.getSl());
            cgfkmx.setJe(one.getJe());
            cgfkmxService.createPurchaseCgfkmx(cgfkmx);

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
                if (purchaseCgmx.getFksl() + one.getSl() > purchaseCgmx.getSl())
                    throw new FebsException("付款数量大于采购单数量");

                purchaseCgmx.setFksl(purchaseCgmx.getFksl() + one.getSl());
                purchaseCgmx.setFkje(purchaseCgmx.getFkje().add(one.getJe()));
                cgmxService.updatePurchaseCgmx(purchaseCgmx);

                purchaseCgResp.setFksl(purchaseCgResp.getFksl()+ one.getSl());
                purchaseCgResp.setFkje(purchaseCgResp.getFkje().add(one.getJe()));
                cgService.updatePurchaseCg(purchaseCgResp);
            } else if ("yf".equals(one.getOrderType())) {
                //运费

                YfdReq yfdReq = new YfdReq();
                yfdReq.setDjbh(one.getYdjh());
                YfdResp yfdResp = yfdService.findOrderqtYfds(yfdReq).get(0);
                if (yfdResp == null) throw new FebsException("运费单不存在");

                OrderqtYfdmx orderqtYfdmx = new OrderqtYfdmx();
                orderqtYfdmx.setPid(yfdResp.getId());
                orderqtYfdmx.setSpId(one.getSpId());
                orderqtYfdmx = yfdmxService.findOrderqtYfdmxs(orderqtYfdmx).get(0);
                if (orderqtYfdmx == null) throw new FebsException("运费单不存在");
                if (orderqtYfdmx.getFksl() + one.getSl() > orderqtYfdmx.getSl())
                    throw new FebsException("付款数量大于运费单数量");

                orderqtYfdmx.setFksl(orderqtYfdmx.getFksl() + one.getSl());
                orderqtYfdmx.setFkje(orderqtYfdmx.getFkje().add(one.getJe()));
                yfdmxService.updateOrderqtYfdmx(orderqtYfdmx);

            } else if ("ys".equals(one.getOrderType())) {
                //印刷费
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
                if (ysfdmx.getFksl() + one.getSl() > ysfdmx.getSl())
                    throw new FebsException("付款数量大于印刷费单数量");

                ysfdmx.setFksl(ysfdmx.getFksl() + one.getSl());
                ysfdmx.setFkje(ysfdmx.getFkje().add(one.getJe()));
                ysfdmxService.updateOrderqtYsfdmx(ysfdmx);
            }
        });



    }

    public void fk(String djbh) {
        PurchaseCgfkReq purchaseCgfk = new PurchaseCgfkReq();
        purchaseCgfk.setDjbh(djbh);
        PurchaseCgfkResp purchaseCgfkResp = cgfkService.findPurchaseCgfks(purchaseCgfk).get(0);
        if (purchaseCgfkResp == null) {
            throw new FebsException("付款单不存在");
        }
        PurchaseCgfkmx purchaseCgfkmx = new PurchaseCgfkmx();
        purchaseCgfkmx.setPid(purchaseCgfkResp.getId());
        List<PurchaseCgfkmxResp> cgfkmxList = cgfkmxService.findPurchaseCgfkmxs(purchaseCgfkmx);
        if (CollectionUtils.isEmpty(cgfkmxList))
            throw new FebsException("付款单明细不存在");

        for (PurchaseCgfkmxResp cgfkmx : cgfkmxList){
            String orderType = cgfkmx.getYdjh().substring(0,2);

            if ("cg".equals(orderType)) {


            } else if ("yf".equals(orderType)) {

            } else if ("ys".equals(orderType)) {

            }
        }
    }
}
