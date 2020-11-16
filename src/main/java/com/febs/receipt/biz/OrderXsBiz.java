package com.febs.receipt.biz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.febs.basic.entity.*;
import com.febs.basic.service.*;
import com.febs.common.entity.QueryRequest;
import com.febs.common.entity.excel.OrderXsExcelModel;
import com.febs.common.enums.DeletedEnum;
import com.febs.common.exception.FebsException;
import com.febs.purchase.entity.PurchaseCg;
import com.febs.purchase.entity.PurchaseCgmx;
import com.febs.purchase.service.IPurchaseCgService;
import com.febs.purchase.service.IPurchaseCgmxService;
import com.febs.receipt.entity.*;
import com.febs.receipt.service.*;
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
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class OrderXsBiz {

    @Autowired
    private IOrderXsService xsService;

    @Autowired
    private IOrderXsmxService xsmxService;

    @Autowired
    private IOrderXtService xtService;

    @Autowired
    private IOrderXtmxService xtmxService;

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

    @Autowired
    private IOrderCkService ckService;
    @Autowired
    private IOrderCkmxService ckmxService;

    @Autowired
    private IPurchaseCgService cgService;

    @Autowired
    private IPurchaseCgmxService cgmxService;

    /**
     * @param request
     * @param orderXs
     * @return
     */
    public IPage<OrderXsResp> findByPage(QueryRequest request, OrderXsReq orderXs) {
        return xsService.findOrderXss(request, orderXs);
    }

    public OrderXsResp view(Long id){
        OrderXsReq orderXs = new OrderXsReq();
        orderXs.setId(id);
        OrderXsResp resp =  xsService.selectOneByQuery(orderXs);
        OrderXsmx orderXsmx = new OrderXsmx();
        orderXsmx.setPid(id);
        resp.setMxList(xsmxService.findOrderXsmxs(orderXsmx));
        return resp;
    }

    public void create(OrderXsReq orderXsReq) {
        //保存商品明细
        if(CollectionUtils.isEmpty(orderXsReq.getOrderXsmxList())){
            throw new FebsException("商品明细不能为空");
        }
        Integer total = 0;
        BigDecimal totalAmount = new BigDecimal(0);
        List<OrderXsmx> mxList = orderXsReq.getOrderXsmxList();

        for (OrderXsmx mx : mxList){
            total += mx.getJhsl();
            totalAmount = totalAmount.add(mx.getJe());
            mx.setXsje(mx.getJe().multiply(mx.getZk()));
        }

        orderXsReq.setSl(total);
        orderXsReq.setJe(totalAmount);
        orderXsReq.setXdrq(new Date());
        OrderXs orderXs = new OrderXs();
        BeanUtils.copyProperties(orderXsReq,orderXs);
        Long orderXsId = xsService.createOrderXs(orderXs);

        for(OrderXsmx mx : orderXsReq.getOrderXsmxList()){
            mx.setPid(orderXsId);
            xsmxService.createOrderXsmx(mx);
        }

    }

    @Transactional
    public void update(OrderXsReq orderXsReq) {

        if(CollectionUtils.isEmpty(orderXsReq.getOrderXsmxList())){
            throw new FebsException("商品明细不能为空");
        }

        Integer total = 0;
        BigDecimal totalAmount = new BigDecimal(0);
        List<OrderXsmx> mxList = orderXsReq.getOrderXsmxList();

        for (OrderXsmx mx : mxList){
            total += mx.getJhsl();
            totalAmount = totalAmount.add(mx.getJe());
            mx.setXsje(mx.getJe().multiply(mx.getZk()));
        }

        OrderXs orderXs = new OrderXs();
        BeanUtils.copyProperties(orderXsReq,orderXs);
        orderXs.setSl(total);
        orderXs.setJe(totalAmount);
        orderXs.setUpdateTime(new Date());
        xsService.updateOrderXs(orderXs);

        OrderXsmxExample example = new OrderXsmxExample();
        example.createCriteria().andPidEqualTo(orderXsReq.getId());
        xsmxService.deleteByExample(example);

        for(OrderXsmx mx : orderXsReq.getOrderXsmxList()){
            mx.setPid(orderXsReq.getId());
            xsmxService.createOrderXsmx(mx);
        }

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
        /*excelCheck(resp);
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
        xsmxService.createOrderXsmx(orderXsmx);*/
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
        orderXs.setAuditor(req.getAuditor());
        orderXs.setShrq(new Date());
        xsService.updateOrderXs(orderXs);
    }

    public void executeOrderXs(OrderXsReq req,boolean status){
        OrderXsmx xsmx = xsmxService.findById(req.getMxId());
        if (xsmx == null) {
            throw new FebsException("销售单不存在");
        }

        Shangpin shangpin = shangpinService.findByPrimaryKey(xsmx.getSpId());


        //计划数为销售单总数量
        if ((xsmx.getTzsl() +xsmx.getCksl()+req.getTzsl()) > xsmx.getJhsl() ) {
            throw new FebsException("执行数量超出销售单数量");
        }

        xsmx.setTzsl(xsmx.getTzsl()+req.getTzsl());
        OrderXsmx orderXsmx = xsmxService.updateOrderXsmx(xsmx);

        OrderXs orderXs = xsService.findById(orderXsmx.getPid());
        orderXs.setZx(req.getZx());
        orderXs.setZxr(req.getZxr());
        orderXs.setZxrq(req.getZxrq());
        xsService.updateOrderXs(orderXs);

        Cangku ck = cangkuService.findById(orderXs.getCangkuId());

        if (ck == null) throw new FebsException("销售单仓库不存在");

        if (0 == req.getZxfs()){
            //自发，生成出库单
            OrderCk orderCk = new OrderCk();
            orderCk.setYdbh(orderXs.getDjbh());
            orderCk.setYdjh(orderXs.getYdjh());
            orderCk.setXdrq(new Date());
            orderCk.setCangkuId(orderXs.getCangkuId());
            orderCk.setKehuId(orderXs.getKehuId());
            orderCk.setOrgId(orderXs.getOrgId());
            orderCk.setDjlxId(orderXs.getDjlxId());
            orderCk.setSl(req.getTzsl());
            orderCk.setJe(shangpin.getYsj().multiply(new BigDecimal(req.getTzsl())));
            orderCk.setZdr(req.getZxr());
            orderCk.setZdrq(new Date());
            Long orderCkId = ckService.createOrderCk(orderCk);
            OrderCkmx orderCkmx = new OrderCkmx();
            orderCkmx.setPid(orderCkId);
            orderCkmx.setSpId(xsmx.getSpId());
            orderCkmx.setSl(req.getTzsl());
            orderCkmx.setDj(shangpin.getYsj());
            orderCkmx.setJe(shangpin.getYsj().multiply(new BigDecimal(req.getTzsl())));
            ckmxService.createOrderCkmx(orderCkmx);
        }else if (1 == req.getZxfs()){
            //直发，生成采购单
            PurchaseCg cg = new PurchaseCg();
            cg.setXdrq(new Date());
            cg.setXsdh(orderXs.getDjbh());
            cg.setYdjh(orderXs.getYdjh());
            cg.setUserId(req.getUserId());
            cg.setBmId(orderXs.getBumengId());

            Shangpin sp = new Shangpin();
            sp.setId(xsmx.getSpId());
            sp = shangpinService.findOneByQuery(sp);

            cg.setGysId(sp.getGysId());
            cg.setCangkuId(req.getCangkuId());
            cg.setSl(req.getTzsl());
            cg.setJe(shangpin.getCgj().multiply(new BigDecimal(req.getTzsl())));
            cg.setZdr(req.getZxr());
            cg.setZdrq(new Date());
            Long cgId = cgService.createPurchaseCg(cg);

            PurchaseCgmx cgmx = new PurchaseCgmx();
            cgmx.setPid(cgId);
            cgmx.setSpId(xsmx.getSpId());
            cgmx.setSl(req.getTzsl());
            cgmx.setDj(shangpin.getCgj());
            cgmx.setJe(shangpin.getCgj().multiply(new BigDecimal(req.getTzsl())));
            cgmxService.createPurchaseCgmx(cgmx);
        }

    }

    public void closeOrderXs(OrderXs req,boolean status){
        OrderXs orderXs = xsService.findById(req.getId());
        if (orderXs == null) {
            throw new FebsException("销售单不存在");
        }
        if (status == true && orderXs.getSh() == 1) throw new FebsException("销售单已关闭");
        if (status == false && orderXs.getSh() == 0) throw new FebsException("销售单未关闭");
        orderXs.setGb(req.getGb());
        orderXs.setGbr(req.getGbr());
        orderXs.setGbrq(new Date());
        xsService.updateOrderXs(orderXs);

    }

    @Transactional
    public void returnOrderXs(OrderXsReq req){
        OrderXsmx mx = xsmxService.findById(req.getMxId());
        if (mx == null) {
            throw new FebsException("销售单不存在");
        }

        if((req.getTksl() + mx.getXtsl()) > mx.getJhsl()) throw new FebsException("退款数量超过销售单数量");
        OrderXs orderXs = xsService.findById(mx.getPid());

        mx.setXtsl(mx.getXtsl() + req.getTksl());
        mx.setXtje(mx.getXtje().add(req.getTkje()));
        xsmxService.updateOrderXsmx(mx);

        OrderXt orderXt = new OrderXt();
        orderXt.setXdrq(new Date());
        orderXt.setYdbh(orderXs.getDjbh());
        orderXt.setYdjh(orderXs.getYdjh());
        orderXt.setOrgId(orderXs.getOrgId());
        orderXt.setUserId(req.getUserId());
        orderXt.setBumengId(orderXs.getBumengId());
        orderXt.setKehuId(orderXs.getKehuId());
        orderXt.setCangkuId(orderXs.getCangkuId());
        orderXt.setKhlyId(orderXs.getKhlyId());
        orderXt.setLllyId(orderXs.getLllyId());
        orderXt.setDjlxId(orderXs.getDjlxId());
        orderXt.setKhqyId(orderXs.getKhqyId());

        orderXt.setSl(req.getTksl());
        orderXt.setJe(req.getTkje());

        Long orderXtId = xtService.createOrderXt(orderXt);

        OrderXtmx orderXtmx = new OrderXtmx();
        orderXtmx.setPid(orderXtId);
        orderXtmx.setSpId(req.getSpId());
        orderXtmx.setJhsl(req.getTksl());
        orderXtmx.setJe(req.getTkje());
        orderXtmx.setDj(req.getTkje().divide(new BigDecimal(req.getTksl())));
        xtmxService.createOrderXtmx(orderXtmx);

    }

    public void excelUpload(List<OrderXsExcelModel> data,String type){

        if (CollectionUtils.isEmpty(data)){
            throw new FebsException("excel不能为空");
        }

        List<OrderXsReq> orderXsReqList = Arrays.asList((OrderXsReq[])data.toArray());

        for (OrderXsReq orderXsReq : orderXsReqList){

        }


    }

    private void excelCheck(OrderXsReq req){
        if (req.getXdrq() == null){
            throw new FebsException("下单日期为空");
        }
        if (StringUtils.isEmpty(req.getYdjh())){
            throw new FebsException("客户订单编号为空");
        }
        if (StringUtils.isEmpty(req.getKhmc())){
            throw new FebsException("客户名称为空");
        }
        Kehu kehu = new Kehu();
        kehu.setKhmc(req.getKhmc());
        kehu = kehuService.findOneByQuery(kehu);
//        req.setKh
        if (StringUtils.isEmpty(req.getPtdamc())){
            throw new FebsException("购货单位名称为空");
        }
        if (StringUtils.isEmpty(req.getAddress())){
            throw new FebsException("收货地址为空");
        }
        if (StringUtils.isEmpty(req.getContact())){
            throw new FebsException("收货人为空");
        }
        if (StringUtils.isEmpty(req.getTel())){
            throw new FebsException("联系电话为空");
        }
        if (StringUtils.isEmpty(req.getSptm())) {
            throw new FebsException("商品条码为空");
        }
        if (req.getSl() == null) {
            throw new FebsException("数量为空");
        }
        if (req.getJe() == null) {
            throw new FebsException("金额为空");
        }
        if (StringUtils.isEmpty(req.getBmmc())){
            Bumeng bumeng = new Bumeng();
            bumeng.setBmmc(req.getBmmc());
            bumeng = bumengService.findBumengs(bumeng).get(0);
            req.setBumengId(bumeng.getId());
        }


    }

}
