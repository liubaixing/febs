package com.febs.purchase.mapper;

import com.febs.purchase.entity.PurchaseCgfkmx;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.febs.purchase.entity.PurchaseCgfkmxExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 采购付款明细 Mapper
 *
 * @author liubaixing
 * @date 2020-06-27 20:02:41
 */
public interface PurchaseCgfkmxMapper extends BaseMapper<PurchaseCgfkmx> {
    long countByExample(PurchaseCgfkmxExample example);

    int deleteByExample(PurchaseCgfkmxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseCgfkmx record);

    int insertSelective(PurchaseCgfkmx record);

    List<PurchaseCgfkmx> selectByExample(PurchaseCgfkmxExample example);

    PurchaseCgfkmx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseCgfkmx record, @Param("example") PurchaseCgfkmxExample example);

    int updateByExample(@Param("record") PurchaseCgfkmx record, @Param("example") PurchaseCgfkmxExample example);

    int updateByPrimaryKeySelective(PurchaseCgfkmx record);

    int updateByPrimaryKey(PurchaseCgfkmx record);
}
