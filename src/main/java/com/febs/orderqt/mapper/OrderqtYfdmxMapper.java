package com.febs.orderqt.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.febs.orderqt.entity.OrderqtYfdmx;
import com.febs.orderqt.entity.OrderqtYfdmxExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 运费单明细 Mapper
 *
 * @author liubaixing
 * @date 2020-07-29 14:14:20
 */
public interface OrderqtYfdmxMapper extends BaseMapper<OrderqtYfdmx> {
    long countByExample(OrderqtYfdmxExample example);

    int deleteByExample(OrderqtYfdmxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderqtYfdmx record);

    int insertSelective(OrderqtYfdmx record);

    List<OrderqtYfdmx> selectByExample(OrderqtYfdmxExample example);

    OrderqtYfdmx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderqtYfdmx record, @Param("example") OrderqtYfdmxExample example);

    int updateByExample(@Param("record") OrderqtYfdmx record, @Param("example") OrderqtYfdmxExample example);

    int updateByPrimaryKeySelective(OrderqtYfdmx record);

    int updateByPrimaryKey(OrderqtYfdmx record);
}
