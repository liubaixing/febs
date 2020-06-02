package cc.mrbird.febs.basic.service;

import cc.mrbird.febs.basic.entity.BasicJldw;
import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 计量单位 Service接口
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:11
 */
public interface IBasicJldwService extends IService<BasicJldw> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param basicJldw basicJldw
     * @return IPage<BasicJldw>
     */
    IPage<BasicJldw> findBasicJldws(QueryRequest request, BasicJldw basicJldw);

    /**
     * 查询（所有）
     *
     * @param basicJldw basicJldw
     * @return List<BasicJldw>
     */
    List<BasicJldw> findBasicJldws(BasicJldw basicJldw);

    /**
     * 新增
     *
     * @param basicJldw basicJldw
     */
    void createBasicJldw(BasicJldw basicJldw);

    /**
     * 修改
     *
     * @param basicJldw basicJldw
     */
    void updateBasicJldw(BasicJldw basicJldw);

    /**
     * 删除
     */
    void deleteBasicJldw(String[] ids);
}
