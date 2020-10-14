package com.febs.common.utils;

import com.alibaba.fastjson.JSON;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.request.OapiUserCreateRequest;
import com.dingtalk.api.request.OapiUserUpdateRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.dingtalk.api.response.OapiUserCreateResponse;
import com.febs.common.enums.dingtalk.DingTalkEnum;
import com.febs.common.exception.FebsException;
import com.febs.common.service.RedisService;
import com.febs.system.entity.DingTalkDepartment;
import com.febs.system.entity.DingTalkUser;
import com.taobao.api.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private static final String USER_CREATE_URL = "https://oapi.dingtalk.com/user/create?access_token=ACCESS_TOKEN";
    private static final String USER_UPDATE_URL = "https://oapi.dingtalk.com/user/create?access_token=ACCESS_TOKEN";
    private static final String USER_DELETED_URL = "https://oapi.dingtalk.com/user/create?access_token=ACCESS_TOKEN";
    private static final String DEPARTMENT_CREATE_URL = "https://oapi.dingtalk.com/user/create?access_token=ACCESS_TOKEN";
    private static final String DEPARTMENT_UPDATE_URL = "https://oapi.dingtalk.com/user/create?access_token=ACCESS_TOKEN";
    private static final String DEPARTMENT_DELETED_URL = "https://oapi.dingtalk.com/user/create?access_token=ACCESS_TOKEN";


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

    public Object execute(DingTalkEnum dingTalkEnum,String data) throws ApiException {

        switch (dingTalkEnum)
        {
            case USER_CREATE:
                dingTalkUserApi(USER_CREATE_URL,data);
                break;
            case USER_DELETE:
                dingTalkUserApi(USER_DELETED_URL,data);
                break;
            case USER_UPDATE:
                dingTalkUserApi(USER_UPDATE_URL,data);
                break;
            case DEPARTMENT_CREATE:
                break;
            case DEPARTMENT_DELETE:
                break;
            case DEPARTMENT_UPDATE:
                break;
            default:
                throw new FebsException("");
        }

        return null;
    }


    private OapiUserCreateResponse dingTalkUserApi(String url,String data) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient(url);

        DingTalkUser user = JSON.parseObject(data, DingTalkUser.class);
        OapiUserCreateRequest request = BeanUtils.transformFrom(user,OapiUserCreateRequest.class);
//        OapiUserUpdateRequest
        return client.execute(request, getDingTalkAccessToken());
    }

    private OapiUserCreateResponse dingTalkDepartmentApi(String url,String data) throws ApiException {
        DingTalkClient client = new DefaultDingTalkClient(url);

        DingTalkDepartment department = JSON.parseObject(data, DingTalkDepartment.class);
        OapiUserCreateRequest request = BeanUtils.transformFrom(department,OapiUserCreateRequest.class);
        return client.execute(request, getDingTalkAccessToken());
    }



    public static void main(String[] args) {
        DingTalkUser user = new DingTalkUser();
        user.setStaffId("zhangsan");
        System.out.println(user);
//        user.setUserid("lisi");
//        System.out.println(user);

    }


}
