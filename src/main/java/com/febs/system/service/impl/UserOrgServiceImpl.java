package com.febs.system.service.impl;

import com.febs.system.entity.UserOrg;
import com.febs.system.entity.UserOrgExample;
import com.febs.system.mapper.UserOrgMapper;
import com.febs.system.service.IUserOrgService;
import com.febs.system.vo.req.UserPowerReq;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: IUserOrgServiceImpl
 * @Description:
 * @Author:
 * @Date 2020/9/25
 * @Version 1.0
 */
@Service
public class UserOrgServiceImpl implements IUserOrgService {

    @Resource
    private UserOrgMapper userOrgMapper;


    @Override
    public List<UserOrg> listByExample(UserOrgExample example) {
        return userOrgMapper.selectByExample(example);
    }

    @Override
    public List<Long> getUserOrg(Long userId) {
        UserOrgExample example = new UserOrgExample();
        example.createCriteria().andUserIdEqualTo(userId);
        example.createCriteria().andUserIdEqualTo(userId);
        List<UserOrg> userOrgList = listByExample(example);
        return userOrgList.stream().map(UserOrg::getOrgId).collect(Collectors.toList());
    }

    @Override
    public void create(UserOrg userOrg) {
        userOrgMapper.insertSelective(userOrg);
    }

    @Override
    public void delete(UserOrgExample example) {
        userOrgMapper.deleteByExample(example);
    }

}
