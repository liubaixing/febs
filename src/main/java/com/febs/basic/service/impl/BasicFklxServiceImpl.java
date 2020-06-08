package com.febs.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.basic.entity.BasicFklx;
import com.febs.basic.mapper.BasicFklxMapper;
import com.febs.basic.service.IBasicFklxService;
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
 * 付款类型 Service实现
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:34
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BasicFklxServiceImpl extends ServiceImpl<BasicFklxMapper, BasicFklx> implements IBasicFklxService {

    @Autowired
    private BasicFklxMapper basicFklxMapper;

    @Override
    public IPage<BasicFklx> findBasicFklxs(QueryRequest request, BasicFklx basicFklx) {
        LambdaQueryWrapper<BasicFklx> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        if(StringUtils.isNotBlank(basicFklx.getFklxdm())){
            queryWrapper.like(BasicFklx::getFklxdm,basicFklx.getFklxdm());
        }
        if(StringUtils.isNotBlank(basicFklx.getFklxmc())){
            queryWrapper.like(BasicFklx::getFklxmc,basicFklx.getFklxmc());
        }
        if(basicFklx.getStatus()!=null){
            queryWrapper.eq(BasicFklx::getStatus,basicFklx.getStatus());
        }
        Page<BasicFklx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<BasicFklx> findBasicFklxs(BasicFklx basicFklx) {
	    LambdaQueryWrapper<BasicFklx> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createBasicFklx(BasicFklx basicFklx) {
        check(basicFklx);
        this.save(basicFklx);
        if(StringUtils.isBlank(basicFklx.getFklxdm())){
            String dm = StringUtil.padStart(basicFklx.getId());
            basicFklx.setFklxdm(dm);
            this.updateById(basicFklx);
        }
    }

    @Override
    @Transactional
    public void updateBasicFklx(BasicFklx basicFklx) {
        if(basicFklx.getId()==null){
            throw new FebsException("id不能为空，添加失败");
        }
        this.updateById(basicFklx);
    }

    @Override
    @Transactional
    public void deleteBasicFklx(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	private void check(BasicFklx basicFklx) throws FebsException{
        LambdaQueryWrapper<BasicFklx> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(basicFklx.getFklxdm())){
            queryWrapper.eq(BasicFklx::getFklxdm,basicFklx.getFklxdm());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("代码重复，添加失败");
            }
        }
        if(StringUtils.isNotBlank(basicFklx.getFklxmc())){
            queryWrapper.eq(BasicFklx::getFklxmc,basicFklx.getFklxmc());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("名称重复，添加失败");
            }
        }
    }
}
