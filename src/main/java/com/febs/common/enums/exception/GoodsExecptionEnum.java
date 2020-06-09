package com.febs.common.enums.exception;


public enum GoodsExecptionEnum {
    GOODS_NOT_EXIST("500100","商品不存在")
    ;

    private String code;
    private String message;

    GoodsExecptionEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
