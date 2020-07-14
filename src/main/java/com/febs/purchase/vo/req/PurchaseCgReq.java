package com.febs.purchase.vo.req;

import com.febs.purchase.entity.PurchaseCg;
import com.febs.purchase.entity.PurchaseCgmx;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
public class PurchaseCgReq extends PurchaseCg {

    @ApiModelProperty("下单开始")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    @ApiModelProperty("下单结束")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    @ApiModelProperty("业务员")
    private String userName;
    @ApiModelProperty("部门")
    private String bmmc;
    @ApiModelProperty("供应商")
    private String gysmc;
    @ApiModelProperty("仓库")
    private String ckmc;
    @ApiModelProperty("发票税率")
    private String fpsdmc;
    @ApiModelProperty("发票类型")
    private String fplxmc;
    @ApiModelProperty("单据类型")
    private String djlxmc;
    @ApiModelProperty("采购负责人")
    private String cgfzrmc;
    @ApiModelProperty("下单负责人")
    private String xdfzrmc;
    @ApiModelProperty("采购单明细id")
    private Long mxId;
    @ApiModelProperty("商品名称")
    private String spmc;

    @ApiModelProperty("快递单号")
    private String kuaidiNo;

    @ApiModelProperty("备注信息")
    private String remarkInfo;

    @ApiModelProperty("服务费（运费、印刷费）")
    private BigDecimal serviceFee;

    @ApiModelProperty("明细集合")
    List<PurchaseCgmx> cgmxList;
}
