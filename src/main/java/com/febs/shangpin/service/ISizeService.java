package com.febs.shangpin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.common.entity.QueryRequest;
import com.febs.shangpin.entity.Size;

import java.util.List;

/**
 * 尺码 Service接口
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:58
 */
public interface ISizeService extends IService<Size> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param size size
     * @return IPage<Size>
     */
    IPage<Size> findSizes(QueryRequest request, Size size);

    /**
     * 查询（所有）
     *
     * @param size size
     * @return List<Size>
     */
    List<Size> findSizes(Size size);

    /**
     * 新增
     *
     * @param size size
     */
    void createSize(Size size);

    /**
     * 修改
     *
     * @param size size
     */
    void updateSize(Size size);

    /**
     * 删除
     */
    void deleteSize(String[] ids);
}
