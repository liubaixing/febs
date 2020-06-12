package com.febs.receipt.vo.req;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.febs.receipt.entity.OrderXs;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class OrderXsReq extends OrderXs {

    @ApiModelProperty("开始时间")
    @ExcelIgnore
    private Date startTime;

    @ApiModelProperty("结束时间")
    @ExcelIgnore
    private Date endTime;



}
