package com.febs.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.basic.entity.BasicLlly;
import com.febs.basic.mapper.BasicLllyMapper;
import com.febs.basic.service.IBasicLllyService;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.StringUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 流量来源 Service实现
 *
 * @author liubaixing
 * @date 2020-05-22 01:40:04
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BasicLllyServiceImpl extends ServiceImpl<BasicLllyMapper, BasicLlly> implements IBasicLllyService {

    @Autowired
    private BasicLllyMapper basicLllyMapper;

    @Override
    public IPage<BasicLlly> findBasicLllys(QueryRequest request, BasicLlly basicLlly) {
        LambdaQueryWrapper<BasicLlly> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        if(StringUtils.isNotBlank(basicLlly.getLllydm())){
            queryWrapper.like(BasicLlly::getLllydm,basicLlly.getLllydm());
        }
        if(StringUtils.isNotBlank(basicLlly.getLllymc())){
            queryWrapper.like(BasicLlly::getLllymc,basicLlly.getLllymc());
        }
        if(basicLlly.getStatus()!=null){
            queryWrapper.eq(BasicLlly::getStatus,basicLlly.getStatus());
        }
        Page<BasicLlly> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<BasicLlly> findBasicLllys(BasicLlly basicLlly) {
	    LambdaQueryWrapper<BasicLlly> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createBasicLlly(BasicLlly basicLlly) {
        check(basicLlly);
        this.save(basicLlly);
        if(StringUtils.isBlank(basicLlly.getLllydm())){
            String dm = StringUtil.padStart(basicLlly.getId());
            basicLlly.setLllydm(dm);
            this.updateById(basicLlly);
        }
    }

    @Override
    @Transactional
    public void updateBasicLlly(BasicLlly basicLlly) {
        if(basicLlly.getId()==null){
            throw new FebsException("id不能为空，修改失败");
        }
        this.updateById(basicLlly);
    }

    @Override
    @Transactional
    public void deleteBasicLlly(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	private void check(BasicLlly basicLlly) throws FebsException{
        LambdaQueryWrapper<BasicLlly> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(basicLlly.getLllydm())){
            queryWrapper.eq(BasicLlly::getLllydm,basicLlly.getLllydm());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("代码重复，添加失败");
            }
        }
        if(StringUtils.isNotBlank(basicLlly.getLllymc())){
            queryWrapper.eq(BasicLlly::getLllymc,basicLlly.getLllymc());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("名称重复，添加失败");
            }
        }
    }
}
