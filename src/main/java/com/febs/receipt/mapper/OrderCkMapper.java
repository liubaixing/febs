package com.febs.receipt.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.receipt.entity.OrderCk;
import com.febs.receipt.entity.OrderCkExample;
import com.febs.receipt.vo.req.OrderCkReq;
import com.febs.receipt.vo.resp.OrderCkResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 出库单 Mapper
 *
 * @author liubaixing
 * @date 2020-07-03 22:44:01
 */
public interface OrderCkMapper extends BaseMapper<OrderCk> {
    long countByExample(OrderCkExample example);

    int deleteByExample(OrderCkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderCk record);

    int insertSelective(OrderCk record);

    List<OrderCk> selectByExample(OrderCkExample example);

    OrderCk selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderCk record, @Param("example") OrderCkExample example);

    int updateByExample(@Param("record") OrderCk record, @Param("example") OrderCkExample example);

    int updateByPrimaryKeySelective(OrderCk record);

    int updateByPrimaryKey(OrderCk record);

    IPage<OrderCkResp> selectPageByQuery(Page<OrderCk> page,@Param("ck") OrderCkReq req);

    List<OrderCkResp> selectByQuery(OrderCkReq req);

}
