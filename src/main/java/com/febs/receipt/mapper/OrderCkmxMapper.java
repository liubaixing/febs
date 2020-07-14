package com.febs.receipt.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.receipt.entity.OrderCkmx;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.febs.receipt.entity.OrderCkmxExample;
import com.febs.receipt.vo.resp.OrderCkmxResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 出库单明细 Mapper
 *
 * @author liubaixing
 * @date 2020-07-03 22:44:06
 */
public interface OrderCkmxMapper extends BaseMapper<OrderCkmx> {

    long countByExample(OrderCkmxExample example);

    int deleteByExample(OrderCkmxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderCkmx record);

    int insertSelective(OrderCkmx record);

    List<OrderCkmx> selectByExample(OrderCkmxExample example);

    OrderCkmx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderCkmx record, @Param("example") OrderCkmxExample example);

    int updateByExample(@Param("record") OrderCkmx record, @Param("example") OrderCkmxExample example);

    int updateByPrimaryKeySelective(OrderCkmx record);

    int updateByPrimaryKey(OrderCkmx record);

    IPage<OrderCkmxResp> selectPageByQuery(Page<OrderCkmx> page,@Param("mx") OrderCkmx req);

    List<OrderCkmxResp> selectByQuery(OrderCkmx orderXsfpmx);

}
