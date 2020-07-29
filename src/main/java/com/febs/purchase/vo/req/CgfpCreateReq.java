package com.febs.purchase.vo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CgfpCreateReq {

    @ApiModelProperty("摘要")
    private String bz;

    private List<PurchaseCgfpReq> cgfpList;
}
