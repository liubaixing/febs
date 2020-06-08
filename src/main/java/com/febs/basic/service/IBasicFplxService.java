package com.febs.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.basic.entity.BasicFplx;
import com.febs.common.entity.QueryRequest;

import java.util.List;

/**
 * 发票类型 Service接口
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:37
 */
public interface IBasicFplxService extends IService<BasicFplx> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param basicFplx basicFplx
     * @return IPage<BasicFplx>
     */
    IPage<BasicFplx> findBasicFplxs(QueryRequest request, BasicFplx basicFplx);

    /**
     * 查询（所有）
     *
     * @param basicFplx basicFplx
     * @return List<BasicFplx>
     */
    List<BasicFplx> findBasicFplxs(BasicFplx basicFplx);

    /**
     * 新增
     *
     * @param basicFplx basicFplx
     */
    void createBasicFplx(BasicFplx basicFplx);

    /**
     * 修改
     *
     * @param basicFplx basicFplx
     */
    void updateBasicFplx(BasicFplx basicFplx);

    /**
     * 删除
     */
    void deleteBasicFplx(String[] ids);
}
