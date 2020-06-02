package cc.mrbird.febs.system.service;

import cc.mrbird.febs.system.entity.Kehu;

import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

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
    IPage<Kehu> findKehus(QueryRequest request, Kehu kehu);

    /**
     * 查询（所有）
     *
     * @param kehu kehu
     * @return List<Kehu>
     */
    List<Kehu> findKehus(Kehu kehu);

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

    /**
     * 删除
     *
     * @param ids ids
     */
    void deleteKehu(String[] ids);
}
