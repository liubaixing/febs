package com.febs.system.controller;

import com.febs.system.biz.DingTalkUserBiz;
import com.febs.system.entity.DingTalkUser;
import com.febs.system.service.IDingTalkUserService;
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
@RequestMapping("dingTalk")
public class DingTalkUserController {

    @Autowired
    private DingTalkUserBiz userBiz;
    @Autowired
    private IDingTalkUserService userService;

    @GetMapping("/{id}")
    public DingTalkUser getUser(@PathVariable Long id){
        return userService.getById(id);
    }

    @GetMapping("/list")
    public List<DingTalkUser> list(DingTalkUser user){
        return userService.getByList(user);
    }

    @PostMapping("")
    public void add(DingTalkUser user){
        userBiz.add(user);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,DingTalkUser user){
        userBiz.update(id,user);
    }

    @GetMapping("/{id}")
    public void delete(@PathVariable Long id){
        userBiz.delete(id);
    }

}
