package com.febs.receipt.vo.resp;

import com.febs.receipt.entity.OrderXsfp;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderXsfpResp extends OrderXsfp {


    @ApiModelProperty("发票明细id")
    private Long mxId;
    @ApiModelProperty("原单号")
    private String ydjh;
    @ApiModelProperty("商品id")
    private Integer spId;
    @ApiModelProperty("开票数量")
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

    List<OrderXsfpmxResp> xsfpmxList;
}
