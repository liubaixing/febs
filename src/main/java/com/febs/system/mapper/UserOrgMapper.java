package com.febs.system.mapper;

import com.febs.system.entity.UserOrg;
import com.febs.system.entity.UserOrgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserOrgMapper {
    long countByExample(UserOrgExample example);

    int deleteByExample(UserOrgExample example);

    int deleteByPrimaryKey(Long userOrgId);

    int insert(UserOrg record);

    int insertBacth(List<UserOrg> userOrgList);

    int insertSelective(UserOrg record);

    List<UserOrg> selectByExample(UserOrgExample example);

    UserOrg selectByPrimaryKey(Long userOrgId);

    int updateByExampleSelective(@Param("record") UserOrg record, @Param("example") UserOrgExample example);

    int updateByExample(@Param("record") UserOrg record, @Param("example") UserOrgExample example);

    int updateByPrimaryKeySelective(UserOrg record);

    int updateByPrimaryKey(UserOrg record);
}