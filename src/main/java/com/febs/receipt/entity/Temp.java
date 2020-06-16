package com.febs.receipt.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.util.Date;

@Data
public class Temp {

    private Date xdrq;

    //    @ExcelProperty(value = "加急", index = 2, converter = WhetherConverter.class)
    protected Byte sfjj;

    //    @ExcelProperty(value = "客户订单编号",index = 4)
    private String ydjh;

    //    @ExcelProperty(value = "业务员",index = 5)
    private String userName;

    //    @ExcelProperty(value = "部门",index = 6)
    private String bmmc;

    //    @ExcelProperty(value = "客户名称",index = 7)
    private String khmc;

    //    @ExcelProperty(value = "发货仓库",index = 8)
    private String ckmc;

    //    @ExcelProperty(value = "客户来源名称",index = 9)
    private String khlymc;
}
