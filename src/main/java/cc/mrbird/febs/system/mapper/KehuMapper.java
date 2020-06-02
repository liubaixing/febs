package cc.mrbird.febs.system.mapper;

import cc.mrbird.febs.system.entity.Kehu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 客户管理 Mapper
 *
 * @author lbx
 * @date 2020-05-16 19:44:24
 */
public interface KehuMapper extends BaseMapper<Kehu> {

    IPage<Kehu> selectDetailPage(Page<Kehu> page, @Param("kehu") Kehu kehu);

    List<Kehu> selectDetail(@Param("kehu") Kehu kehu);

}
