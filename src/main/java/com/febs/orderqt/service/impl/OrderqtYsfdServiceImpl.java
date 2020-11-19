package com.febs.orderqt.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.basic.entity.BasicFplx;
import com.febs.basic.entity.BasicFpsd;
import com.febs.basic.mapper.BasicFplxMapper;
import com.febs.basic.mapper.BasicFpsdMapper;
import com.febs.common.constant.OrderqtConstant;
import com.febs.common.entity.QueryRequest;
import com.febs.common.entity.excel.YfdExcelModel;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.DateUtil;
import com.febs.common.utils.StringUtil;
import com.febs.orderqt.entity.*;
import com.febs.orderqt.mapper.OrderqtYsfdMapper;
import com.febs.orderqt.mapper.OrderqtYsfdmxMapper;
import com.febs.orderqt.service.IOrderqtYsfdService;
import com.febs.orderqt.vo.req.YfdReq;
import com.febs.orderqt.vo.req.YsfdReq;
import com.febs.orderqt.vo.resp.YsfdResp;
import com.febs.purchase.entity.PurchaseCg;
import com.febs.purchase.entity.PurchaseCgExample;
import com.febs.purchase.entity.PurchaseCgmx;
import com.febs.purchase.entity.PurchaseCgmxExample;
import com.febs.purchase.mapper.PurchaseCgMapper;
import com.febs.purchase.mapper.PurchaseCgmxMapper;
import com.febs.system.entity.Gys;
import com.febs.system.entity.GysExample;
import com.febs.system.mapper.GysMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 印刷费单 Service实现
 *
 * @author liubaixing
 * @date 2020-07-29 14:14:23
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OrderqtYsfdServiceImpl extends ServiceImpl<OrderqtYsfdMapper, OrderqtYsfd> implements IOrderqtYsfdService {

    @Resource
    private OrderqtYsfdMapper orderqtYsfdMapper;
    @Resource
    private OrderqtYsfdmxMapper ysfdmxMapper;

    @Resource
    private GysMapper gysMapper;
    @Resource
    private BasicFpsdMapper fpsdMapper;
    @Resource
    private BasicFplxMapper fplxMapper;
    @Resource
    private PurchaseCgMapper cgMapper;
    @Resource
    private PurchaseCgmxMapper cgmxMapper;

    @Override
    public IPage<YsfdResp> findOrderqtYsfds(QueryRequest request, YsfdReq req) {
        Page<OrderqtYsfd> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.orderqtYsfdMapper.selectPageByQuery(page, req);
    }

    @Override
    public List<YsfdResp> findOrderqtYsfds(YsfdReq req) {
		return this.orderqtYsfdMapper.selectByQuery(req);
    }

    @Override
    public YsfdResp findById(Long id){
        YsfdReq req = new YsfdReq();
        req.setId(id);
        List<YsfdResp> ysfdList = findOrderqtYsfds(req);
        return CollectionUtils.isEmpty(ysfdList) ? null : ysfdList.get(0);
    }

    @Override
    @Transactional
    public Long createOrderqtYsfd(OrderqtYsfd orderqtYsfd) {
        this.orderqtYsfdMapper.insertSelective(orderqtYsfd);

        String orderXsNo = "";
        if (StringUtils.isNotBlank(orderqtYsfd.getDjbh())) {
            orderXsNo = orderqtYsfd.getDjbh() + DateUtil.getYear() + StringUtil.padStart(orderqtYsfd.getId());
        }else{
            orderXsNo = OrderqtConstant.ORDER_YSF_PREFIX + DateUtil.getYear() + StringUtil.padStart(orderqtYsfd.getId());
        }
        orderqtYsfd.setDjbh(orderXsNo);

        this.orderqtYsfdMapper.updateByPrimaryKeySelective(orderqtYsfd);

        return orderqtYsfd.getId();
    }

    @Override
    @Transactional
    public void updateOrderqtYsfd(OrderqtYsfd orderqtYsfd) {
        this.orderqtYsfdMapper.updateByPrimaryKeySelective(orderqtYsfd);
    }

    @Override
    @Transactional
    public void deleteOrderqtYsfd(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

    @Override
    @Transactional
	public void deleteByExample(OrderqtYsfdExample example){
        this.orderqtYsfdMapper.deleteByExample(example);
    }


    @Override
    public List<YfdExcelModel> upload(List<YfdExcelModel> data) {
        if (CollectionUtils.isEmpty(data)) {
            throw new FebsException("excel数据为空");
        }

        List<YsfdReq> list = new ArrayList<>();

        excelDataCheck(data,list);

        list.stream().forEach(one ->{
            OrderqtYsfd ysfd = new OrderqtYsfd();
            ysfd.setDjrq(one.getDjrq());
            ysfd.setGysId(one.getGysId());
            ysfd.setJe(one.getJe());
            Long pid = createOrderqtYsfd(ysfd);

            OrderqtYsfdmx ysfdmx = new OrderqtYsfdmx();
            ysfdmx.setPid(pid);
            ysfdmx.setYdjh(one.getYdjh());
            ysfdmx.setSpId(one.getSpId());
            ysfdmx.setJe(one.getJe());
            ysfdmxMapper.insertSelective(ysfdmx);
        });

        return null;
    }

    private void excelDataCheck(List<YfdExcelModel> source, List<YsfdReq> target){

        source.stream().forEach(one -> {
            YsfdReq ysfd = new YsfdReq();
            ysfd.setDjrq(one.getDjrq());

            /** 供应商 **/
            if (StringUtils.isBlank(one.getGys())){
                throw new FebsException("供应商不能为空");
            }
            GysExample gysExample = new GysExample();
            gysExample.createCriteria().andGysmcEqualTo(one.getGys());
            List<Gys> gysList = gysMapper.selectByExample(gysExample);
            if (CollectionUtils.isEmpty(gysList)) {
                throw new FebsException("供应商不存在");
            }
            Gys gys = gysList.get(0);
            ysfd.setGysId(gys.getId());

            /** 采购单号 **/
            if (StringUtils.isBlank(one.getCgdh())){
                throw new FebsException("采购单号不能为空");
            }
            PurchaseCgExample cgExample = new PurchaseCgExample();
            cgExample.createCriteria().andDjbhEqualTo(one.getCgdh());
            List<PurchaseCg> cgList = cgMapper.selectByExample(cgExample);
            if (CollectionUtils.isEmpty(cgList)) {
                throw new FebsException("采购单不存在");
            }
            PurchaseCg cg = cgList.get(0);
            ysfd.setYdjh(cg.getDjbh());

            PurchaseCgmxExample cgmxExample = new PurchaseCgmxExample();
            cgmxExample.createCriteria().andPidEqualTo(cg.getId());
            PurchaseCgmx cgmx = cgmxMapper.selectByExample(cgmxExample).get(0);
            ysfd.setSpId(cgmx.getSpId());

            if (one.getJe()!=null){
                throw new FebsException("金额不能为空");
            }
            ysfd.setJe(one.getJe());

            if (StringUtils.isBlank(one.getFplx())){
                LambdaQueryWrapper<BasicFplx> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.like(BasicFplx::getFplxmc,one.getFplx());
                BasicFplx fplx = fplxMapper.selectOne(queryWrapper);
                ysfd.setFplxId(fplx.getId());
            }else{
                ysfd.setFplxId(gys.getFplxId());
            }

            if (StringUtils.isBlank(one.getFpsd())){
                LambdaQueryWrapper<BasicFpsd> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.like(BasicFpsd::getFpsdmc,one.getFpsd());
                BasicFpsd fpsd = fpsdMapper.selectOne(queryWrapper);
                ysfd.setFpsdId(fpsd.getId());
            }else{
                ysfd.setFpsdId(gys.getFpsdId());
            }
        });

    }

}
