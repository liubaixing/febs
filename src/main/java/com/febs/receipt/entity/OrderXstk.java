package com.febs.receipt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 销售退款 Entity
 *
 * @author liubaixing
 * @date 2020-06-02 13:37:38
 */
@Data
@TableName("order_xstk")
public class OrderXstk {

    /**
     * 摘要
     */
    @TableField("bz")
    private String bz;

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
     * 退款编号
     */
    @TableField("djbh")
    private String djbh;

    /**
     * 单据日期
     */
    @TableField("djrq")
    private Integer djrq;

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
     * 附件
     */
    @TableField("fj")
    private String fj;

    /**
     * 购货单位ID 购货单位
     */
    @TableField("ghdw_id")
    private Integer ghdwId;

    /**
     * 
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Long id;

    /**
     * 退款金额
     */
    @TableField("je")
    private BigDecimal je;
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
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

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
    private Integer zfrq;

}