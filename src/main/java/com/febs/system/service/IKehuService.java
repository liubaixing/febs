package com.febs.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.common.entity.QueryRequest;
import com.febs.system.entity.Kehu;
import com.febs.system.vo.resp.KehuResp;

import java.util.List;

/**
 * 客户管理 Service接口
 *
 * @author lbx
 * @date 2020-05-16 19:44:24
 */
public interface IKehuService extends IService<Kehu> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param kehu kehu
     * @return IPage<Kehu>
     */
    IPage<KehuResp> findKehus(QueryRequest request, KehuResp kehu);

    /**
     * 查询（所有）
     *
     * @param kehu kehu
     * @return List<Kehu>
     */
    List<KehuResp> findKehus(KehuResp kehu);

    /**
     * 新增
     *
     * @param kehu kehu
     */
    void createKehu(Kehu kehu);

    /**
     * 修改
     *
     * @param kehu kehu
     */
    void updateKehu(Kehu kehu);

    void excelInsert(KehuResp kehu);

    /**
     * 删除
     *
     * @param ids ids
     */
    void deleteKehu(String[] ids);
}
