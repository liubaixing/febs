package com.febs.shangpin.vo.resp;

import com.alibaba.excel.annotation.ExcelProperty;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.febs.shangpin.entity.Shangpin;
import lombok.Data;

@Data
@TableName("shangpin")
public class ShangpinResp extends Shangpin {



    @ExcelProperty(value = "供应商",index = 12)
    @TableField("gysmc")
    private String gysmc;

    @ExcelProperty(value = "计量单位",index = 13)
    @TableField("jldwmc")
    private String jldwmc;

    @ExcelProperty(value = "总类",index = 2)
    @TableField("zlmc")
    private String zlmc;

    @ExcelProperty(value = "大类",index = 3)
    @TableField("dlmc")
    private String dlmc;

    @ExcelProperty(value = "小类",index = 4)
    @TableField("xlmc")
    private String xlmc;

    @ExcelProperty(value = "其他类别",index = 5)
    @TableField("qtlbmc")
    private String qtlbmc;

    @ExcelProperty(value = "品牌名称",index = 1)
    @TableField("ppglmc")
    private String ppglmc;

}
