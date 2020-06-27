package com.febs.purchase.entity;

import java.math.BigDecimal;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 退仓单 Entity
 *
 * @author liubaixing
 * @date 2020-06-27 19:55:32
 */
@Data
@TableName("purchase_tc")
public class PurchaseTc {

    /**
     * 
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Long id;

    /**
     * 退仓单号
     */
    @TableField("djbh")
    private String djbh;

    /**
     * 下单日期
     */
    @TableField("xdrq")
    private Integer xdrq;

    /**
     * 客户订单编号
     */
    @TableField("ydjh")
    private String ydjh;

    /**
     * 销退单号
     */
    @TableField("xtdh")
    private String xtdh;

    /**
     * 用户ID 业务员
     */
    @TableField("user_id")
    private Integer userId;

    /**
     * 部门ID 部门
     */
    @TableField("bm_id")
    private Integer bmId;

    /**
     * 供应商ID 供应商
     */
    @TableField("gys_id")
    private Integer gysId;

    /**
     * 仓库ID 仓库名称
     */
    @TableField("cangku_id")
    private Integer cangkuId;

    /**
     * 发票税率ID 发票税率
     */
    @TableField("fpsl_id")
    private Integer fpslId;

    /**
     * 发票类型ID 发票类型
     */
    @TableField("fplx_id")
    private Integer fplxId;

    /**
     * 单据类型ID 单据类型名称
     */
    @TableField("djlx_id")
    private Integer djlxId;

    /**
     * 用户ID 采购负责人
     */
    @TableField("cgfzr")
    private Integer cgfzr;

    /**
     * 用户ID 下单负责人
     */
    @TableField("xdfzr")
    private Integer xdfzr;

    /**
     * 是否定制 0-否 1-是
     */
    @TableField("sfdz")
    private Byte sfdz;

    /**
     * 是否加急 0-否 1-是
     */
    @TableField("sfjj")
    private Byte sfjj;

    /**
     * 物流单号
     */
    @TableField("wldh")
    private String wldh;

    /**
     * 摘要
     */
    @TableField("bz")
    private String bz;

    /**
     * 要求到货时间
     */
    @TableField("yqdhrq")
    private Integer yqdhrq;

    /**
     * 整单数量
     */
    @TableField("sl")
    private Integer sl;

    /**
     * 整单金额
     */
    @TableField("je")
    private BigDecimal je;
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
     * 0-未确认 1-已确认
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
     * 0-未审核 1-已审核
     */
    @TableField("sh")
    private Byte sh;

    /**
     * 审核人
     */
    @TableField("jshr")
    private String jshr;

    /**
     * 审核日期
     */
    @TableField("shrq")
    private Integer shrq;

    /**
     * 0-未开始收货 1-已开始收货
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
     * 0-未收货确认 1-已收货确认
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
     * 0-未开始退仓 1-已开始退仓
     */
    @TableField("kstc")
    private Byte kstc;

    /**
     * 开始退仓人
     */
    @TableField("kstcr")
    private String kstcr;

    /**
     * 开始退仓日期
     */
    @TableField("kstcrq")
    private Integer kstcrq;

    /**
     * 0-未退仓发货 1-已退仓发货
     */
    @TableField("tcfh")
    private Byte tcfh;

    /**
     * 退仓发货人
     */
    @TableField("tcfhr")
    private String tcfhr;

    /**
     * 退仓发货日期
     */
    @TableField("tcfhrq")
    private Integer tcfhrq;

    /**
     * 0-未运费录入 1-已运费录入
     */
    @TableField("yflr")
    private Byte yflr;

    /**
     * 运费录入人
     */
    @TableField("yflrr")
    private String yflrr;

    /**
     * 运费录入日期
     */
    @TableField("yflrrq")
    private Integer yflrrq;

    /**
     * 0-未印刷费录入 1-已印刷费录入
     */
    @TableField("ysflr")
    private Byte ysflr;

    /**
     * 印刷费录入人
     */
    @TableField("ysflrr")
    private String ysflrr;

    /**
     * 印刷费录入日期
     */
    @TableField("ysflrrq")
    private Integer ysflrrq;

    /**
     * 0-未关闭 1-已关闭
     */
    @TableField("zs")
    private Byte zs;

    /**
     * 关闭
     */
    @TableField("zsr")
    private String zsr;

    /**
     * 关闭日期
     */
    @TableField("zsrq")
    private Integer zsrq;

    /**
     * 0-未作废 1-已作废
     */
    @TableField("zf")
    private Byte zf;

    /**
     * 作废
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
