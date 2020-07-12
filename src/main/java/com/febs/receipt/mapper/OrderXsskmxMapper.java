package com.febs.receipt.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.receipt.entity.OrderXsskmx;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.febs.receipt.entity.OrderXsskmxExample;
import com.febs.receipt.vo.resp.OrderXsskmxResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 销售收款明细 Mapper
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:11
 */
public interface OrderXsskmxMapper extends BaseMapper<OrderXsskmx> {
    long countByExample(OrderXsskmxExample example);

    int deleteByExample(OrderXsskmxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderXsskmx record);

    int insertSelective(OrderXsskmx record);

    List<OrderXsskmx> selectByExample(OrderXsskmxExample example);

    OrderXsskmx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderXsskmx record, @Param("example") OrderXsskmxExample example);

    int updateByExample(@Param("record") OrderXsskmx record, @Param("example") OrderXsskmxExample example);

    int updateByPrimaryKeySelective(OrderXsskmx record);

    int updateByPrimaryKey(OrderXsskmx record);

    IPage<OrderXsskmxResp> selectPageByQuery(Page<OrderXsskmx> page, OrderXsskmx req);

    List<OrderXsskmxResp> selectByQuery(OrderXsskmx orderXsfpmx);
}
