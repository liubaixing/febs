package com.febs.system.entity;


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
 * 公司管理 Entity
 *
 * @author lbx
 * @date 2020-05-16 19:58:39
 */
@Data
@TableName("system_gongsi")
public class Gongsi {

    /**
     * 
     */
    @ExcelIgnore
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 公司代码
     */
    @ExcelIgnore
    @TableField("gsdm")
    private String gsdm;

    /**
     * 公司名称
     */
    @ExcelProperty(value = "公司名称",index = 0)
    @NotBlank(message = "{required}")
    @TableField("gsmc")
    private String gsmc;

    /**
     * 负责人联系电话
     */
    @ExcelProperty(value = "负责人电话",index = 1)
    @TableField("tel")
    private String tel;

    /**
     * 负责人
     */
    @ExcelProperty(value = "负责人",index = 2)
    @TableField("contact")
    private String contact;

    /**
     * 发货地址
     */
    @ExcelProperty(value = "发货地址",index = 3)
    @TableField("address")
    private String address;

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
    @ExcelProperty(value = "是否启用",index = 4,converter = StatusConverter.class)
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
