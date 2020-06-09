package com.febs.shangpin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.basic.entity.BasicJldw;
import com.febs.basic.mapper.BasicJldwMapper;
import com.febs.common.constant.GoodsConstant;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.StringUtil;
import com.febs.shangpin.entity.*;
import com.febs.shangpin.mapper.*;
import com.febs.shangpin.service.IShangpinService;
import com.febs.shangpin.vo.resp.ShangpinResp;
import com.febs.system.entity.Gys;
import com.febs.system.mapper.GysMapper;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 商品 Service实现
 *
 * @author liubaixing
 * @date 2020-05-22 01:06:25
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ShangpinServiceImpl extends ServiceImpl<ShangpinMapper, Shangpin> implements IShangpinService {

    @Autowired
    private ShangpinMapper shangpinMapper;

    @Autowired
    private ShangpinPpglMapper ppglMapper;

    @Autowired
    private ShangpinZlMapper zlMapper;
    @Autowired
    private ShangpinDlMapper dlMapper;
    @Autowired
    private ShangpinXlMapper xlMapper;
    @Autowired
    private ShangpinQtlbMapper qtlbMapper;
    @Autowired
    private GysMapper gysMapper;
    @Autowired
    private BasicJldwMapper jldwMapper;

    @Override
    public IPage<ShangpinResp> findShangpins(QueryRequest request, ShangpinResp shangpin) {
        Page<Shangpin> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.shangpinMapper.selectDetailPage(page,shangpin);
    }

    @Override
    public List<ShangpinResp> findShangpins(ShangpinResp shangpin) {
		return this.shangpinMapper.selectDetail(shangpin);
    }

    @Override
    @Transactional
    public void createShangpin(Shangpin shangpin) {
        check(shangpin);
        shangpin.setCreateTime(new Date());
        this.shangpinMapper.insertSelective(shangpin);
        if(StringUtils.isBlank(shangpin.getSpdm())){
            String dm = StringUtil.padStart(shangpin.getId());
            shangpin.setSpdm(GoodsConstant.GOODS_DM_PREFIX+dm);
            this.shangpinMapper.updateByPrimaryKeySelective(shangpin);
        }
    }

    @Override
    @Transactional
    public void excelInsert(ShangpinResp sp){
        if(StringUtils.isNotBlank(sp.getPpglmc())){
            LambdaQueryWrapper<ShangpinPpgl> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(ShangpinPpgl::getPpglmc,sp.getPpglmc());
            ShangpinPpgl ppgl = ppglMapper.selectOne(queryWrapper);
            if(ppgl == null) throw new FebsException("Excel品牌名称数据异常，导入失败！");
            sp.setPpId(ppgl.getId());
        }
        if(StringUtils.isNotBlank(sp.getZlmc())){
            LambdaQueryWrapper<ShangpinZl> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(ShangpinZl::getZlmc,sp.getZlmc());
            ShangpinZl zl = zlMapper.selectOne(queryWrapper);
            if(zl == null) throw new FebsException("Excel总类数据异常，导入失败！");
            sp.setZlId(zl.getId());
        }
        if(StringUtils.isNotBlank(sp.getDlmc())){
            LambdaQueryWrapper<ShangpinDl> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(ShangpinDl::getDlmc,sp.getDlmc());
            ShangpinDl dl = dlMapper.selectOne(queryWrapper);
            if(dl == null) throw new FebsException("Excel大类数据异常，导入失败！");
            sp.setDlId(dl.getId());
        }
        if(StringUtils.isNotBlank(sp.getXlmc())){
            LambdaQueryWrapper<ShangpinXl> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(ShangpinXl::getXlmc,sp.getXlmc());
            ShangpinXl xl = xlMapper.selectOne(queryWrapper);
            if(xl == null) throw new FebsException("Excel小类数据异常，导入失败！");
            sp.setXlId(xl.getId());
        }
        if(StringUtils.isNotBlank(sp.getQtlbmc())){
            LambdaQueryWrapper<ShangpinQtlb> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(ShangpinQtlb::getQtlbmc,sp.getQtlbmc());
            ShangpinQtlb qtlb = qtlbMapper.selectOne(queryWrapper);
            if(qtlb == null) throw new FebsException("Excel其它类别数据异常，导入失败！");
            sp.setQtlbId(qtlb.getId());
        }
        if(StringUtils.isNotBlank(sp.getGysmc())){
            LambdaQueryWrapper<Gys> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(Gys::getGysmc,sp.getGysmc());
            Gys gys = gysMapper.selectOne(queryWrapper);
            if(gys == null) throw new FebsException("Excel供应商数据异常，导入失败！");
            sp.setGysId(gys.getId());
        }
        if(StringUtils.isNotBlank(sp.getJldwmc())){
            LambdaQueryWrapper<BasicJldw> queryWrapper = new LambdaQueryWrapper<>();
            queryWrapper.eq(BasicJldw::getJldwmc,sp.getJldwmc());
            BasicJldw jldw = jldwMapper.selectOne(queryWrapper);
            if(jldw == null) throw new FebsException("Excel计量单位数据异常，导入失败！");
            sp.setJldwId(jldw.getId());
        }
        Shangpin shangpin = new Shangpin();
        BeanUtils.copyProperties(sp,shangpin);
        createShangpin(shangpin);
    }

    @Override
    @Transactional
    public void updateShangpin(Shangpin shangpin) {
        if(shangpin.getId()==null){
            throw new FebsException("id不能为空，添加失败");
        }
        this.shangpinMapper.updateByPrimaryKeySelective(shangpin);
    }

    @Override
    @Transactional
    public void deleteShangpin(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}


	private void check(Shangpin shangpin) throws FebsException{
        LambdaQueryWrapper<Shangpin> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(shangpin.getSpdm())){
            queryWrapper.eq(Shangpin::getSpdm,shangpin.getSpdm());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("商品代码重复");
            }
        }
        if(StringUtils.isNotBlank(shangpin.getSpmc())){
            queryWrapper.eq(Shangpin::getSpmc,shangpin.getSpmc());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("商品名称重复");
            }
        }
    }

}
