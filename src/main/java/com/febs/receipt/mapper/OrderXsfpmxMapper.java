package com.febs.receipt.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.receipt.entity.OrderXsfpmx;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.febs.receipt.entity.OrderXsfpmxExample;
import com.febs.receipt.vo.resp.OrderXsfpmxResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 销售发票明细 Mapper
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:07
 */
public interface OrderXsfpmxMapper extends BaseMapper<OrderXsfpmx> {
    long countByExample(OrderXsfpmxExample example);

    int deleteByExample(OrderXsfpmxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderXsfpmx record);

    int insertSelective(OrderXsfpmx record);

    List<OrderXsfpmx> selectByExample(OrderXsfpmxExample example);

    OrderXsfpmx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderXsfpmx record, @Param("example") OrderXsfpmxExample example);

    int updateByExample(@Param("record") OrderXsfpmx record, @Param("example") OrderXsfpmxExample example);

    int updateByPrimaryKeySelective(OrderXsfpmx record);

    int updateByPrimaryKey(OrderXsfpmx record);

    IPage<OrderXsfpmxResp> selectPageByQuery(Page<OrderXsfpmx> page,@Param("mx") OrderXsfpmx req);

    List<OrderXsfpmxResp> selectByQuery(OrderXsfpmx orderXsfpmx);
}
