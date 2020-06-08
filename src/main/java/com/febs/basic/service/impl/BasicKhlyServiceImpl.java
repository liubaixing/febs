package com.febs.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.basic.entity.BasicKhly;
import com.febs.basic.mapper.BasicKhlyMapper;
import com.febs.basic.service.IBasicKhlyService;
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
 * 客户来源 Service实现
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:54
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BasicKhlyServiceImpl extends ServiceImpl<BasicKhlyMapper, BasicKhly> implements IBasicKhlyService {

    @Autowired
    private BasicKhlyMapper basicKhlyMapper;

    @Override
    public IPage<BasicKhly> findBasicKhlys(QueryRequest request, BasicKhly basicKhly) {
        LambdaQueryWrapper<BasicKhly> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        if(StringUtils.isNotBlank(basicKhly.getKhlydm())){
            queryWrapper.like(BasicKhly::getKhlydm,basicKhly.getKhlydm());
        }
        if(StringUtils.isNotBlank(basicKhly.getKhlymc())){
            queryWrapper.like(BasicKhly::getKhlymc,basicKhly.getKhlymc());
        }
        if(basicKhly.getStatus()!=null){
            queryWrapper.eq(BasicKhly::getStatus,basicKhly.getStatus());
        }
        Page<BasicKhly> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<BasicKhly> findBasicKhlys(BasicKhly basicKhly) {
	    LambdaQueryWrapper<BasicKhly> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createBasicKhly(BasicKhly basicKhly) {
        check(basicKhly);
        this.save(basicKhly);
        if(StringUtils.isBlank(basicKhly.getKhlydm())){
            String dm = StringUtil.padStart(basicKhly.getId());
            basicKhly.setKhlydm(dm);
            this.updateById(basicKhly);
        }
    }

    @Override
    @Transactional
    public void updateBasicKhly(BasicKhly basicKhly) {
        if(basicKhly.getId()==null){
            throw new FebsException("id不能为空，修改失败");
        }
        this.updateById(basicKhly);
    }

    @Override
    @Transactional
    public void deleteBasicKhly(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	private void check(BasicKhly basicKhly) throws FebsException{
        LambdaQueryWrapper<BasicKhly> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(basicKhly.getKhlydm())){
            queryWrapper.eq(BasicKhly::getKhlydm,basicKhly.getKhlydm());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("代码重复，添加失败");
            }
        }
        if(StringUtils.isNotBlank(basicKhly.getKhlymc())){
            queryWrapper.eq(BasicKhly::getKhlymc,basicKhly.getKhlymc());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("名称重复，添加失败");
            }
        }
    }
}
