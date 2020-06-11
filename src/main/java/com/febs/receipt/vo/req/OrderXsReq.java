package com.febs.receipt.vo.req;

import com.febs.receipt.entity.OrderXs;
import lombok.Data;

import java.util.Date;

@Data
public class OrderXsReq extends OrderXs {

    private Date startTime;
    private Date endTime;

}
