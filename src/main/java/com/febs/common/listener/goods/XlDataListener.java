package com.febs.common.listener.goods;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.febs.shangpin.entity.ShangpinXl;
import com.febs.shangpin.service.IShangpinXlService;

public class XlDataListener extends AnalysisEventListener<ShangpinXl> {

    private IShangpinXlService xlService;

    public XlDataListener(IShangpinXlService xlService) {
        this.xlService = xlService;
    }

    @Override
    public void invoke(ShangpinXl shangpinXl, AnalysisContext analysisContext) {
        xlService.createShangpinXl(shangpinXl);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
