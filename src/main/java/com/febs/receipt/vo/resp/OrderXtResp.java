package com.febs.receipt.vo.resp;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.febs.receipt.entity.OrderXt;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class OrderXtResp extends OrderXt {

    @ExcelProperty(value = "购货单位名称",index = 4)
    private String ptdamc;

    @ExcelProperty(value = "业务员",index = 5)
    private String userName;

    @ExcelProperty(value = "部门",index = 6)
    private String bmmc;

    @ExcelProperty(value = "客户名称",index = 7)
    private String khmc;

    @ExcelProperty(value = "收货仓库",index = 8)
    private String ckmc;

    @ExcelProperty(value = "客户来源名称",index = 9)
    @TableField("khlymc")
    private String khlymc;

    @ExcelProperty(value = "流量来源名称",index = 10)
    private String lllymc;

    @ExcelProperty(value = "单据类型",index = 13)
    private String djlxmc;

    @ExcelProperty(value = "客户区域名称",index = 14)
    private String khqymc;

    @ExcelProperty(value = "商品代码",index = 17)
    private String spdm;

    @ExcelProperty(value = "商品名称",index = 18)
    private String spmc;

    @ExcelProperty(value = "商品条码",index = 19)
    private String memo;

    @ExcelProperty(value = "数量",index = 20)
    private Integer sun;

    @ExcelProperty(value = "单价",index = 21)
    private BigDecimal dj;

    @ExcelProperty(value = "金额",index = 22)
    private BigDecimal je;

    @ExcelProperty(value = "平台折扣",index = 23)
    private BigDecimal zk;

    @ExcelProperty(value = "销售净额",index = 24)
    private BigDecimal xsje;

    @ExcelProperty(value = "计量单位",index = 25)
    private String jldwmc;
}
