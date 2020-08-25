package com.febs.purchase.service.impl;

import com.febs.common.constant.PurchaseConstant;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.DateUtil;
import com.febs.common.utils.StringUtil;
import com.febs.purchase.entity.PurchaseCgfk;
import com.febs.purchase.entity.PurchaseCgfkExample;
import com.febs.purchase.mapper.PurchaseCgfkMapper;
import com.febs.purchase.service.IPurchaseCgfkService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.purchase.vo.req.PurchaseCgfkReq;
import com.febs.purchase.vo.resp.PurchaseCgfkResp;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 采购付款 Service实现
 *
 * @author liubaixing
 * @date 2020-06-27 19:46:20
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PurchaseCgfkServiceImpl extends ServiceImpl<PurchaseCgfkMapper, PurchaseCgfk> implements IPurchaseCgfkService {

    @Autowired
    private PurchaseCgfkMapper purchaseCgfkMapper;

    @Override
    public IPage<PurchaseCgfkResp> findPurchaseCgfks(QueryRequest request, PurchaseCgfkReq purchaseCgfk) {
        Page<PurchaseCgfk> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.purchaseCgfkMapper.selectPageByQuery(page, purchaseCgfk);
    }

    @Override
    public List<PurchaseCgfkResp> findPurchaseCgfks(PurchaseCgfkReq purchaseCgfk) {
		return this.purchaseCgfkMapper.selectByQuery(purchaseCgfk);
    }

    @Override
    public PurchaseCgfkResp findById(Long id) {
        PurchaseCgfkReq purchaseCgfk = new PurchaseCgfkReq();
        purchaseCgfk.setId(id);
        List<PurchaseCgfkResp> cgList = findPurchaseCgfks(purchaseCgfk);
        return CollectionUtils.isEmpty(cgList) ? null : cgList.get(0);
    }

    @Override
    @Transactional
    public Long createPurchaseCgfk(PurchaseCgfk purchaseCgfk) {
        this.purchaseCgfkMapper.insertSelective(purchaseCgfk);
        String bh = "";
        if (StringUtils.isNotBlank(purchaseCgfk.getDjbh())){
            bh = purchaseCgfk.getDjbh() + DateUtil.getYear() + StringUtil.padStart(purchaseCgfk.getId());
        }else{
            bh = PurchaseConstant.PURCHASE_FK_PREFIX + DateUtil.getYear() + StringUtil.padStart(purchaseCgfk.getId());
        }
        purchaseCgfk.setDjbh(bh);
        this.purchaseCgfkMapper.updateByPrimaryKeySelective(purchaseCgfk);
        return purchaseCgfk.getId();
    }

    @Override
    @Transactional
    public void updatePurchaseCgfk(PurchaseCgfk purchaseCgfk) {
        this.purchaseCgfkMapper.updateByPrimaryKeySelective(purchaseCgfk);
    }

    @Override
    @Transactional
    public void updateByExample(PurchaseCgfk record, PurchaseCgfkExample example){
        this.purchaseCgfkMapper.updateByExampleSelective(record,example);
    }
    @Override
    @Transactional
    public void deletePurchaseCgfk(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
