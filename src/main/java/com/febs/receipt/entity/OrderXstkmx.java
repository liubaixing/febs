package com.febs.receipt.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 销售退款明细 Entity
 *
 * @author liubaixing
 * @date 2020-06-02 13:38:37
 */
@Data
@TableName("order_xstkmx")
public class OrderXstkmx {

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
     * order_xstk id
     */
    @TableField("pid")
    private Long pid;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 原单号
     */
    @TableField("ydjh")
    private String ydjh;

}
