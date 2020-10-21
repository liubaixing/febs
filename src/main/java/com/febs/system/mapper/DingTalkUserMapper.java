package com.febs.system.mapper;

import com.febs.system.entity.DingTalkUserExample;
import java.util.List;

import com.febs.system.entity.DingTalkUser;
import org.apache.ibatis.annotations.Param;

public interface DingTalkUserMapper {
    long countByExample(DingTalkUserExample example);

    int deleteByExample(DingTalkUserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DingTalkUser record);

    int insertSelective(DingTalkUser record);

    List<DingTalkUser> selectByExample(DingTalkUserExample example);

    DingTalkUser selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DingTalkUser record, @Param("example") DingTalkUserExample example);

    int updateByExample(@Param("record") DingTalkUser record, @Param("example") DingTalkUserExample example);

    int updateByPrimaryKeySelective(DingTalkUser record);

    int updateByPrimaryKey(DingTalkUser record);
}