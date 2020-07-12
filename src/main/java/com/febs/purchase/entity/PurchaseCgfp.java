package com.febs.purchase.entity;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 采购发票 Entity
 *
 * @author liubaixing
 * @date 2020-07-07 15:40:19
 */
@Data
@TableName("purchase_cgfp")
public class PurchaseCgfp {

    /**
     * 
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Long id;

    /**
     * 采购开票单号
     */
    @ApiModelProperty("采购开票单号")
    @TableField("djbh")
    private String djbh;

    /**
     * 单据日期
     */
    @ApiModelProperty("单据日期")
    @TableField("djrq")
    private Date djrq;

    /**
     * 供应商 供应商ID
     */
    @TableField("gys_id")
    private Integer gysId;

    /**
     * 开户银行 开户银行ID
     */
    @TableField("khyh_id")
    private Integer khyhId;

    /**
     * 开票金额
     */
    @ApiModelProperty("开票金额")
    @TableField("je")
    private BigDecimal je;
    /**
     * 摘要
     */
    @ApiModelProperty("摘要")
    @TableField("bz")
    private String bz;

    /**
     * 附件
     */
    @ApiModelProperty("附件")
    @TableField("fj")
    private String fj;

    /**
     * 制单人
     */
    @ApiModelProperty("制单人")
    @TableField("zdr")
    private String zdr;

    /**
     * 制单日期
     */
    @TableField("zdrq")
    private Date zdrq;

    /**
     * 确认 0-未确认 1-已确认
     */
    @ApiModelProperty("确认 0-未确认 1-已确认")
    @TableField("qr")
    private Byte qr;

    /**
     * 确认人
     */
    @ApiModelProperty("确认人")
    @TableField("qrr")
    private String qrr;

    /**
     * 确认日期
     */
    @TableField("qrrq")
    private Date qrrq;

    /**
     * 审核 0-未审核 1-已审核
     */
    @ApiModelProperty("审核 0-未审核 1-已审核")
    @TableField("sh")
    private Byte sh;

    /**
     * 审核人
     */
    @ApiModelProperty("审核人")
    @TableField("shr")
    private String shr;

    /**
     * 审核日期
     */
    @TableField("shrq")
    private Date shrq;

    /**
     * 开票 0-未开票 1-已开票
     */
    @ApiModelProperty("开票 0-未开票 1-已开票")
    @TableField("kp")
    private Byte kp;

    /**
     * 开票人
     */
    @ApiModelProperty("开票人")
    @TableField("kpr")
    private String kpr;

    /**
     * 开票日期
     */
    @TableField("kprq")
    private Date kprq;

    /**
     * 作废 0-未作废 1-已作废
     */
    @ApiModelProperty("作废 0-未作废 1-已作废")
    @TableField("zf")
    private Byte zf;

    /**
     * 作废人
     */
    @ApiModelProperty("作废人")
    @TableField("zfr")
    private String zfr;

    /**
     * 作废日期
     */
    @TableField("zfrq")
    private Date zfrq;

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
