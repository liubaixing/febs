package cc.mrbird.febs.common.listener;

import cc.mrbird.febs.system.entity.Gongsi;
import cc.mrbird.febs.system.service.IGongsiService;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

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
