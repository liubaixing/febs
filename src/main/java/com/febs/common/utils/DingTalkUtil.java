package com.febs.common.utils;

import com.alibaba.fastjson.JSON;
import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.DingTalkClient;
import com.dingtalk.api.request.*;
import com.dingtalk.api.response.*;
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

import java.util.*;

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

//    private final RedisService redisService;

    @Value("dingtalk.appkey")
    private String appkey;
    @Value("dingtalk.appsecret")
    private String appsecret;

    private static final String DING_TALK_ACCESS_TOKEN = "DING_TALK_ACCESS_TOKEN";

    /*钉钉接口URL*/
    private static final String ACCESS_TOKEN_URL = "https://oapi.dingtalk.com/gettoken";

    private static final String USER_CREATE_URL = "https://oapi.dingtalk.com/user/create?access_token=ACCESS_TOKEN";
    private static final String USER_UPDATE_URL = "https://oapi.dingtalk.com/user/update?access_token=ACCESS_TOKEN";
    private static final String USER_DELETED_URL = "https://oapi.dingtalk.com/user/delete?access_token=ACCESS_TOKEN&userid=ID";
    private static final String USER_GET_URL = "https://oapi.dingtalk.com/user/get?access_token=ACCESS_TOKEN&userid=ID";

    private static final String DEPARTMENT_CREATE_URL = "https://oapi.dingtalk.com/department/create?access_token=ACCESS_TOKEN";
    private static final String DEPARTMENT_UPDATE_URL = "https://oapi.dingtalk.com/department/update?access_token=ACCESS_TOKEN";
    private static final String DEPARTMENT_DELETED_URL = "https://oapi.dingtalk.com/department/delete?access_token=ACCESS_TOKEN&id=ID";
    private static final String DEPARTMENT_GET_URL = "https://oapi.dingtalk.com/department/get?access_token=ACCESS_TOKEN&id=ID";

    private static final String ACCESS_TOKEN = "9fbdc5cc3acc37468d95da56d67df77a";

    public String getDingTalkAccessToken() throws ApiException {

//        Object accessToken = redisService.get("DING_TALK_ACCESS_TOKEN");
//
//        if (accessToken != null)
//            return accessToken.toString();
//
//        DefaultDingTalkClient client = new DefaultDingTalkClient(ACCESS_TOKEN_URL);
//        OapiGettokenRequest request = new OapiGettokenRequest();
//        request.setAppkey(appkey);
//        request.setAppsecret(appsecret);
//        request.setHttpMethod("GET");
//        OapiGettokenResponse response = client.execute(request);
//        redisService.set(DING_TALK_ACCESS_TOKEN,response.getAccessToken(),7200L);
//        return response.getAccessToken();
        return "";
    }

    public Object execute(DingTalkEnum dingTalkEnum,String data) throws ApiException {
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
                obj = dingTalkDepartmentCreateOrUpdate(DEPARTMENT_UPDATE_URL,data);
                break;
            case DEPARTMENT_UPDATE:
                obj = dingTalkDepartmentCreateOrUpdate(DEPARTMENT_DELETED_URL,data);
                break;
            case DEPARTMENT_GET:
                obj = departmentDeleteOrGet(DEPARTMENT_GET_URL,data);
                break;
            default:
                throw new FebsException("钉钉调用失败");
        }

        return obj;
    }


    private OapiUserCreateResponse dingTalkUserCreateOrUpdate(String url,String data) throws ApiException
    {
//        url = url.replace("ACCESS_TOKEN",getDingTalkAccessToken());
        url = url.replace("ACCESS_TOKEN",ACCESS_TOKEN);

        DingTalkClient client = new DefaultDingTalkClient(url);

        DingTalkUser user = JSON.parseObject(data, DingTalkUser.class);
        OapiUserCreateRequest request = BeanUtils.transformFrom(user,OapiUserCreateRequest.class);
        return client.execute(request);
    }

    private OapiDepartmentCreateResponse dingTalkDepartmentCreateOrUpdate(String url, String data) throws ApiException
    {
//        url = url.replace("ACCESS_TOKEN",getDingTalkAccessToken());
        url = url.replace("ACCESS_TOKEN",ACCESS_TOKEN);

        DingTalkClient client = new DefaultDingTalkClient(url);

        DingTalkDepartment department = JSON.parseObject(data, DingTalkDepartment.class);
        OapiDepartmentCreateRequest request = BeanUtils.transformFrom(department,OapiDepartmentCreateRequest.class);
        return client.execute(request);
    }

    private OapiUserGetResponse userDeleteOrGet(String url, String data) throws ApiException
    {
//        url = url.replace("ACCESS_TOKEN",getDingTalkAccessToken()).replace("ID",data);
        url = url.replace("ACCESS_TOKEN",ACCESS_TOKEN).replace("ID",data);

        DingTalkClient client = new DefaultDingTalkClient(url);
        OapiUserGetRequest request = new OapiUserGetRequest();
        request.setUserid(data);
        OapiUserGetResponse response = client.execute(request,ACCESS_TOKEN);
        return response;
    }


    private OapiDepartmentGetResponse departmentDeleteOrGet(String url, String data) throws ApiException
    {
//        url = url.replace("ACCESS_TOKEN",getDingTalkAccessToken()).replace("ID",data);
        url = url.replace("ACCESS_TOKEN",ACCESS_TOKEN).replace("ID",data);

        DingTalkClient client = new DefaultDingTalkClient(url);
        OapiDepartmentGetRequest request = new OapiDepartmentGetRequest();
//        request.setHttpMethod("GET");
        return client.execute(request);
    }



    public static void main(String[] args) throws ApiException {
        DingTalkUtil dingTalkUtil = new DingTalkUtil();

        DefaultDingTalkClient client = new DefaultDingTalkClient(ACCESS_TOKEN_URL);
        OapiGettokenRequest request = new OapiGettokenRequest();
        request.setAppkey("dingleemfjcnobu98wys");
        request.setAppsecret("yuNTOzAcTvX0XgKhlESc-1Eu78N3uY0A-F5gXmErc2_7MQPU7lO_oN0-0Nb_RKsg");
//        request.setHttpMethod("GET");
        OapiGettokenResponse response = client.execute(request);

        DingTalkUser user = new DingTalkUser();
        user.setStaffId("123456789");
        user.setName("张超");
        user.setDepartment(JSON.toJSONString(Arrays.asList(1,2,3)));
        user.setPosition("普通员工");
        user.setMobile("123456789");
        user.setEmail("15071449236@qq.com");

        String data = JSON.toJSONString(user);

        Object object = dingTalkUtil.execute(DingTalkEnum.USER_CREATE,data);
        System.out.println(JSON.toJSONString(object));
    }


}
