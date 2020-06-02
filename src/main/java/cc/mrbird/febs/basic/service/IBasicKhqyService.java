package cc.mrbird.febs.basic.service;

import cc.mrbird.febs.basic.entity.BasicKhqy;
import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 客户区域 Service接口
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:58
 */
public interface IBasicKhqyService extends IService<BasicKhqy> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param basicKhqy basicKhqy
     * @return IPage<BasicKhqy>
     */
    IPage<BasicKhqy> findBasicKhqys(QueryRequest request, BasicKhqy basicKhqy);

    /**
     * 查询（所有）
     *
     * @param basicKhqy basicKhqy
     * @return List<BasicKhqy>
     */
    List<BasicKhqy> findBasicKhqys(BasicKhqy basicKhqy);

    /**
     * 新增
     *
     * @param basicKhqy basicKhqy
     */
    void createBasicKhqy(BasicKhqy basicKhqy);

    /**
     * 修改
     *
     * @param basicKhqy basicKhqy
     */
    void updateBasicKhqy(BasicKhqy basicKhqy);

    /**
     * 删除
     */
    void deleteBasicKhqy(String[] ids);
}
