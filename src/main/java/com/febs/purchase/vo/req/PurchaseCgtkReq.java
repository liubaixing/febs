package com.febs.purchase.vo.req;

import com.febs.purchase.entity.PurchaseCgtk;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class PurchaseCgtkReq extends PurchaseCgtk {

    @ApiModelProperty("单据开始")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    @ApiModelProperty("单据结束")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    @ApiModelProperty("供应商")
    private String gysmc;

    @ApiModelProperty("商品名称")
    private String spmc;

    @ApiModelProperty("商品id")
    private Integer spId;
    @ApiModelProperty("开票数量")
    private Integer sl;
    @ApiModelProperty("原单号")
    private String ydjh;

}
