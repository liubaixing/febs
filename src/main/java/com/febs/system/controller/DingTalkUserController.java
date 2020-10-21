package com.febs.system.controller;

import com.febs.common.entity.FebsResponse;
import com.febs.system.biz.DingTalkUserBiz;
import com.febs.system.entity.DingTalkUser;
import com.febs.system.service.IDingTalkUserService;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: DingTalkUserController
 * @Description: 钉钉
 * @Author:
 * @Date 2020/10/16
 * @Version 1.0
 */
@RestController
@RequestMapping("dingTalk/user")
public class DingTalkUserController {

    @Autowired
    private DingTalkUserBiz userBiz;
    @Autowired
    private IDingTalkUserService userService;

    @GetMapping("/{id}")
    public FebsResponse getUser(@PathVariable Long id){
        return new FebsResponse().success().data(userService.getById(id));
    }

    @GetMapping("/list")
    public FebsResponse list(DingTalkUser user){
        return new FebsResponse().success().data(userService.getByList(user));
    }

    @PostMapping("")
    public FebsResponse add(DingTalkUser user) throws ApiException {
        userBiz.add(user);
        return new FebsResponse().success();
    }

    @PutMapping("/{id}")
    public FebsResponse update(@PathVariable Long id,DingTalkUser user) throws ApiException {
        userBiz.update(id,user);
        return new FebsResponse().success();
    }

    @DeleteMapping("/{id}")
    public FebsResponse delete(@PathVariable Long id) throws ApiException {
        userBiz.delete(id);
        return new FebsResponse().success();
    }

}
