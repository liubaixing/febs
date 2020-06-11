package com.febs.common.enums;

import lombok.Getter;

@Getter
public enum DeletedEnum {

    NORMAL(0, "正常"),
    DELETED(1, "已删除");

    private Integer code;
    private String label;

    private DeletedEnum(Integer code, String label) {
        this.code = code;
        this.label = label;
    }


}
