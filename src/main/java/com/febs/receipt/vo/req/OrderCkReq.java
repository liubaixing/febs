package com.febs.receipt.vo.req;

import com.febs.receipt.entity.OrderCk;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderCkReq extends OrderCk {

    @ApiModelProperty("单据开始")
    private Date startTime;
    @ApiModelProperty("单据结束")
    private Date endTime;
    @ApiModelProperty("购货单位")
    private String ptdamc;

    @ApiModelProperty("仓库名称")
    private String ckmc;
    @ApiModelProperty("客户名称")
    private String khmc;

    @ApiModelProperty("商品名称")
    private String spmc;

    List<OrderXsmxReq> orderXsmxeList;

}
