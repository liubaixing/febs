package com.febs.receipt.vo.resp;

import com.febs.receipt.entity.OrderCk;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderCkResp extends OrderCk {
    private Long mxId;
    private String ckmc;
    private String khmc;
    private String ptdamc;

    private String djlxmc;
    private String spdm;
    private String spmc;
    private String memo;
    private String jldwmc;
    private BigDecimal cbje;
    private BigDecimal jsjg;
    private BigDecimal jishuije;

}
