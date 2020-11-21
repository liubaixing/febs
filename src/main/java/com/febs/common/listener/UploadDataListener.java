package com.febs.common.listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import com.febs.common.entity.ExcelUpload;
import com.febs.common.service.IExportService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: UploadDataListener
 * @Description: 通用导入模板
 * @Author: liubaixing
 * @Date 2020/8/5
 * @Version 1.0
 */
public class UploadDataListener<T extends ExcelUpload> extends AnalysisEventListener<T> {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(UploadDataListener.class);

    private static final int BATCH_COUNT = 3000;

    private List<T> data = new ArrayList<T>();

    private IExportService service;

    public UploadDataListener(IExportService service) {
        this.service = service;
    }

    public List<T> getData(){
        return data;
    }

    @Override
    public void invoke(T obj, AnalysisContext context) {
        data.add(obj);
        if (data.size() >= BATCH_COUNT) {
            saveData();
            data.clear();
        }
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {
        saveData();
        LOGGER.info("所有数据解析完成！");
    }

    /**
     * 加上存储数据库
     */
    private void saveData() {
        LOGGER.info("{}条数据，开始存储数据库！", data.size());
        service.upload(data);
        LOGGER.info("存储数据库成功！");
    }
}
