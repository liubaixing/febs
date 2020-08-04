package com.febs.receipt.biz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.febs.common.entity.QueryRequest;
import com.febs.common.enums.DeletedEnum;
import com.febs.common.exception.FebsException;
import com.febs.purchase.entity.PurchaseRk;
import com.febs.purchase.entity.PurchaseRkmx;
import com.febs.purchase.entity.PurchaseTc;
import com.febs.purchase.entity.PurchaseTcmx;
import com.febs.purchase.service.IPurchaseRkService;
import com.febs.purchase.service.IPurchaseRkmxService;
import com.febs.purchase.service.IPurchaseTcService;
import com.febs.purchase.service.IPurchaseTcmxService;
import com.febs.receipt.entity.*;
import com.febs.receipt.service.IOrderXtService;
import com.febs.receipt.service.IOrderXtmxService;
import com.febs.receipt.vo.req.OrderXsReq;
import com.febs.receipt.vo.req.OrderXtReq;
import com.febs.receipt.vo.resp.OrderXtResp;
import com.febs.receipt.vo.resp.OrderXtmxResp;
import com.febs.system.entity.Cangku;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Service
public class OrderXtBiz {

    @Autowired
    private IOrderXtService xtService;

    @Autowired
    private IOrderXtmxService xtmxService;

    @Autowired
    private IPurchaseTcService tcService;

    @Autowired
    private IPurchaseTcmxService tcmxService;

    @Autowired
    private IPurchaseRkService rkService;

    @Autowired
    private IPurchaseRkmxService rkmxService;

    public IPage<OrderXtResp> findByPage(QueryRequest request, OrderXtReq orderXt){
        return xtService.findOrderXts(request,orderXt);
    }

    public OrderXtResp view(Long id){
        OrderXtResp orderXt = xtService.findById(id);
        OrderXtmx orderXtmx = new OrderXtmx();
        orderXtmx.setPid(orderXt.getId());
        orderXt.setXtmxList(xtmxService.findOrderXtmxs(orderXtmx));
        return orderXt;
    }

    @Transactional
    public void create(OrderXtReq orderXtReq) {
        //保存商品明细
        if(CollectionUtils.isEmpty(orderXtReq.getOrderXtmxList())){
            throw new FebsException("销退单明细不能为空");
        }

        List<OrderXtmx> xtmxeList = orderXtReq.getOrderXtmxList();

        OrderXt xt = new OrderXt();
        BeanUtils.copyProperties(orderXtReq,xt);
        xt.setXdrq(new Date());

        Integer zsl = xtmxeList.stream().mapToInt(OrderXtmx::getJhsl).sum();
        BigDecimal zje = xtmxeList.stream().map(OrderXtmx::getJe).reduce(BigDecimal.ZERO,BigDecimal::add);
        xt.setSl(zsl);
        xt.setJe(zje);
        Long orderXtId = xtService.createOrderXt(orderXtReq);

        for (OrderXtmx mx : orderXtReq.getOrderXtmxList()){
            mx.setPid(orderXtId);
            xtmxService.createOrderXtmx(mx);
        }

    }

    public void delete(String[] ids) {
        OrderXt orderXt = new OrderXt();
        for (String id : ids) {
            orderXt.setId(Long.valueOf(id));
            orderXt.setDeleted(DeletedEnum.DELETED.getCode());
            xtService.updateOrderXt(orderXt);
        }
    }


    public void confirmOrderXt(OrderXs req, boolean status){
        OrderXt orderXt = xtService.findById(req.getId());
        if (orderXt == null) {
            throw new FebsException("销退单不存在");
        }
        if (status == true && orderXt.getQr() == 1) throw new FebsException("销退单已确认");
        if (status == false && orderXt.getQr() == 0) throw new FebsException("销退单未确认");

        orderXt.setQr(req.getQr());
        orderXt.setQrr(req.getQrr());
        orderXt.setQrrq(new Date());
        xtService.updateOrderXt(orderXt);
    }


    public void checkOrderXt(OrderXs req,boolean status){
        OrderXt orderXt = xtService.findById(req.getId());
        if (orderXt == null) {
            throw new FebsException("销退单不存在");
        }
        if (status == true && orderXt.getSh() == 1) throw new FebsException("销退单已审核");
        if (status == false && orderXt.getSh() == 0) throw new FebsException("销退单未审核");
        orderXt.setSh(req.getSh());
        orderXt.setAuditor(req.getAuditor());
        orderXt.setShrq(new Date());
        xtService.updateOrderXt(orderXt);
    }

    public void executeOrderXt(OrderXtReq req){
        OrderXtResp xtResp = xtService.findById(req.getId());
        OrderXtmxResp xtmx = xtmxService.findById(req.getMxId());
        if (xtmx == null) {
            throw new FebsException("销售单不存在");
        }

        OrderXtmxResp xtmxResp = xtmxService.findById(req.getMxId());
        if(xtmxResp.getTzsl()+xtmxResp.getCksl()+req.getSl() > xtmxResp.getJhsl()) throw new FebsException("执行数量大于计划数量");

        xtmxResp.setTzsl(xtmxResp.getTzsl()+req.getSl());
        xtmxResp.setCbje(xtmxResp.getCbje().add(req.getJe()));
        xtmxService.updateOrderXtmx(xtmxResp);

        if(req.getCkxz() == 0){
            //自发，生成退仓单
            PurchaseTc tc = new PurchaseTc();
            tc.setXdrq(new Date());
            tc.setXtdh(xtResp.getDjbh());
            tc.setUserId(xtResp.getUserId());
            tc.setBmId(xtResp.getBumengId());
            tc.setCangkuId(xtResp.getCangkuId());
            tc.setDjlxId(xtResp.getDjlxId());
            tc.setSl(req.getSl());
            tc.setJe(req.getJe());
            tc.setZdr(req.getZxr());
            tc.setZdrq(new Date());
            Long id = tcService.createPurchaseTc(tc);
            PurchaseTcmx tcmx = new PurchaseTcmx();
            tcmx.setPid(id);
            tcmx.setSpId(req.getSpId());
            tcmx.setSl(req.getSl());
            tcmx.setJe(req.getJe());
            tcmx.setDj(req.getDj());
            tcmxService.createPurchaseTcmx(tcmx);
        }else if(req.getCkxz() == 1){
            //直发，生成入库单
            PurchaseRk rk = new PurchaseRk();
            rk.setYdbh(xtResp.getDjbh());
            rk.setXdrq(new Date());
            rk.setCangkuId(xtResp.getCangkuId());
            rk.setKehuId(xtResp.getKehuId());
            rk.setOrgId(xtResp.getOrgId());
            rk.setDjlxId(xtResp.getDjlxId());
            rk.setSl(req.getSl());
            rk.setJe(req.getJe());
            rk.setZdr(req.getZxr());
            rk.setZdrq(new Date());
            Long id = rkService.createPurchaseRk(rk);

            PurchaseRkmx rkmx = new PurchaseRkmx();
            rkmx.setPid(id);
            rkmx.setSpId(req.getSpId());
            rkmx.setDj(req.getDj());
            rkmx.setJe(req.getJe());
            rkmxService.createPurchaseRkmx(rkmx);
        }

    }



}
