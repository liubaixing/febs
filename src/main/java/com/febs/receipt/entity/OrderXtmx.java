package com.febs.receipt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 销退单明细 Entity
 *
 * @author liubaixing
 * @date 2020-06-02 13:38:50
 */
@Data
@TableName("order_xtmx")
public class OrderXtmx {

    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;

    /**
     * 0:正常,1:删除(默认0)
     */
    @TableField("deleted")
    private Integer deleted;

    /**
     * 单价
     */
    @TableField("dj")
    private BigDecimal dj;
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
     * 返利金额
     */
    @TableField("flje")
    private BigDecimal flje;
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
     * 
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Long id;

    /**
     * 金额
     */
    @TableField("je")
    private BigDecimal je;
    /**
     * 计税金额
     */
    @TableField("jishuije")
    private BigDecimal jishuije;
    /**
     * 计税价格
     */
    @TableField("jsjg")
    private BigDecimal jsjg;
    /**
     * order_xt id
     */
    @TableField("pid")
    private Long pid;

    /**
     * SKU
     */
    @TableField("sku")
    private String sku;

    /**
     * 数量
     */
    @TableField("sl")
    private Integer sl;

    /**
     * 商品ID
     */
    @TableField("sp_id")
    private Integer spId;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 销售净额
     */
    @TableField("xsje")
    private BigDecimal xsje;
    /**
     * 平台折扣
     */
    @TableField("zk")
    private BigDecimal zk;
}
