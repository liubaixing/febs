package com.febs.purchase.service.impl;

import com.febs.common.constant.PurchaseConstant;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.DateUtil;
import com.febs.common.utils.StringUtil;
import com.febs.purchase.entity.PurchaseCgfp;
import com.febs.purchase.entity.PurchaseCgfpExample;
import com.febs.purchase.mapper.PurchaseCgfpMapper;
import com.febs.purchase.service.IPurchaseCgfpService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.purchase.vo.req.PurchaseCgfpReq;
import com.febs.purchase.vo.resp.PurchaseCgfpResp;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 采购发票 Service实现
 *
 * @author liubaixing
 * @date 2020-06-27 19:55:27
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PurchaseCgfpServiceImpl extends ServiceImpl<PurchaseCgfpMapper, PurchaseCgfp> implements IPurchaseCgfpService {

    @Autowired
    private PurchaseCgfpMapper purchaseCgfpMapper;

    @Override
    public IPage<PurchaseCgfpResp> findPurchaseCgfps(QueryRequest request, PurchaseCgfpReq purchaseCgfp) {
        Page<PurchaseCgfp> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.purchaseCgfpMapper.selectPageByQuery(page, purchaseCgfp);
    }

    @Override
    public List<PurchaseCgfpResp> findPurchaseCgfps(PurchaseCgfpReq purchaseCgfp) {
		return this.purchaseCgfpMapper.selectByQuery(purchaseCgfp);
    }

    @Override
    public PurchaseCgfpResp findById(Long id) {
        PurchaseCgfpReq purchaseCgfp = new PurchaseCgfpReq();
        purchaseCgfp.setId(id);
        List<PurchaseCgfpResp> cgfpList = findPurchaseCgfps(purchaseCgfp);
        return CollectionUtils.isEmpty(cgfpList) ? null : cgfpList.get(0);
    }


    @Override
    @Transactional
    public Long createPurchaseCgfp(PurchaseCgfp purchaseCgfp) {
        this.purchaseCgfpMapper.insertSelective(purchaseCgfp);

        String bh = "";
        if (StringUtils.isNotBlank(purchaseCgfp.getDjbh())){
            bh = purchaseCgfp.getDjbh() + DateUtil.getYear() + StringUtil.padStart(purchaseCgfp.getId());
        }else{
            bh = PurchaseConstant.PURCHASE_FP_PREFIX + DateUtil.getYear() + StringUtil.padStart(purchaseCgfp.getId());
        }
        purchaseCgfp.setDjbh(bh);

        this.purchaseCgfpMapper.updateByPrimaryKeySelective(purchaseCgfp);
        return purchaseCgfp.getId();
    }

    @Override
    @Transactional
    public void updatePurchaseCgfp(PurchaseCgfp purchaseCgfp) {
        this.purchaseCgfpMapper.updateByPrimaryKeySelective(purchaseCgfp);
    }

    @Override
    @Transactional
    public void updateByExample(PurchaseCgfp record,PurchaseCgfpExample example){
        this.purchaseCgfpMapper.updateByExampleSelective(record,example);
    }

    @Override
    @Transactional
    public void deletePurchaseCgfp(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
