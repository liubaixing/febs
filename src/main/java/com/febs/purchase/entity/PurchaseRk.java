package com.febs.purchase.entity;

import java.util.Date;
import java.math.BigDecimal;

import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 入库单 Entity
 *
 * @author liubaixing
 * @date 2020-07-07 15:40:21
 */
@Data
@TableName("purchase_rk")
public class PurchaseRk {

    /**
     * 
     */
    @TableId(value = "Id", type = IdType.AUTO)
    private Long id;

    /**
     * 入库单号
     */
    @TableField("djbh")
    private String djbh;

    /**
     * 销退单号
     */
    @TableField("ydbh")
    private String ydbh;

    /**
     * 客户订单编号
     */
    @TableField("ydjh")
    private String ydjh;

    /**
     * 订单日期
     */
    @TableField("xdrq")
    private Date xdrq;

    /**
     * 入库仓库 仓库ID
     */
    @TableField("cangku_id")
    private Integer cangkuId;

    /**
     * 客户名称 客户ID
     */
    @TableField("kehu_id")
    private Integer kehuId;

    /**
     * 购货单位 购货单位ID
     */
    @TableField("org_id")
    private Integer orgId;

    /**
     * 单据类型 单据类型ID
     */
    @TableField("djlx_id")
    private Integer djlxId;

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
     * 数量
     */
    @TableField("sl")
    private Integer sl;

    /**
     * 成本金额
     */
    @TableField("je")
    private BigDecimal je;
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
    private Date qrrq;

    /**
     * 审核入库 0-未审核入库 1-已审核入库
     */
    @TableField("shrk")
    private Byte shrk;

    /**
     * 审核入库人
     */
    @TableField("shrkr")
    private String shrkr;

    /**
     * 审核入库日期
     */
    @TableField("shrkrq")
    private Date shrkrq;

    /**
     * 关闭 0-未关闭 1-已关闭
     */
    @TableField("gb")
    private Byte gb;

    /**
     * 关闭
     */
    @TableField("gbr")
    private String gbr;

    /**
     * 关闭日期
     */
    @TableField("gbrq")
    private Date gbrq;

    /**
     * 作废 0-未作废 1-已作废
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
