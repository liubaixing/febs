package cc.mrbird.febs.shangpin.entity;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
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
@Excel("商品")
@TableName("shangpin")
public class Shangpin {

    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 商品代码
     */
    @ExcelProperty(value = "商品代码")
    @ApiModelProperty("商品代码")
    @TableField("spdm")
    private String spdm;

    /**
     * 商品名称
     */
    @ExcelProperty(value = "商品名称")
    @ApiModelProperty("商品名称（必填）")
    @NotBlank(message = "{required}")
    @TableField("spmc")
    private String spmc;



    /**
     * 销售价
     */
    @ExcelProperty(value = "销售价")
    @ApiModelProperty("销售价")
    @TableField("xsj")
    private BigDecimal xsj;
    /**
     * 吊牌价
     */
    @ExcelProperty(value = "吊牌价")
    @ApiModelProperty("吊牌价")
    @TableField("dpj")
    private BigDecimal dpj;
    /**
     * 预售价
     */
    @ExcelProperty(value = "预售价")
    @ApiModelProperty("预售价")
    @TableField("ysj")
    private BigDecimal ysj;
    /**
     * 采购价
     */
    @ExcelProperty(value = "采购价")
    @ApiModelProperty("采购价")
    @TableField("cgj")
    private BigDecimal cgj;
    /**
     * 默认供应商 供应商表id
     */
    @ExcelIgnore
    @ApiModelProperty("供应商表id（必填）")
    @NotNull(message = "{required}")
    @TableField("gys_id")
    private Integer gysId;


    /**
     * 起订量
     */
    @ExcelProperty(value = "起订量")
    @ApiModelProperty("起订量")
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
    @NotNull(message = "{required}")
    private Integer zlId;


    /**
     * 大类 Shangpin_dl大类id
     */
    @ExcelIgnore
    @ApiModelProperty("大类id")
    @TableField("dl_id")
    @NotNull(message = "{required}")
    private Integer dlId;


    /**
     * 小类 Shangpin_xl小类id
     */
    @ExcelIgnore
    @ApiModelProperty("小类id")
    @TableField("xl_id")
    @NotNull(message = "{required}")
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

    @ExcelProperty(value = "供应商")
    @TableField("gysmc")
    private String gysmc;

    @ExcelProperty(value = "计量单位")
    @TableField("jldwmc")
    private String jldwmc;

    @ExcelProperty(value = "总类")
    @TableField("zlmc")
    private String zlmc;

    @ExcelProperty(value = "大类")
    @TableField("dlmc")
    private String dlmc;

    @ExcelProperty(value = "小类")
    @TableField("xlmc")
    private String xlmc;

    @ExcelProperty(value = "其他类别")
    @TableField("qtlbmc")
    private String qtlbmc;

    @ExcelProperty(value = "品牌名称")
    @TableField("ppglmc")
    private String ppglmc;

    /**
     * 是否启用 0:启用 1:停用
     */
    @ExcelIgnore
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
