package com.febs.purchase.entity;

import java.math.BigDecimal;
import java.util.Date;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 采购退款 Entity
 *
 * @author liubaixing
 * @date 2020-07-07 15:40:18
 */
@Data
@TableName("purchase_cgtk")
public class PurchaseCgtk {

    /**
     * 
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Long id;

    /**
     * 退款单号
     */
    @ApiModelProperty("退款单号")
    @TableField("djbh")
    private String djbh;

    /**
     * 单据日期
     */
    @ApiModelProperty("单据日期")
    @TableField("djrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date djrq;

    /**
     * 供应商 供应商ID
     */
    @TableField("gys_id")
    private Integer gysId;

    /**
     * 退款金额
     */
    @ApiModelProperty("退款金额")
    @TableField("je")
    private BigDecimal je;
    /**
     * 开户银行 开户银行ID
     */
    @TableField("khyh_id")
    private Integer khyhId;

    /**
     * 银行账号
     */
    @ApiModelProperty("银行账号")
    @TableField("yhzh")
    private String yhzh;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
    @TableField("auditor")
    private String auditor;

    /**
     * 审核日期
     */
    @TableField("shrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date shrq;

    /**
     * 退款 0-未退款 1-已退款
     */
    @ApiModelProperty("退款 0-未退款 1-已退款")
    @TableField("tk")
    private Byte tk;

    /**
     * 退款人
     */
    @ApiModelProperty("退款人")
    @TableField("tkr")
    private String tkr;

    /**
     * 退款日期
     */
    @TableField("tkrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date tkrq;

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
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
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
