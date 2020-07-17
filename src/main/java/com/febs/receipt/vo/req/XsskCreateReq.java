package com.febs.receipt.vo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class XsskCreateReq {

    @ApiModelProperty("摘要")
    private String bz;

    @ApiModelProperty("销售收款集合")
    private List<OrderXsskReq> xsskList;


}
