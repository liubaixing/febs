package com.febs.common.listener.goods;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.febs.shangpin.entity.ShangpinZl;
import com.febs.shangpin.service.IShangpinZlService;

public class ZlDataListener extends AnalysisEventListener<ShangpinZl> {

    private IShangpinZlService zlService;

    public ZlDataListener(IShangpinZlService zlService) {
        this.zlService = zlService;
    }

    @Override
    public void invoke(ShangpinZl shangpinZl, AnalysisContext analysisContext) {
        zlService.createShangpinZl(shangpinZl);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
