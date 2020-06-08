package com.febs.system.vo.resp;

import com.alibaba.excel.annotation.ExcelProperty;
import com.febs.system.entity.Kehu;
import lombok.Data;

@Data
public class KehuResp extends Kehu {

    @ExcelProperty(value = "客户类型",index = 1)
    private String khlbmc;
    @ExcelProperty(value = "所属用户",index = 2)
    private String userName;

}
