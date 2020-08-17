package com.febs.orderqt.vo.req;

import com.febs.orderqt.entity.OrderqtYfd;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class YfdReq extends OrderqtYfd {

    @ApiModelProperty("单据开始")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date startTime;

    @ApiModelProperty("单据结束")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endTime;

    private String gysmc;

}