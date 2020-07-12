package com.febs.purchase.service.impl;

import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.purchase.entity.PurchaseCgfpmx;
import com.febs.purchase.mapper.PurchaseCgfpmxMapper;
import com.febs.purchase.service.IPurchaseCgfpmxService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.purchase.vo.resp.PurchaseCgfpmxResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 采购发票明细 Service实现
 *
 * @author liubaixing
 * @date 2020-06-27 19:55:24
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PurchaseCgfpmxServiceImpl extends ServiceImpl<PurchaseCgfpmxMapper, PurchaseCgfpmx> implements IPurchaseCgfpmxService {

    @Autowired
    private PurchaseCgfpmxMapper purchaseCgfpmxMapper;

    @Override
    public IPage<PurchaseCgfpmxResp> findPurchaseCgfpmxs(QueryRequest request, PurchaseCgfpmx purchaseCgfpmx) {
        Page<PurchaseCgfpmx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.purchaseCgfpmxMapper.selectPageByQuery(page, purchaseCgfpmx);
    }

    @Override
    public List<PurchaseCgfpmxResp> findPurchaseCgfpmxs(PurchaseCgfpmx purchaseCgfpmx) {
		return this.purchaseCgfpmxMapper.selectByQuery(purchaseCgfpmx);
    }

    @Override
    @Transactional
    public Long createPurchaseCgfpmx(PurchaseCgfpmx purchaseCgfpmx) {
        this.purchaseCgfpmxMapper.insertSelective(purchaseCgfpmx);
        return purchaseCgfpmx.getId();
    }

    @Override
    @Transactional
    public void updatePurchaseCgfpmx(PurchaseCgfpmx purchaseCgfpmx) {
        this.purchaseCgfpmxMapper.updateByPrimaryKeySelective(purchaseCgfpmx);
    }

    @Override
    @Transactional
    public void deletePurchaseCgfpmx(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
