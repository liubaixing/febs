package com.febs.common.utils;

import com.alibaba.fastjson.JSON;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
import com.febs.common.enums.dingtalk.DingTalkEnum;
import com.febs.common.exception.FebsException;
import com.febs.common.service.RedisService;
import com.febs.system.entity.dingtalk.DingTalkDepartmentEntity;
import com.febs.system.entity.dingtalk.DingTalkUserEntity;
import com.taobao.api.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @ClassName: DingTalkUtil
 * @Description:  钉钉工具类
 * @Author:
 * @Date 2020/10/13
 * @Version 1.0
 */
@Component
@RequiredArgsConstructor
public class DingTalkUtil {

    private final RedisService redisService;

    @Value("dingtalk.appkey")
    private String appkey;
    @Value("dingtalk.appsecret")
    private String appsecret;

    private static final String DING_TALK_ACCESS_TOKEN = "DING_TALK_ACCESS_TOKEN";

    /*钉钉接口URL*/
    private static final String ACCESS_TOKEN_URL = "https://oapi.dingtalk.com/gettoken";

    private static final String USER_CREATE_URL = "https://oapi.dingtalk.com/user/create";
    private static final String USER_UPDATE_URL = "https://oapi.dingtalk.com/user/update";
    private static final String USER_DELETED_URL = "https://oapi.dingtalk.com/user/delete";
    private static final String USER_GET_URL = "https://oapi.dingtalk.com/user/get";

    private static final String DEPARTMENT_CREATE_URL = "https://oapi.dingtalk.com/department/create";
    private static final String DEPARTMENT_UPDATE_URL = "https://oapi.dingtalk.com/department/update";
    private static final String DEPARTMENT_DELETED_URL = "https://oapi.dingtalk.com/department/delete";
    private static final String DEPARTMENT_GET_URL = "https://oapi.dingtalk.com/department/get";

    public String getDingTalkAccessToken() throws ApiException {

        Object accessToken = redisService.get("DING_TALK_ACCESS_TOKEN");

        if (accessToken != null)
            return accessToken.toString();

        DefaultDingTalkClient client = new DefaultDingTalkClient(ACCESS_TOKEN_URL);
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey(appkey);
        request.setAppsecret(appsecret);
        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);
        redisService.set(DING_TALK_ACCESS_TOKEN,response.getAccessToken(),7200L);
        return response.getAccessToken();
    }


    public String execute(DingTalkEnum dingTalkEnum,String data) throws ApiException {
        Object obj = null;
        switch (dingTalkEnum)
        {
            case USER_CREATE:
                obj = dingTalkUserCreateOrUpdate(USER_CREATE_URL,data);
                break;
            case USER_DELETE:
                obj = userDeleteOrGet(USER_DELETED_URL,data);
                break;
            case USER_UPDATE:
                obj = dingTalkUserCreateOrUpdate(USER_UPDATE_URL,data);
                break;
            case USER_GET:
                obj = userDeleteOrGet(USER_GET_URL,data);
                break;
            case DEPARTMENT_CREATE:
                obj = dingTalkDepartmentCreateOrUpdate(DEPARTMENT_CREATE_URL,data);
                break;
            case DEPARTMENT_DELETE:
                obj = departmentDeleteOrGet(DEPARTMENT_DELETED_URL,data);
                break;
            case DEPARTMENT_UPDATE:
                obj = dingTalkDepartmentCreateOrUpdate(DEPARTMENT_UPDATE_URL,data);
                break;
            case DEPARTMENT_GET:
                obj = departmentDeleteOrGet(DEPARTMENT_GET_URL,data);
                break;
            default:
                throw new FebsException("钉钉调用失败");
        }

        return JSON.toJSONString(obj);
    }


    private OapiUserCreateResponse dingTalkUserCreateOrUpdate(String url,String data) throws ApiException
    {
        DingTalkClient client = new DefaultDingTalkClient(url);

        DingTalkUserEntity user = JSON.parseObject(data, DingTalkUserEntity.class);
        OapiUserCreateRequest request = BeanUtils.transformFrom(user,OapiUserCreateRequest.class);
        return client.execute(request,getDingTalkAccessToken());
    }

    private OapiDepartmentCreateResponse dingTalkDepartmentCreateOrUpdate(String url, String data) throws ApiException
    {
        DingTalkClient client = new DefaultDingTalkClient(url);

        DingTalkDepartmentEntity department = JSON.parseObject(data, DingTalkDepartmentEntity.class);
        OapiDepartmentCreateRequest request = BeanUtils.transformFrom(department,OapiDepartmentCreateRequest.class);
        return client.execute(request,getDingTalkAccessToken());
    }

    private OapiUserGetResponse userDeleteOrGet(String url, String data) throws ApiException
    {
        DingTalkClient client = new DefaultDingTalkClient(url);
        OapiUserGetRequest request = new OapiUserGetRequest();
        request.setUserid(data);
        return client.execute(request,getDingTalkAccessToken());
    }


    private OapiDepartmentGetResponse departmentDeleteOrGet(String url, String data) throws ApiException
    {
        DingTalkClient client = new DefaultDingTalkClient(url);
        OapiDepartmentGetRequest request = new OapiDepartmentGetRequest();
        request.setId(data);
        return client.execute(request,getDingTalkAccessToken());
    }



    public static void main(String[] args) throws ApiException {
//        DingTalkUtil dingTalkUtil = new DingTalkUtil();


        /*DingTalkUser user = new DingTalkUser();
        user.setName("张三");
        user.setDepartment(JSON.toJSONString(Arrays.asList(413188010)));
        user.setPosition("普通员工");
        user.setMobile("15071449238");
        user.setEmail("15071449236@qq.com");*/


        /*DingTalkDepartment department = new DingTalkDepartment();
        department.setName("测试部门1");
        department.setParentid("413188010");

        String data = JSON.toJSONString(department);

        Object object = dingTalkUtil.execute(DingTalkEnum.DEPARTMENT_CREATE,data);
        System.out.println(JSON.toJSONString(object));*/


    }

}
