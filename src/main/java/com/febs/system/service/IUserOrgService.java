package com.febs.system.service;

import com.febs.system.entity.UserOrg;
import com.febs.system.entity.UserOrgExample;
import com.febs.system.vo.req.UserPowerReq;

import java.util.List;

/**
 * @ClassName: IUserOrgService
 * @Description:
 * @Author
 * @Date 2020/9/25
 * @Version 1.0
 */
public interface IUserOrgService {

    List<UserOrg> listByExample(UserOrgExample example);

    List<Long> getUserOrg(Long userId);

    void create(UserOrg userOrg);

    int insertBacth(List<UserOrg> userOrgList);

    void delete(UserOrgExample example);

}
