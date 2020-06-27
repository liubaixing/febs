package com.febs.purchase.service.impl;

import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.purchase.entity.PurchaseRkmx;
import com.febs.purchase.mapper.PurchaseRkmxMapper;
import com.febs.purchase.service.IPurchaseRkmxService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 入库单明细 Service实现
 *
 * @author liubaixing
 * @date 2020-06-27 19:56:10
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PurchaseRkmxServiceImpl extends ServiceImpl<PurchaseRkmxMapper, PurchaseRkmx> implements IPurchaseRkmxService {

    @Autowired
    private PurchaseRkmxMapper purchaseRkmxMapper;

    @Override
    public IPage<PurchaseRkmx> findPurchaseRkmxs(QueryRequest request, PurchaseRkmx purchaseRkmx) {
        LambdaQueryWrapper<PurchaseRkmx> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<PurchaseRkmx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<PurchaseRkmx> findPurchaseRkmxs(PurchaseRkmx purchaseRkmx) {
	    LambdaQueryWrapper<PurchaseRkmx> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createPurchaseRkmx(PurchaseRkmx purchaseRkmx) {
        LambdaQueryWrapper<PurchaseRkmx> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
        throw new FebsException("数据已存在，添加失败");
        }
        this.save(purchaseRkmx);
    }

    @Override
    @Transactional
    public void updatePurchaseRkmx(PurchaseRkmx purchaseRkmx) {
        LambdaQueryWrapper<PurchaseRkmx> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
            throw new FebsException("数据已存在，添加失败");
        }
        this.saveOrUpdate(purchaseRkmx);
    }

    @Override
    @Transactional
    public void deletePurchaseRkmx(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
