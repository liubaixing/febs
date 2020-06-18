package com.febs.receipt.biz;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.febs.basic.entity.BasicKhly;
import com.febs.basic.entity.BasicPtda;
import com.febs.basic.service.IBasicKhlyService;
import com.febs.basic.service.IBasicPtdaService;
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
                throw new FebsException("");
            }
            orderXs.setCangkuId(cangku.getId());
        }
        if (StringUtils.isNotBlank(resp.getKhlymc())) {
            BasicKhly khly = new BasicKhly();
            khly.setKhlymc(resp.getKhlymc());
            khly = khlyService.findOneByQuery(khly);
            if (khly == null){
                throw new FebsException("");
            }
            orderXs.setKhlyId(khly.getId());
        }




        Long XsId = xsService.createOrderXs(orderXs);
        if (StringUtils.isNotBlank(resp.getSpmc())) {

        }



    }


    public OrderXsResp orderXsStatusCheck(Long id, String type,boolean status,String user){
        byte sta = 0;//状态
        if (status)
            sta =1;
        OrderXs orderXs = new OrderXs();
        orderXs.setId(id);
        switch (type){
            case "CONFIRM" :
                //确认
                orderXs.setQr(sta);
                orderXs.setQrr(user);
                orderXs.setQrrq(new Date());
                break;
            case "CHECK" :
                //审核
                orderXs.setSh(sta);
                orderXs.setShr(user);
                orderXs.setShrq(new Date());
                break;
            case "EXECUTE" :
                //执行
                orderXs.setZx(sta);
                orderXs.setZxr(user);
                orderXs.setZxrq(new Date());
                break;
            default:
                throw new FebsException("接口状态不存在");
        }
       return xsService.updateOrderXs(orderXs);
    }

}
