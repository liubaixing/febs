package com.febs.dingtalk;

import com.dingtalk.api.DefaultDingTalkClient;
import com.dingtalk.api.request.OapiGettokenRequest;
import com.dingtalk.api.response.OapiGettokenResponse;
import com.febs.common.utils.DingTalkUtil;
import com.taobao.api.ApiException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName: DingtalkClient
 * @Description:
 * @Author:
 * @Date 2020/10/13
 * @Version 1.0
 */
@RestController
public class DingTalkClient {

    @Autowired
    private DingTalkUtil dingTalkUtil;

    @GetMapping("")
    public String getToken() throws ApiException {
        return dingTalkUtil.getDingTalkAccessToken();
    }

}
