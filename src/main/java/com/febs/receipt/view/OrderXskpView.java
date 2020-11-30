package com.febs.receipt.view;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName: OrderXskpView
 * @Description:
 * @Author:
 * @Date 2020/11/26
 * @Version 1.0
 */
@Data
public class OrderXskpView {

    private Long id;
    private Long mxId;
    private Integer spId;

    private String spdm;

    private String spmc;

    private String memo;

    private Integer jhsl;

    private Integer tzsl;

    private Integer cksl;
    private BigDecimal dj;

    private BigDecimal mxje;

    private BigDecimal zk;

    private BigDecimal xsje;
    private Integer xtsl;
    private BigDecimal xtje;

    /*
    cksl: 0
    dj: 0
    djbh: "AY200001"
    #id: "31"
    je: 0
    jhsl: 1
    kpsl: 0
    memo: ""
    #mxId: "39"
    orderType: "xs"
    sksl: 0
    sl: null
    #spId: 10138
    #spdm: "SP000682"
    #spmc: "充电活页笔记本BJB003"
    tksl: 0
    tzsl: 0
    #xsje: 0
    #xtsl: 0
    zk: 1
     */

}
