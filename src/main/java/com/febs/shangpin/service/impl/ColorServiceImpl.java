package com.febs.shangpin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.shangpin.entity.Color;
import com.febs.shangpin.mapper.ColorMapper;
import com.febs.shangpin.service.IColorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 颜色 Service实现
 *
 * @author liubaixing
 * @date 2020-05-22 00:59:30
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ColorServiceImpl extends ServiceImpl<ColorMapper, Color> implements IColorService {

    @Autowired
    private ColorMapper colorMapper;

    @Override
    public IPage<Color> findColors(QueryRequest request, Color color) {
        LambdaQueryWrapper<Color> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Color> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Color> findColors(Color color) {
	    LambdaQueryWrapper<Color> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createColor(Color color) {
        LambdaQueryWrapper<Color> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
        throw new FebsException("数据已存在，添加失败");
        }
        this.save(color);
    }

    @Override
    @Transactional
    public void updateColor(Color color) {
        LambdaQueryWrapper<Color> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
        throw new FebsException("数据已存在，添加失败");
        }
        this.saveOrUpdate(color);
    }

    @Override
    @Transactional
    public void deleteColor(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
