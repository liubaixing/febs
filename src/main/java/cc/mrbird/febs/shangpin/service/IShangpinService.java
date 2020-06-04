package cc.mrbird.febs.shangpin.service;

import cc.mrbird.febs.shangpin.entity.Shangpin;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.shangpin.vo.resp.ShangpinResp;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 商品 Service接口
 *
 * @author liubaixing
 * @date 2020-05-22 01:06:25
 */
public interface IShangpinService extends IService<Shangpin> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param shangpin shangpin
     * @return IPage<Shangpin>
     */
    IPage<ShangpinResp> findShangpins(QueryRequest request, ShangpinResp shangpin);

    /**
     * 查询（所有）
     *
     * @param shangpin shangpin
     * @return List<Shangpin>
     */
    List<ShangpinResp> findShangpins(ShangpinResp shangpin);

    /**
     * 新增
     *
     * @param shangpin shangpin
     */
    void createShangpin(Shangpin shangpin);

    /**
     * 修改
     *
     * @param shangpin shangpin
     */
    void updateShangpin(Shangpin shangpin);

    /**
     * 删除
     */
    void deleteShangpin(String[] ids);

    void saveImport(List<ShangpinResp> data);
}
