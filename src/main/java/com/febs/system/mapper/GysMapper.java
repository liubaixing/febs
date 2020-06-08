package com.febs.system.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.system.entity.Gys;
import com.febs.system.entity.GysExample;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * 供应商 Mapper
 *
 * @author lbx
 * @date 2020-05-16 19:58:42
 */
public interface GysMapper extends BaseMapper<Gys> {


    long countByExample(GysExample example);

    int deleteByExample(GysExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Gys record);

    int insertSelective(Gys record);

    List<Gys> selectByExample(GysExample example);

    Gys selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Gys record, @Param("example") GysExample example);

    int updateByExample(@Param("record") Gys record, @Param("example") GysExample example);

    int updateByPrimaryKeySelective(Gys record);

    int updateByPrimaryKey(Gys record);
    
    IPage<Gys> selectDetailPage(Page<Gys> page, @Param("gys")Gys gys);
    List<Gys> selectDetail(@Param("gys")Gys gys);

    @Select("SELECT * FROM system_gys ${ew.customSqlSegment}")
    Gys selectOne(@Param("ew") Wrapper<Gys> queryWrapper);
}
