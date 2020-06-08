package com.febs.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.basic.entity.BasicFpsd;
import com.febs.basic.mapper.BasicFpsdMapper;
import com.febs.basic.service.IBasicFpsdService;
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
 * 发票税点 Service实现
 *
 * @author liubaixing
 * @date 2020-05-22 01:27:27
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BasicFpsdServiceImpl extends ServiceImpl<BasicFpsdMapper, BasicFpsd> implements IBasicFpsdService {

    @Autowired
    private BasicFpsdMapper basicFpsdMapper;

    @Override
    public IPage<BasicFpsd> findBasicFpsds(QueryRequest request, BasicFpsd basicFpsd) {
        LambdaQueryWrapper<BasicFpsd> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        if(StringUtils.isNotBlank(basicFpsd.getFpsddm())){
            queryWrapper.like(BasicFpsd::getFpsddm,basicFpsd.getFpsddm());
        }
        if(StringUtils.isNotBlank(basicFpsd.getFpsdmc())){
            queryWrapper.like(BasicFpsd::getFpsdmc,basicFpsd.getFpsdmc());
        }
        if(basicFpsd.getStatus()!=null){
            queryWrapper.eq(BasicFpsd::getStatus,basicFpsd.getStatus());
        }
        Page<BasicFpsd> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<BasicFpsd> findBasicFpsds(BasicFpsd basicFpsd) {
	    LambdaQueryWrapper<BasicFpsd> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createBasicFpsd(BasicFpsd basicFpsd) {
        check(basicFpsd);
        this.save(basicFpsd);
        if(StringUtils.isBlank(basicFpsd.getFpsddm())){
            String dm = StringUtil.padStart(basicFpsd.getId());
            basicFpsd.setFpsddm(dm);
            this.updateById(basicFpsd);
        }
    }

    @Override
    @Transactional
    public void updateBasicFpsd(BasicFpsd basicFpsd) {
        if(basicFpsd.getId()==null){
            throw new FebsException("id不能为空，修改失败");
        }
        this.updateById(basicFpsd);
    }

    @Override
    @Transactional
    public void deleteBasicFpsd(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	private void check(BasicFpsd basicFpsd) throws FebsException{
        LambdaQueryWrapper<BasicFpsd> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(basicFpsd.getFpsddm())){
            queryWrapper.eq(BasicFpsd::getFpsddm,basicFpsd.getFpsddm());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("代码重复，添加失败");
            }
        }
        if(StringUtils.isNotBlank(basicFpsd.getFpsdmc())){
            queryWrapper.eq(BasicFpsd::getFpsdmc,basicFpsd.getFpsdmc());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("名称重复，添加失败");
            }
        }
    }
}
