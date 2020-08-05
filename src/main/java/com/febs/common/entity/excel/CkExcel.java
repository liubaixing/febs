package com.febs.common.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.febs.common.entity.ExcelUpload;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName: CkExcel
 * @Description: 出库单导入实体类
 * @Author: liubx
 * @Date 2020/8/5
 * @Version 1.0
 */
@Data
public class CkExcel extends ExcelUpload {

    @ExcelProperty(value = "出库单号",index = 0)
    private String djbh;

    @ExcelProperty(value = "销售单号",index = 1)
    private String ydbh;

    @ExcelProperty(value = "客户订单编号",index = 2)
    private String ydjh;

    @ExcelProperty(value = "单据日期",index = 3)
    private Date xdrq;

    @ExcelProperty(value = "摘要",index = 4)
    private String bz;

    @ExcelProperty(value = "数量",index = 5)
    private Integer sl;

    @ExcelProperty(value = "金额",index = 6)
    private BigDecimal je;

    @ExcelProperty(value = "仓库名称",index = 7)
    private String ckmc;

    @ExcelProperty(value = "客户名称",index = 8)
    private String khmc;

    @ExcelProperty(value = "购货单位",index = 9)
    private String ptdamc;

    @ExcelProperty(value = "单据类型",index = 10)
    private String djlxmc;

    @ExcelProperty(value = "商品代码",index = 11)
    private String spdm;

    @ExcelProperty(value = "商品名称",index = 12)
    private String spmc;

    @ExcelProperty(value = "商品条码",index = 13)
    private String memo;

    @ExcelProperty(value = "计量单位",index = 14)
    private String jldwmc;
}
