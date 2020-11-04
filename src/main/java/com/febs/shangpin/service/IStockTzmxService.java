package com.febs.shangpin.service;

import com.febs.shangpin.entity.StockTzmx;
import com.febs.shangpin.entity.StockTzmxExample;
import com.febs.shangpin.vo.resp.StockTzmxResp;

import java.util.List;

/**
 * @ClassName: IStockTzmxService
 * @Description:
 * @Author:
 * @Date 2020/11/4
 * @Version 1.0
 */
public interface IStockTzmxService {
    List<StockTzmxResp> findStockTzList(StockTzmx req);

    void saveObject(StockTzmx stockTz);

    void updateObject(StockTzmx stockTz);

    void delete(Long id);

    void delete(StockTzmxExample example);
}
