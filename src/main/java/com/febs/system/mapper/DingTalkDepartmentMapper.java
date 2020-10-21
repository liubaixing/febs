package com.febs.system.mapper;

import com.febs.system.entity.DingTalkDepartmentExample;
import java.util.List;

import com.febs.system.entity.DingTalkDepartment;
import org.apache.ibatis.annotations.Param;

public interface DingTalkDepartmentMapper {
    long countByExample(DingTalkDepartmentExample example);

    int deleteByExample(DingTalkDepartmentExample example);

    int deleteByPrimaryKey(Long id);

    int insert(DingTalkDepartment record);

    int insertSelective(DingTalkDepartment record);

    List<DingTalkDepartment> selectByExample(DingTalkDepartmentExample example);

    DingTalkDepartment selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") DingTalkDepartment record, @Param("example") DingTalkDepartmentExample example);

    int updateByExample(@Param("record") DingTalkDepartment record, @Param("example") DingTalkDepartmentExample example);

    int updateByPrimaryKeySelective(DingTalkDepartment record);

    int updateByPrimaryKey(DingTalkDepartment record);
}