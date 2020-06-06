package cc.mrbird.febs.common.listener;

import cc.mrbird.febs.system.entity.Cangku;
import cc.mrbird.febs.system.service.ICangkuService;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

public class CangkuDataListener extends AnalysisEventListener<Cangku> {

    private ICangkuService cangkuService;

    public CangkuDataListener(ICangkuService cangkuService){
        this.cangkuService = cangkuService;
    }

    @Override
    public void invoke(Cangku cangku, AnalysisContext analysisContext) {
        cangkuService.excelInsert(cangku);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
