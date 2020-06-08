package com.febs.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.basic.entity.BasicHsxm;
import com.febs.common.entity.QueryRequest;

import java.util.List;

/**
 * 核算项目 Service接口
 *
 * @author liubaixing
 * @date 2020-05-22 01:38:13
 */
public interface IBasicHsxmService extends IService<BasicHsxm> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param basicHsxm basicHsxm
     * @return IPage<BasicHsxm>
     */
    IPage<BasicHsxm> findBasicHsxms(QueryRequest request, BasicHsxm basicHsxm);

    /**
     * 查询（所有）
     *
     * @param basicHsxm basicHsxm
     * @return List<BasicHsxm>
     */
    List<BasicHsxm> findBasicHsxms(BasicHsxm basicHsxm);

    /**
     * 新增
     *
     * @param basicHsxm basicHsxm
     */
    void createBasicHsxm(BasicHsxm basicHsxm);

    /**
     * 修改
     *
     * @param basicHsxm basicHsxm
     */
    void updateBasicHsxm(BasicHsxm basicHsxm);

    /**
     * 删除
     */
    void deleteBasicHsxm(String[] ids);
}
