package cc.mrbird.febs.shangpin.entity;

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
    @ApiModelProperty("商品代码")
    @ExcelField("商品代码")
    @TableField("spdm")
    private String spdm;

    /**
     * 商品名称
     */
    @ApiModelProperty("商品名称")
    @ExcelField("商品名称")
    @NotBlank(message = "{required}")
    @TableField("spmc")
    private String spmc;

    /**
     * 唯一码
     */
    @ApiModelProperty("唯一码（必填）")
    @ExcelField("唯一码")
    @NotBlank(message = "{required}")
    @TableField("memo")
    private String memo;

    /**
     * 销售价
     */
    @ApiModelProperty("销售价")
    @ExcelField("销售价")
    @TableField("xsj")
    private BigDecimal xsj;
    /**
     * 吊牌价
     */
    @ApiModelProperty("吊牌价")
    @ExcelField("吊牌价")
    @TableField("dpj")
    private BigDecimal dpj;
    /**
     * 预售价
     */
    @ApiModelProperty("预售价")
    @ExcelField("预售价")
    @TableField("ysj")
    private BigDecimal ysj;
    /**
     * 采购价
     */
    @ApiModelProperty("采购价")
    @ExcelField("采购价")
    @TableField("cgj")
    private BigDecimal cgj;
    /**
     * 默认供应商 供应商表id
     */
    @ApiModelProperty("供应商表id（必填）")
    @NotNull(message = "{required}")
    @TableField("gys_id")
    private Integer gysId;

    @ExcelField("供应商名称")
    private String gysmc;

    /**
     * 起订量
     */
    @ApiModelProperty("起订量")
    @ExcelField("起订量")
    @TableField("qdl")
    private Integer qdl;

    /**
     * 计量单位 计量单位id
     */
    @NotNull(message = "计量单位不能为空")
    @ApiModelProperty("计量单位id（必填）")
    @TableField("jldw_id")
    private Integer jldwId;

    @ExcelField("计量单位")
    private String jldwmc;

    /**
     * 默认仓库 仓库id
     */
    @ApiModelProperty("仓库id（必填）")
    @NotNull(message = "仓库不能为空")
    @TableField("ck_id")
    private Integer ckId;
    @ExcelField("仓库")
    private String ckmc;

    /**
     * 默认供应商图片
     */
    @ApiModelProperty("默认供应商图片")
    @TableField("mrtp")
    private String mrtp;

    /**
     * 总类 Shangpin_zl总类id
     */
    @ApiModelProperty("总类id（必填）")
    @TableField("zl_id")
    @NotNull(message = "{required}")
    private Integer zlId;
    @ExcelField("总类")
    private String zlmc;

    /**
     * 大类 Shangpin_dl大类id
     */
    @ApiModelProperty("大类id")
    @TableField("dl_id")
    private Integer dlId;
    @ExcelField("大类")
    private String dlmc;

    /**
     * 小类 Shangpin_xl小类id
     */
    @ApiModelProperty("小类id")
    @TableField("xl_id")
    private Integer xlId;
    @ExcelField("小类")
    private String xlmc;

    /**
     * 其他类别 Shangpin_qtlb其他类别id
     */
    @ApiModelProperty("其他类别id")
    @TableField("qtlb_id")
    private Integer qtlbId;
    @ExcelField("其他类别")
    private String qtlbmc;

    /**
     * 商品品牌
     */
    @ApiModelProperty("商品品牌id")
    private Integer ppId;
    @ExcelField("品牌名称")
    private String ppglmc;

    /**
     * 是否启用 0:启用 1:停用
     */
    @ApiModelProperty("是否启用 0:启用 1:停用")
    @TableField("status")
    private Integer status;
    @ExcelField("创建时间")
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;
    @TableField("deleted")
    private Integer deleted;

}
