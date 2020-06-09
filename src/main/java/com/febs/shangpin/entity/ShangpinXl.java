package com.febs.shangpin.entity;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.febs.common.converter.StatusConverter;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 小类 Entity
 *
 * @author liubaixing1
 * @date 2020-05-22 01:10:54
 */
@Data
@TableName("shangpin_xl")
public class ShangpinXl {

    /**
     * 
     */
    @ExcelIgnore
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 小类代码
     */
    @ExcelIgnore
    @NotBlank(message = "{required}")
    @TableField("xldm")
    private String xldm;

    /**
     * 小类名称
     */
    @ExcelProperty(value = "小类名称",index = 0)
    @NotBlank(message = "{required}")
    @TableField("xlmc")
    private String xlmc;

    /**
     * 备注
     */
    @ExcelIgnore
    @TableField("memo")
    private String memo;

    /**
     * 备用1
     */
    @ExcelIgnore
    @TableField("ex1")
    private String ex1;

    /**
     * 备用2
     */
    @ExcelIgnore
    @TableField("ex2")
    private String ex2;

    /**
     * 备用3
     */
    @ExcelIgnore
    @TableField("ex3")
    private String ex3;

    /**
     * 是否启用 0:启用 1:停用
     */
    @ExcelProperty(value = "是否启用",index = 1,converter = StatusConverter.class)
    @TableField("status")
    private Integer status;

    @ExcelIgnore
    @TableField("create_time")
    private Date createTime;

    @ExcelIgnore
    @TableField("update_time")
    private Date updateTime;

    @ExcelIgnore
    @TableField("deleted")
    private Integer deleted;

}
