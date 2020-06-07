package cc.mrbird.febs.common.listener;

import cc.mrbird.febs.shangpin.service.IShangpinService;
import cc.mrbird.febs.shangpin.vo.resp.ShangpinResp;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

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
