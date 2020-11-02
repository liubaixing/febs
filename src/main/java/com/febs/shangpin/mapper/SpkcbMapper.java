package com.febs.shangpin.mapper;

import com.febs.shangpin.entity.Spkcb;
import com.febs.shangpin.entity.SpkcbExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SpkcbMapper {
    long countByExample(SpkcbExample example);

    int deleteByExample(SpkcbExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Spkcb record);

    int insertSelective(Spkcb record);

    List<Spkcb> selectByExample(SpkcbExample example);

    Spkcb selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Spkcb record, @Param("example") SpkcbExample example);

    int updateByExample(@Param("record") Spkcb record, @Param("example") SpkcbExample example);

    int updateByPrimaryKeySelective(Spkcb record);

    int updateByPrimaryKey(Spkcb record);
}