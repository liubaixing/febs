package com.febs.receipt.entity;

import java.util.Date;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 销售单明细 Entity
 *
 * @author liubaixing
 * @date 2020-06-11 13:59:06
 */
@Data
@TableName("order_xsmx")
public class OrderXsmx {

    /**
     * 
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Long id;

    /**
     * order_xs id
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
     * 计划数
     */
    @ApiModelProperty("计划数")
    @TableField("jhsl")
    private Integer jhsl;

    /**
     * 通知数
     */
    @ApiModelProperty("通知数")
    @TableField("tzsl")
    private Integer tzsl;

    /**
     * 出库数
     */
    @ApiModelProperty("出库数")
    @TableField("cksl")
    private Integer cksl;

    /**
     * 单价
     */
    @ApiModelProperty("单价")
    @TableField("dj")
    private BigDecimal dj;
    /**
     * 金额
     */
    @ApiModelProperty("金额")
    @TableField("je")
    private BigDecimal je;
    /**
     * 平台折扣
     */
    @ApiModelProperty("平台折扣")
    @TableField("zk")
    private BigDecimal zk;
    /**
     * 销售净额
     */
    @ApiModelProperty("销售净额")
    @TableField("xsje")
    private BigDecimal xsje;

    /**
     * 开票数量
     */
    private Integer kpsl;

    /**
     * 收款数量
     */
    private Integer sksl;

    /**
     * 退款数量
     */
    private Integer tksl;

    /**
     * 销退数量
     */
    private Integer xtsl;

    /**
     * 开票金额
     */
    private BigDecimal kpje;

    /**
     * 收款金额
     */
    private BigDecimal skje;

    /**
     * 退款金额
     */
    private BigDecimal tkje;

    /**
     * 销退金额
     */
    private BigDecimal xtje;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
