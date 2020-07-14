package com.febs.receipt.vo.req;

import com.febs.receipt.entity.OrderXssk;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class OrderXsskReq extends OrderXssk {

    @ApiModelProperty("单据开始")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    @ApiModelProperty("单据结束")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    @ApiModelProperty("购货单位")
    private String ptdamc;

    @ApiModelProperty("商品名称")
    private String spmc;

    @ApiModelProperty("收款单明细")
    List<OrderXsmxReq> orderXsmxeList;

}
