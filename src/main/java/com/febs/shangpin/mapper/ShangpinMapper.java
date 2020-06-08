package com.febs.shangpin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.shangpin.entity.Shangpin;
import com.febs.shangpin.entity.ShangpinExample;
import com.febs.shangpin.vo.resp.ShangpinResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 商品 Mapper
 *
 * @author liubaixing
 * @date 2020-05-22 01:06:25
 */
public interface ShangpinMapper extends BaseMapper<Shangpin> {

    long countByExample(ShangpinExample example);

    int deleteByExample(ShangpinExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Shangpin record);

    int insertSelective(Shangpin record);

    List<Shangpin> selectByExample(ShangpinExample example);

    Shangpin selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Shangpin record, @Param("example") ShangpinExample example);

    int updateByExample(@Param("record") Shangpin record, @Param("example") ShangpinExample example);

    int updateByPrimaryKeySelective(Shangpin record);

    int updateByPrimaryKey(Shangpin record);

    IPage<ShangpinResp> selectDetailPage(Page<Shangpin> page, @Param("sp")ShangpinResp sp);

    List<ShangpinResp> selectDetail(@Param("sp")ShangpinResp sp);

}
