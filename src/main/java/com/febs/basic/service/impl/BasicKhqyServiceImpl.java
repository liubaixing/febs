package com.febs.basic.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.basic.entity.BasicKhqy;
import com.febs.basic.mapper.BasicKhqyMapper;
import com.febs.basic.service.IBasicKhqyService;
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
 * 客户区域 Service实现
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:58
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BasicKhqyServiceImpl extends ServiceImpl<BasicKhqyMapper, BasicKhqy> implements IBasicKhqyService {

    @Autowired
    private BasicKhqyMapper basicKhqyMapper;

    @Override
    public IPage<BasicKhqy> findBasicKhqys(QueryRequest request, BasicKhqy basicKhqy) {
        LambdaQueryWrapper<BasicKhqy> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        if(StringUtils.isNotBlank(basicKhqy.getKhqydm())){
            queryWrapper.like(BasicKhqy::getKhqydm,basicKhqy.getKhqydm());
        }
        if(StringUtils.isNotBlank(basicKhqy.getKhqymc())){
            queryWrapper.like(BasicKhqy::getKhqymc,basicKhqy.getKhqymc());
        }
        if(basicKhqy.getStatus()!=null){
            queryWrapper.eq(BasicKhqy::getStatus,basicKhqy.getStatus());
        }
        Page<BasicKhqy> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<BasicKhqy> findBasicKhqys(BasicKhqy basicKhqy) {
	    LambdaQueryWrapper<BasicKhqy> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createBasicKhqy(BasicKhqy basicKhqy) {
        check(basicKhqy);
        this.save(basicKhqy);
        if(StringUtils.isBlank(basicKhqy.getKhqydm())){
            String dm = StringUtil.padStart(basicKhqy.getId());
            basicKhqy.setKhqydm(dm);
            this.updateById(basicKhqy);
        }
    }

    @Override
    @Transactional
    public void updateBasicKhqy(BasicKhqy basicKhqy) {
        if(basicKhqy.getId()==null){
            throw new FebsException("id不能为空，修改失败");
        }
        this.updateById(basicKhqy);
    }

    @Override
    @Transactional
    public void deleteBasicKhqy(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	private void check(BasicKhqy basicKhqy) throws FebsException{
        LambdaQueryWrapper<BasicKhqy> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(basicKhqy.getKhqydm())){
            queryWrapper.eq(BasicKhqy::getKhqydm,basicKhqy.getKhqydm());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("代码重复，添加失败");
            }
        }
        if(StringUtils.isNotBlank(basicKhqy.getKhqymc())){
            queryWrapper.eq(BasicKhqy::getKhqymc,basicKhqy.getKhqymc());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("名称重复，添加失败");
            }
        }
    }
}
