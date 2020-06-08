package com.febs.shangpin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.common.entity.QueryRequest;
import com.febs.shangpin.entity.ShangpinDl;

import java.util.List;

/**
 * 大类 Service接口
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:00
 */
public interface IShangpinDlService extends IService<ShangpinDl> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param shangpinDl shangpinDl
     * @return IPage<ShangpinDl>
     */
    IPage<ShangpinDl> findShangpinDls(QueryRequest request, ShangpinDl shangpinDl);

    /**
     * 查询（所有）
     *
     * @param shangpinDl shangpinDl
     * @return List<ShangpinDl>
     */
    List<ShangpinDl> findShangpinDls(ShangpinDl shangpinDl);

    /**
     * 新增
     *
     * @param shangpinDl shangpinDl
     */
    void createShangpinDl(ShangpinDl shangpinDl);

    /**
     * 修改
     *
     * @param shangpinDl shangpinDl
     */
    void updateShangpinDl(ShangpinDl shangpinDl);

    /**
     * 删除
     */
    void deleteShangpinDl(String[] ids);
}
