package com.febs.purchase.mapper;

import com.febs.purchase.entity.PurchaseRkmx;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.febs.purchase.entity.PurchaseRkmxExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 入库单明细 Mapper
 *
 * @author liubaixing
 * @date 2020-06-27 19:56:10
 */
public interface PurchaseRkmxMapper extends BaseMapper<PurchaseRkmx> {
    long countByExample(PurchaseRkmxExample example);

    int deleteByExample(PurchaseRkmxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseRkmx record);

    int insertSelective(PurchaseRkmx record);

    List<PurchaseRkmx> selectByExample(PurchaseRkmxExample example);

    PurchaseRkmx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseRkmx record, @Param("example") PurchaseRkmxExample example);

    int updateByExample(@Param("record") PurchaseRkmx record, @Param("example") PurchaseRkmxExample example);

    int updateByPrimaryKeySelective(PurchaseRkmx record);

    int updateByPrimaryKey(PurchaseRkmx record);
}
