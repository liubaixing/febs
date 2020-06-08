package com.febs.shangpin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.shangpin.entity.Size;
import com.febs.shangpin.mapper.SizeMapper;
import com.febs.shangpin.service.ISizeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 尺码 Service实现
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:58
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class SizeServiceImpl extends ServiceImpl<SizeMapper, Size> implements ISizeService {

    @Autowired
    private SizeMapper sizeMapper;

    @Override
    public IPage<Size> findSizes(QueryRequest request, Size size) {
        LambdaQueryWrapper<Size> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Size> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Size> findSizes(Size size) {
	    LambdaQueryWrapper<Size> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createSize(Size size) {
        LambdaQueryWrapper<Size> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
        throw new FebsException("数据已存在，添加失败");
        }
        this.save(size);
    }

    @Override
    @Transactional
    public void updateSize(Size size) {
        LambdaQueryWrapper<Size> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
        throw new FebsException("数据已存在，添加失败");
        }
        this.saveOrUpdate(size);
    }

    @Override
    @Transactional
    public void deleteSize(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
