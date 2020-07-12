package com.febs.receipt.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.receipt.entity.OrderXstkmx;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.febs.receipt.entity.OrderXstkmxExample;
import com.febs.receipt.vo.resp.OrderXstkmxResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 销售退款明细 Mapper
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:13
 */
public interface OrderXstkmxMapper extends BaseMapper<OrderXstkmx> {
    long countByExample(OrderXstkmxExample example);

    int deleteByExample(OrderXstkmxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderXstkmx record);

    int insertSelective(OrderXstkmx record);

    List<OrderXstkmx> selectByExample(OrderXstkmxExample example);

    OrderXstkmx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderXstkmx record, @Param("example") OrderXstkmxExample example);

    int updateByExample(@Param("record") OrderXstkmx record, @Param("example") OrderXstkmxExample example);

    int updateByPrimaryKeySelective(OrderXstkmx record);

    int updateByPrimaryKey(OrderXstkmx record);

    IPage<OrderXstkmxResp> selectPageByQuery(Page<OrderXstkmx> page, OrderXstkmx req);

    List<OrderXstkmxResp> selectByQuery(OrderXstkmx orderXsfpmx);
}
