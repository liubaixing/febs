package com.febs.shangpin.vo.resp;

import com.alibaba.excel.annotation.ExcelProperty;
import com.febs.shangpin.entity.ShangpinGys;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

@Data
public class ShangpinGysResp extends ShangpinGys {

    @ExcelProperty(value = "供应商",index = 12)
    @ExcelField("供应商")
    private String gysmc;

    @ExcelProperty(value = "计量单位",index = 13)
    private String jldwmc;

    @ExcelProperty(value = "总类",index = 2)
    private String zlmc;

    @ExcelProperty(value = "大类",index = 3)
    private String dlmc;

    @ExcelProperty(value = "小类",index = 4)
    private String xlmc;

    @ExcelProperty(value = "其他类别",index = 5)
    private String qtlbmc;

    @ExcelProperty(value = "品牌名称",index = 1)
    private String ppglmc;

}
