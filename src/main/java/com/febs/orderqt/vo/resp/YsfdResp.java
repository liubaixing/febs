package com.febs.orderqt.vo.resp;

import com.febs.orderqt.entity.OrderqtYsfd;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class YsfdResp extends OrderqtYsfd {


    @ApiModelProperty("订单类型")
    private String orderType;
}
