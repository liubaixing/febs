package com.febs.shangpin.vo.req;

import com.febs.shangpin.entity.StockTz;
import com.febs.shangpin.entity.StockTzmx;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class StockTzReq extends StockTz {

    @ApiModelProperty("单据开始")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;
    @ApiModelProperty("单据结束")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    private String spmc;

    private List<StockTzmx> stockTzmxList;

}
