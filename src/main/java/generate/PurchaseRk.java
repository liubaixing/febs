package generate;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 * purchase_rk
 * @author 
 */
@Data
public class PurchaseRk implements Serializable {
    private Long id;

    /**
     * 入库单号
     */
    private String djbh;

    /**
     * 销退单号
     */
    private String ydbh;

    /**
     * 客户订单编号
     */
    private String ydjh;

    /**
     * 订单日期
     */
    private Date xdrq;

    /**
     * 仓库ID 入库仓库
     */
    private Integer cangkuId;

    /**
     * 客户ID 客户名称
     */
    private Integer kehuId;

    /**
     * 购货单位ID 购货单位
     */
    private Integer orgId;

    /**
     * 单据类型ID 单据类型名称 导入是填入字母用于单据编号编码
     */
    private Integer djlxId;

    /**
     * 摘要
     */
    private String bz;

    /**
     * 附件
     */
    private String fj;

    /**
     * 数量
     */
    private Integer sl;

    /**
     * 成本金额
     */
    private BigDecimal je;

    /**
     * 制单人
     */
    private String zdr;

    /**
     * 制单日期
     */
    private Date zdrq;

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
    private Date qrrq;

    /**
     * 0-未审核入库 1-已审核入库
     */
    private Byte shrk;

    /**
     * 审核入库人
     */
    private String shrkr;

    /**
     * 审核入库日期
     */
    private Date shrkrq;

    /**
     * 0-未关闭 1-已关闭
     */
    private Byte gb;

    /**
     * 关闭
     */
    private String gbr;

    /**
     * 关闭日期
     */
    private Date gbrq;

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
    private Date zfrq;

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

    private static final long serialVersionUID = 1L;
}