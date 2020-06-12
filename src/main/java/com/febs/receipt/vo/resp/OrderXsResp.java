package com.febs.receipt.vo.resp;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.febs.receipt.entity.OrderXs;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class OrderXsResp extends OrderXs {

    @ExcelProperty(value = "业务员",index = 0)
    @TableField("user_name")
    private String userName;

    @ExcelProperty(value = "部门",index = 0)
    @TableField("bmmc")
    private String bmmc;

    @ExcelProperty(value = "客户名称",index = 0)
    @TableField("khmc")
    private String khmc;

    @ExcelProperty(value = "发货仓库",index = 0)
    @TableField("ckmc")
    private String ckmc;

    @ExcelProperty(value = "客户来源",index = 0)
    @TableField("khlymc")
    private String khlymc;

    @ExcelProperty(value = "流量来源",index = 0)
    @TableField("lllymc")
    private String lllymc;

    @ExcelProperty(value = "购货单位",index = 0)
    @TableField("ptdamc")
    private String ptdamc;

    @ExcelProperty(value = "单据类型",index = 0)
    @TableField("djlxmc")
    private String djlxmc;

    @ExcelProperty(value = "客户区域",index = 0)
    @TableField("khqymc")
    private String khqymc;

    @ExcelProperty(value = "商品代码",index = 0)
    @TableField("spdm")
    private String spdm;

    @ExcelProperty(value = "商品名称",index = 0)
    @TableField("spmc")
    private String spmc;

    @ExcelProperty(value = "商品条码",index = 7)
    @TableField("memo")
    private String memo;

}
