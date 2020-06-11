package com.febs.receipt.mapper;

import com.febs.receipt.entity.OrderXt;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.febs.receipt.entity.OrderXtExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 销退单 Mapper
 *
 * @author liubaixing
 * @date 2020-06-11 11:46:11
 */
public interface OrderXtMapper extends BaseMapper<OrderXt> {

    long countByExample(OrderXtExample example);

    int deleteByExample(OrderXtExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderXt record);

    int insertSelective(OrderXt record);

    List<OrderXt> selectByExample(OrderXtExample example);

    OrderXt selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderXt record, @Param("example") OrderXtExample example);

    int updateByExample(@Param("record") OrderXt record, @Param("example") OrderXtExample example);

    int updateByPrimaryKeySelective(OrderXt record);

    int updateByPrimaryKey(OrderXt record);

}
