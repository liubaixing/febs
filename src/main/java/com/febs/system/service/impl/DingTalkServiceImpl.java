package com.febs.system.service.impl;

import com.febs.system.entity.DingTalkDepartment;
import com.febs.system.entity.DingTalkUser;
import com.febs.system.service.IDingTalkService;

import java.util.List;

/**
 * @ClassName: DingTalkServiceImpl
 * @Description:
 * @Author:
 * @Date 2020/10/13
 * @Version 1.0
 */
public class DingTalkServiceImpl implements IDingTalkService {
    @Override
    public DingTalkUser createUser(DingTalkUser dingTalkUser) {
        return null;
    }

    @Override
    public DingTalkUser updateUser(DingTalkUser dingTalkUser) {
        return null;
    }

    @Override
    public void deleteUser(String staffId) {

    }

    @Override
    public Integer createDepartment(DingTalkDepartment dingTalkDepartment) {
        return null;
    }

    @Override
    public DingTalkDepartment updateDepartment(DingTalkDepartment dingTalkDepartment) {
        return null;
    }

    @Override
    public void deletedDepartment(List<Integer> ids) {

    }
}
