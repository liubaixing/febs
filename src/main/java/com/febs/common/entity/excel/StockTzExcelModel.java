package com.febs.common.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.febs.common.entity.ExcelUpload;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName: StockTzExcelModel
 * @Description:
 * @Author:
 * @Date 2020/12/3
 * @Version 1.0
 */
@Data
public class StockTzExcelModel extends ExcelUpload {

    @ExcelProperty(value = "单据日期",index = 0)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date djrq;
    @ExcelProperty(value = "仓库",index = 1)
    private String cangku;
    @ExcelProperty(value = "盘点类型",index = 2)
    private String pdlx;
    @ExcelProperty(value = "商品名称",index = 3)
    private String spmc;
    @ExcelProperty(value = "调整数量",index = 4)
    private Integer sl;

}
