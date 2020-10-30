package com.febs.common.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;

import java.util.List;

/**
 * @ClassName: CommonExcelListener
 * @Description:
 * @Author:
 * @Date 2020/10/30
 * @Version 1.0
 */
public class CommonExcelListener<T> extends AnalysisEventListener<T> {

    private List<T> datas;

    public List<T> getDatas(){
        return datas;
    }


    @Override
    public void invoke(T data, AnalysisContext analysisContext) {
        datas.add(data);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {

    }
}
