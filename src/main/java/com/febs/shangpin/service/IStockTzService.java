package com.febs.shangpin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.febs.common.entity.QueryRequest;
import com.febs.common.entity.excel.StockTzExcelModel;
import com.febs.common.service.IExportService;
import com.febs.shangpin.entity.StockTz;
import com.febs.shangpin.vo.req.StockTzReq;
import com.febs.shangpin.vo.resp.StockTzResp;

import java.util.List;

public interface IStockTzService extends IExportService<StockTzExcelModel> {

    IPage<StockTzResp> findStockTzPage(QueryRequest request, StockTzReq req);

    List<StockTzResp> findStockTzList(StockTzReq req);

    StockTz getStockTzById(Long id);

    StockTz saveObject(StockTz stockTz);

    StockTz updateObject(StockTz stockTz);

    void delete(Long id);
}
