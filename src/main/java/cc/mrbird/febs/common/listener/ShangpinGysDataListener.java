package cc.mrbird.febs.common.listener;

import cc.mrbird.febs.shangpin.service.IShangpinGysService;
import cc.mrbird.febs.shangpin.vo.resp.ShangpinGysResp;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

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
