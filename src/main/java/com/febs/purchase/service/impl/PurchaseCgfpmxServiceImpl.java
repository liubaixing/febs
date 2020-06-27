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
import org.apache.commons.lang3.StringUtils;
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
    public IPage<PurchaseCgfpmx> findPurchaseCgfpmxs(QueryRequest request, PurchaseCgfpmx purchaseCgfpmx) {
        LambdaQueryWrapper<PurchaseCgfpmx> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<PurchaseCgfpmx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<PurchaseCgfpmx> findPurchaseCgfpmxs(PurchaseCgfpmx purchaseCgfpmx) {
	    LambdaQueryWrapper<PurchaseCgfpmx> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createPurchaseCgfpmx(PurchaseCgfpmx purchaseCgfpmx) {
        LambdaQueryWrapper<PurchaseCgfpmx> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
        throw new FebsException("数据已存在，添加失败");
        }
        this.save(purchaseCgfpmx);
    }

    @Override
    @Transactional
    public void updatePurchaseCgfpmx(PurchaseCgfpmx purchaseCgfpmx) {
        LambdaQueryWrapper<PurchaseCgfpmx> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
            throw new FebsException("数据已存在，添加失败");
        }
        this.saveOrUpdate(purchaseCgfpmx);
    }

    @Override
    @Transactional
    public void deletePurchaseCgfpmx(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
