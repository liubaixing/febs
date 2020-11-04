package com.febs.shangpin.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * stock_tz
 * @author 
 */
@Data
public class StockTz implements Serializable {
    private Long id;

    /**
     * 调整单号
     */
    private String djbh;

    /**
     * 单据日期
     */
    private Integer xdrq;

    /**
     * 仓库ID 仓库名称
     */
    private Integer cangkuId;

    /**
     * 盘点类型 0-全盘 1-盘款
     */
    private Byte pdlx;

    /**
     * 摘要
     */
    private String bz;

    /**
     * 调整数量
     */
    private Integer sl;

    /**
     * 调整金额
     */
    private BigDecimal je;

    /**
     * 附件
     */
    private String fj;

    /**
     * 制单人
     */
    private String zdr;

    /**
     * 0-未确认 1-已确认
     */
    private Byte qr;

    /**
     * 确认人
     */
    private String qrr;

    /**
     * 确认日期
     */
    private Integer qrrq;

    /**
     * 0-未审核 1-已审核
     */
    private Byte sh;

    /**
     * 审核人
     */
    private String shr;

    /**
     * 审核日期
     */
    private Integer shrq;

    /**
     * 0-未执行 1-已执行
     */
    private Byte zx;

    /**
     * 执行人
     */
    private String zxr;

    /**
     * 执行日期
     */
    private Integer zxrq;

    /**
     * 0-未终审 1-已终审
     */
    private Byte zs;

    /**
     * 终审
     */
    private String zsr;

    /**
     * 终审日期
     */
    private Integer zsrq;

    /**
     * 0-未作废 1-已作废
     */
    private Byte zf;

    /**
     * 作废
     */
    private String zfr;

    /**
     * 作废日期
     */
    private Integer zfrq;

    /**
     * 备用1
     */
    private String ex1;

    /**
     * 备用2
     */
    private String ex2;

    /**
     * 备用3
     */
    private String ex3;

    private static final long serialVersionUID = 1L;
}