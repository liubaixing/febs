package com.febs.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.common.entity.QueryRequest;
import com.febs.system.entity.CommonId;
import com.febs.system.mapper.CommonIdMapper;
import com.febs.system.service.ICommonIdService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 公共自增id表 Service实现
 *
 * @author liubaixing
 * @date 2020-05-30 22:48:51
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class CommonIdServiceImpl extends ServiceImpl<CommonIdMapper, CommonId> implements ICommonIdService {

    @Autowired
    private CommonIdMapper commonIdMapper;

    @Override
    public IPage<CommonId> findCommonIds(QueryRequest request, CommonId commonId) {
        LambdaQueryWrapper<CommonId> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<CommonId> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<CommonId> findCommonIds(CommonId commonId) {
	    LambdaQueryWrapper<CommonId> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createCommonId(CommonId commonId) {
        this.save(commonId);
    }

    @Override
    @Transactional
    public void updateCommonId(CommonId commonId) {
        this.updateById(commonId);
    }

    @Override
    @Transactional
    public void deleteCommonId(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

}
