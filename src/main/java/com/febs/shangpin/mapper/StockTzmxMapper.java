package com.febs.shangpin.mapper;

import com.febs.shangpin.entity.StockTzmx;
import com.febs.shangpin.entity.StockTzmxExample;
import java.util.List;

import com.febs.shangpin.vo.resp.StockTzmxResp;
import org.apache.ibatis.annotations.Param;

public interface StockTzmxMapper {
    long countByExample(StockTzmxExample example);

    int deleteByExample(StockTzmxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StockTzmx record);

    int insertSelective(StockTzmx record);

    List<StockTzmx> selectByExample(StockTzmxExample example);

    StockTzmx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StockTzmx record, @Param("example") StockTzmxExample example);

    int updateByExample(@Param("record") StockTzmx record, @Param("example") StockTzmxExample example);

    int updateByPrimaryKeySelective(StockTzmx record);

    int updateByPrimaryKey(StockTzmx record);

    List<StockTzmxResp> selectByQuery(StockTzmx stockTzmx);

}