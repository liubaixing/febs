package com.febs.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.basic.entity.BasicCklb;
import com.febs.common.entity.QueryRequest;

import java.util.List;

/**
 * 仓库类别 Service接口
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:18
 */
public interface IBasicCklbService extends IService<BasicCklb> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param basicCklb basicCklb
     * @return IPage<BasicCklb>
     */
    IPage<BasicCklb> findBasicCklbs(QueryRequest request, BasicCklb basicCklb);

    /**
     * 查询（所有）
     *
     * @param basicCklb basicCklb
     * @return List<BasicCklb>
     */
    List<BasicCklb> findBasicCklbs(BasicCklb basicCklb);

    /**
     * 新增
     *
     * @param basicCklb basicCklb
     */
    void createBasicCklb(BasicCklb basicCklb);

    /**
     * 修改
     *
     * @param basicCklb basicCklb
     */
    void updateBasicCklb(BasicCklb basicCklb);

    /**
     * 删除
     */
    void deleteBasicCklb(String[] ids);
}
