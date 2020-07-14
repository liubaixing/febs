package com.febs.receipt.vo.req;

import com.febs.receipt.vo.resp.OrderXsResp;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class OrderXsskCreateReq {

    @ApiModelProperty("销售单")
    private List<OrderXsResp> orderXsList;

    @ApiModelProperty("摘要")
    private String bz;

}
