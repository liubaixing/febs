package com.febs.purchase.vo.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@Data
public class CgtkCreateReq {

    @ApiModelProperty("摘要")
    private String bz;

    private List<PurchaseCgtkReq> cgtkList;

}
