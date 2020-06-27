package com.febs.purchase.service.impl;

import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.purchase.entity.PurchaseCgtk;
import com.febs.purchase.mapper.PurchaseCgtkMapper;
import com.febs.purchase.service.IPurchaseCgtkService;
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
 * 采购退款 Service实现
 *
 * @author liubaixing
 * @date 2020-06-27 19:54:56
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PurchaseCgtkServiceImpl extends ServiceImpl<PurchaseCgtkMapper, PurchaseCgtk> implements IPurchaseCgtkService {

    @Autowired
    private PurchaseCgtkMapper purchaseCgtkMapper;

    @Override
    public IPage<PurchaseCgtk> findPurchaseCgtks(QueryRequest request, PurchaseCgtk purchaseCgtk) {
        LambdaQueryWrapper<PurchaseCgtk> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<PurchaseCgtk> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<PurchaseCgtk> findPurchaseCgtks(PurchaseCgtk purchaseCgtk) {
	    LambdaQueryWrapper<PurchaseCgtk> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createPurchaseCgtk(PurchaseCgtk purchaseCgtk) {
        LambdaQueryWrapper<PurchaseCgtk> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
        throw new FebsException("数据已存在，添加失败");
        }
        this.save(purchaseCgtk);
    }

    @Override
    @Transactional
    public void updatePurchaseCgtk(PurchaseCgtk purchaseCgtk) {
        LambdaQueryWrapper<PurchaseCgtk> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
            throw new FebsException("数据已存在，添加失败");
        }
        this.saveOrUpdate(purchaseCgtk);
    }

    @Override
    @Transactional
    public void deletePurchaseCgtk(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
