package com.febs.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.basic.entity.BasicFklx;
import com.febs.common.entity.QueryRequest;

import java.util.List;

/**
 * 付款类型 Service接口
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:34
 */
public interface IBasicFklxService extends IService<BasicFklx> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param basicFklx basicFklx
     * @return IPage<BasicFklx>
     */
    IPage<BasicFklx> findBasicFklxs(QueryRequest request, BasicFklx basicFklx);

    /**
     * 查询（所有）
     *
     * @param basicFklx basicFklx
     * @return List<BasicFklx>
     */
    List<BasicFklx> findBasicFklxs(BasicFklx basicFklx);

    /**
     * 新增
     *
     * @param basicFklx basicFklx
     */
    void createBasicFklx(BasicFklx basicFklx);

    /**
     * 修改
     *
     * @param basicFklx basicFklx
     */
    void updateBasicFklx(BasicFklx basicFklx);

    /**
     * 删除
     */
    void deleteBasicFklx(String[] ids);
}
