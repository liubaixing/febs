package com.febs.common.listener.system;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.febs.system.service.IKehuService;
import com.febs.system.vo.resp.KehuResp;

public class KehuDataListener extends AnalysisEventListener<KehuResp> {

    private IKehuService kehuService;

    public KehuDataListener(IKehuService kehuService){
        this.kehuService = kehuService;
    }

    @Override
    public void invoke(KehuResp data, AnalysisContext analysisContext) {
        kehuService.excelInsert(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) { }


}
