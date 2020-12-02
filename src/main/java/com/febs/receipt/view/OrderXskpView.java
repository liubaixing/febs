package com.febs.receipt.view;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.febs.receipt.vo.resp.OrderXsResp;
import com.febs.receipt.vo.resp.OrderXtResp;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ClassName: OrderXskpView
 * @Description:
 * @Author:
 * @Date 2020/11/26
 * @Version 1.0
 */
@Data
public class OrderXskpView {

    private List<OrderXsResp> orderXsRespList;
    private List<OrderXtResp> orderXtRespList;

    /*private Long id;
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
    private BigDecimal xtje;*/


}
