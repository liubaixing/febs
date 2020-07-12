package com.febs.receipt.vo.resp;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.febs.receipt.entity.OrderXt;
import com.febs.receipt.entity.OrderXtmx;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class OrderXtResp extends OrderXt {

    @ApiModelProperty("购货单位")
    @ExcelProperty(value = "购货单位",index = 4)
    private String ptdamc;

    @ApiModelProperty("业务员")
    @ExcelProperty(value = "业务员",index = 5)
    private String userName;

    @ApiModelProperty("部门")
    @ExcelProperty(value = "部门",index = 6)
    private String bmmc;

    @ApiModelProperty("客户名称")
    @ExcelProperty(value = "客户名称",index = 7)
    private String khmc;

    @ApiModelProperty("仓库名称")
    @ExcelProperty(value = "仓库名称",index = 8)
    private String ckmc;

    @ApiModelProperty("客户来源")
    @ExcelProperty(value = "客户来源",index = 9)
    @TableField("khlymc")
    private String khlymc;

    @ApiModelProperty("流量来源")
    @ExcelProperty(value = "流量来源",index = 10)
    private String lllymc;

    @ApiModelProperty("单据类型")
    @ExcelProperty(value = "单据类型",index = 13)
    private String djlxmc;

    @ApiModelProperty("客户区域")
    @ExcelProperty(value = "客户区域",index = 14)
    private String khqymc;

    @ApiModelProperty("商品代码")
    @ExcelProperty(value = "商品代码",index = 17)
    private String spdm;

    @ApiModelProperty("商品名称")
    @ExcelProperty(value = "商品名称",index = 18)
    private String spmc;

    @ApiModelProperty("商品条码")
    @ExcelProperty(value = "商品条码",index = 19)
    private String memo;

    @ApiModelProperty("计划数")
    @ExcelProperty(value = "计划数",index = 20)
    private Integer jhsl;

    @ApiModelProperty("通知数")
    @ExcelProperty(value = "通知数",index = 21)
    private Integer tzsl;

    @ApiModelProperty("退货数")
    @ExcelProperty(value = "退货数",index = 22)
    private Integer cksl;

    @ApiModelProperty("单价")
    @ExcelProperty(value = "单价",index = 23)
    private BigDecimal dj;

    @ApiModelProperty("金额")
    @ExcelProperty(value = "金额",index = 24)
    private BigDecimal je;

    @ApiModelProperty("平台折扣")
    @ExcelProperty(value = "平台折扣",index = 25)
    private BigDecimal zk;

    @ApiModelProperty("销售净额")
    @ExcelProperty(value = "销售净额",index = 26)
    private BigDecimal xsje;

    @ApiModelProperty("计量单位")
    @ExcelProperty(value = "计量单位",index = 27)
    private String jldwmc;

    @ApiModelProperty("销退单明细id")
    @ExcelIgnore
    private Long mxId;

    @ExcelIgnore
    private List<OrderXtmxResp> xtmxList;
}
