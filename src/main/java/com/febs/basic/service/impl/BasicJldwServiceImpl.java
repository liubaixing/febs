package com.febs.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.basic.entity.BasicJldw;
import com.febs.basic.mapper.BasicJldwMapper;
import com.febs.basic.service.IBasicJldwService;
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
 * 计量单位 Service实现
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:11
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BasicJldwServiceImpl extends ServiceImpl<BasicJldwMapper, BasicJldw> implements IBasicJldwService {

    @Autowired
    private BasicJldwMapper basicJldwMapper;

    @Override
    public IPage<BasicJldw> findBasicJldws(QueryRequest request, BasicJldw basicJldw) {
        LambdaQueryWrapper<BasicJldw> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        if(StringUtils.isNotBlank(basicJldw.getJldwdm())){
            queryWrapper.like(BasicJldw::getJldwdm,basicJldw.getJldwdm());
        }
        if(StringUtils.isNotBlank(basicJldw.getJldwmc())){
            queryWrapper.like(BasicJldw::getJldwmc,basicJldw.getJldwmc());
        }
        if(basicJldw.getStatus()!=null){
            queryWrapper.eq(BasicJldw::getStatus,basicJldw.getStatus());
        }
        Page<BasicJldw> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<BasicJldw> findBasicJldws(BasicJldw basicJldw) {
	    LambdaQueryWrapper<BasicJldw> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createBasicJldw(BasicJldw basicJldw) {
        check(basicJldw);
        this.save(basicJldw);
        if(StringUtils.isBlank(basicJldw.getJldwdm())){
            String dm = StringUtil.padStart(basicJldw.getId());
            basicJldw.setJldwdm(dm);
            this.updateById(basicJldw);
        }
    }

    @Override
    @Transactional
    public void updateBasicJldw(BasicJldw basicJldw) {
        if(basicJldw.getId()==null){
            throw new FebsException("id不能为空，修改失败");
        }
        this.updateById(basicJldw);
    }

    @Override
    @Transactional
    public void deleteBasicJldw(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	private void check(BasicJldw basicJldw) throws FebsException{
        LambdaQueryWrapper<BasicJldw> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(basicJldw.getJldwdm())){
            queryWrapper.eq(BasicJldw::getJldwdm,basicJldw.getJldwdm());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("代码重复，添加失败");
            }
        }
        if(StringUtils.isNotBlank(basicJldw.getJldwmc())){
            queryWrapper.eq(BasicJldw::getJldwmc,basicJldw.getJldwmc());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("代码重复，添加失败");
            }
        }
    }
}
