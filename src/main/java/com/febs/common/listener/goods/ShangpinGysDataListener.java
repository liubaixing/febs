package com.febs.common.listener.goods;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.febs.shangpin.service.IShangpinGysService;
import com.febs.shangpin.vo.resp.ShangpinGysResp;

public class ShangpinGysDataListener extends AnalysisEventListener<ShangpinGysResp> {

    private IShangpinGysService shangpinGysService;

    public ShangpinGysDataListener(IShangpinGysService shangpinGysService) {
        this.shangpinGysService = shangpinGysService;
    }

    @Override
    public void invoke(ShangpinGysResp shangpinGys, AnalysisContext analysisContext) {
        shangpinGysService.excelInsert(shangpinGys);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
