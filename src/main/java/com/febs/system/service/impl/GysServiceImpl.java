package com.febs.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.basic.entity.BasicFplx;
import com.febs.basic.entity.BasicFpsd;
import com.febs.basic.mapper.BasicFplxMapper;
import com.febs.basic.mapper.BasicFpsdMapper;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.StringUtil;
import com.febs.system.entity.Gys;
import com.febs.system.entity.User;
import com.febs.system.mapper.GysMapper;
import com.febs.system.service.IGysService;
import com.febs.system.service.IUserService;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 供应商 Service实现
 *
 * @author MrBird
 * @date 2020-05-22 00:06:57
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class GysServiceImpl extends ServiceImpl<GysMapper, Gys> implements IGysService {

    @Autowired
    private GysMapper gysMapper;

    @Autowired
    private IUserService userService;

    @Autowired
    private BasicFplxMapper fplxMapper;
    @Autowired
    private BasicFpsdMapper fpsdMapper;

    @Override
    public IPage<Gys> findGyss(QueryRequest request, Gys gys) {
        Page<Gys> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.gysMapper.selectDetailPage(page,gys);
    }

    @Override
    public List<Gys> findGyss(Gys gys) {
        return this.gysMapper.selectDetail(gys);
    }

    @Override
    @Transactional
    public void createGys(Gys gys) {
        check(gys);
        gys.setCreateTime(new Date());
        this.gysMapper.insertSelective(gys);
        if(StringUtils.isBlank(gys.getGysdm())){
            String dm = StringUtil.padStart(gys.getId());
            gys.setGysdm(dm);
            this.gysMapper.updateByPrimaryKeySelective(gys);
        }
    }

    @Override
    @Transactional
    public void updateGys(Gys gys) {
        if(gys.getId()==null){
            throw new FebsException("id不能为空，添加失败");
        }
        this.gysMapper.updateByPrimaryKeySelective(gys);
    }

    @Override
    @Transactional
    public void excelInsert(Gys gys){
        if(StringUtils.isNotBlank(gys.getCgfzrmc())){
            User user = userService.findByName(gys.getCgfzrmc());
            if(user == null){
                throw  new FebsException("采购负责人数据异常");
            }
            gys.setCgfzr(user.getUserId());
        }
        if(StringUtils.isNotBlank(gys.getXdfzrmc())){
            User user = userService.findByName(gys.getXdfzrmc());
            if(user == null){
                throw  new FebsException("下单负责人数据异常");
            }
            gys.setXdfzr(user.getUserId());
        }
        if(StringUtils.isNotBlank(gys.getFplxmc())){
            LambdaQueryWrapper<BasicFplx> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(BasicFplx::getFplxmc,gys.getFplxmc());
            List<BasicFplx> list = fplxMapper.selectList(wrapper);
            if(CollectionUtils.isEmpty(list)){
                throw  new FebsException("发票类型不存在，请检查！");
            }
            if(list.size()>1){
                throw new FebsException("发票类型存在重复数据，请检查");
            }
            gys.setFplxId(list.get(0).getId());
        }
        if(StringUtils.isNotBlank(gys.getFpsdmc())){
            LambdaQueryWrapper<BasicFpsd> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(BasicFpsd::getFpsdmc,gys.getFpsdmc());
            List<BasicFpsd> list = fpsdMapper.selectList(wrapper);
            if(CollectionUtils.isEmpty(list)){
                throw  new FebsException("发票税点不存在，请检查！");
            }
            if(list.size()>1){
                throw new FebsException("发票税点存在重复数据，请检查");
            }
            gys.setFpsdId(list.get(0).getId());
        }
        createGys(gys);
    }

    @Override
    @Transactional
    public void deleteGys(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	private void check(Gys gys) throws FebsException{
        LambdaQueryWrapper<Gys> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(gys.getGysdm())){
            queryWrapper.eq(Gys::getGysdm,gys.getGysdm());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("数据已存在，添加失败");
            }
        }
        if(StringUtils.isNotBlank(gys.getGysmc())){
            queryWrapper.eq(Gys::getGysmc,gys.getGysmc());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("供应商名称，添加失败");
            }
        }
    }

}
