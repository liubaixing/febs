package com.febs.common.listener.system;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.febs.system.entity.Bumeng;
import com.febs.system.service.IBumengService;

public class BumengDataListener extends AnalysisEventListener<Bumeng> {

    private IBumengService bumengService;

    public BumengDataListener(IBumengService bumengService) {
        this.bumengService = bumengService;
    }

    @Override
    public void invoke(Bumeng bumeng, AnalysisContext analysisContext) {
        bumengService.excelInsert(bumeng);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
