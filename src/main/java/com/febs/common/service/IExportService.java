package com.febs.common.service;

import com.febs.common.entity.ExcelUpload;

import java.util.Collection;

/**
 * @ClassName: IExportService
 * @Description: excel导入通用业务接口
 * @Author
 * @Date 2020/8/5
 * @Version 1.0
 */
public interface IExportService<T extends ExcelUpload> {

    /**
     * <p>
     * 文件上傳
     * </p>
     *
     * @param list 导入信息
     * @return 是否成功
     */
    boolean upload(Collection<T> list);
}
