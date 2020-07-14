package com.febs.receipt.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.febs.receipt.entity.OrderXtmx;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.febs.receipt.entity.OrderXtmxExample;
import com.febs.receipt.vo.resp.OrderXtmxResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 销退单明细 Mapper
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:04
 */
public interface OrderXtmxMapper extends BaseMapper<OrderXtmx> {
    long countByExample(OrderXtmxExample example);

    int deleteByExample(OrderXtmxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderXtmx record);

    int insertSelective(OrderXtmx record);

    List<OrderXtmx> selectByExample(OrderXtmxExample example);

    OrderXtmx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderXtmx record, @Param("example") OrderXtmxExample example);

    int updateByExample(@Param("record") OrderXtmx record, @Param("example") OrderXtmxExample example);

    int updateByPrimaryKeySelective(OrderXtmx record);

    int updateByPrimaryKey(OrderXtmx record);

    IPage<OrderXtmxResp> selectPageByQuery(IPage<OrderXtmx> page,@Param("mx") OrderXtmx orderXtmx);

    List<OrderXtmxResp> selectByQuery(OrderXtmx orderXtmx);

}
