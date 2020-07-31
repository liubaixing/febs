package com.febs.orderqt.entity;

import java.math.BigDecimal;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 印刷费单明细 Entity
 *
 * @author liubaixing
 * @date 2020-07-29 14:14:26
 */
@Data
@TableName("orderqt_ysfdmx")
public class OrderqtYsfdmx {

    /**
     * 
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Long id;

    /**
     * orderqt_ysfd id
     */
    @TableField("pid")
    private Long pid;

    /**
     * 原单号
     */
    @TableField("ydjh")
    private String ydjh;

    /**
     * 商品ID
     */
    @TableField("sp_id")
    private Integer spId;

    /**
     * 颜色ID
     */
    @TableField("gg1_id")
    private Integer gg1Id;

    /**
     * 尺码ID
     */
    @TableField("gg2_id")
    private Integer gg2Id;

    /**
     * 数量
     */
    @TableField("sl")
    private Integer sl;

    /**
     * 金额
     */
    @TableField("je")
    private BigDecimal je;

    /**
     * 通知数量
     */
    @TableField("tzsl")
    private Integer tzsl;

    /**
     * 开票数量
     */
    @TableField("kpsl")
    private Integer kpsl;

    /**
     * 付款数量
     */
    @TableField("fksl")
    private Integer fksl;

    /**
     * 退款数量
     */
    @TableField("tksl")
    private Integer tksl;

    /**
     * 开票金额
     */
    @TableField("kpje")
    private BigDecimal kpje;
    /**
     * 付款金额
     */
    @TableField("fkje")
    private BigDecimal fkje;
    /**
     * 退款金额
     */
    @TableField("tkje")
    private BigDecimal tkje;
    /**
     * 备用1
     */
    @TableField("ex1")
    private String ex1;

    /**
     * 备用2
     */
    @TableField("ex2")
    private String ex2;

    /**
     * 备用3
     */
    @TableField("ex3")
    private String ex3;

}
