package com.febs.common.enums;

import lombok.Getter;

@Getter
public enum VerifyEnum {

    UNSUBMITTED(0,"未提交"),
    SUBMITTED(1,"已提交"),
    VERIFY(2,"已审核"),
    RETURN(3,"已打回");

    private Integer code;
    private String lable;

    private VerifyEnum(Integer code,String lable){
        this.code = code;
        this.lable = lable;
    }


}
