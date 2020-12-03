package com.febs.purchase.view;

import com.febs.orderqt.vo.resp.YfdResp;
import com.febs.orderqt.vo.resp.YsfdResp;
import com.febs.purchase.vo.resp.PurchaseCgResp;
import com.febs.purchase.vo.resp.PurchaseTcResp;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CgfpView
 * @Description:
 * @Author:
 * @Date 2020/12/3
 * @Version 1.0
 */
@Data
public class CgfpView {

    private List<PurchaseCgResp> cgRespList = new ArrayList<>();
    private List<PurchaseTcResp> tcRespList = new ArrayList<>();
    private List<YfdResp> yfdRespList = new ArrayList<>();
    private List<YsfdResp> ysfdRespList = new ArrayList<>();

}
