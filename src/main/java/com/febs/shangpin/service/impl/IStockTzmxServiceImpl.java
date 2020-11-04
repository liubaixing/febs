package com.febs.shangpin.service.impl;

import com.febs.shangpin.entity.StockTzmx;
import com.febs.shangpin.entity.StockTzmxExample;
import com.febs.shangpin.mapper.StockTzmxMapper;
import com.febs.shangpin.service.IStockTzmxService;
import com.febs.shangpin.vo.resp.StockTzmxResp;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: IStockTzmxServiceImpl
 * @Description:
 * @Author:
 * @Date 2020/11/4
 * @Version 1.0
 */
@Service
public class IStockTzmxServiceImpl implements IStockTzmxService {

    @Resource
    private StockTzmxMapper stockTzmxMapper;

    @Override
    public List<StockTzmxResp> findStockTzList(StockTzmx req) {
        return stockTzmxMapper.selectByQuery(req);
    }

    @Override
    public void saveObject(StockTzmx stockTz) {
        stockTzmxMapper.insertSelective(stockTz);
    }

    @Override
    public void updateObject(StockTzmx stockTz) {
        stockTzmxMapper.updateByPrimaryKeySelective(stockTz);
    }

    @Override
    public void delete(Long id) {
        stockTzmxMapper.deleteByPrimaryKey(id);
    }

    @Override
    public void delete(StockTzmxExample example) {
        stockTzmxMapper.deleteByExample(example);
    }

}
