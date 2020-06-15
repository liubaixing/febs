package com.febs.receipt.vo.resp;

import com.febs.receipt.entity.OrderXsmx;
import lombok.Data;

@Data
public class OrderXsmxResp extends OrderXsmx {

    private String spdm;
    private String spmc;
    private String memo;
    private String jldwmc;
}
