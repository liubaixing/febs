package com.febs.system.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * user_org
 * @author 
 */
@Data
public class UserOrg implements Serializable {

    public UserOrg(){}
    public UserOrg(Long orgId){this.orgId = orgId;}

    /**
     * 用户授权购货单位id
     */
    private Long userOrgId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 购货单位id
     */
    private Long orgId;

    /**
     * 状态  OPEN 开启 CLOSE 关闭
     */
    private String controlStatus;

    /**
     * 扩展元数据字段, 不限定字段协议格式, 可以采用json, xml 等格式保存
     */
    private String extras;

    /**
     * 版本
     */
    private Integer version;

    private static final long serialVersionUID = 1L;
}