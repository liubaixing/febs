package com.febs.receipt.vo.req;

import com.febs.receipt.vo.resp.OrderXtResp;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class OrderXstkCreateReq {

    @ApiModelProperty("销售单")
    private List<OrderXtResp> orderXtList;

    @ApiModelProperty("摘要")
    private String bz;

}
