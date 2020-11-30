package com.febs.shangpin.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * spkcb
 * @author 
 */
@Data
public class Spkcb implements Serializable {
    private Integer id;

    /**
     * 仓库ID
     */
    private Integer ckId;

    /**
     * 仓库名称
     */
    private String ckName;

    /**
     * SKU
     */
    private String sku;

    /**
     * SKU_ID
     */
    private Integer skuId;

    /**
     * 商品 ID
     */
    private Integer goodsId;

    /**
     * 颜色 ID
     */
    private Integer colorId;

    /**
     * 尺码 ID
     */
    private Integer sizeId;

    /**
     * 在库库存
     */
    private Integer sl;

    /**
     * 配货锁定库存
     */
    private Integer sl1;

    /**
     * 确认锁定库存
     */
    private Integer sl2;

    /**
     * 冻结库存
     */
    private Integer sl3;

    /**
     * 在途库存
     */
    private Integer sl4;

    /**
     * 预售库存
     */
    private Integer sl5;

    /**
     * 确认锁定的预售库存
     */
    private Integer sl6;

    /**
     * 预警库存
     */
    private Integer sl7;

    private String ckdm;

    private String shangpinSpdm;
    private String shangpinSpmc;
    private String shangpinMemo;

    private String colorCode;

    private String sizeCode;

    private Date lastchanged;

    /**
     * 澶囨敞
     */
    private String remark;

    private static final long serialVersionUID = 1L;
}