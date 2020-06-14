package com.febs.system.service.impl;

import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.StringUtil;
import com.febs.system.entity.Bumeng;
import com.febs.system.entity.Gongsi;
import com.febs.system.mapper.BumengMapper;
import com.febs.system.mapper.GongsiMapper;
import com.febs.system.service.IBumengService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 部门管理 Service实现
 *
 * @author liubaixing
 * @date 2020-06-14 17:15:53
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BumengServiceImpl extends ServiceImpl<BumengMapper, Bumeng> implements IBumengService {

    @Autowired
    private BumengMapper bumengMapper;

    @Autowired
    private GongsiMapper gongsiMapper;

    @Override
    public IPage<Bumeng> findBumengs(QueryRequest request, Bumeng bumeng) {
        LambdaQueryWrapper<Bumeng> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        if (StringUtils.isNotBlank(bumeng.getBmdm())){
            queryWrapper.like(Bumeng::getBmdm,bumeng.getBmdm());
        }
        if (StringUtils.isNotBlank(bumeng.getBmmc())) {
            queryWrapper.like(Bumeng::getBmmc,bumeng.getBmmc());
        }
        Page<Bumeng> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Bumeng> findBumengs(Bumeng bumeng) {
	    LambdaQueryWrapper<Bumeng> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createBumeng(Bumeng bumeng) {
        check(bumeng);
        bumeng.setCreateTime(new Date());
        bumengMapper.insertSelective(bumeng);
        if(StringUtils.isBlank(bumeng.getBmdm())){
            String dm = StringUtil.padStart(bumeng.getId());
            bumeng.setBmdm(dm);
            bumengMapper.updateByPrimaryKeySelective(bumeng);
        }
    }

    @Override
    @Transactional
    public void updateBumeng(Bumeng bumeng) {
        bumengMapper.updateByPrimaryKeySelective(bumeng);
    }

    @Override
    @Transactional
    public void deleteBumeng(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

    @Override
    @Transactional
	public void excelInsert(Bumeng bumeng){
        LambdaQueryWrapper<Gongsi> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Gongsi::getGsmc,bumeng.getGsmc());
        Gongsi gongsi = gongsiMapper.selectOne(queryWrapper);
        if (gongsi == null) {
            throw new FebsException("公司数据异常");
        }
        bumeng.setGsId(gongsi.getId());
        createBumeng(bumeng);
    }

	private void check(Bumeng bumeng){
        LambdaQueryWrapper<Bumeng> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(bumeng.getBmdm())){
            queryWrapper.eq(Bumeng::getBmdm,bumeng.getBmdm());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if(count>0){
                throw new FebsException("代码重复");
            }
        }
        if(StringUtils.isNotBlank(bumeng.getBmmc())){
            queryWrapper.eq(Bumeng::getBmmc,bumeng.getBmmc());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if(count>0){
                throw new FebsException("名称重复");
            }
        }
    }
}
