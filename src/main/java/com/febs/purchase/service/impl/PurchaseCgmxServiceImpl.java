package com.febs.purchase.service.impl;

import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.purchase.entity.PurchaseCgmx;
import com.febs.purchase.mapper.PurchaseCgmxMapper;
import com.febs.purchase.service.IPurchaseCgmxService;
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
 * 采购单明细 Service实现
 *
 * @author liubaixing
 * @date 2020-06-27 19:46:14
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PurchaseCgmxServiceImpl extends ServiceImpl<PurchaseCgmxMapper, PurchaseCgmx> implements IPurchaseCgmxService {

    @Autowired
    private PurchaseCgmxMapper purchaseCgmxMapper;

    @Override
    public IPage<PurchaseCgmx> findPurchaseCgmxs(QueryRequest request, PurchaseCgmx purchaseCgmx) {
        LambdaQueryWrapper<PurchaseCgmx> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<PurchaseCgmx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<PurchaseCgmx> findPurchaseCgmxs(PurchaseCgmx purchaseCgmx) {
	    LambdaQueryWrapper<PurchaseCgmx> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createPurchaseCgmx(PurchaseCgmx purchaseCgmx) {
        LambdaQueryWrapper<PurchaseCgmx> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
        throw new FebsException("数据已存在，添加失败");
        }
        this.save(purchaseCgmx);
    }

    @Override
    @Transactional
    public void updatePurchaseCgmx(PurchaseCgmx purchaseCgmx) {
        LambdaQueryWrapper<PurchaseCgmx> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
            throw new FebsException("数据已存在，添加失败");
        }
        this.saveOrUpdate(purchaseCgmx);
    }

    @Override
    @Transactional
    public void deletePurchaseCgmx(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
