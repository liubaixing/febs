package com.febs.purchase.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.purchase.entity.PurchaseRk;
import com.febs.purchase.entity.PurchaseRkExample;
import com.febs.purchase.vo.req.PurchaseRkReq;
import com.febs.purchase.vo.resp.PurchaseRkResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 入库单 Mapper
 *
 * @author liubaixing
 * @date 2020-06-27 19:56:08
 */
public interface PurchaseRkMapper extends BaseMapper<PurchaseRk> {
    long countByExample(PurchaseRkExample example);

    int deleteByExample(PurchaseRkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseRk record);

    int insertSelective(PurchaseRk record);

    List<PurchaseRk> selectByExample(PurchaseRkExample example);

    PurchaseRk selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseRk record, @Param("example") PurchaseRkExample example);

    int updateByExample(@Param("record") PurchaseRk record, @Param("example") PurchaseRkExample example);

    int updateByPrimaryKeySelective(PurchaseRk record);

    int updateByPrimaryKey(PurchaseRk record);

    IPage<PurchaseRkResp> selectPageByQuery(Page<PurchaseRk> page, PurchaseRkReq req);

    List<PurchaseRkResp> selectByQuery(PurchaseRkReq req);
}
