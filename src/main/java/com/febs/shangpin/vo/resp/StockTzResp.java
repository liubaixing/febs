package com.febs.shangpin.vo.resp;

import com.febs.shangpin.entity.StockTz;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class StockTzResp extends StockTz {

    private String ckmc;
    private Long mxId;
    private Integer spId;
    private BigDecimal dj;
    private BigDecimal flje;
    private BigDecimal zk;
    private String sku;
    private String spmc;

    private List<StockTzmxResp> stockTzmxList;
}
