package com.febs.receipt.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.febs.receipt.entity.OrderXsmx;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.febs.receipt.entity.OrderXsmxExample;
import com.febs.receipt.vo.resp.OrderXsmxResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 销售单明细 Mapper
 *
 * @author liubaixing
 * @date 2020-06-11 13:59:06
 */
public interface OrderXsmxMapper extends BaseMapper<OrderXsmx> {

    long countByExample(OrderXsmxExample example);

    int deleteByExample(OrderXsmxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderXsmx record);

    int insertSelective(OrderXsmx record);

    List<OrderXsmx> selectByExample(OrderXsmxExample example);


    IPage<OrderXsmxResp> selectPageByQuery(IPage<OrderXsmx> page,@Param("mx") OrderXsmx orderXsmx);

    List<OrderXsmxResp> selectByQuery(OrderXsmx orderXsmx);

    OrderXsmx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderXsmx record, @Param("example") OrderXsmxExample example);

    int updateByExample(@Param("record") OrderXsmx record, @Param("example") OrderXsmxExample example);

    int updateByPrimaryKeySelective(OrderXsmx record);

    int updateByPrimaryKey(OrderXsmx record);

}
