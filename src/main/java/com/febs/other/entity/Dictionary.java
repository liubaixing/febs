package com.febs.other.entity;

import java.io.Serializable;
import lombok.Data;

/**
 * dictionary
 * @author 
 */
@Data
public class Dictionary implements Serializable {
    /**
     * 关键字
     */
    private String code;

    /**
     * 值
     */
    private Long val;

    private static final long serialVersionUID = 1L;
}