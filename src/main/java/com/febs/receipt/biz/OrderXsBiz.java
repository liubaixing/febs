package com.febs.receipt.biz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.febs.basic.entity.*;
import com.febs.basic.service.*;
import com.febs.common.entity.QueryRequest;
import com.febs.common.enums.DeletedEnum;
import com.febs.common.enums.order.OrderStatusEnum;
import com.febs.common.exception.FebsException;
import com.febs.receipt.entity.OrderXs;
import com.febs.receipt.entity.OrderXsmx;
import com.febs.receipt.service.IOrderXsService;
import com.febs.receipt.service.IOrderXsmxService;
import com.febs.receipt.vo.req.OrderXsReq;
import com.febs.receipt.vo.resp.OrderXsResp;
import com.febs.shangpin.entity.Shangpin;
import com.febs.shangpin.service.IShangpinService;
import com.febs.system.entity.Bumeng;
import com.febs.system.entity.Cangku;
import com.febs.system.entity.Kehu;
import com.febs.system.entity.User;
import com.febs.system.service.IBumengService;
import com.febs.system.service.ICangkuService;
import com.febs.system.service.IKehuService;
import com.febs.system.service.IUserService;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
public class OrderXsBiz {

    @Autowired
    private IOrderXsService xsService;

    @Autowired
    private IOrderXsmxService xsmxService;

    @Autowired
    private IShangpinService shangpinService;

    @Autowired
    private IBasicPtdaService ptdaService;

    @Autowired
    private IUserService userService;
    @Autowired
    private IBumengService bumengService;
    @Autowired
    private IKehuService kehuService;
    @Autowired
    private ICangkuService cangkuService;
    @Autowired
    private IBasicKhlyService khlyService;
    @Autowired
    private IBasicDjlxService djlxService;
    @Autowired
    private IBasicKhqyService khqyService;
    @Autowired
    private IBasicLllyService lllyService;


    /**
     * @param request
     * @param orderXs
     * @return
     */
    public IPage<OrderXsResp> findByPage(QueryRequest request, OrderXsReq orderXs) {
        return xsService.findOrderXss(request, orderXs);
    }

    public void create(OrderXsReq orderXsReq) {
        //保存商品明细
        if(CollectionUtils.isEmpty(orderXsReq.getOrderXsmxList())){
            throw new FebsException("商品明细不能为空");
        }
        orderXsReq.setXdrq(new Date());
        Long orderXsId = xsService.createOrderXs(orderXsReq);
        for(OrderXsmx mx : orderXsReq.getOrderXsmxList()){
            mx.setPid(orderXsId);
            xsmxService.createOrderXsmx(mx);
        }

    }

    public void update(OrderXs orderXs) {
        xsService.updateOrderXs(orderXs);
    }

    public void delete(String[] ids) {
        OrderXs orderXs = new OrderXs();
        for (String id : ids) {
            orderXs.setId(Long.valueOf(id));
            orderXs.setDeleted(DeletedEnum.DELETED.getCode());
            xsService.updateOrderXs(orderXs);
        }
    }

    public void excelInsert(OrderXsResp resp){
        excelCheck(resp);
        OrderXs orderXs = new OrderXs();
        BeanUtils.copyProperties(resp,orderXs);
        if (StringUtils.isNotBlank(resp.getPtdamc())) {
            BasicPtda ptda = new BasicPtda();
            ptda.setPtdamc(resp.getPtdamc());
            ptda = ptdaService.findOneByQuery(ptda);
            if(ptda == null){
                throw new FebsException("购货单位不存在");
            }
            orderXs.setOrgId(ptda.getId());
        }else{
            throw new FebsException("购货单位名称不能为空");
        }
        if (StringUtils.isNotBlank(resp.getUserName())) {
            User user = userService.findByName(resp.getUserName());
            if (user == null) {
                throw new FebsException("业务员不存在");
            }
            orderXs.setUserId(user.getUserId());
        }
        if (StringUtils.isNotBlank(resp.getBmmc())) {
            Bumeng bumeng = new Bumeng();
            bumeng.setBmmc(resp.getBmmc());
            bumeng = bumengService.findOneByQuery(bumeng);
            if (bumeng == null) {
                throw new FebsException("部门不存在");
            }
            orderXs.setBumengId(bumeng.getId());
        }

        if (StringUtils.isNotBlank(resp.getKhmc())) {
            Kehu kehu = new Kehu();
            kehu.setKhmc(resp.getKhmc());
            kehu = kehuService.findOneByQuery(kehu);
            if (kehu == null) {
                throw new FebsException("客户不存在");
            }
            orderXs.setKehuId(kehu.getId());
        }else {
            throw new FebsException("客户名称不能为空");
        }
        if (StringUtils.isNotBlank(resp.getCkmc())) {
            Cangku cangku = new Cangku();
            cangku.setCkmc(resp.getCkmc());
            cangku = cangkuService.findOneByQuery(cangku);
            if (cangku == null) {
                throw new FebsException("发货仓库不存在");
            }
            orderXs.setCangkuId(cangku.getId());
        }
        if (StringUtils.isNotBlank(resp.getKhlymc())) {
            BasicKhly khly = new BasicKhly();
            khly.setKhlymc(resp.getKhlymc());
            khly = khlyService.findOneByQuery(khly);
            if (khly == null){
                throw new FebsException("客户来源不存在");
            }
            orderXs.setKhlyId(khly.getId());
        }
        if (StringUtils.isNotBlank(resp.getDjlxmc())) {
            BasicDjlx djlx = new BasicDjlx();
            djlx.setDjlxdm(resp.getDjlxmc());
            djlx = djlxService.findOneByQuery(djlx);
            if (djlx == null) {
                throw new FebsException("单据类型不存在");
            }
            orderXs.setDjlxId(djlx.getId());
        }else {
            throw new FebsException("单据类型不能为空");
        }
        if (StringUtils.isNotBlank(resp.getKhqymc())) {
            BasicKhqy khqy = new BasicKhqy();
            khqy.setKhqymc(resp.getKhqymc());
            khqy = khqyService .findOneByQuery(khqy);
            if (khqy == null) {
                throw new FebsException("客户区域名称不存在");
            }
            orderXs.setKhqyId(khqy.getId());
        }
        if (StringUtils.isNotBlank(resp.getLllymc())){
            BasicLlly llly = new BasicLlly();
            llly.setLllymc(resp.getLllymc());
            llly = lllyService.findOneByQuery(llly);
            if (llly == null){
                throw new FebsException("流量来源名称不能为空");
            }
            orderXs.setLllyId(llly.getId());
        }
        OrderXsmx orderXsmx = new OrderXsmx();
        BeanUtils.copyProperties(resp,orderXsmx);
        if (StringUtils.isNotBlank(resp.getSpmc())) {
            Shangpin sp = new Shangpin();
            sp.setSpmc(resp.getSpmc());
            sp = shangpinService.findOneByQuery(sp);
            if (sp == null) {
                throw new FebsException("商品不存在");
            }
            orderXsmx.setSpId(sp.getId());
        }else {
            throw new FebsException("商品名称不能为空");
        }
        Long xsId = xsService.createOrderXs(orderXs);

        orderXsmx.setPid(xsId);
        orderXsmx.setDj(resp.getJe().multiply(new BigDecimal(resp.getSl())));
        orderXsmx.setXsje(resp.getJe().subtract(resp.getZk()));
        xsmxService.createOrderXsmx(orderXsmx);
    }

    public void confirmOrderXs(OrderXs req,boolean status){
        OrderXs orderXs = xsService.findById(req.getId());
        if (orderXs == null) {
            throw new FebsException("销售单不存在");
        }
        if (status == true && orderXs.getQr() == 1) throw new FebsException("销售单已确认");
        if (status == false && orderXs.getQr() == 0) throw new FebsException("销售单未确认");

        orderXs.setQr(req.getQr());
        orderXs.setQrr(req.getQrr());
        orderXs.setQrrq(new Date());
        xsService.updateOrderXs(orderXs);
    }


    public void checkOrderXs(OrderXs req,boolean status){
        OrderXs orderXs = xsService.findById(req.getId());
        if (orderXs == null) {
            throw new FebsException("销售单不存在");
        }
        if (status == true && orderXs.getSh() == 1) throw new FebsException("销售单已审核");
        if (status == false && orderXs.getSh() == 0) throw new FebsException("销售单未审核");
        orderXs.setSh(req.getSh());
        orderXs.setShr(req.getShr());
        orderXs.setShrq(new Date());
        xsService.updateOrderXs(orderXs);
    }

    public void executeOrderXs(OrderXs req,boolean status){
        OrderXs orderXs = xsService.findById(req.getId());
        if (orderXs == null) {
            throw new FebsException("销售单不存在");
        }
        if (orderXs.getKpsl() == orderXs.getSl()) {
            throw new FebsException("订单已执行完毕");
        }
        //开票数量+已开票数量 > 销售单数量
        if ((req.getKpsl() + orderXs.getKpsl()) - orderXs.getSl() > 0) {
            throw new FebsException("执行数量超出销售单数量");
        }

        orderXs.setKpsl(orderXs.getKpsl()+req.getKpsl());
        orderXs.setZx(req.getZx());
        orderXs.setZxr(req.getZxr());
        orderXs.setZxrq(new Date());
        xsService.updateOrderXs(orderXs);

        Cangku ck = cangkuService.findById(orderXs.getCangkuId());

        if (ck == null) throw new FebsException("销售单仓库不存在");

        if (0 == ck.getCkxz()){
            //自发，生成出库单
        }else{
            //直发，生成采购单


        }

    }

    public void closeOrderXs(OrderXs req,boolean status){
        OrderXs orderXs = xsService.findById(req.getId());
        if (orderXs == null) {
            throw new FebsException("销售单不存在");
        }

        orderXs.setGb(req.getGb());
        orderXs.setGbr(req.getGbr());
        orderXs.setGbrq(new Date());
        xsService.updateOrderXs(orderXs);

    }

    public void returnOrderXs(Long id , OrderXsReq req){
        OrderXsmx mx = xsmxService.findById(id);
        if (mx == null) {
            throw new FebsException("销售单不存在");
        }

        if((req.getTksl() + mx.getTksl()) > mx.getJhsl()) throw new FebsException("退款数量大于销售单数量");
//        if (req.getTkje().add(mx.getTkje()).compareTo(mx.get))


    }

    private void excelCheck(OrderXsResp resp){
        if (resp.getXdrq() == null) {
            throw new FebsException("下单日期不能为空");
        }
        if (resp.getSfjj() == null){
            throw new FebsException("加急不能为空");
        }
        if (StringUtils.isBlank(resp.getYdjh())) {
            throw new FebsException("客户订单编号不能为空");
        }
        if (StringUtils.isBlank(resp.getKhmc())) {
            throw new FebsException("客户名称不能为空");
        }
        if (StringUtils.isBlank(resp.getPtdamc())) {
            throw new FebsException("购货单位不能为空");
        }
        if (StringUtils.isBlank(resp.getDjlxmc())) {
            throw new FebsException("单据类型不能为空");
        }
        if (StringUtils.isBlank(resp.getKhqymc())) {
            throw new FebsException("客户区域不能为空");
        }
        if (StringUtils.isBlank(resp.getAddress())) {
            throw new FebsException("收货地址不能为空");
        }
        if (StringUtils.isBlank(resp.getContact())) {
            throw new FebsException("收货人不能为空");
        }
        if (StringUtils.isBlank(resp.getTel())) {
            throw new FebsException("联系电话不能为空");
        }
        if (StringUtils.isBlank(resp.getSpmc())) {
            throw new FebsException("商品名称不能为空");
        }
        if (resp.getSl() == null) {
            throw new FebsException("数量不能为空");
        }
        if (resp.getJe() == null) {
            throw new FebsException("金额不能为空");
        }
        if (resp.getZk() == null) {
            throw new FebsException("平台折扣不能为空");
        }
    }

}
