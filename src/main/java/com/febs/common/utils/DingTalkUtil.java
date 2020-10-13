package com.febs.common.utils;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.febs.common.service.RedisService;
import com.taobao.api.ApiException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
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

}
