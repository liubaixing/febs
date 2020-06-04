package cc.mrbird.febs.system.mapper;

import cc.mrbird.febs.system.entity.Gongsi;
import cc.mrbird.febs.system.entity.GongsiExample;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 公司管理 Mapper
 *
 * @author lbx
 * @date 2020-05-16 19:58:39
 */
public interface GongsiMapper extends BaseMapper<Gongsi> {

    long countByExample(GongsiExample example);

    int deleteByExample(GongsiExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Gongsi record);

    int insertSelective(Gongsi record);

    List<Gongsi> selectByExample(GongsiExample example);

    Gongsi selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Gongsi record, @Param("example") GongsiExample example);

    int updateByExample(@Param("record") Gongsi record, @Param("example") GongsiExample example);

    int updateByPrimaryKeySelective(Gongsi record);

    int updateByPrimaryKey(Gongsi record);
    
}
