package cc.mrbird.febs.common.listener;

import cc.mrbird.febs.system.entity.Kehu;
import cc.mrbird.febs.system.service.IKehuService;
import cc.mrbird.febs.system.vo.resp.KehuResp;
import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

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
