package com.febs.shangpin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.StringUtil;
import com.febs.shangpin.entity.ShangpinZl;
import com.febs.shangpin.mapper.ShangpinZlMapper;
import com.febs.shangpin.service.IShangpinZlService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 总类 Service实现
 *
 * @author liubaixing1
 * @date 2020-05-22 01:10:57
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ShangpinZlServiceImpl extends ServiceImpl<ShangpinZlMapper, ShangpinZl> implements IShangpinZlService {

    @Autowired
    private ShangpinZlMapper shangpinZlMapper;

    @Override
    public IPage<ShangpinZl> findShangpinZls(QueryRequest request, ShangpinZl shangpinZl) {
        LambdaQueryWrapper<ShangpinZl> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        if(StringUtils.isNotBlank(shangpinZl.getZldm())){
            queryWrapper.like(ShangpinZl::getZldm,shangpinZl.getZldm());
        }
        if (StringUtils.isNotBlank(shangpinZl.getZlmc())){
            queryWrapper.like(ShangpinZl::getZlmc,shangpinZl.getZlmc());
        }
        Page<ShangpinZl> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<ShangpinZl> findShangpinZls(ShangpinZl shangpinZl) {
	    LambdaQueryWrapper<ShangpinZl> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createShangpinZl(ShangpinZl shangpinZl) {
        check(shangpinZl);
        this.save(shangpinZl);
        if(StringUtils.isBlank(shangpinZl.getZldm())){
            String dm = StringUtil.padStart(shangpinZl.getId());
            shangpinZl.setZldm(dm);
            this.updateById(shangpinZl);
        }
    }

    @Override
    @Transactional
    public void updateShangpinZl(ShangpinZl shangpinZl) {
        if(shangpinZl==null){
            throw new FebsException("id不能为空，修改失败");
        }
        this.updateById(shangpinZl);
    }

    @Override
    @Transactional
    public void deleteShangpinZl(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	private void check(ShangpinZl shangpinZl)throws FebsException{
        LambdaQueryWrapper<ShangpinZl> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(shangpinZl.getZldm())){
            queryWrapper.eq(ShangpinZl::getZldm,shangpinZl.getZldm());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("总类代码已存在");
            }
        }
        if(StringUtils.isNotBlank(shangpinZl.getZlmc())){
            queryWrapper.eq(ShangpinZl::getZlmc,shangpinZl.getZlmc());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("总类名称已存在");
            }
        }
    }

}
