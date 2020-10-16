package com.febs.system.biz;

import com.febs.common.exception.FebsException;
import com.febs.common.utils.DingTalkUtil;
import com.febs.system.entity.DingTalkUser;
import com.febs.system.entity.User;
import com.febs.system.service.IDingTalkUserService;
import com.febs.system.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: DingTalkUserBiz
 * @Description: 钉钉用户逻辑
 * @Author:
 * @Date 2020/10/16
 * @Version 1.0
 */
@Service
public class DingTalkUserBiz {

    @Autowired
    private IDingTalkUserService dingTalkUserService;
    @Autowired
    private IUserService userService;

    @Autowired
    private DingTalkUtil dingTalkUtil;

    public void add(DingTalkUser dingTalkUser) {






    }

    public void update(Long id, DingTalkUser user) {
    }

    public void delete(Long id) {
    }


    private User userCheck(Long userId){

        User user = userService.findById(userId);

        if (user == null)
        {
            throw new FebsException("系统用户不存在");
        }



        return user;
    }

}
