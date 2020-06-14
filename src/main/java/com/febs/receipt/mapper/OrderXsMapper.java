package com.febs.receipt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.receipt.entity.OrderXs;
import com.febs.receipt.entity.OrderXsExample;
import com.febs.receipt.vo.req.OrderXsReq;
import com.febs.receipt.vo.resp.OrderXsResp;
import com.febs.shangpin.entity.Shangpin;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 销售单 Mapper
 *
 * @author liubaixing
 * @date 2020-06-11 11:36:56
 */
public interface OrderXsMapper extends BaseMapper<OrderXs> {

    long countByExample(OrderXsExample example);

    int deleteByExample(OrderXsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderXs record);

    int insertSelective(OrderXs record);

    List<OrderXs> selectByExample(OrderXsExample example);

    IPage<OrderXsResp> selectPageByQuery(Page<OrderXs> page, OrderXsReq req);

    OrderXsResp selectOneByQuery(OrderXsReq req);

    OrderXs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderXs record, @Param("example") OrderXsExample example);

    int updateByExample(@Param("record") OrderXs record, @Param("example") OrderXsExample example);

    int updateByPrimaryKeySelective(OrderXs record);

    int updateByPrimaryKey(OrderXs record);


}
