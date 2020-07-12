package com.febs.purchase.vo.resp;

import com.febs.purchase.entity.PurchaseCgfp;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class PurchaseCgfpResp extends PurchaseCgfp {

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

    @ApiModelProperty("开票数量")
    private Integer sl;

    List<PurchaseCgfpmxResp> cgfpmxListl;

}
