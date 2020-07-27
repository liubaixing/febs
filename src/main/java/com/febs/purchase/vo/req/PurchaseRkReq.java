package com.febs.purchase.vo.req;

import com.febs.purchase.entity.PurchaseRk;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class PurchaseRkReq extends PurchaseRk {

    @ApiModelProperty("单据开始")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    @ApiModelProperty("单据结束")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    @ApiModelProperty("仓库名称")
    private String ckmc;

    @ApiModelProperty("客户名称")
    private String khmc;

    @ApiModelProperty("购货单位")
    private String ptdamc;

    @ApiModelProperty("商品")
    private String spmc;
}
