package com.febs.common.listener.receipt;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.febs.receipt.biz.OrderXsBiz;
import com.febs.receipt.service.IOrderXsService;
import com.febs.receipt.vo.resp.OrderXsResp;

public class OrderXslistener extends AnalysisEventListener<OrderXsResp> {

    private OrderXsBiz xsBiz;

    public OrderXslistener(OrderXsBiz xsBiz) {
        this.xsBiz = xsBiz;
    }

    @Override
    public void invoke(OrderXsResp orderXsResp, AnalysisContext analysisContext) {
        xsBiz.excelInsert(orderXsResp);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
