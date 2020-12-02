package com.febs.orderqt.vo.req;

import com.alibaba.excel.annotation.ExcelIgnore;
import com.febs.orderqt.entity.OrderqtYfd;
import com.febs.orderqt.entity.OrderqtYfdmx;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

@Data
public class YfdReq extends OrderqtYfd {

    @ApiModelProperty("单据开始")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    @ApiModelProperty("单据结束")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    private String gysmc;

    private List<OrderqtYfdmx> yfdmxeList;

    private String ydjh;

    private Integer spId;

    @ExcelIgnore
    private List<String> djbhList;

}
