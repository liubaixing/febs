package cc.mrbird.febs.shangpin.entity;


import com.wuwenze.poi.annotation.ExcelField;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 品牌管理 Entity
 *
 * @author liubaixing1
 * @date 2020-05-22 01:10:37
 */
@Data
@TableName("shangpin_ppgl")
public class ShangpinPpgl {

    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 品牌代码
     */
    @ApiModelProperty("品牌代码")
    @ExcelField("品牌代码")
    @TableField("ppgldm")
    private String ppgldm;

    /**
     * 品牌名称
     */
    @ApiModelProperty("品牌名称")
    @ExcelField("品牌名称")
    @NotBlank(message = "{required}")
    @TableField("ppglmc")
    private String ppglmc;

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
