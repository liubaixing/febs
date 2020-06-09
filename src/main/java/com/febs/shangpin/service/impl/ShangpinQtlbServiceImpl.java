package com.febs.shangpin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.StringUtil;
import com.febs.shangpin.entity.ShangpinQtlb;
import com.febs.shangpin.mapper.ShangpinQtlbMapper;
import com.febs.shangpin.service.IShangpinQtlbService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 其他类别 Service实现
 *
 * @author liubaixing1
 * @date 2020-05-22 01:10:44
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ShangpinQtlbServiceImpl extends ServiceImpl<ShangpinQtlbMapper, ShangpinQtlb> implements IShangpinQtlbService {

    @Autowired
    private ShangpinQtlbMapper shangpinQtlbMapper;

    @Override
    public IPage<ShangpinQtlb> findShangpinQtlbs(QueryRequest request, ShangpinQtlb shangpinQtlb) {
        LambdaQueryWrapper<ShangpinQtlb> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        if (StringUtils.isNotBlank(shangpinQtlb.getQtlbdm())){
            queryWrapper.like(ShangpinQtlb::getQtlbdm,shangpinQtlb.getQtlbdm());
        }
        if (StringUtils.isNotBlank(shangpinQtlb.getQtlbmc())){
            queryWrapper.like(ShangpinQtlb::getQtlbmc,shangpinQtlb.getQtlbmc());
        }
        Page<ShangpinQtlb> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<ShangpinQtlb> findShangpinQtlbs(ShangpinQtlb shangpinQtlb) {
	    LambdaQueryWrapper<ShangpinQtlb> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createShangpinQtlb(ShangpinQtlb shangpinQtlb) {
        check(shangpinQtlb);
        this.save(shangpinQtlb);
        if (StringUtils.isBlank(shangpinQtlb.getQtlbdm())){
            String dm = StringUtil.padStart(shangpinQtlb.getId());
            shangpinQtlb.setQtlbdm(dm);
            this.updateById(shangpinQtlb);
        }
    }

    @Override
    @Transactional
    public void updateShangpinQtlb(ShangpinQtlb shangpinQtlb) {
        if(shangpinQtlb.getId()==null){
            throw new FebsException("id不能为空，添加失败");
        }
        this.updateById(shangpinQtlb);
    }

    @Override
    @Transactional
    public void deleteShangpinQtlb(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	private void check(ShangpinQtlb shangpinQtlb) throws FebsException{
        LambdaQueryWrapper<ShangpinQtlb> queryWrapper = new LambdaQueryWrapper<>();
        if (StringUtils.isNotBlank(shangpinQtlb.getQtlbdm())){
            queryWrapper.eq(ShangpinQtlb::getQtlbdm,shangpinQtlb.getQtlbdm());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("代码已存在");
            }
        }
        if (StringUtils.isNotBlank(shangpinQtlb.getQtlbmc())){
            queryWrapper.eq(ShangpinQtlb::getQtlbmc,shangpinQtlb.getQtlbmc());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("名称已存在");
            }
        }
    }

}
