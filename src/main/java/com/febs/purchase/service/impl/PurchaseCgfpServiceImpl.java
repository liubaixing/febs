package com.febs.purchase.service.impl;

import com.febs.common.constant.PurchaseConstant;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.DateUtil;
import com.febs.common.utils.StringUtil;
import com.febs.purchase.entity.PurchaseCgfp;
import com.febs.purchase.mapper.PurchaseCgfpMapper;
import com.febs.purchase.service.IPurchaseCgfpService;
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
    public IPage<PurchaseCgfp> findPurchaseCgfps(QueryRequest request, PurchaseCgfp purchaseCgfp) {
        LambdaQueryWrapper<PurchaseCgfp> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<PurchaseCgfp> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<PurchaseCgfp> findPurchaseCgfps(PurchaseCgfp purchaseCgfp) {
	    LambdaQueryWrapper<PurchaseCgfp> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public Long createPurchaseCgfp(PurchaseCgfp purchaseCgfp) {
        this.purchaseCgfpMapper.insertSelective(purchaseCgfp);
        String bh = PurchaseConstant.PURCHASE_RK_PREFIX + DateUtil.getYear() + StringUtil.padStart(purchaseCgfp.getId());
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
    public void deletePurchaseCgfp(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
