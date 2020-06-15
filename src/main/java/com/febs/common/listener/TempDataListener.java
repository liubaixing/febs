package com.febs.common.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.febs.receipt.entity.Temp;

public class TempDataListener extends AnalysisEventListener<Temp> {
    @Override
    public void invoke(Temp temp, AnalysisContext analysisContext) {
        System.out.println(temp);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
