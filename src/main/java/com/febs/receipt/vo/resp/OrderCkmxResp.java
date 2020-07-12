package com.febs.receipt.vo.resp;

import com.febs.receipt.entity.OrderCkmx;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class OrderCkmxResp extends OrderCkmx {

    @ApiModelProperty("商品代码")
    private String spdm;
    @ApiModelProperty("商品名称")
    private String spmc;
    @ApiModelProperty("商品条码")
    private String memo;

    @ApiModelProperty("计量单位")
    private String jldwmc;


}
