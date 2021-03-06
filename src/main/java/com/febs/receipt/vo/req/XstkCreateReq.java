package com.febs.receipt.vo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class XstkCreateReq {

    @ApiModelProperty("摘要")
    private String bz;

    @ApiModelProperty("销售收款集合")
    private List<OrderXstkReq> xstkList;

}
