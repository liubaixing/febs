package com.febs.shangpin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.common.entity.QueryRequest;
import com.febs.common.entity.excel.StockTzExcelModel;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.DateUtil;
import com.febs.common.utils.StringUtil;
import com.febs.orderqt.vo.req.YsfdReq;
import com.febs.shangpin.entity.Shangpin;
import com.febs.shangpin.entity.ShangpinExample;
import com.febs.shangpin.entity.StockTz;
import com.febs.shangpin.entity.StockTzmx;
import com.febs.shangpin.mapper.ShangpinMapper;
import com.febs.shangpin.mapper.StockTzMapper;
import com.febs.shangpin.mapper.StockTzmxMapper;
import com.febs.shangpin.service.IStockTzService;
import com.febs.shangpin.vo.req.StockTzReq;
import com.febs.shangpin.vo.resp.StockTzResp;
import com.febs.system.entity.Cangku;
import com.febs.system.entity.CangkuExample;
import com.febs.system.mapper.CangkuMapper;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
public class StockTzServiceImpl implements IStockTzService {

    @Resource
    private StockTzMapper stockTzMapper;
    @Resource
    private StockTzmxMapper stockTzmxMapper;
    @Resource
    private CangkuMapper cangkuMapper;
    @Resource
    private ShangpinMapper shangpinMapper;

    @Override
    public IPage<StockTzResp> findStockTzPage(QueryRequest request, StockTzReq stockTz) {
        Page<StockTz> page = new Page<>(request.getPageNum(), request.getPageSize());
        return stockTzMapper.selectPageByQuery(page,stockTz);
    }

    @Override
    public List<StockTzResp> findStockTzList(StockTzReq stockTz) {
        return stockTzMapper.selectByQuery(stockTz);
    }

    @Override
    public StockTz getStockTzById(Long id){
        return stockTzMapper.selectByPrimaryKey(id);
    }

    @Override
    public StockTz saveObject(StockTz stockTz) {
        stockTzMapper.insertSelective(stockTz);
        String orderNo = "tz" + DateUtil.getYear() + StringUtil.padStart(stockTz.getId());
        stockTz.setDjbh(orderNo);
        updateObject(stockTz);
        return stockTz;
    }

    @Override
    public StockTz updateObject(StockTz stockTz) {
        stockTzMapper.updateByPrimaryKeySelective(stockTz);
        return stockTzMapper.selectByPrimaryKey(stockTz.getId());
    }

    @Override
    public void delete(Long id) {
        stockTzMapper.deleteByPrimaryKey(id);
    }

    @Transactional
    @Override
    public List<StockTzExcelModel> upload(List<StockTzExcelModel> data) {

        if (CollectionUtils.isEmpty(data)) {
            throw new FebsException("excel数据为空");
        }

        List<StockTzReq> list =  excelDataCheck(data);

        if (CollectionUtils.isEmpty(list)){
            throw new FebsException("excel数据校验异常");
        }

        for (StockTzReq stockTzReq : list){
            StockTz stockTz = new StockTz();
            stockTz.setXdrq(stockTzReq.getXdrq());
            stockTz.setCangkuId(stockTzReq.getCangkuId());
            stockTz.setSl(stockTzReq.getSl());
            stockTzMapper.insertSelective(stockTz);
            String orderNo = "tz" + DateUtil.getYear() + StringUtil.padStart(stockTz.getId());
            stockTz.setDjbh(orderNo);
            updateObject(stockTz);

            StockTzmx stockTzmx = new StockTzmx();
            stockTzmx.setPid(stockTz.getId());
            stockTzmx.setSpId(stockTzReq.getSpId());
            stockTzmx.setSl(stockTzReq.getSl());
            stockTzmxMapper.insertSelective(stockTzmx);

        }

        return null;
    }

    private List<StockTzReq> excelDataCheck(List<StockTzExcelModel> data){

        return data.stream().map(one -> {
            StockTzReq stockTzReq = new StockTzReq();

            CangkuExample cangkuExample = new CangkuExample();
            cangkuExample.createCriteria().andCkmcEqualTo(one.getCangku());
            List<Cangku> cangkuList = cangkuMapper.selectByExample(cangkuExample);
            if (CollectionUtils.isEmpty(cangkuList)){
                throw new FebsException("仓库数据异常，请检查");
            }
            stockTzReq.setCangkuId(cangkuList.get(0).getId());

            ShangpinExample shangpinExample = new ShangpinExample();
            shangpinExample.createCriteria().andSpmcEqualTo(one.getSpmc());
            List<Shangpin> shangpinList = shangpinMapper.selectByExample(shangpinExample);
            if (CollectionUtils.isEmpty(shangpinList)){
                throw new FebsException("商品数据异常，请检查");
            }
            stockTzReq.setSpId(shangpinList.get(0).getId());
            stockTzReq.setSl(one.getSl());
            if ("全盘".equals(one.getPdlx())){
                stockTzReq.setPdlx((byte)0);
            }else{
                stockTzReq.setPdlx((byte)1);
            }
            stockTzReq.setXdrq(one.getDjrq());
            return stockTzReq;
        }).collect(Collectors.toList());

    }

}
