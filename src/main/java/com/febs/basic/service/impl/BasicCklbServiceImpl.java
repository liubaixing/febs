package com.febs.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.basic.entity.BasicCklb;
import com.febs.basic.mapper.BasicCklbMapper;
import com.febs.basic.service.IBasicCklbService;
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
 * 仓库类别 Service实现
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:18
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BasicCklbServiceImpl extends ServiceImpl<BasicCklbMapper, BasicCklb> implements IBasicCklbService {

    @Autowired
    private BasicCklbMapper basicCklbMapper;

    @Override
    public IPage<BasicCklb> findBasicCklbs(QueryRequest request, BasicCklb basicCklb) {
        LambdaQueryWrapper<BasicCklb> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        if(StringUtils.isNotBlank(basicCklb.getCklbdm())){
            queryWrapper.like(BasicCklb::getCklbdm,basicCklb.getCklbdm());
        }
        if(StringUtils.isNotBlank(basicCklb.getCklbmc())){
            queryWrapper.like(BasicCklb::getCklbmc,basicCklb.getCklbmc());
        }
        if(basicCklb.getStatus()!=null){
            queryWrapper.eq(BasicCklb::getStatus,basicCklb.getStatus());
        }
        Page<BasicCklb> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<BasicCklb> findBasicCklbs(BasicCklb basicCklb) {
	    LambdaQueryWrapper<BasicCklb> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createBasicCklb(BasicCklb basicCklb) {
        check(basicCklb);
        this.save(basicCklb);
        if(StringUtils.isBlank(basicCklb.getCklbdm())){
            String dm = StringUtil.padStart(basicCklb.getId());
            basicCklb.setCklbdm(dm);
            this.updateById(basicCklb);
        }
    }

    @Override
    @Transactional
    public void updateBasicCklb(BasicCklb basicCklb) {
        if(basicCklb.getId()==null){
            throw new FebsException("id不能为空，修改失败");
        }
        this.updateById(basicCklb);
    }

    @Override
    @Transactional
    public void deleteBasicCklb(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	private void check(BasicCklb basicCklb) throws FebsException{
        LambdaQueryWrapper<BasicCklb> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(basicCklb.getCklbdm())){
            queryWrapper.eq(BasicCklb::getCklbdm,basicCklb.getCklbdm());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("代码重复，添加失败");
            }
        }
        if(StringUtils.isNotBlank(basicCklb.getCklbmc())){
            queryWrapper.eq(BasicCklb::getCklbmc,basicCklb.getCklbmc());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("名称重复，添加失败");
            }
        }
    }

}
