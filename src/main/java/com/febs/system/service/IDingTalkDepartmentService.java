package com.febs.system.service;

import com.febs.system.entity.DingTalkDepartment;
import com.febs.system.entity.DingTalkUser;

import java.util.List;

/**
 * @ClassName: IDingTalkDepartmentService
 * @Description:
 * @Author
 * @Date 2020/10/16
 * @Version 1.0
 */
public interface IDingTalkDepartmentService {

    DingTalkDepartment getById(Long id);

    List<DingTalkDepartment> getByList(DingTalkDepartment department);

    /**
     * 创建钉钉部门
     * @param dingTalkDepartment
     * @return
     */
    void createDepartment(DingTalkDepartment dingTalkDepartment);
    /**
     * 修改钉钉部门
     * @param dingTalkDepartment
     * @return
     */
    void updateDepartment(DingTalkDepartment dingTalkDepartment);

    /**
     * 删除钉钉部门
     * @param id
     */
    void deletedDepartment(Long id);


}
