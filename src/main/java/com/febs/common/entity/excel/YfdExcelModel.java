package com.febs.common.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.febs.common.entity.ExcelUpload;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class YfdExcelModel extends ExcelUpload {

    @ExcelProperty(value = "日期",index = 0)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date djrq;

    @ExcelProperty(value = "供应商",index = 1)
    private String gys;

    @ExcelProperty(value = "发票类型",index = 2)
    private String fplx;

    @ExcelProperty(value = "发票税率",index = 3)
    private String fpsd;

    @ExcelProperty(value = "采购单号",index = 4)
    private String cgdh;

    @ExcelProperty(value = "金额",index = 5)
    private BigDecimal je;

}
