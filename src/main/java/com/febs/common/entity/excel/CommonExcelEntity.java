package com.febs.common.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.febs.common.entity.ExcelUpload;
import lombok.Data;

/**
 * @ClassName: CommonExcelEntity
 * @Description:
 * @Author:
 * @Date 2020/10/30
 * @Version 1.0
 */
@Data
public class CommonExcelEntity extends ExcelUpload {

    /**
     * 销售单号
     */
    @ExcelProperty(index = 0)
    private String row;

    /**
     * 销退单号
     */
    @ExcelProperty(index = 1)
    private String row1;

    /**
     * 采购单号
     */
    @ExcelProperty(index = 2)
    private String row2;

    /**
     * 采购退款单号
     */
    @ExcelProperty(index = 3)
    private String row3;

    /**
     * 运费单号
     */
    @ExcelProperty(index = 4)
    private String row4;

    /**
     * 印刷费单号
     */
    @ExcelProperty(index = 5)
    private String row5;

}
