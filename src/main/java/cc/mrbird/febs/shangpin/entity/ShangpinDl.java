package cc.mrbird.febs.shangpin.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * 大类 Entity
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:00
 */
@Data
@TableName("shangpin_dl")
public class ShangpinDl {

    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 大类代码
     */
    @TableField("dldm")
    private String dldm;

    /**
     * 大类名称
     */
    @TableField("dlmc")
    private String dlmc;

    /**
     * 备注
     */
    @TableField("memo")
    private String memo;

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
     * 是否启用 0:启用 1:停用
     */
    @TableField("status")
    private Integer status;
    @TableField("create_time")
    private Date createTime;
    @TableField("update_time")
    private Date updateTime;
    @TableField("deleted")
    private Integer deleted;

}
