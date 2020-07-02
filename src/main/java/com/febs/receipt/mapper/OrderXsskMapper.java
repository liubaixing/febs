package com.febs.receipt.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.receipt.entity.OrderXsfp;
import com.febs.receipt.entity.OrderXssk;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.febs.receipt.entity.OrderXsskExample;
import com.febs.receipt.vo.req.OrderXsfpReq;
import com.febs.receipt.vo.req.OrderXsskReq;
import com.febs.receipt.vo.resp.OrderXsfpResp;
import com.febs.receipt.vo.resp.OrderXsskResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 销售收款 Mapper
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:18
 */
public interface OrderXsskMapper extends BaseMapper<OrderXssk> {
    long countByExample(OrderXsskExample example);

    int deleteByExample(OrderXsskExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderXssk record);

    int insertSelective(OrderXssk record);

    List<OrderXssk> selectByExample(OrderXsskExample example);

    OrderXssk selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderXssk record, @Param("example") OrderXsskExample example);

    int updateByExample(@Param("record") OrderXssk record, @Param("example") OrderXsskExample example);

    int updateByPrimaryKeySelective(OrderXssk record);

    int updateByPrimaryKey(OrderXssk record);

    IPage<OrderXsskResp> selectPageByQuery(Page<OrderXssk> page, OrderXsskReq req);
}
