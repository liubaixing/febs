package cc.mrbird.febs.basic.service;

import cc.mrbird.febs.basic.entity.BasicFklx;
import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 付款类型 Service接口
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:34
 */
public interface IBasicFklxService extends IService<BasicFklx> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param basicFklx basicFklx
     * @return IPage<BasicFklx>
     */
    IPage<BasicFklx> findBasicFklxs(QueryRequest request, BasicFklx basicFklx);

    /**
     * 查询（所有）
     *
     * @param basicFklx basicFklx
     * @return List<BasicFklx>
     */
    List<BasicFklx> findBasicFklxs(BasicFklx basicFklx);

    /**
     * 新增
     *
     * @param basicFklx basicFklx
     */
    void createBasicFklx(BasicFklx basicFklx);

    /**
     * 修改
     *
     * @param basicFklx basicFklx
     */
    void updateBasicFklx(BasicFklx basicFklx);

    /**
     * 删除
     */
    void deleteBasicFklx(String[] ids);
}
