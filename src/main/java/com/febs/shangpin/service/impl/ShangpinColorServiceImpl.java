package com.febs.shangpin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.shangpin.entity.ShangpinColor;
import com.febs.shangpin.mapper.ShangpinColorMapper;
import com.febs.shangpin.service.IShangpinColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 商品颜色 Service实现
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:53
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ShangpinColorServiceImpl extends ServiceImpl<ShangpinColorMapper, ShangpinColor> implements IShangpinColorService {

    @Autowired
    private ShangpinColorMapper shangpinColorMapper;

    @Override
    public IPage<ShangpinColor> findShangpinColors(QueryRequest request, ShangpinColor shangpinColor) {
        LambdaQueryWrapper<ShangpinColor> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<ShangpinColor> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<ShangpinColor> findShangpinColors(ShangpinColor shangpinColor) {
	    LambdaQueryWrapper<ShangpinColor> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createShangpinColor(ShangpinColor shangpinColor) {
        LambdaQueryWrapper<ShangpinColor> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
        throw new FebsException("数据已存在，添加失败");
        }
        this.save(shangpinColor);
    }

    @Override
    @Transactional
    public void updateShangpinColor(ShangpinColor shangpinColor) {
        LambdaQueryWrapper<ShangpinColor> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
        throw new FebsException("数据已存在，添加失败");
        }
        this.saveOrUpdate(shangpinColor);
    }

    @Override
    @Transactional
    public void deleteShangpinColor(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
