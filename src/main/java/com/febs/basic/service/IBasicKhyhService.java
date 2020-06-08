package com.febs.basic.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.basic.entity.BasicKhyh;
import com.febs.common.entity.QueryRequest;

import java.util.List;

/**
 * 开户银行 Service接口
 *
 * @author liubaixing
 * @date 2020-05-22 01:40:01
 */
public interface IBasicKhyhService extends IService<BasicKhyh> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param basicKhyh basicKhyh
     * @return IPage<BasicKhyh>
     */
    IPage<BasicKhyh> findBasicKhyhs(QueryRequest request, BasicKhyh basicKhyh);

    /**
     * 查询（所有）
     *
     * @param basicKhyh basicKhyh
     * @return List<BasicKhyh>
     */
    List<BasicKhyh> findBasicKhyhs(BasicKhyh basicKhyh);

    /**
     * 新增
     *
     * @param basicKhyh basicKhyh
     */
    void createBasicKhyh(BasicKhyh basicKhyh);

    /**
     * 修改
     *
     * @param basicKhyh basicKhyh
     */
    void updateBasicKhyh(BasicKhyh basicKhyh);

    /**
     * 删除
     */
    void deleteBasicKhyh(String[] ids);
}
