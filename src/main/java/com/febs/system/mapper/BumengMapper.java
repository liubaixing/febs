package com.febs.system.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.system.entity.Bumeng;
import com.febs.system.entity.BumengExample;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
 * 部门管理 Mapper
 *
 * @author lbx
 * @date 2020-05-16 19:50:02
 */
public interface BumengMapper extends BaseMapper<Bumeng> {

    long countByExample(BumengExample example);

    int deleteByExample(BumengExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Bumeng record);

    int insertSelective(Bumeng record);

    List<Bumeng> selectByExample(BumengExample example);

    Bumeng selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@org.apache.ibatis.annotations.Param("record") Bumeng record, @org.apache.ibatis.annotations.Param("example") BumengExample example);

    int updateByExample(@org.apache.ibatis.annotations.Param("record") Bumeng record, @org.apache.ibatis.annotations.Param("example") BumengExample example);

    int updateByPrimaryKeySelective(Bumeng record);

    int updateByPrimaryKey(Bumeng record);
    
    IPage<Bumeng> selectPage(Page<Bumeng> page, @Param("ew") Wrapper queryWrapper);


}
