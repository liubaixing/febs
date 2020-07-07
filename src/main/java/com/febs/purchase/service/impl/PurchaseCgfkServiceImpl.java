package com.febs.purchase.service.impl;

import com.febs.common.constant.PurchaseConstant;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.DateUtil;
import com.febs.common.utils.StringUtil;
import com.febs.purchase.entity.PurchaseCgfk;
import com.febs.purchase.mapper.PurchaseCgfkMapper;
import com.febs.purchase.service.IPurchaseCgfkService;
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
    public IPage<PurchaseCgfk> findPurchaseCgfks(QueryRequest request, PurchaseCgfk purchaseCgfk) {
        LambdaQueryWrapper<PurchaseCgfk> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<PurchaseCgfk> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<PurchaseCgfk> findPurchaseCgfks(PurchaseCgfk purchaseCgfk) {
	    LambdaQueryWrapper<PurchaseCgfk> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public Long createPurchaseCgfk(PurchaseCgfk purchaseCgfk) {
        this.purchaseCgfkMapper.insertSelective(purchaseCgfk);
        String bh = PurchaseConstant.PURCHASE_FK_PREFIX + DateUtil.getYear() + StringUtil.padStart(purchaseCgfk.getId());
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
    public void deletePurchaseCgfk(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
