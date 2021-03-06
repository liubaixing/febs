package com.febs.orderqt.vo.resp;

import com.febs.orderqt.entity.OrderqtYfd;
import com.febs.orderqt.entity.OrderqtYfdmx;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class YfdResp extends OrderqtYfd {


    @ApiModelProperty("订单类型")
    private String orderType;

    @ApiModelProperty("供应商名称")
    private String gysmc;

    private Integer sl;

    private Long mxId;
    private Integer spId;
    private Integer kpsl;
    private Integer sksl;
    private Integer tksl;

    private BigDecimal kpje;
    private BigDecimal skje;
    private BigDecimal tkje;

    List<OrderqtYfdmx> mxList;

}
