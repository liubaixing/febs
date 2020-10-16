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
public interface IDingTalkUserService {

     DingTalkUser getById(Long id);

     List<DingTalkUser> getByList(DingTalkUser user);

     /**
      * 创建钉钉用户
      * @param dingTalkUser
      * @return
      */
     void createUser(DingTalkUser dingTalkUser);
     /**
      * 修改钉钉用户
      * @param dingTalkUser
      * @return
      */
     void updateUser(DingTalkUser dingTalkUser);

     /**
      * 删除钉钉用户
      * @param id
      */
     void deleteUser(Long id);



}
