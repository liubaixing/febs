package com.febs.common.listener.goods;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.febs.shangpin.entity.ShangpinQtlb;
import com.febs.shangpin.service.IShangpinQtlbService;

public class QtlbDataListener extends AnalysisEventListener<ShangpinQtlb> {

    private IShangpinQtlbService qtlbService;

    public QtlbDataListener(IShangpinQtlbService qtlbService) {
        this.qtlbService = qtlbService;
    }

    @Override
    public void invoke(ShangpinQtlb shangpinQtlb, AnalysisContext analysisContext) {
        qtlbService.createShangpinQtlb(shangpinQtlb);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
