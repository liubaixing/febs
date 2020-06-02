package cc.mrbird.febs.shangpin.service;

import cc.mrbird.febs.shangpin.entity.ShangpinSize;

import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 商品尺码 Service接口
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:46
 */
public interface IShangpinSizeService extends IService<ShangpinSize> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param shangpinSize shangpinSize
     * @return IPage<ShangpinSize>
     */
    IPage<ShangpinSize> findShangpinSizes(QueryRequest request, ShangpinSize shangpinSize);

    /**
     * 查询（所有）
     *
     * @param shangpinSize shangpinSize
     * @return List<ShangpinSize>
     */
    List<ShangpinSize> findShangpinSizes(ShangpinSize shangpinSize);

    /**
     * 新增
     *
     * @param shangpinSize shangpinSize
     */
    void createShangpinSize(ShangpinSize shangpinSize);

    /**
     * 修改
     *
     * @param shangpinSize shangpinSize
     */
    void updateShangpinSize(ShangpinSize shangpinSize);

    /**
     * 删除
     */
    void deleteShangpinSize(String[] ids);
}
