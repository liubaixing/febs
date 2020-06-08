package com.febs.shangpin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.common.entity.QueryRequest;
import com.febs.shangpin.entity.ShangpinSku;

import java.util.List;

/**
 * 商品SKU Service接口
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:56
 */
public interface IShangpinSkuService extends IService<ShangpinSku> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param shangpinSku shangpinSku
     * @return IPage<ShangpinSku>
     */
    IPage<ShangpinSku> findShangpinSkus(QueryRequest request, ShangpinSku shangpinSku);

    /**
     * 查询（所有）
     *
     * @param shangpinSku shangpinSku
     * @return List<ShangpinSku>
     */
    List<ShangpinSku> findShangpinSkus(ShangpinSku shangpinSku);

    /**
     * 新增
     *
     * @param shangpinSku shangpinSku
     */
    void createShangpinSku(ShangpinSku shangpinSku);

    /**
     * 修改
     *
     * @param shangpinSku shangpinSku
     */
    void updateShangpinSku(ShangpinSku shangpinSku);

    /**
     * 删除
     */
    void deleteShangpinSku(String[] ids);
}
