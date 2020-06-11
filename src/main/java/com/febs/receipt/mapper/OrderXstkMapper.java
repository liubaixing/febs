package com.febs.receipt.mapper;

import com.febs.receipt.entity.OrderXstk;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.febs.receipt.entity.OrderXstkExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 销售退款 Mapper
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:20
 */
public interface OrderXstkMapper extends BaseMapper<OrderXstk> {
    long countByExample(OrderXstkExample example);

    int deleteByExample(OrderXstkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderXstk record);

    int insertSelective(OrderXstk record);

    List<OrderXstk> selectByExample(OrderXstkExample example);

    OrderXstk selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderXstk record, @Param("example") OrderXstkExample example);

    int updateByExample(@Param("record") OrderXstk record, @Param("example") OrderXstkExample example);

    int updateByPrimaryKeySelective(OrderXstk record);

    int updateByPrimaryKey(OrderXstk record);
}
