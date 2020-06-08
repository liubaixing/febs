package com.febs.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.common.entity.QueryRequest;
import com.febs.system.entity.Cangku;

import java.util.List;

/**
 * 仓库管理 Service接口
 *
 * @author MrBird
 * @date 2020-05-22 00:06:45
 */
public interface ICangkuService extends IService<Cangku> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param cangku cangku
     * @return IPage<Cangku>
     */
    IPage<Cangku> findCangkus(QueryRequest request, Cangku cangku);

    /**
     * 查询（所有）
     *
     * @param cangku cangku
     * @return List<Cangku>
     */
    List<Cangku> findCangkus(Cangku cangku);

    /**
     * 新增
     *
     * @param cangku cangku
     */
    void createCangku(Cangku cangku);

    /**
     * 修改
     *
     * @param cangku cangku
     */
    void updateCangku(Cangku cangku);

    void excelInsert(Cangku cangku);

    /**
     * 删除
     */
    void deleteCangku(String[] ids);
}
