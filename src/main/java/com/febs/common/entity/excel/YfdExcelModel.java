package com.febs.common.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.febs.common.entity.ExcelUpload;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @ClassName: YfdExcelModel
 * @Description:
 * @Author:
 * @Date 2020/11/17
 * @Version 1.0
 */
@Data
public class YfdExcelModel extends ExcelUpload {

    /**
     * 下单日期
     */
    @ExcelProperty(value = "日期",index = 0)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss ")
    private Date rq;


    /**
     * 下单日期
     */
    @ExcelProperty(value = "供应商",index = 1)
    private String gys;

    /**
     * 下单日期
     */
    @ExcelProperty(value = "发票类型",index = 2)
    private String fplx;

    /**
     * 下单日期
     */
    @ExcelProperty(value = "发票税率",index = 3)
    private String fpsl;

    /**
     * 下单日期
     */
    @ExcelProperty(value = "采购单号",index = 4)
    private String cgdh;

    @ExcelProperty(value = "金额",index = 5)
    private BigDecimal je;

}
