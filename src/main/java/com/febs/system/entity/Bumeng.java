package com.febs.system.entity;

import java.util.Date;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 部门管理 Entity
 *
 * @author liubaixing
 * @date 2020-06-14 17:15:53
 */
@Data
@TableName("system_bumeng")
public class Bumeng {

    /**
     * 
     */
    @ExcelIgnore
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 部门代码
     */
    @ExcelIgnore
    @TableField("bmdm")
    private String bmdm;

    /**
     * 部门名称
     */
    @ExcelProperty(value = "部门名称",index = 0)
    @TableField("bmmc")
    private String bmmc;

    /**
     * 所属公司 System_gongsi表id
     */
    @ExcelIgnore
    @TableField("gs_id")
    private Integer gsId;


    @ExcelProperty(value = "所属公司",index = 1)
    private String gsmc;

    /**
     * 负责人联系电话
     */
    @ExcelProperty(value = "负责人联系电话",index = 2)
    @TableField("tel")
    private String tel;

    /**
     * 部门负责人
     */
    @ExcelProperty(value = "部门负责人",index = 3)
    @TableField("contact")
    private String contact;

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
    @ExcelIgnore
    @TableField("status")
    private Integer status;

    /**
     * 创建时间
     */
    @ExcelIgnore
    @TableField("create_time")
    private Date createTime;

    /**
     * 修改时间
     */
    @ExcelIgnore
    @TableField("update_time")
    private Date updateTime;

    /**
     * 0:正常,1:删除(默认0)
     */
    @ExcelIgnore
    @TableField("deleted")
    private Integer deleted;

}
