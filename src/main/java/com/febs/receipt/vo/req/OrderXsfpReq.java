package com.febs.receipt.vo.req;

import com.febs.receipt.entity.OrderXsfp;
import com.febs.receipt.entity.OrderXsmx;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class OrderXsfpReq extends OrderXsfp {

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

    @ApiModelProperty("原单号 (销售单号)")
    private String ydjh;

    @ApiModelProperty("商品id")
    private Integer spId;

    @ApiModelProperty("数量")
    private Integer sl;

    @ApiModelProperty("单据类型")
    private String orderType;

}
