package com.febs.system.biz;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.dingtalk.api.request.OapiUserCreateRequest;
import com.dingtalk.api.response.OapiUserCreateResponse;
import com.dingtalk.api.response.OapiUserGetResponse;
import com.febs.common.enums.dingtalk.DingTalkEnum;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.BeanUtils;
import com.febs.common.utils.DingTalkUtil;
import com.febs.system.entity.DingTalkUser;
import com.febs.system.entity.DingTalkUserExample;
import com.febs.system.entity.User;
import com.febs.system.entity.dingtalk.DingTalkUserEntity;
import com.febs.system.mapper.DingTalkUserMapper;
import com.febs.system.service.IDingTalkUserService;
import com.febs.system.service.IUserService;
import com.taobao.api.ApiException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

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
    @Resource
    private DingTalkUserMapper dingTalkUserMapper;
    @Autowired
    private IUserService userService;

    @Autowired
    private DingTalkUtil dingTalkUtil;

    public void add(DingTalkUser dingTalkUser) throws ApiException
    {

        createCheck(dingTalkUser);

        User user = userService.findById(dingTalkUser.getUserId());

        if (user == null)
        {
            throw new FebsException("系统用户不存在");
        }

        DingTalkUserEntity userEntity = BeanUtils.transformFrom(dingTalkUser,DingTalkUserEntity.class);

       String result = dingTalkUtil.execute(DingTalkEnum.USER_CREATE, JSON.toJSONString(userEntity));
       OapiUserCreateResponse response = JSONObject.parseObject(result,OapiUserCreateResponse.class);

       if (response.getErrcode() == 0){

           dingTalkUser.setStaffId(response.getUserid());
           dingTalkUserService.createUser(dingTalkUser);
       }

       throw new FebsException("钉钉用户添加失败");

    }

    public void update(Long id, DingTalkUser user) throws ApiException
    {

        DingTalkUser dingTalkUser = dingTalkUserService.getById(id);
        if (dingTalkUser == null){
            throw new FebsException("钉钉用户不存在");
        }

        dingTalkUser.setId(id);

        updateCheck(user);

        if(!dingTalkUser.getMobile().equals(user.getMobile())){
            DingTalkUserExample example = new DingTalkUserExample();
            example.createCriteria().andDeletedEqualTo(0).andMobileEqualTo(user.getMobile());
            if(dingTalkUserMapper.countByExample(example) > 0){
                throw new FebsException("手机号已存在");
            }
        }

        DingTalkUserEntity userEntity = BeanUtils.transformFrom(dingTalkUser,DingTalkUserEntity.class);

        String result = dingTalkUtil.execute(DingTalkEnum.USER_UPDATE, JSON.toJSONString(userEntity));
        OapiUserCreateResponse response = JSONObject.parseObject(result,OapiUserCreateResponse.class);

        if (response.getErrcode() == 0){
            dingTalkUserService.updateUser(dingTalkUser);
        }

        throw new FebsException("钉钉用户添加失败");
    }

    public void delete(Long id) throws ApiException
    {
        DingTalkUser dingTalkUser = dingTalkUserService.getById(id);
        if (dingTalkUser == null){
            throw new FebsException("钉钉用户不存在");
        }

        String result = dingTalkUtil.execute(DingTalkEnum.USER_DELETE, JSON.toJSONString(dingTalkUser.getStaffId()));
        OapiUserGetResponse response = JSONObject.parseObject(result,OapiUserGetResponse.class);

        if (response.getErrcode() != 0){
            throw new FebsException("钉钉用户删除失败");
        }

    }

    private void createCheck(DingTalkUser dingTalkUser)
    {
        if (StringUtils.isBlank(dingTalkUser.getName())) {
            throw new FebsException("用户名不能为空");
        }
        if (StringUtils.isBlank(dingTalkUser.getDepartment())) {
            throw new FebsException("部门不能为空");
        }
        if (StringUtils.isBlank(dingTalkUser.getMobile())) {
            throw new FebsException("手机号不能为空");
        }else {
            DingTalkUserExample example = new DingTalkUserExample();
            example.createCriteria().andDeletedEqualTo(0).andMobileEqualTo(dingTalkUser.getMobile());
            if(dingTalkUserMapper.countByExample(example) > 0){
                throw new FebsException("手机号已存在");
            }
        }
        if(StringUtils.isNotBlank(dingTalkUser.getStaffId())){
            DingTalkUserExample example = new DingTalkUserExample();
            example.createCriteria().andDeletedEqualTo(0).andStaffIdEqualTo(dingTalkUser.getStaffId());
            if (dingTalkUserMapper.countByExample(example) > 0){
                throw new FebsException("钉钉用户名已存在");
            }
        }

    }

    private void updateCheck(DingTalkUser user){
        if (StringUtils.isBlank(user.getStaffId())) {
            throw new FebsException("钉钉id不能为空");
        }
        if (StringUtils.isBlank(user.getName())) {
            throw new FebsException("用户名不能为空");
        }
        if (StringUtils.isBlank(user.getMobile())) {
            throw new FebsException("手机号不能为空");
        }
    }

}
