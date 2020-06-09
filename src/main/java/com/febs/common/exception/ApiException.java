package com.febs.common.exception;

import lombok.Data;

/**
 *  系统自定义异常
 */
@Data
public class ApiException extends RuntimeException {

    private String code;
    private String message;

    public ApiException(String code,String message){
        this.code = code;
        this.message = message;
    }

}
