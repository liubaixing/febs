package com.febs.shangpin.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.febs.common.converter.StatusConverter;
import com.febs.common.converter.VerifyConverter;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

/**
 * 供应商商品 Entity
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:05
 */
@Data
@TableName("shangpin_gys")
public class ShangpinGys {

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
    @NotBlank(message = "{required}")
    @TableField("spmc")
    private String spmc;

    @ExcelProperty(value = "唯一码",index = 7)
    @ApiModelProperty("唯一码")
    private String memo;

    @ExcelIgnore
    private Integer shangpinId;
    /**
     * 销售价
     */
    @ExcelProperty(value = "销售价",index = 10)
    @ApiModelProperty("销售价")
    @TableField("xsj")
    private BigDecimal xsj;
    /**
     * 吊牌价
     */
    @ExcelProperty(value = "吊牌价",index = 8)
    @ApiModelProperty("吊牌价")
    @TableField("dpj")
    private BigDecimal dpj;
    /**
     * 预售价
     */
    @ExcelProperty(value = "预售价",index = 11)
    @ApiModelProperty("预售价")
    @TableField("ysj")
    private BigDecimal ysj;
    /**
     * 采购价
     */
    @ExcelProperty(value = "采购价",index = 9)
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
    private Integer zlId;


    /**
     * 大类 Shangpin_dl大类id
     */
    @ExcelIgnore
    @ApiModelProperty("大类id")
    @TableField("dl_id")
    private Integer dlId;


    /**
     * 小类 Shangpin_xl小类id
     */
    @ExcelIgnore
    @ApiModelProperty("小类id")
    @TableField("xl_id")
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
     * 审核状态 0 初始状态 1 已提交 2 已审核 3 已打回
     */
    @ExcelProperty(value = "审核状态",index = 14,converter = VerifyConverter.class)
    @ApiModelProperty("审核状态 0 初始状态 1 已提交 2 已审核 3 已打回 ")
    @TableField("lyxt")
    private Byte lyxt;

    /**
     * 是否启用 0:启用 1:停用
     */
    @ExcelProperty(value = "状态",index = 15,converter = StatusConverter.class)
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
