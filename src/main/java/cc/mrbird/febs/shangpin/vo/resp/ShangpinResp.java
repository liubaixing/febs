package cc.mrbird.febs.shangpin.vo.resp;

import cc.mrbird.febs.shangpin.entity.Shangpin;
import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("shangpin")
public class ShangpinResp extends Shangpin {



    @ExcelProperty(value = "供应商",index = 13)
    @TableField("gysmc")
    private String gysmc;

    @ExcelProperty(value = "计量单位",index = 14)
    @TableField("jldwmc")
    private String jldwmc;

    @ExcelProperty(value = "总类",index = 3)
    @TableField("zlmc")
    private String zlmc;

    @ExcelProperty(value = "大类",index = 4)
    @TableField("dlmc")
    private String dlmc;

    @ExcelProperty(value = "小类",index = 5)
    @TableField("xlmc")
    private String xlmc;

    @ExcelProperty(value = "其他类别",index = 6)
    @TableField("qtlbmc")
    private String qtlbmc;

    @ExcelProperty(value = "品牌名称",index = 2)
    @TableField("ppglmc")
    private String ppglmc;

}
