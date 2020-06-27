package com.febs.purchase.entity;

import java.math.BigDecimal;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 采购发票明细 Entity
 *
 * @author liubaixing
 * @date 2020-06-27 19:55:24
 */
@Data
@TableName("purchase_cgfpmx")
public class PurchaseCgfpmx {

    /**
     * 
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Long id;

    /**
     * order_cgfp id
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
