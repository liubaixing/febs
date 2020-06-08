package com.febs.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.basic.entity.BasicKhlb;
import com.febs.common.entity.QueryRequest;

import java.util.List;

/**
 * 客户类别 Service接口
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:16
 */
public interface IBasicKhlbService extends IService<BasicKhlb> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param basicKhlb basicKhlb
     * @return IPage<BasicKhlb>
     */
    IPage<BasicKhlb> findBasicKhlbs(QueryRequest request, BasicKhlb basicKhlb);

    /**
     * 查询（所有）
     *
     * @param basicKhlb basicKhlb
     * @return List<BasicKhlb>
     */
    List<BasicKhlb> findBasicKhlbs(BasicKhlb basicKhlb);

    /**
     * 新增
     *
     * @param basicKhlb basicKhlb
     */
    void createBasicKhlb(BasicKhlb basicKhlb);

    /**
     * 修改
     *
     * @param basicKhlb basicKhlb
     */
    void updateBasicKhlb(BasicKhlb basicKhlb);

    /**
     * 删除
     */
    void deleteBasicKhlb(String[] ids);
}
