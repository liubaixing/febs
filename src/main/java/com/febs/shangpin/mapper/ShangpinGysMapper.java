package com.febs.shangpin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.shangpin.entity.ShangpinGys;
import com.febs.shangpin.entity.ShangpinGysExample;
import com.febs.shangpin.vo.resp.ShangpinGysResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 供应商商品 Mapper
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:05
 */
public interface ShangpinGysMapper extends BaseMapper<ShangpinGys> {

    long countByExample(ShangpinGysExample example);

    int deleteByExample(ShangpinGysExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ShangpinGys record);

    int insertSelective(ShangpinGys record);

    List<ShangpinGys> selectByExample(ShangpinGysExample example);

    ShangpinGys selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ShangpinGys record, @Param("example") ShangpinGysExample example);

    int updateByExample(@Param("record") ShangpinGys record, @Param("example") ShangpinGysExample example);

    int updateByPrimaryKeySelective(ShangpinGys record);

    int updateByPrimaryKey(ShangpinGys record);


    IPage<ShangpinGysResp> selectDetailPage(Page<ShangpinGysResp> page, @Param("sp")ShangpinGysResp sp);

    List<ShangpinGysResp> selectDetail(@Param("sp")ShangpinGysResp sp);

}
