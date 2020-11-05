package com.febs.other.mapper;

import java.util.List;

import com.febs.other.entity.Dictionary;
import com.febs.other.entity.DictionaryExample;
import org.apache.ibatis.annotations.Param;

public interface DictionaryMapper {
    long countByExample(DictionaryExample example);

    int deleteByExample(DictionaryExample example);

    int insert(Dictionary record);

    int insertSelective(Dictionary record);

    List<Dictionary> selectByExample(DictionaryExample example);

    int updateByExampleSelective(@Param("record") Dictionary record, @Param("example") DictionaryExample example);

    int updateByExample(@Param("record") Dictionary record, @Param("example") DictionaryExample example);

    void incr();

    Long getXsSerialNumber();

}