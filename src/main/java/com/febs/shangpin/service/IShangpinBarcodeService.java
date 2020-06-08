package com.febs.shangpin.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.febs.common.entity.QueryRequest;
import com.febs.shangpin.entity.ShangpinBarcode;

import java.util.List;

/**
 * 商品条码 Service接口
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:50
 */
public interface IShangpinBarcodeService extends IService<ShangpinBarcode> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param shangpinBarcode shangpinBarcode
     * @return IPage<ShangpinBarcode>
     */
    IPage<ShangpinBarcode> findShangpinBarcodes(QueryRequest request, ShangpinBarcode shangpinBarcode);

    /**
     * 查询（所有）
     *
     * @param shangpinBarcode shangpinBarcode
     * @return List<ShangpinBarcode>
     */
    List<ShangpinBarcode> findShangpinBarcodes(ShangpinBarcode shangpinBarcode);

    /**
     * 新增
     *
     * @param shangpinBarcode shangpinBarcode
     */
    void createShangpinBarcode(ShangpinBarcode shangpinBarcode);

    /**
     * 修改
     *
     * @param shangpinBarcode shangpinBarcode
     */
    void updateShangpinBarcode(ShangpinBarcode shangpinBarcode);

    /**
     * 删除
     */
    void deleteShangpinBarcode(String[] ids);
}
