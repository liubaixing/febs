package com.febs.receipt.mapper;

import com.febs.receipt.entity.OrderXsfp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.febs.receipt.entity.OrderXsfpExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 销售发票 Mapper
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:16
 */
public interface OrderXsfpMapper extends BaseMapper<OrderXsfp> {

    long countByExample(OrderXsfpExample example);

    int deleteByExample(OrderXsfpExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderXsfp record);

    int insertSelective(OrderXsfp record);

    List<OrderXsfp> selectByExample(OrderXsfpExample example);

    OrderXsfp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderXsfp record, @Param("example") OrderXsfpExample example);

    int updateByExample(@Param("record") OrderXsfp record, @Param("example") OrderXsfpExample example);

    int updateByPrimaryKeySelective(OrderXsfp record);

    int updateByPrimaryKey(OrderXsfp record);

}
