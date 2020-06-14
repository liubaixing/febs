package com.febs.common.enums.order;

import lombok.Getter;

@Getter
public enum  OrderStatusEnum {

    CONFIRM("CONFIRM","确认"),
    CHECK("CHECK","审核"),
    EXECUTION("EXECUTE","执行");

    private String status;

    private String remark;

    private OrderStatusEnum(String status, String remark) {
        this.status = status;
        this.remark = remark;
    }
}
