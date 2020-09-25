package com.febs.system.service.impl;

import com.febs.system.entity.UserGys;
import com.febs.system.entity.UserGysExample;
import com.febs.system.mapper.UserGysMapper;
import com.febs.system.service.IUserGysService;
import com.febs.system.vo.req.UserPowerReq;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * @ClassName: IUserGysServiceImpl
 * @Description:
 * @Author:
 * @Date 2020/9/25
 * @Version 1.0
 */
@Service
public class UserGysServiceImpl implements IUserGysService {

    @Resource
    private UserGysMapper userGysMapper;

    @Override
    public List<UserGys> listByExample(UserGysExample example) {
        return userGysMapper.selectByExample(example);
    }

    @Override
    public List<Long> getUserGys(Long userId) {
        UserGysExample example = new UserGysExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<UserGys> userGysList = listByExample(example);
        return userGysList.stream().map(UserGys::getGysId).collect(Collectors.toList());
    }

    @Override
    public void create(UserGys userGys) {
        userGysMapper.insertSelective(userGys);
    }

    @Override
    public void deleted(UserGysExample example) {
        userGysMapper.deleteByExample(example);
    }

}
