package cc.mrbird.febs.shangpin.service;

import cc.mrbird.febs.shangpin.entity.Shangpin;
import cc.mrbird.febs.shangpin.entity.ShangpinGys;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.shangpin.vo.resp.ShangpinGysResp;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 供应商商品 Service接口
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:05
 */
public interface IShangpinGysService extends IService<ShangpinGys> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param shangpinGys shangpinGys
     * @return IPage<ShangpinGys>
     */
    IPage<ShangpinGys> findShangpinGyss(QueryRequest request, ShangpinGys shangpinGys);

    /**
     * 查询（所有）
     *
     * @param shangpinGys shangpinGys
     * @return List<ShangpinGys>
     */
    List<ShangpinGys> findShangpinGyss(ShangpinGys shangpinGys);

    /**
     * 新增
     *
     * @param shangpinGys shangpinGys
     */
    void createShangpinGys(ShangpinGys shangpinGys);

    /**
     * 修改
     *
     * @param shangpinGys shangpinGys
     */
    void updateShangpinGys(ShangpinGys shangpinGys);

    /**
     * 删除
     */
    void deleteShangpinGys(String[] ids);

    void checkGoods(ShangpinGys shangpinGys);

    void saveImport(List<ShangpinGysResp> data);
}
