package com.febs.receipt.vo.req;

import com.febs.receipt.entity.OrderXstk;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderXstkReq extends OrderXstk {

    @ApiModelProperty("单据开始")
    private Date startTime;
    @ApiModelProperty("单据结束")
    private Date endTime;
    @ApiModelProperty("购货单位")
    private String ptdamc;

    @ApiModelProperty("商品名称")
    private String spmc;

    List<OrderXsmxReq> orderXsmxeList;

}
