package generate;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * purchase_cgtk
 * @author 
 */
@Data
public class PurchaseCgtk implements Serializable {
    private Long id;

    /**
     * 退款编号
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
     * 退款金额
     */
    private BigDecimal je;

    /**
     * 开户银行ID 开户银行
     */
    private Integer khyhId;

    /**
     * 银行账号
     */
    private String yhzh;

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
     * 0-未退款 1-已退款
     */
    private Byte tk;

    /**
     * 退款人
     */
    private String tkr;

    /**
     * 退款日期
     */
    private Integer tkrq;

    /**
     * 0-未作废 1-已作废
     */
    private Byte zf;

    /**
     * 作废人
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