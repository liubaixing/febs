package com.febs.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.common.entity.QueryRequest;
import com.febs.system.entity.Gys;

import java.util.List;

/**
 * 供应商 Service接口
 *
 * @author MrBird
 * @date 2020-05-22 00:06:57
 */
public interface IGysService extends IService<Gys> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param gys gys
     * @return IPage<Gys>
     */
    IPage<Gys> findGyss(QueryRequest request, Gys gys);

    /**
     * 查询（所有）
     *
     * @param gys gys
     * @return List<Gys>
     */
    List<Gys> findGyss(Gys gys);

    /**
     * 新增
     *
     * @param gys gys
     */
    void createGys(Gys gys);

    /**
     * 修改
     *
     * @param gys gys
     */
    void updateGys(Gys gys);

    void excelInsert(Gys gys);

    /**
     * 删除
     */
    void deleteGys(String[] ids);
}
