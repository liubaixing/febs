package com.febs.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.basic.entity.BasicKhly;
import com.febs.common.entity.QueryRequest;

import java.util.List;

/**
 * 客户来源 Service接口
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:54
 */
public interface IBasicKhlyService extends IService<BasicKhly> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param basicKhly basicKhly
     * @return IPage<BasicKhly>
     */
    IPage<BasicKhly> findBasicKhlys(QueryRequest request, BasicKhly basicKhly);

    /**
     * 查询（所有）
     *
     * @param basicKhly basicKhly
     * @return List<BasicKhly>
     */
    List<BasicKhly> findBasicKhlys(BasicKhly basicKhly);

    /**
     * 新增
     *
     * @param basicKhly basicKhly
     */
    void createBasicKhly(BasicKhly basicKhly);

    /**
     * 修改
     *
     * @param basicKhly basicKhly
     */
    void updateBasicKhly(BasicKhly basicKhly);

    /**
     * 删除
     */
    void deleteBasicKhly(String[] ids);
}
