package cc.mrbird.febs.shangpin.vo.resp;

import cc.mrbird.febs.shangpin.entity.ShangpinGys;
import com.alibaba.excel.annotation.ExcelProperty;
import com.wuwenze.poi.annotation.ExcelField;
import lombok.Data;

@Data
public class ShangpinGysResp extends ShangpinGys {

    @ExcelProperty(value = "供应商")
    @ExcelField("供应商")
    private String gysmc;

    @ExcelProperty(value = "计量单位")
    private String jldwmc;

    @ExcelProperty(value = "总类")
    private String zlmc;

    @ExcelProperty(value = "大类")
    private String dlmc;

    @ExcelProperty(value = "小类")
    private String xlmc;

    @ExcelProperty(value = "其他类别")
    private String qtlbmc;

    @ExcelProperty(value = "品牌名称")
    private String ppglmc;

}
