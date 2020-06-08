package com.febs.common.utils;

import com.febs.shangpin.entity.Shangpin;
import com.google.common.collect.Lists;
import org.apache.commons.collections.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapUtil {

    public static HashMap<String,Object> newHashMap(Object ... args){
        String key = null;
        Object value = null;
        Object[] obj = args;
        Integer len = obj.length;
        HashMap<String,Object> map = new HashMap<>(len/2);
        if(args!=null && args.length>0){
            for(int i = 0;i<len;i++){
                if(i%2==0){
                    key = (String) obj[i];
                }else{
                    value = obj[i];
                }
                map.put(key,value);
            }
        }
        return map;
    }


    public static void main(String[] args) {
        long beginMillis = System.currentTimeMillis();

        List<Shangpin> successList = Lists.newArrayList();
        List<Map<String, Object>> errorList = Lists.newArrayList();
        Shangpin sp = new Shangpin();
        sp.setSpdm("测试代码");sp.setSpmc("测试名称1");Shangpin sp1 = new Shangpin();
        sp.setSpdm("测试代码1");sp.setSpmc("测试名称11");Shangpin sp2 = new Shangpin();
        sp.setSpdm("测试代码2");sp.setSpmc("测试名称12");
        successList.addAll(Lists.newArrayList(sp,sp1,sp2));
        HashMap map = newHashMap(
                "data",successList
                ,"haveError", CollectionUtils.isNotEmpty(errorList)
                ,"error", errorList
                ,"timeConsuming",(System.currentTimeMillis() - beginMillis) / 1000L
        );
        System.out.println(map);
    }

}
