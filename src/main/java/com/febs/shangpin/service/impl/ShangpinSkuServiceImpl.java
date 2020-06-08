package com.febs.shangpin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.shangpin.entity.ShangpinSku;
import com.febs.shangpin.mapper.ShangpinSkuMapper;
import com.febs.shangpin.service.IShangpinSkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 商品SKU Service实现
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:56
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ShangpinSkuServiceImpl extends ServiceImpl<ShangpinSkuMapper, ShangpinSku> implements IShangpinSkuService {

    @Autowired
    private ShangpinSkuMapper shangpinSkuMapper;

    @Override
    public IPage<ShangpinSku> findShangpinSkus(QueryRequest request, ShangpinSku shangpinSku) {
        LambdaQueryWrapper<ShangpinSku> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<ShangpinSku> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<ShangpinSku> findShangpinSkus(ShangpinSku shangpinSku) {
	    LambdaQueryWrapper<ShangpinSku> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createShangpinSku(ShangpinSku shangpinSku) {
        LambdaQueryWrapper<ShangpinSku> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
        throw new FebsException("数据已存在，添加失败");
        }
        this.save(shangpinSku);
    }

    @Override
    @Transactional
    public void updateShangpinSku(ShangpinSku shangpinSku) {
        LambdaQueryWrapper<ShangpinSku> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
        throw new FebsException("数据已存在，添加失败");
        }
        this.saveOrUpdate(shangpinSku);
    }

    @Override
    @Transactional
    public void deleteShangpinSku(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
