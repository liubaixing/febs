package cc.mrbird.febs.system.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * 部门管理 Entity
 *
 * @author lbx
 * @date 2020-05-16 19:50:02
 */
@Data
@TableName("system_bumeng")
public class Bumeng {

    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 部门代码
     */
    @TableField("bmdm")
    private String bmdm;

    /**
     * 部门名称
     */
    @TableField("bmmc")
    private String bmmc;

    /**
     * 所属公司 System_gongsi表id
     */
    @TableField("gs_id")
    private Integer gsId;

    /**
     * 负责人联系电话
     */
    @TableField("tel")
    private String tel;

    /**
     * 部门负责人
     */
    @TableField("contact")
    private String contact;

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
