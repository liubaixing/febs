package com.febs.common.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {

    ENABLE(0,"启用"),
    DISABLE(1,"停用"),
    UNKNOWN(2,"未知");
    private Integer code;
    private String lable;

    private StatusEnum(Integer code,String lable){
        this.code = code;
        this.lable = lable;
    }


}
