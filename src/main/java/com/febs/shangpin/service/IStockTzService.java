package com.febs.shangpin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.febs.common.entity.QueryRequest;
import com.febs.shangpin.vo.req.StockTzReq;
import com.febs.shangpin.vo.resp.StockTzResp;

public interface IStockTzService {

    IPage<StockTzResp> findStockTzList(QueryRequest request, StockTzReq req);




}
