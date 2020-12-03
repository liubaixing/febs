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
import com.febs.orderqt.entity.OrderqtYfd;
import com.febs.orderqt.entity.OrderqtYfdExample;
import com.febs.orderqt.entity.OrderqtYfdmx;
import com.febs.orderqt.mapper.OrderqtYfdMapper;
import com.febs.orderqt.mapper.OrderqtYfdmxMapper;
import com.febs.orderqt.service.IOrderqtYfdService;
import com.febs.orderqt.vo.req.YfdReq;
import com.febs.orderqt.vo.resp.YfdResp;
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
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 运费单 Service实现
 *
 * @author liubaixing
 * @date 2020-07-29 14:14:12
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OrderqtYfdServiceImpl extends ServiceImpl<OrderqtYfdMapper, OrderqtYfd> implements IOrderqtYfdService {

    @Resource
    private OrderqtYfdMapper orderqtYfdMapper;
    @Resource
    private OrderqtYfdmxMapper yfdmxMapper;

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
    public IPage<YfdResp> findOrderqtYfds(QueryRequest request, YfdReq req) {
        Page<OrderqtYfd> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.orderqtYfdMapper.selectPageByQuery(page, req);
    }

    @Override
    public List<YfdResp> findOrderqtYfds(YfdReq req) {
		return this.orderqtYfdMapper.selectByQuery(req);
    }

    @Override
    public YfdResp findById(Long id){
        YfdReq req = new YfdReq();
        req.setId(id);
        List<YfdResp> yfdRespList = findOrderqtYfds(req);
        return CollectionUtils.isEmpty(yfdRespList) ? null : yfdRespList.get(0);
    }

    @Override
    @Transactional
    public Long createOrderqtYfd(OrderqtYfd orderqtYfd) {

        this.orderqtYfdMapper.insertSelective(orderqtYfd);

        String orderXsNo = "";
        if (StringUtils.isNotBlank(orderqtYfd.getDjbh())) {
            orderXsNo = orderqtYfd.getDjbh() + DateUtil.getYear() + StringUtil.padStart(orderqtYfd.getId());
        }else{
            orderXsNo = OrderqtConstant.ORDERQT_YF_PREFIX + DateUtil.getYear() + StringUtil.padStart(orderqtYfd.getId());
        }
        orderqtYfd.setDjbh(orderXsNo);

        this.orderqtYfdMapper.updateByPrimaryKeySelective(orderqtYfd);

        return orderqtYfd.getId();
    }

    @Override
    @Transactional
    public void updateOrderqtYfd(OrderqtYfd orderqtYfd) {
        this.orderqtYfdMapper.updateByPrimaryKeySelective(orderqtYfd);
    }

    @Override
    @Transactional
    public void deleteOrderqtYfd(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

    @Override
    @Transactional
	public void deleteByExample(OrderqtYfdExample example){
        this.orderqtYfdMapper.deleteByExample(example);
    }




    @Override
    public List<YfdExcelModel> upload(List<YfdExcelModel> data) {

        if (CollectionUtils.isEmpty(data)) {
            throw new FebsException("excel数据为空");
        }

        List<YfdReq> list = excelDataCheck(data);

        if (CollectionUtils.isEmpty(list)){
            throw new FebsException("excel数据校验异常");
        }

        list.stream().forEach(one ->{
            OrderqtYfd yfd = new OrderqtYfd();
            yfd.setDjrq(one.getDjrq());
            yfd.setGysId(one.getGysId());
            yfd.setJe(one.getJe());
            Long pid = createOrderqtYfd(yfd);

            OrderqtYfdmx yfdmx = new OrderqtYfdmx();
            yfdmx.setPid(pid);
            yfdmx.setYdjh(one.getYdjh());
            yfdmx.setSpId(one.getSpId());
            yfdmx.setJe(one.getJe());
            yfdmxMapper.insertSelective(yfdmx);
        });
        return null;
    }


    private List<YfdReq> excelDataCheck(List<YfdExcelModel> source){

       return source.stream().map(one -> {
            YfdReq yfd = new YfdReq();
            yfd.setDjrq(one.getDjrq());

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
            yfd.setGysId(gys.getId());

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
            yfd.setYdjh(cg.getDjbh());

            PurchaseCgmxExample cgmxExample = new PurchaseCgmxExample();
            cgmxExample.createCriteria().andPidEqualTo(cg.getId());
            PurchaseCgmx cgmx = cgmxMapper.selectByExample(cgmxExample).get(0);
            yfd.setSpId(cgmx.getSpId());

            if (one.getJe()!=null){
                throw new FebsException("金额不能为空");
            }
            yfd.setJe(one.getJe());

            if (StringUtils.isBlank(one.getFplx())){
                LambdaQueryWrapper<BasicFplx> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.like(BasicFplx::getFplxmc,one.getFplx());
                BasicFplx fplx = fplxMapper.selectOne(queryWrapper);
                yfd.setFplxId(fplx.getId());
            }else{
                yfd.setFplxId(gys.getFplxId());
            }

            if (StringUtils.isBlank(one.getFpsd())){
                LambdaQueryWrapper<BasicFpsd> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.like(BasicFpsd::getFpsdmc,one.getFpsd());
                BasicFpsd fpsd = fpsdMapper.selectOne(queryWrapper);
                yfd.setFpsdId(fpsd.getId());
            }else{
                yfd.setFpsdId(gys.getFpsdId());
            }
            return yfd;
        }).collect(Collectors.toList());

    }

}
