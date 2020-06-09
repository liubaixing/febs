package com.febs.shangpin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.StringUtil;
import com.febs.shangpin.entity.ShangpinDl;
import com.febs.shangpin.mapper.ShangpinDlMapper;
import com.febs.shangpin.service.IShangpinDlService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 大类 Service实现
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:00
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ShangpinDlServiceImpl extends ServiceImpl<ShangpinDlMapper, ShangpinDl> implements IShangpinDlService {

    @Autowired
    private ShangpinDlMapper shangpinDlMapper;

    @Override
    public IPage<ShangpinDl> findShangpinDls(QueryRequest request, ShangpinDl shangpinDl) {
        LambdaQueryWrapper<ShangpinDl> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        if(StringUtils.isNotBlank(shangpinDl.getDldm())){
            queryWrapper.like(ShangpinDl::getDldm,shangpinDl.getDldm());
        }
        if(StringUtils.isNotBlank(shangpinDl.getDlmc())){
            queryWrapper.like(ShangpinDl::getDlmc,shangpinDl.getDlmc());
        }
        Page<ShangpinDl> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<ShangpinDl> findShangpinDls(ShangpinDl shangpinDl) {
	    LambdaQueryWrapper<ShangpinDl> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createShangpinDl(ShangpinDl shangpinDl) {
        check(shangpinDl);
        this.save(shangpinDl);
        if(StringUtils.isBlank(shangpinDl.getDldm())){
            String dm = StringUtil.padStart(shangpinDl.getId());
            shangpinDl.setDldm(dm);
            this.updateById(shangpinDl);
        }
    }

    @Override
    @Transactional
    public void updateShangpinDl(ShangpinDl shangpinDl) {
        this.updateById(shangpinDl);
    }

    @Override
    @Transactional
    public void deleteShangpinDl(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	private void check(ShangpinDl shangpinDl) throws FebsException {
        LambdaQueryWrapper<ShangpinDl> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(shangpinDl.getDldm())){
            queryWrapper.eq(ShangpinDl::getDldm,shangpinDl.getDldm());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("大类代码已存在");
            }
        }
        if(StringUtils.isNotBlank(shangpinDl.getDlmc())){
            queryWrapper.eq(ShangpinDl::getDlmc,shangpinDl.getDlmc());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("大类名称已存在");
            }
        }

    }
}
