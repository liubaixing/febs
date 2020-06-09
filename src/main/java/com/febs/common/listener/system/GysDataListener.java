package com.febs.common.listener.system;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.febs.system.entity.Gys;
import com.febs.system.service.IGysService;

public class GysDataListener extends AnalysisEventListener<Gys> {

    private IGysService gysService;

    public GysDataListener(IGysService gysService) {
        this.gysService = gysService;
    }

    @Override
    public void invoke(Gys gys, AnalysisContext analysisContext) {
        gysService.excelInsert(gys);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
