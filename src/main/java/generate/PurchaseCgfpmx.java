package generate;

import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;

/**
 * purchase_cgfpmx
 * @author 
 */
@Data
public class PurchaseCgfpmx implements Serializable {
    private Long id;

    /**
     * order_cgfp id
     */
    private Long pid;

    /**
     * 原单号
     */
    private String ydjh;

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
     * 金额
     */
    private BigDecimal je;

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