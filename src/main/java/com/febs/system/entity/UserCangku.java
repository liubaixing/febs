package com.febs.system.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * user_cangku
 * @author 
 */
@Data
public class UserCangku implements Serializable {
    /**
     * 用户授权仓库id
     */
    private Long userCangkuId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 仓库id
     */
    private Long cangkuId;

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