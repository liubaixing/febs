package com.febs.purchase.biz;

import com.febs.common.exception.FebsException;
import com.febs.common.utils.BeanUtils;
import com.febs.purchase.entity.PurchaseRk;
import com.febs.purchase.entity.PurchaseRkmx;
import com.febs.purchase.service.IPurchaseRkService;
import com.febs.purchase.service.IPurchaseRkmxService;
import com.febs.purchase.vo.req.PurchaseRkReq;
import com.febs.purchase.vo.resp.PurchaseRkResp;
import com.febs.purchase.vo.resp.PurchaseRkmxResp;
import com.febs.receipt.service.IOrderXsService;
import com.febs.receipt.service.IOrderXtService;
import com.febs.receipt.vo.req.OrderXtReq;
import com.febs.receipt.vo.resp.OrderXtResp;
import com.febs.shangpin.entity.Spkcb;
import com.febs.shangpin.entity.SpkcbExample;
import com.febs.shangpin.mapper.SpkcbMapper;
import com.febs.system.entity.User;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
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

    @Resource
    private SpkcbMapper spkcbMapper;

    public PurchaseRkResp view(Long id){

        PurchaseRkResp rkResp = rkService.findById(id);
        if (rkResp == null) {
            throw new FebsException("入库单不存在");
        }

        PurchaseRkmx purchaseRkmx = new PurchaseRkmx();
        rkResp.setRkmxList(rkmxService.findPurchaseRkmxs(purchaseRkmx));

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

    public void create(PurchaseRkReq req) {

        if (CollectionUtils.isEmpty(req.getRkmxList())) {
            throw new FebsException("入库单明细不能为空");
        }

        List<PurchaseRkmx> rkmxList = req.getRkmxList();

        Integer zsl = rkmxList.stream().mapToInt(PurchaseRkmx::getSl).sum();

        BigDecimal zje = rkmxList.stream().map(PurchaseRkmx::getJe).reduce(BigDecimal.ZERO,BigDecimal::add);

        PurchaseRk rk = BeanUtils.transformFrom(req,PurchaseRk.class);
        rk.setJe(zje);
        rk.setSl(zsl);
        Long pid = rkService.createPurchaseRk(rk);

        for (PurchaseRkmx rkmx : rkmxList){
            rkmx.setPid(pid);
            rkmxService.createPurchaseRkmx(rkmx);
        }
    }


    @Transactional
    public void qr(Long id, User user) {

        PurchaseRk purchaseRk = new PurchaseRk();
        purchaseRk.setId(id);
        purchaseRk.setQr((byte)1);
        purchaseRk.setQrr(user.getUsername());
        purchaseRk.setQrrq(new Date());
        rkService.updatePurchaseRk(purchaseRk);


        PurchaseRkmx purchaseRkmx = new PurchaseRkmx();
        purchaseRkmx.setPid(id);

        List<PurchaseRkmxResp> rkmxRespList = rkmxService.findPurchaseRkmxs(purchaseRkmx);

        if (CollectionUtils.isNotEmpty(rkmxRespList)){

            rkmxRespList.stream().forEach( i ->{

                SpkcbExample example = new SpkcbExample();
                example.createCriteria().andGoodsIdEqualTo(i.getSpId());
                List<Spkcb> kcList = spkcbMapper.selectByExample(example);

                if (CollectionUtils.isNotEmpty(kcList)){

                    for (Spkcb spkcb : kcList){

                        if ( spkcb.getSl2() - i.getSl() < 0){
                            throw new FebsException("确认锁定库存不足");
                        }

                        spkcb.setSl(spkcb.getSl() + i.getSl());
                        spkcb.setSl2(spkcb.getSl2()- i.getSl());
                        spkcbMapper.updateByPrimaryKeySelective(spkcb);
                    }

                }

                throw new FebsException("商品库存不存在");

            });

        }

        throw new FebsException("入库单明细为空");

    }


}
