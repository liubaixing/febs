package com.febs.system.service.impl;

import com.febs.system.entity.DingTalkDepartment;
import com.febs.system.entity.DingTalkDepartmentExample;
import com.febs.system.mapper.DingTalkDepartmentMapper;
import com.febs.system.service.IDingTalkDepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: DingTalkDepartmentServiceImpl
 * @Description: 钉钉部门
 * @Author:
 * @Date 2020/10/16
 * @Version 1.0
 */
@Service
public class DingTalkDepartmentServiceImpl implements IDingTalkDepartmentService {

    @Resource
    private DingTalkDepartmentMapper departmentMapper;


    @Override
    public DingTalkDepartment getById(Long id) {
        return departmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public List<DingTalkDepartment> getByList(DingTalkDepartment department) {
        DingTalkDepartmentExample example = new DingTalkDepartmentExample();
        return departmentMapper.selectByExample(example);
    }

    @Override
    public void createDepartment(DingTalkDepartment dingTalkDepartment) {
        departmentMapper.insertSelective(dingTalkDepartment);
    }

    @Override
    public void updateDepartment(DingTalkDepartment dingTalkDepartment) {
        departmentMapper.updateByPrimaryKeySelective(dingTalkDepartment);
    }

    @Override
    public void deletedDepartment(Long id) {
        departmentMapper.deleteByPrimaryKey(id);
    }
}
