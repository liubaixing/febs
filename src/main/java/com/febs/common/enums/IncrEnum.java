package com.febs.common.enums;

import lombok.Getter;

@Getter
public enum IncrEnum {

    SHANGPIN("SHANGPIN","商品自增key"),
    SHANGPIN_GYS("SHANGPIN_GYS","供应商商品自增key"),
    SHANGPIN_PPGL("SHANGPIN_PPGL","商品品牌管理自增key");
    private String code;
    private String lable;

    private  IncrEnum(String code,String lable){
        this.code = code;
        this.lable = lable;
    }


}
