package com.febs.orderqt.entity;

import java.math.BigDecimal;
import java.util.Date;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 印刷费单 Entity
 *
 * @author liubaixing
 * @date 2020-07-29 14:14:23
 */
@Data
@TableName("orderqt_ysfd")
public class OrderqtYsfd {

    /**
     * 
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Long id;

    /**
     * 运刷费单编号
     */
    @TableField("djbh")
    private String djbh;

    /**
     * 单据日期
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @TableField("djrq")
    private Date djrq;

    /**
     * 供应商ID 供应商
     */
    @TableField("gys_id")
    private Integer gysId;

    /**
     * 金额
     */
    @TableField("je")
    private BigDecimal je;
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
    private Date zdrq;

    /**
     * 0-未审核 1-已审核
     */
    @TableField("sh")
    private Byte sh;

    /**
     * 审核人
     */
    @TableField("auditor")
    private String auditor;

    /**
     * 审核日期
     */
    @TableField("shrq")
    private Date shrq;

    /**
     * 0-未作废 1-已作废
     */
    @TableField("zf")
    private Byte zf;

    /**
     * 作废
     */
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
