package com.febs.purchase.view;

import com.febs.orderqt.vo.resp.YfdResp;
import com.febs.orderqt.vo.resp.YsfdResp;
import com.febs.purchase.vo.resp.PurchaseCgResp;
import com.febs.purchase.vo.resp.PurchaseTcResp;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class CgfkView {

    private List<PurchaseCgResp> cgRespList = new ArrayList<>();
    private List<PurchaseTcResp> tcRespList = new ArrayList<>();
    private List<YfdResp> yfdRespList = new ArrayList<>();
    private List<YsfdResp> ysfdRespList = new ArrayList<>();

}
