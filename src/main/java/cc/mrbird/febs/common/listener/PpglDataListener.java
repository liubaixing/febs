package cc.mrbird.febs.common.listener;

import cc.mrbird.febs.shangpin.entity.ShangpinPpgl;
import cc.mrbird.febs.shangpin.service.IShangpinPpglService;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

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
