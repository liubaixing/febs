package com.febs.system.mapper;

import com.febs.system.entity.UserCangku;
import com.febs.system.entity.UserCangkuExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserCangkuMapper {
    long countByExample(UserCangkuExample example);

    int deleteByExample(UserCangkuExample example);

    int deleteByPrimaryKey(Long userCangkuId);

    int insert(UserCangku record);

    int insertBacth(List<UserCangku> userCangkuList);

    int insertSelective(UserCangku record);

    List<UserCangku> selectByExample(UserCangkuExample example);

    UserCangku selectByPrimaryKey(Long userCangkuId);

    int updateByExampleSelective(@Param("record") UserCangku record, @Param("example") UserCangkuExample example);

    int updateByExample(@Param("record") UserCangku record, @Param("example") UserCangkuExample example);

    int updateByPrimaryKeySelective(UserCangku record);

    int updateByPrimaryKey(UserCangku record);
}