package generate;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * purchase_tc
 * @author 
 */
@Data
public class PurchaseTc implements Serializable {
    private Long id;

    /**
     * 退仓单号
     */
    private String djbh;

    /**
     * 下单日期
     */
    private Integer xdrq;

    /**
     * 客户订单编号
     */
    private String ydjh;

    /**
     * 销退单号
     */
    private String xtdh;

    /**
     * 用户ID 业务员
     */
    private Integer userId;

    /**
     * 部门ID 部门
     */
    private Integer bmId;

    /**
     * 供应商ID 供应商
     */
    private Integer gysId;

    /**
     * 仓库ID 仓库名称
     */
    private Integer cangkuId;

    /**
     * 发票税率ID 发票税率
     */
    private Integer fpslId;

    /**
     * 发票类型ID 发票类型
     */
    private Integer fplxId;

    /**
     * 单据类型ID 单据类型名称
     */
    private Integer djlxId;

    /**
     * 用户ID 采购负责人
     */
    private Integer cgfzr;

    /**
     * 用户ID 下单负责人
     */
    private Integer xdfzr;

    /**
     * 是否定制 0-否 1-是
     */
    private Byte sfdz;

    /**
     * 是否加急 0-否 1-是
     */
    private Byte sfjj;

    /**
     * 物流单号
     */
    private String wldh;

    /**
     * 摘要
     */
    private String bz;

    /**
     * 要求到货时间
     */
    private Integer yqdhrq;

    /**
     * 整单数量
     */
    private Integer sl;

    /**
     * 整单金额
     */
    private BigDecimal je;

    /**
     * 开票数量
     */
    private Integer kpsl;

    /**
     * 付款数量
     */
    private Integer fksl;

    /**
     * 退款数量
     */
    private Integer tksl;

    /**
     * 开票金额
     */
    private BigDecimal kpje;

    /**
     * 付款金额
     */
    private BigDecimal fkje;

    /**
     * 退款金额
     */
    private BigDecimal tkje;

    /**
     * 附件
     */
    private String fj;

    /**
     * 收货地址
     */
    private String address;

    /**
     * 收货人人电话
     */
    private String tel;

    /**
     * 收货人
     */
    private String contact;

    /**
     * 制单人
     */
    private String zdr;

    /**
     * 制单日期
     */
    private Integer zdrq;

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
    private String jshr;

    /**
     * 审核日期
     */
    private Integer shrq;

    /**
     * 0-未开始收货 1-已开始收货
     */
    private Byte kssh;

    /**
     * 开始收货人
     */
    private String ksshr;

    /**
     * 开始收货日期
     */
    private Integer ksshrq;

    /**
     * 0-未收货确认 1-已收货确认
     */
    private Byte shqr;

    /**
     * 收货确认人
     */
    private String shqrr;

    /**
     * 收货确认日期
     */
    private Integer shqrrq;

    /**
     * 0-未开始退仓 1-已开始退仓
     */
    private Byte kstc;

    /**
     * 开始退仓人
     */
    private String kstcr;

    /**
     * 开始退仓日期
     */
    private Integer kstcrq;

    /**
     * 0-未退仓发货 1-已退仓发货
     */
    private Byte tcfh;

    /**
     * 退仓发货人
     */
    private String tcfhr;

    /**
     * 退仓发货日期
     */
    private Integer tcfhrq;

    /**
     * 0-未运费录入 1-已运费录入
     */
    private Byte yflr;

    /**
     * 运费录入人
     */
    private String yflrr;

    /**
     * 运费录入日期
     */
    private Integer yflrrq;

    /**
     * 0-未印刷费录入 1-已印刷费录入
     */
    private Byte ysflr;

    /**
     * 印刷费录入人
     */
    private String ysflrr;

    /**
     * 印刷费录入日期
     */
    private Integer ysflrrq;

    /**
     * 0-未关闭 1-已关闭
     */
    private Byte zs;

    /**
     * 关闭
     */
    private String zsr;

    /**
     * 关闭日期
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