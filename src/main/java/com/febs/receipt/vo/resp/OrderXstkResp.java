package com.febs.receipt.vo.resp;

import com.febs.receipt.entity.OrderXstk;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderXstkResp extends OrderXstk {

    @ApiModelProperty("退款明细id")
    private Long mxId;
    @ApiModelProperty("原单号")
    private String ydjh;
    @ApiModelProperty("商品id")
    private Integer spId;
    @ApiModelProperty("退款数量")
    private Integer sl;
    @ApiModelProperty("购货单位")
    private String ptdamc;
    @ApiModelProperty("商品名称")
    private String spmc;
    @ApiModelProperty("商品代码")
    private String spdm;
    @ApiModelProperty("商品条码")
    private String memo;
    @ApiModelProperty("计量单位")
    private String jldwmc;

}
