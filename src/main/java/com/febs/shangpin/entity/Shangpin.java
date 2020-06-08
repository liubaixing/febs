package com.febs.shangpin.entity;

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
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 商品 Entity
 *
 * @author liubaixing
 * @date 2020-05-22 01:06:25
 */
@Data
@TableName("shangpin")
public class Shangpin {

    /**
     * 
     */
    @ExcelIgnore
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品代码
     */
    @ApiModelProperty("商品代码")
    @ExcelIgnore
    @TableField("spdm")
    private String spdm;

    /**
     * 商品名称
     */
    @ExcelProperty(value = "商品名称",index = 0)
    @ApiModelProperty("商品名称（必填）")
    @NotBlank(message = "商品名称不能为空")
    @TableField("spmc")
    private String spmc;

    @ExcelProperty(value = "唯一码",index = 7)
    @ApiModelProperty("唯一码")
    private String memo;

    /**
     * 销售价
     */
    @ExcelProperty(value = "销售价",index = 8)
    @ApiModelProperty("销售价")
    @TableField("xsj")
    private BigDecimal xsj;
    /**
     * 吊牌价
     */
    @ExcelProperty(value = "吊牌价",index = 9)
    @ApiModelProperty("吊牌价")
    @TableField("dpj")
    private BigDecimal dpj;
    /**
     * 预售价
     */
    @ExcelProperty(value = "预售价",index = 10)
    @ApiModelProperty("预售价")
    @TableField("ysj")
    private BigDecimal ysj;
    /**
     * 采购价
     */
    @ExcelProperty(value = "采购价",index = 11)
    @ApiModelProperty("采购价（必填）")
    @TableField("cgj")
    private BigDecimal cgj;
    /**
     * 默认供应商 供应商表id
     */
    @ExcelIgnore
    @ApiModelProperty("供应商表id（必填）")
    @NotNull(message = "供应商不能为空")
    @TableField("gys_id")
    private Integer gysId;


    /**
     * 起订量
     */
    @ExcelProperty(value = "起订量",index = 6)
    @ApiModelProperty("起订量（必填）")
    @NotNull(message = "起订量不能为空")
    @TableField("qdl")
    private Integer qdl;

    /**
     * 计量单位 计量单位id
     */
    @ExcelIgnore
    @NotNull(message = "计量单位不能为空")
    @ApiModelProperty("计量单位id（必填）")
    @TableField("jldw_id")
    private Integer jldwId;

    /**
     * 默认供应商图片
     */
    @ExcelIgnore
    @ApiModelProperty("默认供应商图片")
    @TableField("mrtp")
    private String mrtp;

    /**
     * 总类 Shangpin_zl总类id
     */
    @ExcelIgnore
    @ApiModelProperty("总类id（必填）")
    @TableField("zl_id")
    @NotNull(message = "总类不能为空")
    private Integer zlId;


    /**
     * 大类 Shangpin_dl大类id
     */
    @ExcelIgnore
    @ApiModelProperty("大类id（必填）")
    @TableField("dl_id")
    @NotNull(message = "大类不能为空")
    private Integer dlId;


    /**
     * 小类 Shangpin_xl小类id
     */
    @ExcelIgnore
    @ApiModelProperty("小类id（必填）")
    @TableField("xl_id")
    @NotNull(message = "小类不能为空")
    private Integer xlId;


    /**
     * 其他类别 Shangpin_qtlb其他类别id
     */
    @ExcelIgnore
    @ApiModelProperty("其他类别id")
    @TableField("qtlb_id")
    private Integer qtlbId;


    /**
     * 商品品牌
     */
    @ExcelIgnore
    @ApiModelProperty("商品品牌id")
    @TableField("pp_id")
    private Integer ppId;

    /**
     * 是否启用 0:启用 1:停用
     */
    @ExcelProperty(value = "状态",index = 14,converter = StatusConverter.class)
    @ApiModelProperty("是否启用 0:启用 1:停用")
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
