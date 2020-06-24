package com.febs.receipt.vo.req;

import com.febs.receipt.entity.OrderXsfp;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class OrderXsfpReq extends OrderXsfp {

    private Date startTime;
    private Date endTime;
    @ApiModelProperty("购货单位")
    private String ptdamc;

    private String spmc;

}
