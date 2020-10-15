package com.febs.common.enums.dingtalk;

import lombok.Getter;

@Getter
public enum DingTalkEnum {

    USER_CREATE("创建用户")
    ,USER_UPDATE("修改用户")
    ,USER_DELETE("删除用户")
    ,USER_GET("查看用户")
    ,DEPARTMENT_CREATE("创建部门")
    ,DEPARTMENT_UPDATE("修改部门")
    ,DEPARTMENT_DELETE("删除部门")
    ,DEPARTMENT_GET("查看部门")
    ;

    private String val;

    DingTalkEnum(String val){
        this.val = val;
    }

}
