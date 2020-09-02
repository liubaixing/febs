package com.febs.purchase.entity;

import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 入库单明细 Entity
 *
 * @author liubaixing
 * @date 2020-07-07 15:39:15
 */
@Data
@TableName("purchase_rkmx")
public class PurchaseRkmx {

    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * order_ck id
     */
    @TableField("pid")
    private Long pid;

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
     * 单价
     */
    @TableField("dj")
    private BigDecimal dj;
    /**
     * 成本金额
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

    /**
     * 计税价格
     */
    @TableField("jsjg")
    private BigDecimal jsjg;
    /**
     * 计税金额
     */
    @TableField("jishuije")
    private BigDecimal jishuije;
    /**
     * SKU
     */
    @TableField("sku")
    private String sku;

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 0:正常,1:删除(默认0)
     */
    @TableField("deleted")
    private Integer deleted;

    /**
     * 成本金额
     */
    @TableField("cbje")
    private BigDecimal cbje;
}
