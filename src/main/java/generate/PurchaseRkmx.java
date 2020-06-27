package generate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * purchase_rkmx
 * @author 
 */
@Data
public class PurchaseRkmx implements Serializable {
    private Long id;

    /**
     * order_ck id
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
     * 单价
     */
    private BigDecimal dj;

    /**
     * 成本金额
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

    /**
     * 计税价格
     */
    private BigDecimal jsjg;

    /**
     * 计税金额
     */
    private BigDecimal jishuije;

    /**
     * SKU
     */
    private String sku;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 0:正常,1:删除(默认0)
     */
    private Integer deleted;

    /**
     * 成本金额
     */
    private BigDecimal cbje;

    private static final long serialVersionUID = 1L;
}