package cc.mrbird.febs.basic.service;

import cc.mrbird.febs.basic.entity.BasicLlly;
import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 流量来源 Service接口
 *
 * @author liubaixing
 * @date 2020-05-22 01:40:04
 */
public interface IBasicLllyService extends IService<BasicLlly> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param basicLlly basicLlly
     * @return IPage<BasicLlly>
     */
    IPage<BasicLlly> findBasicLllys(QueryRequest request, BasicLlly basicLlly);

    /**
     * 查询（所有）
     *
     * @param basicLlly basicLlly
     * @return List<BasicLlly>
     */
    List<BasicLlly> findBasicLllys(BasicLlly basicLlly);

    /**
     * 新增
     *
     * @param basicLlly basicLlly
     */
    void createBasicLlly(BasicLlly basicLlly);

    /**
     * 修改
     *
     * @param basicLlly basicLlly
     */
    void updateBasicLlly(BasicLlly basicLlly);

    /**
     * 删除
     */
    void deleteBasicLlly(String[] ids);
}
