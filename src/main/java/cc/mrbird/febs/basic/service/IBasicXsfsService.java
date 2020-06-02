package cc.mrbird.febs.basic.service;


import cc.mrbird.febs.basic.entity.BasicXsfs;
import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 销售方式 Service接口
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:45
 */
public interface IBasicXsfsService extends IService<BasicXsfs> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param basicXsfs basicXsfs
     * @return IPage<BasicXsfs>
     */
    IPage<BasicXsfs> findBasicXsfss(QueryRequest request, BasicXsfs basicXsfs);

    /**
     * 查询（所有）
     *
     * @param basicXsfs basicXsfs
     * @return List<BasicXsfs>
     */
    List<BasicXsfs> findBasicXsfss(BasicXsfs basicXsfs);

    /**
     * 新增
     *
     * @param basicXsfs basicXsfs
     */
    void createBasicXsfs(BasicXsfs basicXsfs);

    /**
     * 修改
     *
     * @param basicXsfs basicXsfs
     */
    void updateBasicXsfs(BasicXsfs basicXsfs);

    /**
     * 删除
     */
    void deleteBasicXsfs(String[] ids);
}
