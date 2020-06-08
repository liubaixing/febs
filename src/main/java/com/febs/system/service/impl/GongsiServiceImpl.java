package com.febs.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.StringUtil;
import com.febs.system.entity.Gongsi;
import com.febs.system.mapper.GongsiMapper;
import com.febs.system.service.IGongsiService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 公司管理 Service实现
 *
 * @author MrBird
 * @date 2020-05-21 22:34:42
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class GongsiServiceImpl extends ServiceImpl<GongsiMapper, Gongsi> implements IGongsiService {

    @Autowired
    private GongsiMapper gongsiMapper;

    @Override
    public IPage<Gongsi> findGongsis(QueryRequest request, Gongsi gongsi) {
        LambdaQueryWrapper<Gongsi> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<Gongsi> page = new Page<>(request.getPageNum(), request.getPageSize());
        if(StringUtils.isNotBlank(gongsi.getGsdm())){
            queryWrapper.like(Gongsi::getGsdm,gongsi.getGsdm());
        }
        if(StringUtils.isNotBlank(gongsi.getGsmc())){
            queryWrapper.like(Gongsi::getGsmc,gongsi.getGsmc());
        }
        if(StringUtils.isNotBlank(gongsi.getTel())){
            queryWrapper.like(Gongsi::getTel,gongsi.getTel());
        }
        if(StringUtils.isNotBlank(gongsi.getContact())){
            queryWrapper.like(Gongsi::getContact,gongsi.getContact());
        }
        if(StringUtils.isNotBlank(gongsi.getAddress())){
            queryWrapper.like(Gongsi::getAddress,gongsi.getAddress());
        }
        if(gongsi.getStatus()!=null){
            queryWrapper.eq(Gongsi::getStatus,gongsi.getStatus());
        }
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Gongsi> findGongsis(Gongsi gongsi) {
	    LambdaQueryWrapper<Gongsi> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createGongsi(Gongsi gongsi) {
        check(gongsi);
        gongsi.setCreateTime(new Date());
        this.gongsiMapper.insertSelective(gongsi);
        if(StringUtils.isBlank(gongsi.getGsdm())){
            String dm = StringUtil.padStart(gongsi.getId());
            gongsi.setGsdm(dm);
            this.gongsiMapper.updateByPrimaryKeySelective(gongsi);
        }
    }

    @Override
    @Transactional
    public void updateGongsi(Gongsi gongsi) {
        if(gongsi.getId()==null){
            throw new FebsException("id不能为空，添加失败");
        }
        this.gongsiMapper.updateByPrimaryKeySelective(gongsi);
    }

    @Override
    @Transactional
    public void deleteGongsi(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	private void check(Gongsi gongsi) throws FebsException{
        LambdaQueryWrapper<Gongsi> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(gongsi.getGsdm())){
            queryWrapper.eq(Gongsi::getGsdm,gongsi.getGsdm());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("公司代码重复");
            }
        }
        if(StringUtils.isNotBlank(gongsi.getGsmc())){
            queryWrapper.eq(Gongsi::getGsmc,gongsi.getGsmc());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("公司名称重复");
            }
        }
    }

}
