package com.febs.common.listener.goods;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.febs.shangpin.entity.ShangpinDl;
import com.febs.shangpin.service.IShangpinDlService;

public class DlDataListener extends AnalysisEventListener<ShangpinDl> {

    private IShangpinDlService dlService;


    public DlDataListener(IShangpinDlService dlService) {
        this.dlService = dlService;
    }

    @Override
    public void invoke(ShangpinDl shangpinDl, AnalysisContext analysisContext) {
        dlService.createShangpinDl(shangpinDl);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
