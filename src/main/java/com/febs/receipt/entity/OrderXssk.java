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
 * 销售收款 Entity
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:18
 */
@Data
@TableName("order_xssk")
public class OrderXssk {

    /**
     * 
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Long id;

    /**
     * 收款编号
     */
    @ApiModelProperty("收款单号")
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
     * 购货单位ID 购货单位
     */
    @ApiModelProperty("购货单位ID")
    @TableField("ghdw_id")
    private Integer ghdwId;

    /**
     * 收款金额
     */
    @ApiModelProperty("收款金额")
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
    @ApiModelProperty("制单日期")
    @TableField("zdrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date zdrq;

    /**
     * 0-未确认 1-已确认
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
    @ApiModelProperty("确认日期")
    @TableField("qrrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date qrrq;

    /**
     * 0-未收款 1-已收款
     */
    @ApiModelProperty("收款 0-未收款 1-已收款")
    @TableField("sk")
    private Byte sk;

    /**
     * 收款人
     */
    @ApiModelProperty("收款人")
    @TableField("skr")
    private String skr;

    /**
     * 收款日期
     */
    @ApiModelProperty("收款日期")
    @TableField("skrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date skrq;


    /**
     * 0-未审核 1-已审核
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
    @ApiModelProperty("审核日期")
    @TableField("shrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date shrq;

    /**
     * 0-未作废 1-已作废
     */
    @ApiModelProperty("作废 0-未作废 1-已作废")
    @TableField("zf")
    private Byte zf;

    /**
     * 作废
     */
    @ApiModelProperty("作废人")
    @TableField("zfr")
    private String zfr;

    /**
     * 作废日期
     */
    @ApiModelProperty("作废日期")
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

}
