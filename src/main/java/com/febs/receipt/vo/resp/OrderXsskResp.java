package com.febs.receipt.vo.resp;

import com.febs.receipt.entity.OrderXssk;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderXsskResp extends OrderXssk {

    private Long mxId;
    @ApiModelProperty("单据编号")
    private String ydjh;
    private Integer spId;
    private Integer sl;
    private BigDecimal je;
    private String ptdamc;
    private String spmc;
    private String spdm;
    private String memo;
    private String jldwmc;

}
