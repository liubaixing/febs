package com.febs.common.listener.system;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.febs.system.entity.Cangku;
import com.febs.system.service.ICangkuService;

public class CangkuDataListener extends AnalysisEventListener<Cangku> {

    private ICangkuService cangkuService;

    public CangkuDataListener(ICangkuService cangkuService){
        this.cangkuService = cangkuService;
    }

    @Override
    public void invoke(Cangku cangku, AnalysisContext analysisContext) {
        cangkuService.excelInsert(cangku);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
