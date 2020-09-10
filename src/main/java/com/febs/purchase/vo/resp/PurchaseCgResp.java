package com.febs.purchase.vo.resp;

import com.febs.purchase.entity.PurchaseCg;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PurchaseCgResp extends PurchaseCg {

    @ApiModelProperty("业务员")
    private String userName;
    @ApiModelProperty("部门")
    private String bmmc;
    @ApiModelProperty("供应商")
    private String gysmc;
    @ApiModelProperty("仓库")
    private String ckmc;
    @ApiModelProperty("发票税率")
    private String fpsdmc;
    @ApiModelProperty("发票类型")
    private String fplxmc;
    @ApiModelProperty("单据类型")
    private String djlxmc;
    @ApiModelProperty("采购负责人")
    private String cgfzrmc;
    @ApiModelProperty("下单负责人")
    private String xdfzrmc;
    @ApiModelProperty("采购单明细id")
    private Long mxId;
    @ApiModelProperty("单价")
    private BigDecimal dj;
    @ApiModelProperty("商品Id")
    private Integer spId;
    @ApiModelProperty("商品代码")
    private String spdm;
    @ApiModelProperty("商品名称")
    private String spmc;
    @ApiModelProperty("商品条码")
    private String memo;
    @ApiModelProperty("计量单位")
    private String jldwmc;

    private Integer jhsl;

    @ApiModelProperty("订单类型")
    private String orderType;

    List<PurchaseCgmxResp> cgmxList;


}
