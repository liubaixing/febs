package com.febs.shangpin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.common.entity.QueryRequest;
import com.febs.shangpin.entity.ShangpinGys;
import com.febs.shangpin.vo.resp.ShangpinGysResp;

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
    IPage<ShangpinGysResp> findShangpinGyss(QueryRequest request, ShangpinGysResp shangpinGys);

    /**
     * 查询（所有）
     *
     * @param shangpinGys shangpinGys
     * @return List<ShangpinGys>
     */
    List<ShangpinGysResp> findShangpinGyss(ShangpinGysResp shangpinGys);

    /**
     * 新增
     *
     * @param shangpinGys shangpinGys
     */
    void createShangpinGys(ShangpinGys shangpinGys);

    void excelInsert(ShangpinGysResp shangpinGysResp);

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

    boolean checkGoods(Integer goodsId,boolean check);

}
