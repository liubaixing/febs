package com.febs.shangpin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

import java.util.Date;

/**
 * 颜色 Entity
 *
 * @author liubaixing
 * @date 2020-05-22 00:59:30
 */
@Data
@TableName("color")
public class Color {

    /**
     * 
     */
    @TableId(value = "color_id", type = IdType.AUTO)
    private Integer colorId;

    /**
     * 
     */
    @TableField("color_code")
    private String colorCode;

    /**
     * 
     */
    @TableField("color_name")
    private String colorName;

    /**
     * 尺码组
     */
    @TableField("color_sort")
    private Integer colorSort;

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

    @ExcelField("创建时间")
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;
    @TableField("deleted")
    private Integer deleted;
}
