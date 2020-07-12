package com.febs.purchase.vo.req;

import com.febs.purchase.entity.PurchaseCgfk;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class PurchaseCgfkReq extends PurchaseCgfk {

    @ApiModelProperty("单据开始")
    private Date startTime;

    @ApiModelProperty("单据结束")
    private Date endTime;

    @ApiModelProperty("供应商")
    private String gysmc;

    @ApiModelProperty("商品名称")
    private String spmc;

}
