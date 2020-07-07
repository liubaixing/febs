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
    public IPage<PurchaseTcmx> findPurchaseTcmxs(QueryRequest request, PurchaseTcmx purchaseTcmx) {
        LambdaQueryWrapper<PurchaseTcmx> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<PurchaseTcmx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<PurchaseTcmx> findPurchaseTcmxs(PurchaseTcmx purchaseTcmx) {
	    LambdaQueryWrapper<PurchaseTcmx> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
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
