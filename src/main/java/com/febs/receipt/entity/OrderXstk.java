package com.febs.receipt.entity;

import java.util.Date;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 销售退款 Entity
 *
 * @author liubaixing
 * @date 2020-06-11 14:01:20
 */
@Data
@TableName("order_xstk")
public class OrderXstk {

    /**
     * 
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Long id;

    /**
     * 退款编号
     */
    @ApiModelProperty("退款单号")
    @TableField("djbh")
    private String djbh;

    /**
     * 单据日期
     */
    @ApiModelProperty("单据日期")
    @TableField("djrq")
    private Date djrq;

    /**
     * 购货单位ID 购货单位
     */
    @ApiModelProperty("购货单位ID")
    @TableField("ghdw_id")
    private Integer ghdwId;

    /**
     * 金额
     */
    @ApiModelProperty("退款金额")
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
    private Date qrrq;

    /**
     * 0-未退款 1-已退款
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
    @ApiModelProperty("退款日期")
    @TableField("tkrq")
    private Date tkrq;


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

}
