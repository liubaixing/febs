package com.febs.system.service;

import com.febs.common.entity.QueryRequest;
import com.febs.system.entity.Bumeng;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 部门管理 Service接口
 *
 * @author liubaixing
 * @date 2020-06-14 17:15:53
 */
public interface IBumengService extends IService<Bumeng> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param bumeng bumeng
     * @return IPage<Bumeng>
     */
    IPage<Bumeng> findBumengs(QueryRequest request, Bumeng bumeng);

    /**
     * 查询（所有）
     *
     * @param bumeng bumeng
     * @return List<Bumeng>
     */
    List<Bumeng> findBumengs(Bumeng bumeng);

    /**
     * 新增
     *
     * @param bumeng bumeng
     */
    void createBumeng(Bumeng bumeng);

    /**
     * 修改
     *
     * @param bumeng bumeng
     */
    void updateBumeng(Bumeng bumeng);

    /**
     * 删除
     */
    void deleteBumeng(String[] ids);

    void excelInsert(Bumeng bumeng);
}
