package com.febs.system.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * ding_talk_department
 * @author 
 */
@Data
public class DingTalkDepartment implements Serializable {
    /**
     * 主键
     */
    private Long id;

    /**
     *
     */
    private Long parentid;

    /**
     * 钉钉端部门名称
     */
    private String name;

    /**
     * 扩展属性
     */
    private String ext;

    private static final long serialVersionUID = 1L;
}