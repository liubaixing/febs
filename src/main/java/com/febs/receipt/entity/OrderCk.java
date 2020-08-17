package com.febs.receipt.entity;

import java.util.Date;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * 出库单 Entity
 *
 * @author liubaixing
 * @date 2020-07-03 22:44:01
 */
@Data
@TableName("order_ck")
public class OrderCk {

    /**
     * 
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Long id;

    /**
     * 出库单号
     */
    @ApiModelProperty("出库单号")
    @TableField("djbh")
    private String djbh;

    /**
     * 销售单号
     */
    @ApiModelProperty("销售单号")
    @TableField("ydbh")
    private String ydbh;

    /**
     * 客户订单编号
     */
    @ApiModelProperty("客户订单编号")
    @TableField("ydjh")
    private String ydjh;

    /**
     * 订单日期
     */
    @ApiModelProperty("单据日期")
    @TableField("xdrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date xdrq;

    /**
     * 仓库ID 出库仓库
     */
    @ApiModelProperty("仓库ID")
    @TableField("cangku_id")
    private Integer cangkuId;

    /**
     * 客户ID 客户名称
     */
    @ApiModelProperty("客户ID")
    @TableField("kehu_id")
    private Integer kehuId;

    /**
     * 购货单位ID 购货单位
     */
    @ApiModelProperty("购货单位ID ")
    @TableField("org_id")
    private Integer orgId;

    /**
     * 单据类型ID 单据类型名称 导入是填入字母用于单据编号编码
     */
    @ApiModelProperty("单据类型ID ")
    @TableField("djlx_id")
    private Integer djlxId;

    /**
     * 摘要
     */
    @ApiModelProperty("摘要 ")
    @TableField("bz")
    private String bz;

    /**
     * 附件
     */
    @ApiModelProperty("附件 ")
    @TableField("fj")
    private String fj;

    /**
     * 数量
     */
    @ApiModelProperty("数量 ")
    @TableField("sl")
    private Integer sl;

    /**
     * 成本金额
     */
    @ApiModelProperty("金额")
    @TableField("je")
    private BigDecimal je;
    /**
     * 制单人
     */
    @ApiModelProperty("制单人")
    @TableField("zdr")
    private String zdr;

    /**
     * 制单日期
     */
    @ApiModelProperty("制单日期")
    @TableField("zdrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date zdrq;

    /**
     * 0-未确认 1-已确认
     */
    @ApiModelProperty("确认 0-未确认 1-已确认")
    @TableField("qr")
    private Byte qr;

    /**
     * 确认人
     */
    @ApiModelProperty("确认人")
    @TableField("qrr")
    private String qrr;

    /**
     * 确认日期
     */
    @ApiModelProperty("确认日期")
    @TableField("qrrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date qrrq;

    /**
     * 0-未备货发货 1-已备货发货
     */
    @ApiModelProperty("备货发货 （0-未备货发货 1-已备货发货）")
    @TableField("bhfh")
    private Byte bhfh;

    /**
     * 备货发货人
     */
    @ApiModelProperty("备货发货人")
    @TableField("bhfhr")
    private String bhfhr;

    /**
     * 备货发货日期
     */
    @ApiModelProperty("备货发货日期")
    @TableField("bhfhrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date bhfhrq;

    /**
     * 0-未关闭 1-已关闭
     */
    @ApiModelProperty("关闭 0-未关闭 1-已关闭")
    @TableField("gb")
    private Byte gb;

    /**
     * 关闭
     */
    @ApiModelProperty("关闭人")
    @TableField("gbr")
    private String gbr;

    /**
     * 关闭日期
     */
    @ApiModelProperty("关闭日期")
    @TableField("gbrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date gbrq;

    /**
     * 0-未作废 1-已作废
     */
    @ApiModelProperty("作废 0-未作废 1-已作废")
    @TableField("zf")
    private Byte zf;

    /**
     * 作废
     */
    @ApiModelProperty("作废人")
    @TableField("zfr")
    private String zfr;

    /**
     * 作废日期
     */
    @ApiModelProperty("作废日期")
    @TableField("zfrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date zfrq;

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
     * 创建时间
     */
    @TableField("create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 0:正常,1:删除(默认0)
     */
    @TableField("deleted")
    private Integer deleted;

}
