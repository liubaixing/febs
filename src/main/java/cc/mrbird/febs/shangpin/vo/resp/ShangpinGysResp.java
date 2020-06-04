package cc.mrbird.febs.shangpin.vo.resp;

import cc.mrbird.febs.shangpin.entity.ShangpinGys;
import com.alibaba.excel.annotation.ExcelProperty;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

@Data
public class ShangpinGysResp extends ShangpinGys {

    @ExcelProperty(value = "供应商",index = 13)
    @ExcelField("供应商")
    private String gysmc;

    @ExcelProperty(value = "计量单位",index = 14)
    private String jldwmc;

    @ExcelProperty(value = "总类",index = 3)
    private String zlmc;

    @ExcelProperty(value = "大类",index = 4)
    private String dlmc;

    @ExcelProperty(value = "小类",index = 5)
    private String xlmc;

    @ExcelProperty(value = "其他类别",index = 6)
    private String qtlbmc;

    @ExcelProperty(value = "品牌名称",index = 2)
    private String ppglmc;

}
