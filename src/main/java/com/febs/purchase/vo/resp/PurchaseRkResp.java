package com.febs.purchase.vo.resp;

import com.febs.purchase.entity.PurchaseRk;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PurchaseRkResp extends PurchaseRk {

    @ApiModelProperty("入库仓库")
    private String ckmc;

    @ApiModelProperty("客户名称")
    private String khmc;

    @ApiModelProperty("购货单位")
    private String ptdamc;

    @ApiModelProperty("单据类型")
    private String djlxmc;

    @ApiModelProperty("商品代码")
    private String spdm;

    @ApiModelProperty("商品名称")
    private String spmc;

    @ApiModelProperty("商品条码")
    private String memo;

    @ApiModelProperty("计量单位")
    private String jldwmc;

    @ApiModelProperty("成本金额")
    private BigDecimal cbje;

    private Long mxId;

    private List<PurchaseRkmxResp> rkmxlist;
}
