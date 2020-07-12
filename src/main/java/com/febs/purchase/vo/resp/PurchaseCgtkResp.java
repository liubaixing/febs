package com.febs.purchase.vo.resp;

import com.febs.purchase.entity.PurchaseCgtk;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PurchaseCgtkResp extends PurchaseCgtk {

    @ApiModelProperty("供应商")
    private String gysmc;

    @ApiModelProperty("开户银行")
    private String khyhmc;

    @ApiModelProperty("付款单明细id")
    private Long mxId;

    @ApiModelProperty("原单号")
    private String ydjh;


    @ApiModelProperty("商品代码")
    private String spdm;
    @ApiModelProperty("商品名称")
    private String spmc;
    @ApiModelProperty("商品条码")
    private String memo;

    @ApiModelProperty("计量单位")
    private String jldwmc;

    @ApiModelProperty("退款数量")
    private Integer sl;


    List<PurchaseCgtkmxResp> cgtkmxList;
}
