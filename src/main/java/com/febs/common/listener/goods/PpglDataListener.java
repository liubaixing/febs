package com.febs.common.listener.goods;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.febs.shangpin.entity.ShangpinPpgl;
import com.febs.shangpin.service.IShangpinPpglService;

public class PpglDataListener extends AnalysisEventListener<ShangpinPpgl> {

    private IShangpinPpglService ppglService;

    public PpglDataListener(IShangpinPpglService ppglService) {
        this.ppglService = ppglService;
    }

    @Override
    public void invoke(ShangpinPpgl shangpinPpgl, AnalysisContext analysisContext) {
        ppglService.createShangpinPpgl(shangpinPpgl);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
