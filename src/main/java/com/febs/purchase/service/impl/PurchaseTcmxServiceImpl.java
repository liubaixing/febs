package com.febs.purchase.service.impl;

import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.purchase.entity.PurchaseTcmx;
import com.febs.purchase.mapper.PurchaseTcmxMapper;
import com.febs.purchase.service.IPurchaseTcmxService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.purchase.vo.resp.PurchaseTcmxResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 退仓单明细 Service实现
 *
 * @author liubaixing
 * @date 2020-06-27 19:55:35
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PurchaseTcmxServiceImpl extends ServiceImpl<PurchaseTcmxMapper, PurchaseTcmx> implements IPurchaseTcmxService {

    @Autowired
    private PurchaseTcmxMapper purchaseTcmxMapper;

    @Override
    public IPage<PurchaseTcmxResp> findPurchaseTcmxs(QueryRequest request, PurchaseTcmx purchaseTcmx) {
        Page<PurchaseTcmx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.purchaseTcmxMapper.selectPageByQuery(page, purchaseTcmx);
    }

    @Override
    public List<PurchaseTcmxResp> findPurchaseTcmxs(PurchaseTcmx purchaseTcmx) {
		return this.purchaseTcmxMapper.selectByQuery(purchaseTcmx);
    }

    @Override
    @Transactional
    public Long createPurchaseTcmx(PurchaseTcmx purchaseTcmx) {
        this.purchaseTcmxMapper.insertSelective(purchaseTcmx);
        return purchaseTcmx.getId();
    }

    @Override
    @Transactional
    public void updatePurchaseTcmx(PurchaseTcmx purchaseTcmx) {
        this.purchaseTcmxMapper.updateByPrimaryKeySelective(purchaseTcmx);
    }

    @Override
    @Transactional
    public void deletePurchaseTcmx(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
