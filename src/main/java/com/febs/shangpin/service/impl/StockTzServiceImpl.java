package com.febs.shangpin.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.febs.common.constant.OrderConstant;
import com.febs.common.entity.QueryRequest;
import com.febs.common.utils.DateUtil;
import com.febs.common.utils.StringUtil;
import com.febs.shangpin.entity.StockTz;
import com.febs.shangpin.mapper.StockTzMapper;
import com.febs.shangpin.service.IStockTzService;
import com.febs.shangpin.vo.req.StockTzReq;
import com.febs.shangpin.vo.resp.StockTzResp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StockTzServiceImpl implements IStockTzService {

    @Resource
    private StockTzMapper stockTzMapper;


    @Override
    public IPage<StockTzResp> findStockTzPage(QueryRequest request, StockTzReq stockTz) {
        return stockTzMapper.selectPageByQuery(request,stockTz);
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
}
