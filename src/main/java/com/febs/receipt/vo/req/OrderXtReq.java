package com.febs.receipt.vo.req;

import com.febs.receipt.entity.OrderXt;
import com.febs.receipt.entity.OrderXtmx;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class OrderXtReq extends OrderXt {

    @ApiModelProperty("下单开始")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    @ApiModelProperty("下单结束")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    @ApiModelProperty("业务员")
    private String userName;

    @ApiModelProperty("部门")
    private String bmmc;

    @ApiModelProperty("客户名称")
    private String khmc;

    @ApiModelProperty("仓库名称")
    private String ckmc;

    @ApiModelProperty("客户来源")
    private String khlymc;

    @ApiModelProperty("流量来源")
    private String lllymc;

    @ApiModelProperty("购货单位")
    private String ptdamc;

    @ApiModelProperty("单据类型")
    private String djlxmc;

    @ApiModelProperty("客户区域")
    private String khqymc;

    @ApiModelProperty("销退单明细id")
    private Long mxId;
    @ApiModelProperty("单价")
    private BigDecimal dj;
    @ApiModelProperty("商品id")
    private Integer spId;
    @ApiModelProperty("商品名称")
    private String spmc;

    @ApiModelProperty("通知数")
    private Integer tzsl;

    @ApiModelProperty("执行方式 0:自发,1:直发")
    private Integer zxfs;

    private List<OrderXtmx> orderXtmxList;

}
