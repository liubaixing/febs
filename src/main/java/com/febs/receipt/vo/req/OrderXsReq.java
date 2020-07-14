package com.febs.receipt.vo.req;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.febs.receipt.entity.OrderXs;
import com.febs.receipt.entity.OrderXsmx;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class OrderXsReq extends OrderXs {

    @ApiModelProperty("下单开始")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty("下单结束")
    private Date endTime;

    @ApiModelProperty("业务员")
    private String userName;

    @ApiModelProperty("部门")
    private String bmmc;

    @ApiModelProperty("客户名称")
    private String khmc;

    @ApiModelProperty("发货仓库")
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

    @ApiModelProperty("商品id")
    private Integer spId;

    @ApiModelProperty("商品代码")
    private String spdm;

    @ApiModelProperty("商品名称")
    private String spmc;

    @ApiModelProperty("商品条码")
    private String memo;

    @ApiModelProperty("明细id")
    private Long mxId;

    @ApiModelProperty("通知数")
    private Integer tzsl;

    @ApiModelProperty("执行方式 0:自发,1:自发")
    private Integer zxfs;

    @ApiModelProperty("销售明细list")
    @ExcelIgnore
    List<OrderXsmx> orderXsmxList;

}
