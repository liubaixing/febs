package com.febs.common.enums;

import lombok.Getter;

@Getter
public enum DictionaryEnum {

    XS_SERIAL_NUMBER("XS_SERIAL_NUMBER","销售单流水")
    ;
    private String code;
    private String lable;

    DictionaryEnum(String code,String lable){
        this.code = code;
        this.lable = lable;
    }

}
