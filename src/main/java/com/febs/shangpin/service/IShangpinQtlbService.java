package com.febs.shangpin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.common.entity.QueryRequest;
import com.febs.shangpin.entity.ShangpinQtlb;

import java.util.List;

/**
 * 其他类别 Service接口
 *
 * @author liubaixing1
 * @date 2020-05-22 01:10:44
 */
public interface IShangpinQtlbService extends IService<ShangpinQtlb> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param shangpinQtlb shangpinQtlb
     * @return IPage<ShangpinQtlb>
     */
    IPage<ShangpinQtlb> findShangpinQtlbs(QueryRequest request, ShangpinQtlb shangpinQtlb);

    /**
     * 查询（所有）
     *
     * @param shangpinQtlb shangpinQtlb
     * @return List<ShangpinQtlb>
     */
    List<ShangpinQtlb> findShangpinQtlbs(ShangpinQtlb shangpinQtlb);

    /**
     * 新增
     *
     * @param shangpinQtlb shangpinQtlb
     */
    void createShangpinQtlb(ShangpinQtlb shangpinQtlb);

    /**
     * 修改
     *
     * @param shangpinQtlb shangpinQtlb
     */
    void updateShangpinQtlb(ShangpinQtlb shangpinQtlb);

    /**
     * 删除
     */
    void deleteShangpinQtlb(String[] ids);
}
