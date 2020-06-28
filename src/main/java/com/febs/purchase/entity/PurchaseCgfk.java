package com.febs.purchase.entity;

import java.math.BigDecimal;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 采购付款 Entity
 *
 * @author liubaixing
 * @date 2020-06-27 19:46:20
 */
@Data
@TableName("purchase_cgfk")
public class PurchaseCgfk {

    /**
     * 
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Long id;

    /**
     * 付款编号
     */
    @TableField("djbh")
    private String djbh;

    /**
     * 单据日期
     */
    @TableField("djrq")
    private Integer djrq;

    /**
     * 供应商ID 供应商
     */
    @TableField("gys_id")
    private Integer gysId;

    /**
     * 付款金额
     */
    @TableField("je")
    private BigDecimal je;
    /**
     * 开户银行ID 开户银行
     */
    @TableField("khyh_id")
    private Integer khyhId;

    /**
     * 银行账号
     */
    @TableField("yhzh")
    private String yhzh;

    /**
     * 摘要
     */
    @TableField("bz")
    private String bz;

    /**
     * 附件
     */
    @TableField("fj")
    private String fj;

    /**
     * 制单人
     */
    @TableField("zdr")
    private String zdr;

    /**
     * 制单日期
     */
    @TableField("zdrq")
    private Integer zdrq;

    /**
     * 0-未确认 1-已确认
     */
    @TableField("qr")
    private Byte qr;

    /**
     * 确认人
     */
    @TableField("qrr")
    private String qrr;

    /**
     * 确认日期
     */
    @TableField("qrrq")
    private Integer qrrq;

    /**
     * 0-未审核 1-已审核
     */
    @TableField("sh")
    private Byte sh;

    /**
     * 审核人
     */
    @TableField("shr")
    private String shr;

    /**
     * 审核日期
     */
    @TableField("shrq")
    private Integer shrq;

    /**
     * 0-未付款 1-已付款
     */
    @TableField("fk")
    private Byte fk;

    /**
     * 付款人
     */
    @TableField("fkr")
    private String fkr;

    /**
     * 付款日期
     */
    @TableField("fkrq")
    private Integer fkrq;

    /**
     * 0-未作废 1-已作废
     */
    @TableField("zf")
    private Byte zf;

    /**
     * 作废人
     */
    @TableField("zfr")
    private String zfr;

    /**
     * 作废日期
     */
    @TableField("zfrq")
    private Integer zfrq;

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