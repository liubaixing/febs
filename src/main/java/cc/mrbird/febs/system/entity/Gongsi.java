package cc.mrbird.febs.system.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * 公司管理 Entity
 *
 * @author lbx
 * @date 2020-05-16 19:58:39
 */
@Data
@TableName("system_gongsi")
public class Gongsi {

    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 公司代码
     */
    @NotBlank(message = "{required}")
    @TableField("gsdm")
    private String gsdm;

    /**
     * 公司名称
     */
    @NotBlank(message = "{required}")
    @TableField("gsmc")
    private String gsmc;

    /**
     * 负责人联系电话
     */
    @TableField("tel")
    private String tel;

    /**
     * 负责人
     */
    @TableField("contact")
    private String contact;

    /**
     * 发货地址
     */
    @TableField("address")
    private String address;

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
