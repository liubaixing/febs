package com.febs.shangpin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * stock_tzmx
 * @author 
 */
@Data
public class StockTzmx implements Serializable {
    private Long id;

    /**
     * order_xs id
     */
    private Long pid;

    /**
     * 商品ID
     */
    private Integer spId;

    /**
     * 颜色ID
     */
    private Integer gg1Id;

    /**
     * 尺码ID
     */
    private Integer gg2Id;

    /**
     * 数量
     */
    private Integer sl;

    /**
     * 成本单价
     */
    private BigDecimal dj;

    /**
     * 调整金额
     */
    private BigDecimal je;

    /**
     * 返利金额
     */
    private BigDecimal flje;

    /**
     * 平台折扣
     */
    private BigDecimal zk;

    /**
     * 销售净额
     */
    private BigDecimal xsje;

    /**
     * 备用1
     */
    private String ex1;

    /**
     * 备用2
     */
    private String ex2;

    /**
     * 备用3
     */
    private String ex3;

    /**
     * 计税价格
     */
    private BigDecimal jsjg;

    /**
     * 计税金额
     */
    private BigDecimal jishuije;

    /**
     * SKU
     */
    private String sku;

    private static final long serialVersionUID = 1L;
}