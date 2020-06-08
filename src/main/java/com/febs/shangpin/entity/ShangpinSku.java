package com.febs.shangpin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品SKU Entity
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:56
 */
@Data
@TableName("shangpin_sku")
public class ShangpinSku {

    /**
     * 
     */
    @TableId(value = "sku_id", type = IdType.AUTO)
    private Integer skuId;

    /**
     * 
     */
    @TableField("sku")
    private String sku;

    /**
     * 
     */
    @TableField("shangpin_id")
    private Integer shangpinId;
    /**
     * 
     */
    @TableField("color_id")
    private Integer colorId;

    /**
     * 
     */
    @TableField("size_id")
    private Integer sizeId;

    /**
     * 
     */
    @TableField("shangpin_spdm")
    private String shangpinSpdm;

    /**
     * 
     */
    @TableField("color_code")
    private String colorCode;

    /**
     * 
     */
    @TableField("size_code")
    private String sizeCode;

    /**
     * 重量(单位KG)
     */
    @TableField("weigh")
    private BigDecimal weigh;
    /**
     * 0:启用 1:停用
     */
    @TableField("status")
    private Byte status;

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
    @TableField("lastchanged")
    private Date lastchanged;

    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;
    @TableField("deleted")
    private Integer deleted;
}
