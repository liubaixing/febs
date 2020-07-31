package com.febs.orderqt.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.orderqt.entity.OrderqtYsfdmx;
import com.febs.orderqt.entity.OrderqtYsfdmxExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 印刷费单明细 Mapper
 *
 * @author liubaixing
 * @date 2020-07-29 14:14:26
 */
public interface OrderqtYsfdmxMapper extends BaseMapper<OrderqtYsfdmx> {
    long countByExample(OrderqtYsfdmxExample example);

    int deleteByExample(OrderqtYsfdmxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderqtYsfdmx record);

    int insertSelective(OrderqtYsfdmx record);

    List<OrderqtYsfdmx> selectByExample(OrderqtYsfdmxExample example);

    OrderqtYsfdmx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderqtYsfdmx record, @Param("example") OrderqtYsfdmxExample example);

    int updateByExample(@Param("record") OrderqtYsfdmx record, @Param("example") OrderqtYsfdmxExample example);

    int updateByPrimaryKeySelective(OrderqtYsfdmx record);

    int updateByPrimaryKey(OrderqtYsfdmx record);

    IPage<OrderqtYsfdmx> selectPageByQuery(Page<OrderqtYsfdmx> page, @Param("mx") OrderqtYsfdmx req);

    List<OrderqtYsfdmx> selectByQuery(OrderqtYsfdmx req);

}
