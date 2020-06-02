package cc.mrbird.febs.system.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.wuwenze.poi.annotation.Excel;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

import java.util.Date;

/**
 * 客户管理 Entity
 *
 * @author lbx
 * @date 2020-05-16 19:44:24
 */
@Data
@TableName("system_kehu")
@Excel("客户管理")
public class Kehu {

    /**
     * 
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 客户代码
     */
    @TableField("khdm")
    @ExcelField(value = "客户代码")
    private String khdm;

    /**
     * 客户名称
     */
    @TableField("khmc")
    @ExcelField(value = "客户名称")
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

    @ExcelField(value = "所属用户")
    private String userName;

    /**
     * 联系人电话
     */
    @TableField("tel")
    @ExcelField(value = "联系人电话")
    private String tel;

    /**
     * 联系人
     */
    @TableField("contact")
    @ExcelField(value = "联系人")
    private String contact;

    /**
     * 收货地址
     */
    @TableField("address")
    @ExcelField(value = "收货地址")
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
