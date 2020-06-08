package com.febs.shangpin.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * 商品条码 Entity
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:50
 */
@Data
@TableName("shangpin_barcode")
public class ShangpinBarcode {

    /**
     * 
     */
    @TableId(value = "barcode_id", type = IdType.AUTO)
    private Integer barcodeId;
    /**
     * sku of shangpin_sku
     */
    @TableField("sku")
    private String sku;

    /**
     * sku_id of shangpin_sku
     */
    @TableField("sku_id")
    private Integer skuId;

    /**
     * 
     */
    @TableField("shangpin_id")
    private Integer shangpinId;
    /**
     * 
     */
    @TableField("color_id")
    private Integer colorId;

    /**
     * 
     */
    @TableField("size_id")
    private Integer sizeId;

    /**
     * 国标码
     */
    @TableField("barcode")
    private String barcode;

    /**
     * 其他码
     */
    @TableField("zdycode")
    private String zdycode;

    /**
     * 0:启用 1:停用
     */
    @TableField("status")
    private Byte status;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;
    @TableField("deleted")
    private Integer deleted;

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
     * 
     */
    @TableField("lastchanged")
    private Date lastchanged;

}
