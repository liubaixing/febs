package generate;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * purchase_tcmx
 * @author 
 */
@Data
public class PurchaseTcmx implements Serializable {
    private Long id;

    /**
     * order_tc id
     */
    private Long pid;

    /**
     * 商品ID
     */
    private Integer spId;

    /**
     * 颜色ID
     */
    private Integer gg1Id;

    /**
     * 尺码ID
     */
    private Integer gg2Id;

    /**
     * 数量
     */
    private Integer sl;

    /**
     * 单价
     */
    private BigDecimal dj;

    /**
     * 金额
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

    /**
     * SKU
     */
    private String sku;

    private static final long serialVersionUID = 1L;
}