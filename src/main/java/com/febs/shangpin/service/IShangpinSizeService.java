package com.febs.shangpin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.common.entity.QueryRequest;
import com.febs.shangpin.entity.ShangpinSize;

import java.util.List;

/**
 * 商品尺码 Service接口
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:46
 */
public interface IShangpinSizeService extends IService<ShangpinSize> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param shangpinSize shangpinSize
     * @return IPage<ShangpinSize>
     */
    IPage<ShangpinSize> findShangpinSizes(QueryRequest request, ShangpinSize shangpinSize);

    /**
     * 查询（所有）
     *
     * @param shangpinSize shangpinSize
     * @return List<ShangpinSize>
     */
    List<ShangpinSize> findShangpinSizes(ShangpinSize shangpinSize);

    /**
     * 新增
     *
     * @param shangpinSize shangpinSize
     */
    void createShangpinSize(ShangpinSize shangpinSize);

    /**
     * 修改
     *
     * @param shangpinSize shangpinSize
     */
    void updateShangpinSize(ShangpinSize shangpinSize);

    /**
     * 删除
     */
    void deleteShangpinSize(String[] ids);
}
