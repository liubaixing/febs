package com.febs.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.basic.entity.BasicDjlx;
import com.febs.common.entity.QueryRequest;

import java.util.List;

/**
 * 单据类型 Service接口
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:22
 */
public interface IBasicDjlxService extends IService<BasicDjlx> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param basicDjlx basicDjlx
     * @return IPage<BasicDjlx>
     */
    IPage<BasicDjlx> findBasicDjlxs(QueryRequest request, BasicDjlx basicDjlx);

    /**
     * 查询（所有）
     *
     * @param basicDjlx basicDjlx
     * @return List<BasicDjlx>
     */
    List<BasicDjlx> findBasicDjlxs(BasicDjlx basicDjlx);

    /**
     * 新增
     *
     * @param basicDjlx basicDjlx
     */
    void createBasicDjlx(BasicDjlx basicDjlx);

    /**
     * 修改
     *
     * @param basicDjlx basicDjlx
     */
    void updateBasicDjlx(BasicDjlx basicDjlx);

    /**
     * 删除
     */
    void deleteBasicDjlx(String[] ids);
}
