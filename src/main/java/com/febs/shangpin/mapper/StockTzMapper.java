package com.febs.shangpin.mapper;

import com.febs.shangpin.entity.StockTz;
import com.febs.shangpin.entity.StockTzExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StockTzMapper {
    long countByExample(StockTzExample example);

    int deleteByExample(StockTzExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StockTz record);

    int insertSelective(StockTz record);

    List<StockTz> selectByExample(StockTzExample example);

    StockTz selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StockTz record, @Param("example") StockTzExample example);

    int updateByExample(@Param("record") StockTz record, @Param("example") StockTzExample example);

    int updateByPrimaryKeySelective(StockTz record);

    int updateByPrimaryKey(StockTz record);
}