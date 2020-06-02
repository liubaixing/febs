package cc.mrbird.febs.system.entity;


import lombok.Data;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

/**
 * 客户管理 Entity
 *
 * @author MrBird
 * @date 2020-05-16 18:22:46
 */
@Data
@TableName("system_kehu")
public class SystemKehu {

    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 客户代码
     */
    @TableField("khdm")
    private String khdm;

    /**
     * 客户名称
     */
    @TableField("khmc")
    private String khmc;

    /**
     * 客户类型
     */
    @TableField("khlx_id")
    private Integer khlxId;

    /**
     * 所属用户  用户表id
     */
    @TableField("ssyh")
    private Integer ssyh;

    /**
     * 联系人电话
     */
    @TableField("tel")
    private String tel;

    /**
     * 联系人
     */
    @TableField("contact")
    private String contact;

    /**
     * 收货地址
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
