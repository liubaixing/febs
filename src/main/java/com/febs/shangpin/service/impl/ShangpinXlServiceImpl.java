package com.febs.shangpin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.shangpin.entity.ShangpinXl;
import com.febs.shangpin.mapper.ShangpinXlMapper;
import com.febs.shangpin.service.IShangpinXlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 小类 Service实现
 *
 * @author liubaixing1
 * @date 2020-05-22 01:10:54
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ShangpinXlServiceImpl extends ServiceImpl<ShangpinXlMapper, ShangpinXl> implements IShangpinXlService {

    @Autowired
    private ShangpinXlMapper shangpinXlMapper;

    @Override
    public IPage<ShangpinXl> findShangpinXls(QueryRequest request, ShangpinXl shangpinXl) {
        LambdaQueryWrapper<ShangpinXl> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<ShangpinXl> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<ShangpinXl> findShangpinXls(ShangpinXl shangpinXl) {
	    LambdaQueryWrapper<ShangpinXl> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createShangpinXl(ShangpinXl shangpinXl) {
        check(shangpinXl);
        this.save(shangpinXl);
    }

    @Override
    @Transactional
    public void updateShangpinXl(ShangpinXl shangpinXl) {
        if(shangpinXl.getId()==null){
            throw new FebsException("id不能为null");
        }
        this.saveOrUpdate(shangpinXl);
    }

    @Override
    @Transactional
    public void deleteShangpinXl(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}


	private void check(ShangpinXl shangpinXl) throws FebsException{
        LambdaQueryWrapper<ShangpinXl> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShangpinXl::getXldm,shangpinXl.getXldm());
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
            throw new FebsException("代码已存在，添加失败");
        }
    }
}
