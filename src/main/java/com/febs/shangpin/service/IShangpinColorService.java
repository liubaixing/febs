package com.febs.shangpin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.common.entity.QueryRequest;
import com.febs.shangpin.entity.ShangpinColor;

import java.util.List;

/**
 * 商品颜色 Service接口
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:53
 */
public interface IShangpinColorService extends IService<ShangpinColor> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param shangpinColor shangpinColor
     * @return IPage<ShangpinColor>
     */
    IPage<ShangpinColor> findShangpinColors(QueryRequest request, ShangpinColor shangpinColor);

    /**
     * 查询（所有）
     *
     * @param shangpinColor shangpinColor
     * @return List<ShangpinColor>
     */
    List<ShangpinColor> findShangpinColors(ShangpinColor shangpinColor);

    /**
     * 新增
     *
     * @param shangpinColor shangpinColor
     */
    void createShangpinColor(ShangpinColor shangpinColor);

    /**
     * 修改
     *
     * @param shangpinColor shangpinColor
     */
    void updateShangpinColor(ShangpinColor shangpinColor);

    /**
     * 删除
     */
    void deleteShangpinColor(String[] ids);
}
