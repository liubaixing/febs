package com.febs.shangpin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.common.entity.QueryRequest;
import com.febs.shangpin.entity.Color;

import java.util.List;

/**
 * 颜色 Service接口
 *
 * @author liubaixing
 * @date 2020-05-22 00:59:30
 */
public interface IColorService extends IService<Color> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param color color
     * @return IPage<Color>
     */
    IPage<Color> findColors(QueryRequest request, Color color);

    /**
     * 查询（所有）
     *
     * @param color color
     * @return List<Color>
     */
    List<Color> findColors(Color color);

    /**
     * 新增
     *
     * @param color color
     */
    void createColor(Color color);

    /**
     * 修改
     *
     * @param color color
     */
    void updateColor(Color color);

    /**
     * 删除
     */
    void deleteColor(String[] ids);
}
