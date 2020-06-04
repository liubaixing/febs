package cc.mrbird.febs.shangpin.mapper;

import cc.mrbird.febs.shangpin.entity.ShangpinGys;
import cc.mrbird.febs.shangpin.entity.ShangpinGysExample;
import cc.mrbird.febs.shangpin.vo.resp.ShangpinGysResp;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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


    IPage<ShangpinGys> selectDetailPage(Page<ShangpinGys> page, @Param("sp")ShangpinGys sp);

    List<ShangpinGys> selectDetail(@Param("sp")ShangpinGys sp);

}
