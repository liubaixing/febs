package com.febs.shangpin.vo.resp;

import com.febs.shangpin.entity.StockTzmx;
import lombok.Data;

/**
 * @ClassName: StockTzmxResp
 * @Description:
 * @Author:
 * @Date 2020/11/4
 * @Version 1.0
 */
@Data
public class StockTzmxResp extends StockTzmx {

    private String spmc;
    private String spdm;
    private String memo;
    private String ckmc;

}
