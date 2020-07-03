package com.febs.receipt.vo.req;

import com.febs.receipt.entity.OrderCk;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class OrderCkReq extends OrderCk {

    private Date startTime;
    private Date endTime;
    @ApiModelProperty("购货单位")
    private String ptdamc;
    private String ckmc;
    private String khmc;

    private String spmc;

    List<OrderXsmxReq> orderXsmxeList;

}
