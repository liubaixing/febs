package cc.mrbird.febs.system.service;

import cc.mrbird.febs.system.entity.CommonId;

import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 公共自增id表 Service接口
 *
 * @author liubaixing
 * @date 2020-05-30 22:48:51
 */
public interface ICommonIdService extends IService<CommonId> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param commonId commonId
     * @return IPage<CommonId>
     */
    IPage<CommonId> findCommonIds(QueryRequest request, CommonId commonId);

    /**
     * 查询（所有）
     *
     * @param commonId commonId
     * @return List<CommonId>
     */
    List<CommonId> findCommonIds(CommonId commonId);

    /**
     * 新增
     *
     * @param commonId commonId
     */
    void createCommonId(CommonId commonId);

    /**
     * 修改
     *
     * @param commonId commonId
     */
    void updateCommonId(CommonId commonId);

    /**
     * 删除
     */
    void deleteCommonId(String[] ids);

}
