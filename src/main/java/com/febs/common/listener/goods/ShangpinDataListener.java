package com.febs.common.listener.goods;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.febs.shangpin.service.IShangpinService;
import com.febs.shangpin.vo.resp.ShangpinResp;

public class ShangpinDataListener extends AnalysisEventListener<ShangpinResp> {

    private IShangpinService shangpinService;


    public ShangpinDataListener(IShangpinService shangpinService) {
        this.shangpinService = shangpinService;
    }

    @Override
    public void invoke(ShangpinResp shangpin, AnalysisContext analysisContext) {
        shangpinService.excelInsert(shangpin);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
