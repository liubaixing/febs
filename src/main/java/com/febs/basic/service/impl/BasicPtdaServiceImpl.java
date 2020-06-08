package com.febs.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.basic.entity.BasicPtda;
import com.febs.basic.mapper.BasicPtdaMapper;
import com.febs.basic.service.IBasicPtdaService;
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
 * 平台档案 Service实现
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:40
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BasicPtdaServiceImpl extends ServiceImpl<BasicPtdaMapper, BasicPtda> implements IBasicPtdaService {

    @Autowired
    private BasicPtdaMapper basicPtdaMapper;

    @Override
    public IPage<BasicPtda> findBasicPtdas(QueryRequest request, BasicPtda basicPtda) {
        LambdaQueryWrapper<BasicPtda> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        if(StringUtils.isNotBlank(basicPtda.getPtdadm())){
            queryWrapper.like(BasicPtda::getPtdadm,basicPtda.getPtdadm());
        }
        if(StringUtils.isNotBlank(basicPtda.getPtdamc())){
            queryWrapper.like(BasicPtda::getPtdamc,basicPtda.getPtdamc());
        }
        if(basicPtda.getStatus()!=null){
            queryWrapper.eq(BasicPtda::getStatus,basicPtda.getStatus());
        }
        Page<BasicPtda> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<BasicPtda> findBasicPtdas(BasicPtda basicPtda) {
	    LambdaQueryWrapper<BasicPtda> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createBasicPtda(BasicPtda basicPtda) {
        check(basicPtda);
        this.save(basicPtda);
        if(StringUtils.isBlank(basicPtda.getPtdadm())){
            String dm = StringUtil.padStart(basicPtda.getId());
            basicPtda.setPtdadm(dm);
            this.updateById(basicPtda);
        }
    }

    @Override
    @Transactional
    public void updateBasicPtda(BasicPtda basicPtda) {
        if(basicPtda.getId()==null){
            throw new FebsException("id不能为空，修改失败");
        }
        this.updateById(basicPtda);
    }

    @Override
    @Transactional
    public void deleteBasicPtda(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	private void check(BasicPtda basicPtda) throws FebsException{
        LambdaQueryWrapper<BasicPtda> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(basicPtda.getPtdadm())){
            queryWrapper.eq(BasicPtda::getPtdadm,basicPtda.getPtdadm());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("代码重复，添加失败");
            }
        }
        if(StringUtils.isNotBlank(basicPtda.getPtdamc())){
            queryWrapper.eq(BasicPtda::getPtdamc,basicPtda.getPtdamc());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("名称重复，添加失败");
            }
        }
    }
}
