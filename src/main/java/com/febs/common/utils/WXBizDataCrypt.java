package com.febs.common.utils;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.Base64Utils;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.spec.AlgorithmParameterSpec;

/**
 * @ClassName: WXBizDataCrypt
 * @Description:
 * @Author:
 * @Date 2020/8/18
 * @Version 1.0
 */
public class WXBizDataCrypt {

    public static void main(String[] args) throws Exception {
        String encryptedData = "X+R9f43eEIi5FTT3rbNihDLcOMPXc9+/8/GW8F1qufCF2JKCKbi4oEXiQyNYKpmK7276R44SFCHm+ze9qhYoXLP4v2d4eCmOb8ndp+Liab0qlWvNYc5C6/0LqbW8zlYmydkJhI56NA6NL/Mb79fRHjjxp1uwU1QcBUZnkWQNWH/zZYZNumSiKy4erd7qvyCB08rsJcPRyv3p6oCj/eo6Hw==";
        String iv = "Gx4eVq80vWIVm8Wz1owAxQ==";
        String sessionKey = "4jp4XS8ONmBMCd9Yc4+0mA==";
        String res = decryptData(encryptedData,iv,sessionKey);
        System.out.println(res);
    }

    public static String decryptData(String encryptedData, String iv,String sessionKey) throws Exception{

        byte[] encrypData = Base64Utils.decodeFromString(encryptedData);
        byte[] ivData = Base64Utils.decodeFromString(iv);
        byte[] key = Base64Utils.decodeFromString(sessionKey);
        String resultString = null;
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(ivData);
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            resultString = new String(cipher.doFinal(encrypData), "UTF-8");
        } catch (Exception e) {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
            cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
            resultString = new String(cipher.doFinal(encrypData), "UTF-8");
        }
        JSONObject object = JSONObject.parseObject(resultString);
        // 拿到手机号码
        String phone = object.getString("phoneNumber");
        return phone;
    }

}
