package com.febs.shangpin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.shangpin.entity.ShangpinSize;
import com.febs.shangpin.mapper.ShangpinSizeMapper;
import com.febs.shangpin.service.IShangpinSizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 商品尺码 Service实现
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:46
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ShangpinSizeServiceImpl extends ServiceImpl<ShangpinSizeMapper, ShangpinSize> implements IShangpinSizeService {

    @Autowired
    private ShangpinSizeMapper shangpinSizeMapper;

    @Override
    public IPage<ShangpinSize> findShangpinSizes(QueryRequest request, ShangpinSize shangpinSize) {
        LambdaQueryWrapper<ShangpinSize> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<ShangpinSize> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<ShangpinSize> findShangpinSizes(ShangpinSize shangpinSize) {
	    LambdaQueryWrapper<ShangpinSize> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createShangpinSize(ShangpinSize shangpinSize) {
        LambdaQueryWrapper<ShangpinSize> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
        throw new FebsException("数据已存在，添加失败");
        }
        this.save(shangpinSize);
    }

    @Override
    @Transactional
    public void updateShangpinSize(ShangpinSize shangpinSize) {
        LambdaQueryWrapper<ShangpinSize> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
        throw new FebsException("数据已存在，添加失败");
        }
        this.saveOrUpdate(shangpinSize);
    }

    @Override
    @Transactional
    public void deleteShangpinSize(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
