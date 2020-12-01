package com.febs.receipt.view;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

/**
 * @ClassName: OrderXskpView
 * @Description:
 * @Author:
 * @Date 2020/11/26
 * @Version 1.0
 */
@Data
public class OrderXskpView {

    private Long id;
    private Long mxId;
    private Integer spId;

    private String spdm;

    private String spmc;

    private String memo;

    private Integer jhsl;

    private Integer tzsl;

    private Integer cksl;
    private BigDecimal dj;

    private BigDecimal mxje;

    private BigDecimal zk;

    private BigDecimal xsje;
    private Integer xtsl;
    private BigDecimal xtje;


}
