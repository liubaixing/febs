package com.febs.system.controller;

import com.google.gson.Gson;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

@Slf4j
@RestController
@Api(tags = "七牛云")
@RequestMapping("/qiniu")
public class QiniuController {

    @Value("${qiniu.accessKey}")
    private String accessKey;

    @Value("${qiniu.secretKey}")
    private String secretKey;
    @Value("${qiniu.bucket}")
    private String bucket;

    @ApiOperation("上传")
    @PostMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file){
        Configuration cfg = new Configuration(Region.region2());
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        Response response = null;
        DefaultPutRet set = null;
        try {
            InputStream inputStream = file.getInputStream();
            response = uploadManager.put(inputStream, null, upToken,null,null);
            set = new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
        } catch (Exception e) {
            log.info(e.getMessage());
            return "fail";
        }
        String imgUrl = "http://qaw1abrqx.bkt.clouddn.com/" + set.hash;
        return imgUrl;
    }

}
