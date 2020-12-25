package com.febs.system.service.impl;

import com.febs.system.entity.UserCangku;
import com.febs.system.entity.UserCangkuExample;
import com.febs.system.mapper.UserCangkuMapper;
import com.febs.system.service.IUserCangkuService;
import com.febs.system.vo.req.UserPowerReq;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @ClassName: IUserCangkuServiceImpl
 * @Description:
 * @Author:
 * @Date 2020/9/25
 * @Version 1.0
 */
@Service
public class UserCangkuServiceImpl implements IUserCangkuService {

    @Resource
    private UserCangkuMapper userCangkuMapper;

    @Override
    public UserCangku getByExample(Long id) {
        return userCangkuMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<UserCangku> listByExample(UserCangkuExample example) {
        return userCangkuMapper.selectByExample(example);
    }

    @Override
    public List<Long> getUserCangku(Long userId){
        UserCangkuExample example = new UserCangkuExample();
        example.createCriteria().andUserIdEqualTo(userId);
        List<UserCangku> userCangkuList = listByExample(example);
        return userCangkuList.stream().map(UserCangku::getCangkuId).collect(Collectors.toList());
    }

    @Override
    public void create(UserCangku userCangku) {
        userCangkuMapper.insertSelective(userCangku);
    }

    @Override
    public int insertBacth(List<UserCangku> userCangkuList) {
        return userCangkuMapper.insertBacth(userCangkuList);
    }

    @Override
    public void delete(UserCangkuExample example) {
        userCangkuMapper.deleteByExample(example);
    }

}
