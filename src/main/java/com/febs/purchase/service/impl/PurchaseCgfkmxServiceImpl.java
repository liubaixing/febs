package com.febs.purchase.service.impl;

import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.purchase.entity.PurchaseCgfkmx;
import com.febs.purchase.mapper.PurchaseCgfkmxMapper;
import com.febs.purchase.service.IPurchaseCgfkmxService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 采购付款明细 Service实现
 *
 * @author liubaixing
 * @date 2020-06-27 20:02:41
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PurchaseCgfkmxServiceImpl extends ServiceImpl<PurchaseCgfkmxMapper, PurchaseCgfkmx> implements IPurchaseCgfkmxService {

    @Autowired
    private PurchaseCgfkmxMapper purchaseCgfkmxMapper;

    @Override
    public IPage<PurchaseCgfkmx> findPurchaseCgfkmxs(QueryRequest request, PurchaseCgfkmx purchaseCgfkmx) {
        LambdaQueryWrapper<PurchaseCgfkmx> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<PurchaseCgfkmx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<PurchaseCgfkmx> findPurchaseCgfkmxs(PurchaseCgfkmx purchaseCgfkmx) {
	    LambdaQueryWrapper<PurchaseCgfkmx> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public Long createPurchaseCgfkmx(PurchaseCgfkmx purchaseCgfkmx) {
        this.purchaseCgfkmxMapper.insertSelective(purchaseCgfkmx);
        return purchaseCgfkmx.getId();
    }

    @Override
    @Transactional
    public void updatePurchaseCgfkmx(PurchaseCgfkmx purchaseCgfkmx) {
        this.purchaseCgfkmxMapper.updateByPrimaryKeySelective(purchaseCgfkmx);
    }

    @Override
    @Transactional
    public void deletePurchaseCgfkmx(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
