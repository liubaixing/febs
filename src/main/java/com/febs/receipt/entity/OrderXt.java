package com.febs.receipt.entity;

import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 销退单 Entity
 *
 * @author liubaixing
 * @date 2020-06-11 11:46:11
 */
@Data
@TableName("order_xt")
public class OrderXt {

    /**
     * 
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Long id;

    /**
     * 销退单号
     */
    @TableField("djbh")
    private String djbh;

    /**
     * 下单日期
     */
    @TableField("xdrq")
    private Date xdrq;

    /**
     * 原单号
     */
    @TableField("ydbh")
    private String ydbh;

    /**
     * 客户订单编号
     */
    @TableField("ydjh")
    private String ydjh;

    /**
     * 加急 0-否 1-是
     */
    @TableField("sfjj")
    private Byte sfjj;

    /**
     * 加急 0-否 1-是
     */
    @TableField("sfdz")
    private Byte sfdz;

    /**
     * 购货单位ID 购货单位
     */
    @TableField("org_id")
    private Integer orgId;

    /**
     * 用户ID 业务员
     */
    @TableField("user_id")
    private Long userId;

    /**
     * 部门ID 部门名称
     */
    @TableField("bumeng_id")
    private Integer bumengId;

    /**
     * 客户ID 客户名称
     */
    @TableField("kehu_id")
    private Integer kehuId;

    /**
     * 仓库ID 仓库名称
     */
    @TableField("cangku_id")
    private Integer cangkuId;

    /**
     * 客户来源ID 客户来源名称
     */
    @TableField("khly_id")
    private Integer khlyId;

    /**
     * 流量来源ID 流量来源名称
     */
    @TableField("llly_id")
    private Integer lllyId;

    /**
     * 要求到货时间
     */
    @TableField("yqdhrq")
    private Date yqdhrq;

    /**
     * 单据类型ID 单据类型名称 导入是填入字母用于单据编号编码
     */
    @TableField("djlx_id")
    private Integer djlxId;

    /**
     * 客户区域ID 客户区域名称
     */
    @TableField("khqy_id")
    private Integer khqyId;

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
     * 附件
     */
    @TableField("fj")
    private String fj;

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
    private Integer kpsl;

    /**
     * 收款数量
     */
    private Integer sksl;

    /**
     * 退款数量
     */
    private Integer tksl;

    /**
     * 开票金额
     */
    private BigDecimal kpje;

    /**
     * 收款金额
     */
    private BigDecimal skje;

    /**
     * 退款金额
     */
    private BigDecimal tkje;

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
    private Date zdrq;

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
    private Date qrrq;

    /**
     * 0-未审核 1-已审核
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
    private Date shrq;

    /**
     * 0-未开始收货 1-已开始收货
     */
    @TableField("kssh")
    private Byte kssh;

    /**
     * 开始收货
     */
    @TableField("ksshr")
    private String ksshr;

    /**
     * 开始收货日期
     */
    @TableField("ksshrq")
    private Date ksshrq;

    /**
     * 0-未收货确认 1-已收货确认
     */
    @TableField("shqr")
    private Byte shqr;

    /**
     * 收货确认
     */
    @TableField("shqrr")
    private String shqrr;

    /**
     * 收货确认日期
     */
    @TableField("shqrrq")
    private Date shqrrq;

    /**
     * 0-未运费录入 1-已运费录入
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
    private Date yflrrq;

    /**
     * 0-未终审 1-已终审
     */
    @TableField("zs")
    private Byte zs;

    /**
     * 终审
     */
    @TableField("zsr")
    private String zsr;

    /**
     * 终审日期
     */
    @TableField("zsrq")
    private Date zsrq;

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
    private Date createTime;

    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;

    /**
     * 0:正常,1:删除(默认0)
     */
    @TableField("deleted")
    private Integer deleted;

}
