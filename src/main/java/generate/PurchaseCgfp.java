package generate;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * purchase_cgfp
 * @author 
 */
@Data
public class PurchaseCgfp implements Serializable {
    private Long id;

    /**
     * 采购开票编号
     */
    private String djbh;

    /**
     * 单据日期
     */
    private Integer djrq;

    /**
     * 供应商ID 供应商
     */
    private Integer gysId;

    /**
     * 开户银行ID 开户银行
     */
    private Integer khyhId;

    /**
     * 开票金额
     */
    private BigDecimal je;

    /**
     * 摘要
     */
    private String bz;

    /**
     * 附件
     */
    private String fj;

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
    private String shr;

    /**
     * 审核日期
     */
    private Integer shrq;

    /**
     * 0-未开票 1-已开票
     */
    private Byte kp;

    /**
     * 开票人
     */
    private String kpr;

    /**
     * 开票日期
     */
    private Integer kprq;

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