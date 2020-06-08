package com.febs.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.common.entity.QueryRequest;
import com.febs.system.entity.Gongsi;

import java.util.List;

/**
 * 公司管理 Service接口
 *
 * @author MrBird
 * @date 2020-05-21 22:34:42
 */
public interface IGongsiService extends IService<Gongsi> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param gongsi gongsi
     * @return IPage<Gongsi>
     */
    IPage<Gongsi> findGongsis(QueryRequest request, Gongsi gongsi);

    /**
     * 查询（所有）
     *
     * @param gongsi gongsi
     * @return List<Gongsi>
     */
    List<Gongsi> findGongsis(Gongsi gongsi);

    /**
     * 新增
     *
     * @param gongsi gongsi
     */
    void createGongsi(Gongsi gongsi);

    /**
     * 修改
     *
     * @param gongsi gongsi
     */
    void updateGongsi(Gongsi gongsi);

    /**
     * 删除
     */
    void deleteGongsi(String[] ids);
}
