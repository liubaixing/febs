package com.febs.common.listener.system;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.febs.system.entity.Gongsi;
import com.febs.system.service.IGongsiService;

public class GongsiDataListener extends AnalysisEventListener<Gongsi> {

    private IGongsiService gongsiServicel;

    public GongsiDataListener(IGongsiService gongsiServicel) {
        this.gongsiServicel = gongsiServicel;
    }

    @Override
    public void invoke(Gongsi gongsi, AnalysisContext analysisContext) {
        gongsiServicel.createGongsi(gongsi);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
