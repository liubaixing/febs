package com.febs.receipt.vo.resp;

import com.febs.receipt.entity.OrderCk;
import com.febs.receipt.entity.OrderCkmx;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderCkResp extends OrderCk {

    @ApiModelProperty("出库单明细id")
    private Long mxId;

    @ApiModelProperty("仓库名称")
    private String ckmc;
    @ApiModelProperty("客户名称")
    private String khmc;
    @ApiModelProperty("购货单位")
    private String ptdamc;

    @ApiModelProperty("单据类型")
    private String djlxmc;
    @ApiModelProperty("商品id")
    private Integer spId;
    @ApiModelProperty("商品代码")
    private String spdm;
    @ApiModelProperty("商品名称")
    private String spmc;
    @ApiModelProperty("商品条码")
    private String memo;
    @ApiModelProperty("计量单位")
    private String jldwmc;
    @ApiModelProperty("成本额")
    private BigDecimal cbje;
    @ApiModelProperty("计税价格")
    private BigDecimal jsjg;
    @ApiModelProperty("计税金额")
    private BigDecimal jishuije;

    List<OrderCkmxResp> ckmxList;

}
