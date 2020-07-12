package com.febs.purchase.service.impl;

import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.purchase.entity.PurchaseCgtkmx;
import com.febs.purchase.mapper.PurchaseCgtkmxMapper;
import com.febs.purchase.service.IPurchaseCgtkmxService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.purchase.vo.resp.PurchaseCgtkmxResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 采购退款明细 Service实现
 *
 * @author liubaixing
 * @date 2020-06-27 19:54:49
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PurchaseCgtkmxServiceImpl extends ServiceImpl<PurchaseCgtkmxMapper, PurchaseCgtkmx> implements IPurchaseCgtkmxService {

    @Autowired
    private PurchaseCgtkmxMapper purchaseCgtkmxMapper;

    @Override
    public IPage<PurchaseCgtkmxResp> findPurchaseCgtkmxs(QueryRequest request, PurchaseCgtkmx purchaseCgtkmx) {
        Page<PurchaseCgtkmx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.purchaseCgtkmxMapper.selectPageByQuery(page, purchaseCgtkmx);
    }

    @Override
    public List<PurchaseCgtkmxResp> findPurchaseCgtkmxs(PurchaseCgtkmx purchaseCgtkmx) {
		return this.purchaseCgtkmxMapper.selectByQuery(purchaseCgtkmx);
    }

    @Override
    @Transactional
    public Long createPurchaseCgtkmx(PurchaseCgtkmx purchaseCgtkmx) {
        this.purchaseCgtkmxMapper.insertSelective(purchaseCgtkmx);
        return purchaseCgtkmx.getId();
    }

    @Override
    @Transactional
    public void updatePurchaseCgtkmx(PurchaseCgtkmx purchaseCgtkmx) {
        this.purchaseCgtkmxMapper.updateByPrimaryKeySelective(purchaseCgtkmx);
    }

    @Override
    @Transactional
    public void deletePurchaseCgtkmx(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
