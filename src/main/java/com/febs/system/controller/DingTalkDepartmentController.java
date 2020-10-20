package com.febs.system.controller;

import com.febs.system.biz.DingTalkDepartmentBiz;
import com.febs.system.entity.DingTalkDepartment;
import com.febs.system.entity.DingTalkUser;
import com.febs.system.service.IDingTalkDepartmentService;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ClassName: DingTalkDepartmentController
 * @Description:
 * @Author:
 * @Date 2020/10/20
 * @Version 1.0
 */
@RestController
@RequestMapping("dingTalkDepartment")
public class DingTalkDepartmentController {

    @Autowired
    private DingTalkDepartmentBiz departmentBiz;
    @Autowired
    private IDingTalkDepartmentService departmentService;

    @GetMapping("/{id}")
    public DingTalkDepartment getUser(@PathVariable Long id){
        return departmentService.getById(id);
    }

    @GetMapping("/list")
    public List<DingTalkDepartment> list(DingTalkDepartment department){
        return departmentService.getByList(department);
    }

    @PostMapping("")
    public void add(DingTalkDepartment department) throws ApiException {
        departmentBiz.add(department);
    }

    @PutMapping("/{id}")
    public void update(@PathVariable Long id,DingTalkDepartment department) throws ApiException {
        departmentBiz.update(id,department);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) throws ApiException {
        departmentBiz.delete(id);
    }

}
