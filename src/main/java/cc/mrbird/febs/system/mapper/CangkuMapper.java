package cc.mrbird.febs.system.mapper;

import cc.mrbird.febs.system.entity.Cangku;
import cc.mrbird.febs.system.entity.CangkuExample;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import io.lettuce.core.dynamic.annotation.Param;

import java.util.List;

/**
 * 仓库管理 Mapper
 *
 * @author lbx
 * @date 2020-05-16 19:57:45
 */
public interface CangkuMapper extends BaseMapper<Cangku> {

    long countByExample(CangkuExample example);

    int deleteByExample(CangkuExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Cangku record);

    int insertSelective(Cangku record);

    List<Cangku> selectByExample(CangkuExample example);

    Cangku selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Cangku record, @Param("example") CangkuExample example);

    int updateByExample(@Param("record") Cangku record, @Param("example") CangkuExample example);

    int updateByPrimaryKeySelective(Cangku record);

    int updateByPrimaryKey(Cangku record);
    
}
