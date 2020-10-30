package com.febs.common.entity.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @ClassName: CommonExcelEntity
 * @Description:
 * @Author:
 * @Date 2020/10/30
 * @Version 1.0
 */
@Data
public class CommonExcelEntity {

    @ExcelProperty(index = 0)
    private String row;
    @ExcelProperty(index = 1)
    private String row1;
    @ExcelProperty(index = 2)
    private String row2;

}
