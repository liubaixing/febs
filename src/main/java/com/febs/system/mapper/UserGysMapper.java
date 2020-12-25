package com.febs.system.mapper;

import com.febs.system.entity.UserGys;
import com.febs.system.entity.UserGysExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserGysMapper {
    long countByExample(UserGysExample example);

    int deleteByExample(UserGysExample example);

    int deleteByPrimaryKey(Long userGysId);

    int insert(UserGys record);

    int insertBacth(List<UserGys> userGysList);

    int insertSelective(UserGys record);

    List<UserGys> selectByExample(UserGysExample example);

    UserGys selectByPrimaryKey(Long userGysId);

    int updateByExampleSelective(@Param("record") UserGys record, @Param("example") UserGysExample example);

    int updateByExample(@Param("record") UserGys record, @Param("example") UserGysExample example);

    int updateByPrimaryKeySelective(UserGys record);

    int updateByPrimaryKey(UserGys record);
}