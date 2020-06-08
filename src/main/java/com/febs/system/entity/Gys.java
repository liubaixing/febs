package com.febs.system.entity;


import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.febs.common.converter.StatusConverter;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 供应商 Entity
 *
 * @author lbx
 * @date 2020-05-16 19:58:42
 */
@Data
@TableName("system_gys")
public class Gys {

    /**
     * 
     */
    @ExcelIgnore
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 供应商代码
     */
    @ApiModelProperty("供应商代码")
    @ExcelIgnore
    @TableField("gysdm")
    private String gysdm;

    /**
     * 供应商名称
     */
    @ApiModelProperty("供应商名称 （必填）")
    @ExcelProperty(value = "供应商名称",index = 0)
    @NotBlank(message = "{required}")
    @TableField("gysmc")
    private String gysmc;

    /**
     * 联系人
     */
    @ApiModelProperty("联系人")
    @ExcelProperty(value = "联系人",index = 1)
    @TableField("lsr")
    private String lsr;

    /**
     * 联系人电话
     */
    @ApiModelProperty("联系人电话")
    @ExcelProperty(value = "联系人电话",index = 2)
    @TableField("lsrdh")
    private String lsrdh;

    /**
     * 联系人微信
     */
    @ApiModelProperty("联系人微信")
    @ExcelProperty(value = "联系人微信",index = 3)
    @TableField("wx")
    private String wx;

    /**
     * 联系人QQ
     */
    @ApiModelProperty("联系人QQ")
    @ExcelProperty(value = "联系人QQ",index = 4)
    @TableField("qq")
    private String qq;

    /**
     * 行业
     */
    @ApiModelProperty("行业")
    @ExcelProperty(value = "行业",index = 5)
    @TableField("hy")
    private String hy;

    /**
     * 采购负责人 用户表id
     */
    @ApiModelProperty("采购负责人")
    @ExcelIgnore
    @TableField("cgfzr")
    private Long cgfzr;

    @ExcelProperty(value = "采购负责人",index = 6)
    private String cgfzrmc;
    /**
     * 下单负责人 用户表id
     */
    @ApiModelProperty("下单负责人")
    @ExcelIgnore
    @TableField("xdfzr")
    private Long xdfzr;

    @ExcelProperty(value = "下单负责人",index = 7)
    private String xdfzrmc;
    /**
     * 发票类型ID
     */
    @ApiModelProperty("发票类型")
    @ExcelIgnore
    @TableField("fplx_id")
    private Integer fplxId;


    @ExcelProperty(value = "发票类型",index = 8)
    private String fplxmc;

    /**
     * 发票税点ID
     */
    @ApiModelProperty("发票税点")
    @ExcelIgnore
    @TableField("fpsd_id")
    private Integer fpsdId;

    @ExcelProperty(value = "发票税点",index = 9)
    private String fpsdmc;
    /**
     * 是否月结
     */
    @ApiModelProperty("是否月结")
    @ExcelProperty(value = "是否月结",index = 10)
    @TableField("sfyj")
    private String sfyj;

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
    @ExcelProperty(value = "是否启用",index = 11,converter = StatusConverter.class)
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
