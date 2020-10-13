package com.febs.system.service;

import com.febs.system.entity.DingTalkDepartment;
import com.febs.system.entity.DingTalkUser;

import java.util.List;

/**
 * @ClassName: IDingTalkService
 * @Description:
 * @Author
 * @Date 2020/10/13
 * @Version 1.0
 */
public interface IDingTalkService {

     /**
      * 创建钉钉用户
      * @param dingTalkUser
      * @return
      */
     DingTalkUser createUser(DingTalkUser dingTalkUser);
     /**
      * 修改钉钉用户
      * @param dingTalkUser
      * @return
      */
     DingTalkUser updateUser(DingTalkUser dingTalkUser);

     /**
      * 删除钉钉用户
      * @param staffId
      */
     void deleteUser(String staffId);

     /**
      * 创建钉钉部门
      * @param dingTalkDepartment
      * @return
      */
     Integer createDepartment(DingTalkDepartment dingTalkDepartment);
     /**
      * 修改钉钉部门
      * @param dingTalkDepartment
      * @return
      */
     DingTalkDepartment updateDepartment(DingTalkDepartment dingTalkDepartment);

     /**
      * 删除钉钉部门
      * @param ids
      */
     void deletedDepartment(List<Integer> ids);

}
