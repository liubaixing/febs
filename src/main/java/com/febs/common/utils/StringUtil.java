package com.febs.common.utils;

import com.google.common.base.Strings;

public class StringUtil {

    /**
     * 代码字段生成
     *  ： 代码字段为7位字符串，根据主键id充0生成
     * @param id
     * @return
     */
    public static String padStart(Integer id){
        return Strings.padStart(id+"",7, '0');
    }


    /**
     * 代码字段生成
     *  ： 代码字段为7位字符串，根据主键id充0生成
     * @param id
     * @return
     */
    public static String serialStr(Long id){
        return Strings.padStart(id+"",7, '0');
    }


    /**
     * 销售单号生成
     * @param id
     * @return
     */
    public static String padStart(Long id){
        return Strings.padStart(id+"",8, '0');
    }
}
