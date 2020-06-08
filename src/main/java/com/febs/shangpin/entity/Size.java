package com.febs.shangpin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 尺码 Entity
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:58
 */
@Data
@TableName("size")
public class Size {

    /**
     * 
     */
    @TableId(value = "size_id", type = IdType.AUTO)
    private Integer sizeId;

    /**
     * 
     */
    @TableField("size_code")
    private String sizeCode;

    /**
     * 
     */
    @TableField("size_name")
    private String sizeName;

    /**
     * 尺码组
     */
    @TableField("size_sort")
    private Integer sizeSort;

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

}
