package com.febs.receipt.entity;

import java.util.Date;
import java.math.BigDecimal;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import org.springframework.format.annotation.DateTimeFormat;

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
    @ExcelIgnore
    @TableId(value = "Id", type = IdType.AUTO)
    private Long id;

    /**
     * 销退单号
     */
    @ApiModelProperty("销退单号")
    @ExcelProperty(value = "销退单号",index = 0)
    @TableField("djbh")
    private String djbh;

    /**
     * 下单日期
     */
    @ExcelProperty(value = "下单日期",index = 1)
    @TableField("xdrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date xdrq;

    /**
     * 原单号
     */
    @ExcelProperty(value = "原单号",index = 2)
    @TableField("ydbh")
    private String ydbh;

    /**
     * 客户订单编号
     */
    @ExcelProperty(value = "客户订单编号",index = 3)
    @TableField("ydjh")
    private String ydjh;

    /**
     * 加急 0-否 1-是
     */
    @ExcelIgnore
    @TableField("sfjj")
    private Byte sfjj;

    /**
     * 加急 0-否 1-是
     */
    @ExcelIgnore
    @TableField("sfdz")
    private Byte sfdz;

    /**
     * 购货单位ID 购货单位
     */
    @ExcelIgnore
    @TableField("org_id")
    private Integer orgId;

    /**
     * 用户ID 业务员
     */
    @ExcelIgnore
    @TableField("user_id")
    private Long userId;

    /**
     * 部门ID 部门名称
     */
    @ExcelIgnore
    @TableField("bumeng_id")
    private Integer bumengId;

    /**
     * 客户ID 客户名称
     */
    @ExcelIgnore
    @TableField("kehu_id")
    private Integer kehuId;

    /**
     * 仓库ID 仓库名称
     */
    @ExcelIgnore
    @TableField("cangku_id")
    private Integer cangkuId;

    /**
     * 客户来源ID 客户来源名称
     */
    @ExcelIgnore
    @TableField("khly_id")
    private Integer khlyId;

    /**
     * 流量来源ID 流量来源名称
     */
    @ExcelIgnore
    @TableField("llly_id")
    private Integer lllyId;

    /**
     * 要求到货时间
     */
    @ExcelIgnore
    @TableField("yqdhrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date yqdhrq;

    /**
     * 单据类型ID 单据类型名称 导入是填入字母用于单据编号编码
     */
    @ExcelIgnore
    @TableField("djlx_id")
    private Integer djlxId;

    /**
     * 客户区域ID 客户区域名称
     */
    @ExcelIgnore
    @TableField("khqy_id")
    private Integer khqyId;

    /**
     * 物流单号
     */
    @ExcelIgnore
    @TableField("wldh")
    private String wldh;

    /**
     * 摘要
     */
    @ExcelProperty(value = "摘要",index = 15)
    @TableField("bz")
    private String bz;

    /**
     * 附件
     */
    @ExcelProperty(value = "附件",index = 16)
    @TableField("fj")
    private String fj;

    /**
     * 整单数量
     */
    @ExcelIgnore
    @TableField("sl")
    private Integer sl;

    /**
     * 整单金额
     */
    @ExcelIgnore
    @TableField("je")
    private BigDecimal je;

    /**
     * 开票数量
     */
    @ExcelIgnore
    private Integer kpsl;

    /**
     * 收款数量
     */
    @ExcelIgnore
    private Integer sksl;

    /**
     * 退款数量
     */
    @ExcelIgnore
    private Integer tksl;

    /**
     * 开票金额
     */
    @ExcelIgnore
    private BigDecimal kpje;

    /**
     * 收款金额
     */
    @ExcelIgnore
    private BigDecimal skje;

    /**
     * 退款金额
     */
    @ExcelIgnore
    private BigDecimal tkje;

    /**
     * 收货地址
     */
    @ApiModelProperty("地址")
    @ExcelProperty(value = "地址",index = 28)
    @TableField("address")
    private String address;

    /**
     * 收货人人电话
     */
    @ApiModelProperty("联系电话")
    @ExcelProperty(value = "联系电话",index = 30)
    @TableField("tel")
    private String tel;

    /**
     * 收货人
     */
    @ApiModelProperty("收货人")
    @ExcelProperty(value = "收货人",index = 29)
    @TableField("contact")
    private String contact;

    /**
     * 制单人
     */
    @ExcelIgnore
    @TableField("zdr")
    private String zdr;

    /**
     * 制单日期
     */
    @ExcelIgnore
    @TableField("zdrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date zdrq;

    /**
     * 0-未确认 1-已确认
     */
    @ApiModelProperty("确认 （0-未确认 1-已确认）")
    @ExcelIgnore
    @TableField("qr")
    private Byte qr;

    /**
     * 确认人
     */
    @ApiModelProperty("确认人")
    @ExcelIgnore
    @TableField("qrr")
    private String qrr;

    /**
     * 确认日期
     */
    @ExcelIgnore
    @TableField("qrrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date qrrq;

    /**
     * 0-未审核 1-已审核
     */
    @ApiModelProperty("审核 （0-未审核 1-已审核）")
    @ExcelIgnore
    @TableField("sh")
    private Byte sh;

    /**
     * 审核人
     */
    @ApiModelProperty("审核人")
    @ExcelIgnore
    @TableField("auditor")
    private String auditor;

    /**
     * 审核日期
     */
    @ExcelIgnore
    @TableField("shrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date shrq;

    /**
     * 0-未开始收货 1-已开始收货
     */
    @ApiModelProperty("开始收货 （0-未开始收货 1-已开始收货）")
    @ExcelIgnore
    @TableField("kssh")
    private Byte kssh;

    /**
     * 开始收货
     */
    @ExcelIgnore
    @TableField("ksshr")
    private String ksshr;

    /**
     * 开始收货日期
     */
    @ExcelIgnore
    @TableField("ksshrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date ksshrq;

    /**
     * 0-未收货确认 1-已收货确认
     */
    @ApiModelProperty("收货确认 （0-未收货确认 1-已收货确认）")
    @ExcelIgnore
    @TableField("shqr")
    private Byte shqr;

    /**
     * 收货确认
     */
    @ExcelIgnore
    @TableField("shqrr")
    private String shqrr;

    /**
     * 收货确认日期
     */
    @ExcelIgnore
    @TableField("shqrrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date shqrrq;

    /**
     * 0-未运费录入 1-已运费录入
     */
    @ApiModelProperty("运费录入 （0-未运费录入 1-已运费录入）")
    @ExcelIgnore
    @TableField("yflr")
    private Byte yflr;

    /**
     * 运费录入
     */
    @ExcelIgnore
    @TableField("yflrr")
    private String yflrr;

    /**
     * 运费录入日期
     */
    @ExcelIgnore
    @TableField("yflrrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date yflrrq;

    /**
     * 0-未终审 1-已终审
     */
    @ApiModelProperty("关闭 （0-未终审 1-已终审）")
    @ExcelIgnore
    @TableField("zs")
    private Byte zs;

    /**
     * 终审
     */
    @ApiModelProperty("关闭人")
    @ExcelIgnore
    @TableField("zsr")
    private String zsr;

    /**
     * 终审日期
     */
    @ExcelIgnore
    @TableField("zsrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date zsrq;

    /**
     * 0-未作废 1-已作废
     */
    @ApiModelProperty("作废 （0-未作废 1-已作废）")
    @ExcelIgnore
    @TableField("z")
    private Byte zf;

    /**
     * 作废人
     */
    @ExcelIgnore
    @TableField("zfr")
    private String zfr;

    /**
     * 作废日期
     */
    @ExcelIgnore
    @TableField("zfrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date zfrq;

    /**
     * 0-未退款 1-部分退款 2-已退款
     */
    @ApiModelProperty("退款 0-未退款 1-部分退款 2-已退款")
    @ExcelIgnore
    @TableField("tk")
    private Byte tk;

    /**
     * 退款人
     */
    @ApiModelProperty("退款人")
    @ExcelIgnore
    @TableField("tkr")
    private String tkr;

    /**
     * 退款日期
     */
    @ApiModelProperty("退款日期")
    @ExcelIgnore
    @TableField("tkrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date tkrq;

    /**
     * 0-未开票 1-部分开票 2-已开票
     */
    @ApiModelProperty("开票 0-未开票 1-部分开票 2-已开票")
    @ExcelIgnore
    @TableField("kp")
    private Byte kp;

    /**
     * 开票人
     */
    @ApiModelProperty("开票人")
    @ExcelIgnore
    @TableField("kpr")
    private String kpr;

    /**
     * 开票日期
     */
    @ApiModelProperty("开票日期")
    @ExcelIgnore
    @TableField("kprq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date kprq;

    /**
     * 0-未执行 1-已执行
     */
    @ApiModelProperty("是否执行 0-未执行 1-已执行")
    @ExcelIgnore
    @TableField("zx")
    private Byte zx;

    /**
     * 执行人
     */
    @ApiModelProperty("执行人")
    @ExcelIgnore
    @TableField("zxr")
    private String zxr;

    /**
     * 执行日期
     */
    @ApiModelProperty("执行日期")
    @ExcelIgnore
    @TableField("zxrq")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date zxrq;

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
     * 创建时间
     */
    @ExcelIgnore
    @TableField("create_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 修改时间
     */
    @ExcelIgnore
    @TableField("update_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 0:正常,1:删除(默认0)
     */
    @ExcelIgnore
    @TableField("deleted")
    private Integer deleted;

}
