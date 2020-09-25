package com.febs.system.controller;

import com.febs.common.entity.FebsResponse;
import com.febs.system.biz.UserPowerBiz;
import com.febs.system.entity.Bumeng;
import com.febs.system.vo.req.UserPowerReq;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: UserAuthController
 * @Description:
 * @Author:
 * @Date 2020/9/25
 * @Version 1.0
 */
@Slf4j
@Validated
@RestController
@RequestMapping("userPower")
public class UserPowerController {

    @Autowired
    private UserPowerBiz userPowerBiz;

    @GetMapping("getUserPower")
    public FebsResponse getUserPower(UserPowerReq req) {
        return new FebsResponse().success().data(userPowerBiz.getUserPower(req));
    }

    @PostMapping("authorization")
    public FebsResponse authorization(UserPowerReq req) {
        userPowerBiz.authorization(req);
        return new FebsResponse().success();
    }

}
