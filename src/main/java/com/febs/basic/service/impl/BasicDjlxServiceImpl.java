package com.febs.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.basic.entity.BasicDjlx;
import com.febs.basic.mapper.BasicDjlxMapper;
import com.febs.basic.service.IBasicDjlxService;
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
 * 单据类型 Service实现
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:22
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BasicDjlxServiceImpl extends ServiceImpl<BasicDjlxMapper, BasicDjlx> implements IBasicDjlxService {

    @Autowired
    private BasicDjlxMapper basicDjlxMapper;

    @Override
    public IPage<BasicDjlx> findBasicDjlxs(QueryRequest request, BasicDjlx basicDjlx) {
        LambdaQueryWrapper<BasicDjlx> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        if(StringUtils.isNotBlank(basicDjlx.getDjlxdm())){
            queryWrapper.like(BasicDjlx::getDjlxdm,basicDjlx.getDjlxdm());
        }
        if(StringUtils.isNotBlank(basicDjlx.getDjlxmc())){
            queryWrapper.like(BasicDjlx::getDjlxmc,basicDjlx.getDjlxmc());
        }
        if(basicDjlx.getStatus()!=null){
            queryWrapper.eq(BasicDjlx::getStatus,basicDjlx.getStatus());
        }
        Page<BasicDjlx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<BasicDjlx> findBasicDjlxs(BasicDjlx basicDjlx) {
	    LambdaQueryWrapper<BasicDjlx> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createBasicDjlx(BasicDjlx basicDjlx) {
        check(basicDjlx);
        this.save(basicDjlx);
        if(StringUtils.isBlank(basicDjlx.getDjlxdm())){
            String dm = StringUtil.padStart(basicDjlx.getId());
            basicDjlx.setDjlxdm(dm);
            this.updateById(basicDjlx);
        }
    }

    @Override
    @Transactional
    public void updateBasicDjlx(BasicDjlx basicDjlx) {
        if(basicDjlx.getId()==null){
            throw new FebsException("id不能为空，修改失败");
        }
        this.updateById(basicDjlx);
    }

    @Override
    @Transactional
    public void deleteBasicDjlx(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	private void check(BasicDjlx basicDjlx) throws FebsException{
        LambdaQueryWrapper<BasicDjlx> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(basicDjlx.getDjlxdm())){
            queryWrapper.eq(BasicDjlx::getDjlxdm,basicDjlx.getDjlxdm());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("代码重复，添加失败");
            }
        }
        if(StringUtils.isNotBlank(basicDjlx.getDjlxmc())){
            queryWrapper.eq(BasicDjlx::getDjlxmc,basicDjlx.getDjlxmc());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("名称重复，添加失败");
            }
        }
    }

}
