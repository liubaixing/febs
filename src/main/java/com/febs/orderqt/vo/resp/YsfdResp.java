package com.febs.orderqt.vo.resp;

import com.febs.orderqt.entity.OrderqtYsfd;
import com.febs.orderqt.entity.OrderqtYsfdmx;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class YsfdResp extends OrderqtYsfd {


    @ApiModelProperty("订单类型")
    private String orderType;

    @ApiModelProperty("供应商名称")
    private String gysmc;
    private Long   mxId;
    private Integer sl;
    private Integer kpsl;
    private Integer sksl;
    private Integer tksl;

    private BigDecimal kpje;
    private BigDecimal skje;
    private BigDecimal tkje;

    private List<OrderqtYsfdmx> mxList;

}
