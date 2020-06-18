package com.febs.receipt.vo.req;

import com.febs.receipt.entity.OrderXs;
import com.febs.receipt.entity.OrderXsmx;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderXsReq extends OrderXs {

    @ApiModelProperty("开始时间")
    private Date startTime;

    @ApiModelProperty("结束时间")
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

    @ApiModelProperty("商品代码")
    private String spdm;

    @ApiModelProperty("商品名称")
    private String spmc;

    @ApiModelProperty("商品条码")
    private String memo;

    List<OrderXsmx> orderXsmxList;

}
