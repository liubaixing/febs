package com.febs.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.basic.entity.BasicFpsd;
import com.febs.common.entity.QueryRequest;

import java.util.List;

/**
 * 发票税点 Service接口
 *
 * @author liubaixing
 * @date 2020-05-22 01:27:27
 */
public interface IBasicFpsdService extends IService<BasicFpsd> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param basicFpsd basicFpsd
     * @return IPage<BasicFpsd>
     */
    IPage<BasicFpsd> findBasicFpsds(QueryRequest request, BasicFpsd basicFpsd);

    /**
     * 查询（所有）
     *
     * @param basicFpsd basicFpsd
     * @return List<BasicFpsd>
     */
    List<BasicFpsd> findBasicFpsds(BasicFpsd basicFpsd);

    /**
     * 新增
     *
     * @param basicFpsd basicFpsd
     */
    void createBasicFpsd(BasicFpsd basicFpsd);

    /**
     * 修改
     *
     * @param basicFpsd basicFpsd
     */
    void updateBasicFpsd(BasicFpsd basicFpsd);

    /**
     * 删除
     */
    void deleteBasicFpsd(String[] ids);
}
