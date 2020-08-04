package com.febs.purchase.vo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CgfpCreateReq {

    @ApiModelProperty("摘要")
    private String bz;

    @ApiModelProperty("供应商")
    private Integer gysId;

    private List<PurchaseCgfpReq> cgfpList;
}
