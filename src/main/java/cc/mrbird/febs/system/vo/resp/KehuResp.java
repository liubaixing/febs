package cc.mrbird.febs.system.vo.resp;

import cc.mrbird.febs.system.entity.Kehu;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

@Data
public class KehuResp extends Kehu {

    @ExcelProperty(value = "客户类型",index = 2)
    private String khlbmc;
    @ExcelProperty(value = "所属用户",index = 3)
    private String userName;

}
