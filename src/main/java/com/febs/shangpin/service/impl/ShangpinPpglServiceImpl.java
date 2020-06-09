package com.febs.shangpin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.StringUtil;
import com.febs.shangpin.entity.ShangpinPpgl;
import com.febs.shangpin.mapper.ShangpinPpglMapper;
import com.febs.shangpin.service.IShangpinPpglService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 品牌管理 Service实现
 *
 * @author liubaixing1
 * @date 2020-05-22 01:10:37
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ShangpinPpglServiceImpl extends ServiceImpl<ShangpinPpglMapper, ShangpinPpgl> implements IShangpinPpglService {

    @Autowired
    private ShangpinPpglMapper shangpinPpglMapper;

    @Override
    public IPage<ShangpinPpgl> findShangpinPpgls(QueryRequest request, ShangpinPpgl shangpinPpgl) {
        LambdaQueryWrapper<ShangpinPpgl> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        if(StringUtils.isNotBlank(shangpinPpgl.getPpgldm())){
            queryWrapper.like(ShangpinPpgl::getPpgldm,shangpinPpgl.getPpgldm());
        }
        if(StringUtils.isNotBlank(shangpinPpgl.getPpglmc())){
            queryWrapper.like(ShangpinPpgl::getPpglmc,shangpinPpgl.getPpglmc());
        }
        Page<ShangpinPpgl> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<ShangpinPpgl> findShangpinPpgls(ShangpinPpgl shangpinPpgl) {
	    LambdaQueryWrapper<ShangpinPpgl> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createShangpinPpgl(ShangpinPpgl shangpinPpgl) {
        check(shangpinPpgl);
        this.save(shangpinPpgl);
        if(StringUtils.isBlank(shangpinPpgl.getPpgldm())){
            String dm = StringUtil.padStart(shangpinPpgl.getId());
            shangpinPpgl.setPpgldm(dm);
            this.updateById(shangpinPpgl);
        }
    }

    @Override
    @Transactional
    public void updateShangpinPpgl(ShangpinPpgl shangpinPpgl) {
        this.updateById(shangpinPpgl);
    }

    @Override
    @Transactional
    public void deleteShangpinPpgl(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	private void check(ShangpinPpgl shangpinPpgl) throws FebsException {
        LambdaQueryWrapper<ShangpinPpgl> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(shangpinPpgl.getPpgldm())){
            queryWrapper.eq(ShangpinPpgl::getPpgldm,shangpinPpgl.getPpgldm());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("代码重复，添加失败");
            }
        }
        if(StringUtils.isNotBlank(shangpinPpgl.getPpglmc())){
            queryWrapper.eq(ShangpinPpgl::getPpglmc,shangpinPpgl.getPpglmc());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("名称重复，添加失败");
            }
        }
    }

}
