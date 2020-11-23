package com.febs.common.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.febs.common.converter.WhetherConverter;
import com.febs.common.entity.ExcelUpload;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class OrderXsExcelModel extends ExcelUpload {


    /**
     * 销售单号
     */
    @ExcelProperty(value = "单据单号",index = 0)
    private String djbh;

    /**
     * 下单日期
     */
    @ExcelProperty(value = "下单日期",index = 1)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date xdrq;

    /**
     * 加急 0-否 1-是
     */
    @ExcelProperty(value = "加急", index = 2, converter = WhetherConverter.class)
    @TableField("sfjj")
    protected Byte sfjj;

    /**
     * 客户订单编号
     */
    @ExcelProperty(value = "客户订单编号",index = 3)
    @TableField("ydjh")
    private String ydjh;

    @ExcelProperty(value = "业务员",index = 4)
    private String userName;

    @ExcelProperty(value = "部门",index = 5)
    private String bmmc;

    @ExcelProperty(value = "客户名称",index = 6)
    private String khmc;

    @ExcelProperty(value = "发货仓库",index = 7)
    private String ckmc;

    @ExcelProperty(value = "客户来源名称",index = 8)
    private String khlymc;

    @ExcelProperty(value = "要求到货时间",index = 9)
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date yqdhrq;

    @ExcelProperty(value = "购货单位名称",index = 10)
    private String ptdamc;

    @ExcelProperty(value = "摘要",index = 11)
    private String bz;


    @ExcelProperty(value = "客户区域名称",index = 12)
    private String khqymc;

    @ExcelProperty(value = "收货地址",index = 13)
    @TableField("address")
    private String address;

    @ExcelProperty(value = "收货人",index = 14)
    private String contact;

    @ExcelProperty(value = "联系电话",index = 15)
    private String tel;

    @ExcelProperty(value = "是否定制",index = 16, converter = WhetherConverter.class)
    private Byte sfdz;

    @ExcelProperty(value = "流量来源名称",index = 17)
    private String lllymc;

    @ExcelProperty(value = "商品条码",index = 18)
    private String sptm;

    @ExcelProperty(value = "唯一码",index = 19)
    private String spmc;

    @ExcelProperty(value = "数量",index = 20)
    private Integer sl;

    @ExcelProperty(value = "数量",index = 21)
    private BigDecimal je;

    @ExcelProperty(value = "平台折扣",index = 22)
    private BigDecimal zk;

}
