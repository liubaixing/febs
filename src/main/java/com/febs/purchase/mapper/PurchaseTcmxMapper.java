package com.febs.purchase.mapper;

import com.febs.purchase.entity.PurchaseTcmx;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.febs.purchase.entity.PurchaseTcmxExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 退仓单明细 Mapper
 *
 * @author liubaixing
 * @date 2020-06-27 19:55:35
 */
public interface PurchaseTcmxMapper extends BaseMapper<PurchaseTcmx> {
    long countByExample(PurchaseTcmxExample example);

    int deleteByExample(PurchaseTcmxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseTcmx record);

    int insertSelective(PurchaseTcmx record);

    List<PurchaseTcmx> selectByExample(PurchaseTcmxExample example);

    PurchaseTcmx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseTcmx record, @Param("example") PurchaseTcmxExample example);

    int updateByExample(@Param("record") PurchaseTcmx record, @Param("example") PurchaseTcmxExample example);

    int updateByPrimaryKeySelective(PurchaseTcmx record);

    int updateByPrimaryKey(PurchaseTcmx record);
}
