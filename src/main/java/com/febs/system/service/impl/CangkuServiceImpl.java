package com.febs.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.basic.entity.BasicCklb;
import com.febs.basic.mapper.BasicCklbMapper;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.StringUtil;
import com.febs.system.entity.Cangku;
import com.febs.system.mapper.CangkuMapper;
import com.febs.system.service.ICangkuService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 仓库管理 Service实现
 *
 * @author MrBird
 * @date 2020-05-22 00:06:45
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class CangkuServiceImpl extends ServiceImpl<CangkuMapper, Cangku> implements ICangkuService {

    @Autowired
    private CangkuMapper cangkuMapper;
    @Autowired
    private BasicCklbMapper cklbMapper;

    @Override
    public IPage<Cangku> findCangkus(QueryRequest request, Cangku cangku) {
        LambdaQueryWrapper<Cangku> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        if(StringUtils.isNotBlank(cangku.getCkdm())){
            queryWrapper.like(Cangku::getCkdm,cangku.getCkdm());
        }
        if(StringUtils.isNotBlank(cangku.getCkmc())){
            queryWrapper.like(Cangku::getCkmc,cangku.getCkmc());
        }
        if(cangku.getCklxId()!=null){
            queryWrapper.eq(Cangku::getCklxId,cangku.getCklxId());
        }
        if(cangku.getCkxz()!=null){
            queryWrapper.like(Cangku::getCkxz,cangku.getCkxz());
        }
        if(StringUtils.isNotBlank(cangku.getTel())){
            queryWrapper.like(Cangku::getTel,cangku.getTel());
        }
        if(StringUtils.isNotBlank(cangku.getContact())){
            queryWrapper.like(Cangku::getContact,cangku.getContact());
        }
        if(cangku.getStatus()!=null){
            queryWrapper.eq(Cangku::getContact,cangku.getContact());
        }
        if(cangku.getDeleted() != null){
            queryWrapper.eq(Cangku::getDeleted,cangku.getDeleted());
        }
        Page<Cangku> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Cangku> findCangkus(Cangku cangku) {
	    LambdaQueryWrapper<Cangku> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createCangku(Cangku cangku) {
        check(cangku);
        cangku.setCreateTime(new Date());
        this.cangkuMapper.insertSelective(cangku);
        if(StringUtils.isBlank(cangku.getCkdm())){
            String dm = StringUtil.padStart(cangku.getId());
            cangku.setCkdm(dm);
            this.cangkuMapper.updateByPrimaryKeySelective(cangku);
        }
    }

    @Override
    @Transactional
    public void updateCangku(Cangku cangku) {
        if(cangku.getId()==null){
            throw new FebsException("id不能为空，添加失败");
        }
        this.cangkuMapper.updateByPrimaryKeySelective(cangku);
    }

    @Override
    @Transactional
    public void excelInsert(Cangku cangku){
        LambdaQueryWrapper<BasicCklb> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(BasicCklb::getCklbmc,cangku.getCklxmc());
        BasicCklb cklb = cklbMapper.selectOne(queryWrapper);
        if(cklb == null){
            throw new FebsException("仓库类型数据有误");
        }
        cangku.setCklxId(cklb.getId());
        createCangku(cangku);
    }

    @Override
    @Transactional
    public void deleteCangku(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	private void check(Cangku cangku) throws FebsException{
        LambdaQueryWrapper<Cangku> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(cangku.getCkdm())){
            queryWrapper.eq(Cangku::getCkdm,cangku.getCkdm());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("仓库代码重复，添加失败");
            }
        }
        if(StringUtils.isNotBlank(cangku.getCkmc())){
            queryWrapper.eq(Cangku::getCkmc,cangku.getCkmc());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("仓库名称重复，添加失败");
            }
        }
    }
}
