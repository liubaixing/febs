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
    @ExcelProperty(index = 0)
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss ")
    private Date djrq;

    @ExcelProperty(index = 1)
    private String gys;

    @ExcelProperty(index = 2)
    private String fplx;

    @ExcelProperty(index = 3)
    private String fpsd;

    @ExcelProperty(index = 4)
    private String cgdh;

    @ExcelProperty(index = 5)
    private BigDecimal je;

}
