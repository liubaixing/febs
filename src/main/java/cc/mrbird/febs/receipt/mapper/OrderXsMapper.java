package cc.mrbird.febs.receipt.mapper;

import cc.mrbird.febs.receipt.entity.OrderXs;
import cc.mrbird.febs.receipt.entity.OrderXsExample;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 销售单 Mapper
 *
 * @author liubaixing
 * @date 2020-06-02 11:27:56
 */
public interface OrderXsMapper extends BaseMapper<OrderXs> {

    long countByExample(OrderXsExample example);

    int deleteByExample(OrderXsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderXs record);

    int insertSelective(  OrderXs record);

    List<  OrderXs> selectByExample(OrderXsExample example);

      OrderXs selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record")   OrderXs record, @Param("example") OrderXsExample example);

    int updateByExample(@Param("record")   OrderXs record, @Param("example") OrderXsExample example);

    int updateByPrimaryKeySelective(  OrderXs record);

    int updateByPrimaryKey(  OrderXs record);
    
}
