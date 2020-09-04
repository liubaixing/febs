package com.febs.system.vo.resp;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.febs.system.entity.Cangku;
import lombok.Data;

/**
 * @ClassName: CangkuResp
 * @Description:
 * @Author:
 * @Date 2020/9/4
 * @Version 1.0
 */
@Data
public class CangkuResp extends Cangku {

    @ExcelIgnore
    private String cklxmc;
}
