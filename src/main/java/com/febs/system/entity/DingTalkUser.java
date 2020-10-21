package com.febs.system.entity;

import java.io.Serializable;
import java.util.Date;
import lombok.Data;

/**
 * ding_talk_user
 * @author 
 */
@Data
public class DingTalkUser implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     * 关联用户表 t_user
     */
    private Long userId;

    /**
     * 钉钉端唯一id
     */
    private String staffId;

    /**
     * 钉钉端用户名称
     */
    private String name;

    /**
     * 联系电话
     */
    private String mobile;

    /**
     * 钉钉端用户部门
     */
    private String department;

    /**
     * 在对应的部门中的排序
     */
    private String orderindepts;

    /**
     * 职务
     */
    private String position;

    /**
     * 办公地点
     */
    private String workplace;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date modifyTime;

    /**
     * 最近访问时间
     */
    private Date lastLoginTime;

    /**
     * 0:正常,1:删除
     */
    private Integer deleted;

    /**
     * 扩展属性
     */
    private String extattr;

    private static final long serialVersionUID = 1L;
}