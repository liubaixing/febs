package com.febs.receipt.entity;

import java.util.Date;
import java.math.BigDecimal;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.febs.common.converter.WhetherConverter;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 销售单 Entity
 *
 * @author liubaixing
 * @date 2020-06-11 11:36:56
 */
@Data
@TableName("order_xs")
public class OrderXs {

    /**
     * 
     */
    @ExcelIgnore
    @TableId(value = "Id", type = IdType.AUTO)
    private Long id;

    /**
     * 销售单号
     */
    @ApiModelProperty("销售单号")
    @ExcelProperty(value = "销售单号",index = 0)
    @TableField("djbh")
    private String djbh;

    /**
     * 下单日期
     */
    @ApiModelProperty("下单日期")
    @ExcelProperty(value = "下单日期",index = 1)
    @TableField("xdrq")
    private Date xdrq;

    /**
     * 原单号
     */
    @ApiModelProperty("原单号")
    @ExcelIgnore
    @TableField("ydbh")
    private String ydbh;

    /**
     * 客户订单编号
     */
    @ApiModelProperty("客户订单编号")
    @ExcelProperty(value = "客户订单编号",index = 4)
    @TableField("ydjh")
    private String ydjh;

    /**
     * 加急 0-否 1-是
     */
    @ApiModelProperty("是否加急（0-否 1-是）")
    @ExcelProperty(value = "加急", index = 2, converter = WhetherConverter.class)
    @TableField("sfjj")
    protected Byte sfjj;

    /**
     * 定制 0-否 1-是
     */
    @ApiModelProperty("是否定制（0-否 1-是）")
    @ExcelProperty(value = "定制",index = 3, converter = WhetherConverter.class)
    @TableField("sfdz")
    private Byte sfdz;

    /**
     * 购货单位ID 购货单位
     */
    @ApiModelProperty("购货单位ID")
    @ExcelIgnore
    @TableField("org_id")
    private Integer orgId;

    /**
     * 用户ID 业务员
     */
    @ApiModelProperty("用户ID（登录用户）")
    @ExcelIgnore
    @TableField("user_id")
    private Long userId;

    /**
     * 部门ID 部门名称
     */
    @ApiModelProperty("部门ID")
    @ExcelIgnore
    @TableField("bumeng_id")
    private Integer bumengId;

    /**
     * 客户ID 客户名称
     */
    @ApiModelProperty("客户ID")
    @ExcelIgnore
    @TableField("kehu_id")
    private Integer kehuId;

    /**
     * 仓库ID 仓库名称
     */
    @ApiModelProperty("仓库ID")
    @ExcelIgnore
    @TableField("cangku_id")
    private Integer cangkuId;

    /**
     * 客户来源ID 客户来源名称
     */
    @ApiModelProperty("客户来源ID")
    @ExcelIgnore
    @TableField("khly_id")
    private Integer khlyId;

    /**
     * 流量来源ID 流量来源名称
     */
    @ApiModelProperty("流量来源ID")
    @ExcelIgnore
    @TableField("llly_id")
    private Integer lllyId;

    /**
     * 要求到货时间
     */
    @ApiModelProperty("要求到货时间")
    @ExcelProperty(value = "要求到货时间",index = 11)
    @TableField("yqdhrq")
    private Date yqdhrq;

    /**
     * 单据类型ID 单据类型名称 导入是填入字母用于单据编号编码
     */
    @ApiModelProperty("单据类型ID")
    @ExcelIgnore
    @TableField("djlx_id")
    private Integer djlxId;

    /**
     * 客户区域ID 客户区域名称
     */
    @ApiModelProperty("客户区域ID")
    @ExcelIgnore
    @TableField("khqy_id")
    private Integer khqyId;

    /**
     * 物流单号
     */
    @ApiModelProperty("物流单号")
    @ExcelProperty(value = "物流单号",index = 15)
    @TableField("wldh")
    private String wldh;

    /**
     * 摘要
     */
    @ApiModelProperty("摘要")
    @ExcelProperty(value = "摘要",index = 16)
    @TableField("bz")
    private String bz;

    /**
     * 附件
     */
    @ApiModelProperty("附件")
    @ExcelProperty(value = "附件",index = 17)
    @TableField("fj")
    private String fj;

    /**
     * 数量
     */
    @ApiModelProperty("数量")
    @ExcelIgnore
    @TableField("sl")
    private Integer sl;

    /**
     * 整单金额
     */
    @ApiModelProperty("整单金额")
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
    @ExcelProperty(value = "收货地址",index = 29)
    @TableField("address")
    private String address;

    /**
     * 收货人人电话
     */
    @ExcelProperty(value = "联系电话",index = 31)
    @TableField("tel")
    private String tel;

    /**
     * 收货人
     */
    @ExcelProperty(value = "收货人",index = 30)
    @TableField("contact")
    private String contact;

    /**
     * 制单人
     */
    @ApiModelProperty("制单人")
    @ExcelIgnore
    @TableField("zdr")
    private String zdr;

    /**
     * 制单日期
     */
    @ApiModelProperty("制单日期")
    @ExcelIgnore
    @TableField("zdrq")
    private Date zdrq;

    /**
     * 0-未确认 1-已确认
     */
    @ApiModelProperty("是否确认")
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
    @ApiModelProperty("确认日期")
    @ExcelIgnore
    @TableField("qrrq")
    private Date qrrq;

    /**
     * 0-未审核 1-已审核
     */
    @ApiModelProperty("是否审核")
    @ExcelIgnore
    @TableField("sh")
    private Byte sh;

    /**
     * 审核人
     */
    @ApiModelProperty("审核人")
    @ExcelIgnore
    @TableField("shr")
    private String shr;

    /**
     * 审核日期
     */
    @ApiModelProperty("审核日期")
    @ExcelIgnore
    @TableField("shrq")
    private Date shrq;

    /**
     * 0-未执行 1-已执行
     */
    @ApiModelProperty("是否执行")
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
    private Date zxrq;

    /**
     * 0-未生成退款 1-已生成退款
     */
    @ApiModelProperty("是否生成退款")
    @ExcelIgnore
    @TableField("sctk")
    private Byte sctk;

    /**
     * 生成退款人
     */
    @ApiModelProperty("生成退款人")
    @ExcelIgnore
    @TableField("sctkr")
    private String sctkr;

    /**
     * 生成退款日期
     */
    @ApiModelProperty("生成退款日期")
    @ExcelIgnore
    @TableField("sctkrq")
    private Date sctkrq;

    /**
     * 0-未关闭 1-已关闭
     */
    @ApiModelProperty("是否关闭")
    @ExcelIgnore
    @TableField("gb")
    private Byte gb;

    /**
     * 关闭人
     */
    @ApiModelProperty("关闭人")
    @ExcelIgnore
    @TableField("gbr")
    private String gbr;

    /**
     * 关闭日期
     */
    @ApiModelProperty("关闭日期")
    @ExcelIgnore
    @TableField("gbrq")
    private Date gbrq;

    /**
     * 0-未作废 1-已作废
     */
    @ApiModelProperty("是否作废")
    @ExcelIgnore
    @TableField("zf")
    private Byte zf;

    /**
     * 作废人
     */
    @ApiModelProperty("作废人")
    @ExcelIgnore
    @TableField("zfr")
    private String zfr;

    /**
     * 作废日期
     */
    @ApiModelProperty("作废日期")
    @ExcelIgnore
    @TableField("zfrq")
    private Date zfrq;

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
    private Date createTime;

    /**
     * 修改时间
     */
    @ExcelIgnore
    @TableField("update_time")
    private Date updateTime;

    /**
     * 0:正常,1:删除(默认0)
     */
    @ExcelIgnore
    @TableField("deleted")
    private Integer deleted;

}
