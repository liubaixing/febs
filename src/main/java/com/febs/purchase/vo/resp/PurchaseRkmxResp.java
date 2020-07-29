package com.febs.purchase.vo.resp;

import com.febs.purchase.entity.PurchaseRkmx;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class PurchaseRkmxResp extends PurchaseRkmx {

    @ApiModelProperty("商品代码")
    private String spdm;
    @ApiModelProperty("商品名称")
    private String spmc;
    @ApiModelProperty("商品条码")
    private String memo;

    @ApiModelProperty("计量单位")
    private String jldwmc;

}
