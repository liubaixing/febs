package com.febs.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.basic.entity.BasicPtda;
import com.febs.common.entity.QueryRequest;

import java.util.List;

/**
 * 平台档案 Service接口
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:40
 */
public interface IBasicPtdaService extends IService<BasicPtda> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param basicPtda basicPtda
     * @return IPage<BasicPtda>
     */
    IPage<BasicPtda> findBasicPtdas(QueryRequest request, BasicPtda basicPtda);

    /**
     * 查询（所有）
     *
     * @param basicPtda basicPtda
     * @return List<BasicPtda>
     */
    List<BasicPtda> findBasicPtdas(BasicPtda basicPtda);

    /**
     * 新增
     *
     * @param basicPtda basicPtda
     */
    void createBasicPtda(BasicPtda basicPtda);

    /**
     * 修改
     *
     * @param basicPtda basicPtda
     */
    void updateBasicPtda(BasicPtda basicPtda);

    /**
     * 删除
     */
    void deleteBasicPtda(String[] ids);
}
