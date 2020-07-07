package com.febs.purchase.entity;

import java.math.BigDecimal;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 采购单 Entity
 *
 * @author liubaixing
 * @date 2020-07-07 15:40:13
 */
@Data
@TableName("purchase_cg")
public class PurchaseCg {

    /**
     * 
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Long id;

    /**
     * 采购单号
     */
    @TableField("djbh")
    private String djbh;

    /**
     * 下单日期
     */
    @TableField("xdrq")
    private Integer xdrq;

    /**
     * 销售单号
     */
    @TableField("xsdh")
    private String xsdh;

    /**
     * 客户订单编号
     */
    @TableField("ydjh")
    private String ydjh;

    /**
     * 业务员 用户ID
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 部门 部门ID
     */
    @TableField("bm_id")
    private Integer bmId;

    /**
     * 供应商 供应商ID
     */
    @TableField("gys_id")
    private Integer gysId;

    /**
     * 仓库 仓库ID
     */
    @TableField("cangku_id")
    private Integer cangkuId;

    /**
     * 发票税率 发票税率ID
     */
    @TableField("fpsl_id")
    private Integer fpslId;

    /**
     * 发票类型 发票类型ID
     */
    @TableField("fplx_id")
    private Integer fplxId;

    /**
     * 单据类型 单据类型ID
     */
    @TableField("djlx_id")
    private Integer djlxId;

    /**
     * 采购负责人 用户ID
     */
    @TableField("cgfzr")
    private Integer cgfzr;

    /**
     * 下单负责人 用户ID
     */
    @TableField("xdfzr")
    private Integer xdfzr;

    /**
     * 是否加急 0-否 1-是
     */
    @TableField("sfjj")
    private Byte sfjj;

    /**
     * 是否定制 0-否 1-是
     */
    @TableField("sfdz")
    private Byte sfdz;

    /**
     * 物流单号
     */
    @TableField("wldh")
    private String wldh;

    /**
     * 要求到货时间
     */
    @TableField("yqdhrq")
    private Integer yqdhrq;

    /**
     * 摘要
     */
    @TableField("bz")
    private String bz;

    /**
     * 收货地址
     */
    @TableField("address")
    private String address;

    /**
     * 收货人人电话
     */
    @TableField("tel")
    private String tel;

    /**
     * 收货人
     */
    @TableField("contact")
    private String contact;

    /**
     * 整单数量
     */
    @TableField("sl")
    private Integer sl;

    /**
     * 开票数量
     */
    @TableField("kpsl")
    private Integer kpsl;

    /**
     * 付款数量
     */
    @TableField("fksl")
    private Integer fksl;

    /**
     * 退款数量
     */
    @TableField("tksl")
    private Integer tksl;

    /**
     * 整单金额
     */
    @TableField("je")
    private BigDecimal je;
    /**
     * 开票金额
     */
    @TableField("kpje")
    private BigDecimal kpje;
    /**
     * 付款金额
     */
    @TableField("fkje")
    private BigDecimal fkje;
    /**
     * 退款金额
     */
    @TableField("tkje")
    private BigDecimal tkje;
    /**
     * 附件
     */
    @TableField("fj")
    private String fj;

    /**
     * 制单人
     */
    @TableField("zdr")
    private String zdr;

    /**
     * 制单日期
     */
    @TableField("zdrq")
    private Integer zdrq;

    /**
     * 确认 0-未确认 1-已确认
     */
    @TableField("qr")
    private Byte qr;

    /**
     * 确认人
     */
    @TableField("qrr")
    private String qrr;

    /**
     * 确认日期
     */
    @TableField("qrrq")
    private Integer qrrq;

    /**
     * 审核 0-未审核 1-已审核
     */
    @TableField("sh")
    private Byte sh;

    /**
     * 审核人
     */
    @TableField("shr")
    private String shr;

    /**
     * 审核日期
     */
    @TableField("shrq")
    private Integer shrq;

    /**
     * 二次复合 0-未二次复合 1-已二次复合
     */
    @TableField("ecsh")
    private Byte ecsh;

    /**
     * 二次复合人
     */
    @TableField("ecshr")
    private String ecshr;

    /**
     * 二次复合日期
     */
    @TableField("ecshrq")
    private Integer ecshrq;

    /**
     * 开始收货 0-未开始收货 1-已开始收货
     */
    @TableField("kssh")
    private Byte kssh;

    /**
     * 开始收货人
     */
    @TableField("ksshr")
    private String ksshr;

    /**
     * 开始收货日期
     */
    @TableField("ksshrq")
    private Integer ksshrq;

    /**
     * 收货确认 0-未收货确认 1-已收货确认
     */
    @TableField("shqr")
    private Byte shqr;

    /**
     * 收货确认人
     */
    @TableField("shqrr")
    private String shqrr;

    /**
     * 收货确认日期
     */
    @TableField("shqrrq")
    private Integer shqrrq;

    /**
     * 开始发货 0-未开始发货 1-已开始发货
     */
    @TableField("ksfh")
    private Byte ksfh;

    /**
     * 开始发货人
     */
    @TableField("ksfhr")
    private String ksfhr;

    /**
     * 开始发货日期
     */
    @TableField("ksfhrq")
    private Integer ksfhrq;

    /**
     * 开始配货 0-未开始配货 1-已开始配货
     */
    @TableField("ksph")
    private Byte ksph;

    /**
     * 开始配货人
     */
    @TableField("ksphr")
    private String ksphr;

    /**
     * 开始配货日期
     */
    @TableField("ksphrq")
    private Integer ksphrq;

    /**
     * 采购发货 0-未采购发货 1-已采购发货
     */
    @TableField("cgfh")
    private Byte cgfh;

    /**
     * 采购发货人
     */
    @TableField("cgfhr")
    private String cgfhr;

    /**
     * 采购发货日期
     */
    @TableField("cgfhrq")
    private Integer cgfhrq;

    /**
     * 运费录入 0-未运费录入 1-已运费录入
     */
    @TableField("yflr")
    private Byte yflr;

    /**
     * 运费录入
     */
    @TableField("yflrr")
    private String yflrr;

    /**
     * 运费录入日期
     */
    @TableField("yflrrq")
    private Integer yflrrq;

    /**
     * 印刷费录入 0-未印刷费录入 1-已印刷费录入
     */
    @TableField("ysflr")
    private Byte ysflr;

    /**
     * 印刷费录入
     */
    @TableField("ysflrr")
    private String ysflrr;

    /**
     * 印刷费录入日期
     */
    @TableField("ysflrrq")
    private Integer ysflrrq;

    /**
     * 生成退仓 0-未生成退仓 1-已生成退仓
     */
    @TableField("sctc")
    private Byte sctc;

    /**
     * 生成退仓
     */
    @TableField("sctcr")
    private String sctcr;

    /**
     * 生成退仓日期
     */
    @TableField("sctcrq")
    private Integer sctcrq;

    /**
     * 关闭 0-未关闭 1-已关闭
     */
    @TableField("zs")
    private Byte zs;

    /**
     * 关闭人
     */
    @TableField("zsr")
    private String zsr;

    /**
     * 关闭日期
     */
    @TableField("zsrq")
    private Integer zsrq;

    /**
     * 作废 0-未作废 1-已作废
     */
    @TableField("zf")
    private Byte zf;

    /**
     * 作废人
     */
    @TableField("zfr")
    private String zfr;

    /**
     * 作废日期
     */
    @TableField("zfrq")
    private Integer zfrq;

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

}
