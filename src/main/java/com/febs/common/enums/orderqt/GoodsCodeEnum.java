package com.febs.common.enums.orderqt;

import lombok.Getter;

@Getter
public enum GoodsCodeEnum {

    YF("SP3893","运费单默认商品code"),
    YSF("SP3894","印刷费单默认商品code");
    private String code;
    private String lable;

    GoodsCodeEnum(String code,String lable){
        this.code = code;
        this.lable = lable;
    }

}
