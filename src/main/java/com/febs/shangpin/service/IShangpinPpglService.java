package com.febs.shangpin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.common.entity.QueryRequest;
import com.febs.shangpin.entity.ShangpinPpgl;

import java.util.List;

/**
 * 品牌管理 Service接口
 *
 * @author liubaixing1
 * @date 2020-05-22 01:10:37
 */
public interface IShangpinPpglService extends IService<ShangpinPpgl> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param shangpinPpgl shangpinPpgl
     * @return IPage<ShangpinPpgl>
     */
    IPage<ShangpinPpgl> findShangpinPpgls(QueryRequest request, ShangpinPpgl shangpinPpgl);

    /**
     * 查询（所有）
     *
     * @param shangpinPpgl shangpinPpgl
     * @return List<ShangpinPpgl>
     */
    List<ShangpinPpgl> findShangpinPpgls(ShangpinPpgl shangpinPpgl);

    /**
     * 新增
     *
     * @param shangpinPpgl shangpinPpgl
     */
    void createShangpinPpgl(ShangpinPpgl shangpinPpgl);

    /**
     * 修改
     *
     * @param shangpinPpgl shangpinPpgl
     */
    void updateShangpinPpgl(ShangpinPpgl shangpinPpgl);

    /**
     * 删除
     */
    void deleteShangpinPpgl(String[] ids);

}
