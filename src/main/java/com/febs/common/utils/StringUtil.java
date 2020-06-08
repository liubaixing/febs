package com.febs.common.utils;

import com.google.common.base.Strings;

public class StringUtil {

    public static String padStart(Integer id){
        return Strings.padStart(id+"",7, '0');
    }

}
