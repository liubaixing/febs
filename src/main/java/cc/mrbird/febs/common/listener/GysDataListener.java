package cc.mrbird.febs.common.listener;

import cc.mrbird.febs.system.entity.Gys;
import cc.mrbird.febs.system.service.IGysService;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

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
