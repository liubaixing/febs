package cc.mrbird.febs.system.mapper;

import cc.mrbird.febs.system.entity.Gys;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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

    IPage<Gys> selectDetailPage(Page<Gys> page, @Param("gys")Gys gys);
    List<Gys> selectDetail(@Param("gys")Gys gys);

    @Select("SELECT * FROM system_gys ${ew.customSqlSegment}")
    Gys selectOne(@Param("ew") Wrapper<Gys> queryWrapper);
}
