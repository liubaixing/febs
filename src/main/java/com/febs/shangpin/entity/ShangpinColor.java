package com.febs.shangpin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 商品颜色 Entity
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:53
 */
@Data
@TableName("shangpin_color")
public class ShangpinColor {

    /**
     * 
     */
    @TableId(value = "shangpin_color_id", type = IdType.AUTO)
    private Integer shangpinColorId;

    /**
     * 
     */
    @TableField("shangpin_id")
    private Integer shangpinId;
    /**
     * 
     */
    @TableField("shangpin_spdm")
    private String shangpinSpdm;

    /**
     * 
     */
    @TableField("color_id")
    private Integer colorId;

    /**
     * 
     */
    @TableField("color_name")
    private String colorName;

    /**
     * 
     */
    @TableField("color_code")
    private String colorCode;

    /**
     * 0:启用 1:停用
     */
    @TableField("status")
    private Byte status;

    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;
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
    @TableField("lastchanged")
    private Date lastchanged;

}
