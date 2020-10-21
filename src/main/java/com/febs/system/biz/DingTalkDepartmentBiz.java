package com.febs.system.biz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.response.OapiDepartmentCreateResponse;
import com.dingtalk.api.response.OapiDepartmentGetResponse;
import com.dingtalk.api.response.OapiUserCreateResponse;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.febs.common.enums.dingtalk.DingTalkEnum;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.BeanUtils;
import com.febs.common.utils.DingTalkUtil;
import com.febs.system.entity.DingTalkDepartment;
import com.febs.system.entity.dingtalk.DingTalkDepartmentEntity;
import com.febs.system.entity.dingtalk.DingTalkUserEntity;
import com.febs.system.mapper.DingTalkDepartmentMapper;
import com.febs.system.service.IDingTalkDepartmentService;
import com.febs.system.service.IDingTalkUserService;
import com.taobao.api.ApiException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName: DingTalkDepartmentBiz
 * @Description:
 * @Author:
 * @Date 2020/10/20
 * @Version 1.0
 */
@Service
public class DingTalkDepartmentBiz {

    @Autowired
    private IDingTalkDepartmentService departmentService;
    @Autowired
    private DingTalkUtil dingTalkUtil;

    public void add(DingTalkDepartment department) throws ApiException {

        if (StringUtils.isBlank(department.getName())){
            throw new FebsException("部门名称不能为空");
        }

        if (department.getParentid() == null){
            throw new FebsException("父部门id不能为空");
        }

        DingTalkDepartmentEntity departmentEntity = BeanUtils.transformFrom(department, DingTalkDepartmentEntity.class);

        String result = dingTalkUtil.execute(DingTalkEnum.DEPARTMENT_CREATE, JSON.toJSONString(departmentEntity));
        OapiDepartmentCreateResponse response = JSONObject.parseObject(result,OapiDepartmentCreateResponse.class);

        if (response.getErrcode() == 0){
            department.setId(response.getId());
            departmentService.createDepartment(department);
            return;
        }

        throw new FebsException("钉钉部门添加失败");

    }

    public void update(Long id,DingTalkDepartment department) throws ApiException {

        DingTalkDepartmentEntity departmentEntity = BeanUtils.transformFrom(department, DingTalkDepartmentEntity.class);

        String result = dingTalkUtil.execute(DingTalkEnum.DEPARTMENT_UPDATE, JSON.toJSONString(departmentEntity));
        OapiDepartmentCreateResponse response = JSONObject.parseObject(result,OapiDepartmentCreateResponse.class);

        if (response.getErrcode() == 0){
            department.setId(id);
            departmentService.createDepartment(department);
            return;
        }

        throw new FebsException("钉钉部门修改失败");
    }

    public void delete(Long id) throws ApiException {

        DingTalkDepartment department = departmentService.getById(id);

        if (department == null) {
            throw new FebsException("部门不存在");
        }

        String result = dingTalkUtil.execute(DingTalkEnum.DEPARTMENT_DELETE, JSON.toJSONString(id));
        OapiDepartmentGetResponse response = JSONObject.parseObject(result, OapiDepartmentGetResponse.class);

        if (response.getErrcode() != 0){
            throw new FebsException("钉钉部门删除失败");
        }

    }

}
