package com.febs.shangpin.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.basic.entity.BasicJldw;
import com.febs.basic.mapper.BasicJldwMapper;
import com.febs.common.constant.GoodsConstant;
import com.febs.common.entity.QueryRequest;
import com.febs.common.enums.exception.GoodsExecptionEnum;
import com.febs.common.exception.ApiException;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.StringUtil;
import com.febs.shangpin.entity.*;
import com.febs.shangpin.mapper.*;
import com.febs.shangpin.service.IShangpinGysService;
import com.febs.shangpin.vo.resp.ShangpinGysResp;
import com.febs.shangpin.vo.resp.ShangpinResp;
import com.febs.system.entity.Gys;
import com.febs.system.mapper.CangkuMapper;
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
 * 供应商商品 Service实现
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:05
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ShangpinGysServiceImpl extends ServiceImpl<ShangpinGysMapper, ShangpinGys> implements IShangpinGysService {

    @Autowired
    private ShangpinGysMapper shangpinGysMapper;

    @Autowired
    private ShangpinPpglMapper ppglMapper;

    @Autowired
    private CangkuMapper ckMapper;

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

    @Autowired
    private ShangpinMapper shangpinMapper;

    @Override
    public IPage<ShangpinGysResp> findShangpinGyss(QueryRequest request, ShangpinGysResp shangpinGys) {
        Page<ShangpinGysResp> page = new Page<>(request.getPageNum(), request.getPageSize());
        return shangpinGysMapper.selectDetailPage(page,shangpinGys);
    }

    @Override
    public List<ShangpinGysResp> findShangpinGyss(ShangpinGysResp shangpinGys) {
		return shangpinGysMapper.selectDetail(shangpinGys);
    }

    @Override
    @Transactional
    public void createShangpinGys(ShangpinGys shangpinGys) {
        check(shangpinGys);
        shangpinGys.setCreateTime(new Date());

        this.shangpinGysMapper.insertSelective(shangpinGys);
        if(StringUtils.isBlank(shangpinGys.getSpdm())){
            String dm = StringUtil.padStart(shangpinGys.getId());
            shangpinGys.setSpdm(GoodsConstant.GYS_GOODS_DM_PREFIX+dm);
            this.shangpinGysMapper.updateByPrimaryKeySelective(shangpinGys);
        }
    }

    @Override
    @Transactional
    public void excelInsert(ShangpinGysResp sp){
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
        ShangpinGys shangpinGys = new ShangpinGysResp();
        BeanUtils.copyProperties(sp,shangpinGys);
        createShangpinGys(shangpinGys);
    }

    @Override
    @Transactional
    public void updateShangpinGys(ShangpinGys shangpinGys) {
        if(shangpinGys.getId()==null){
            throw new FebsException("id不能为空，添加失败");
        }
        this.shangpinGysMapper.updateByPrimaryKeySelective(shangpinGys);
    }

    @Override
    @Transactional
    public void deleteShangpinGys(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	@Override
    @Transactional
    public boolean checkGoods(Integer goodsId,boolean check){
        LambdaQueryWrapper<ShangpinGys> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShangpinGys::getId,goodsId);
        ShangpinGys temp = this.baseMapper.selectOne(queryWrapper);
        if(temp==null){
           throw new FebsException("商品不存在");
        }
        ShangpinExample example = new ShangpinExample();
        example.createCriteria().andSpmcEqualTo(temp.getSpmc());
        long count = shangpinMapper.countByExample(example);
        if(count>0 && !check==true){
            //商品表中存在该商品，并没有二次确认，询问是否更新
            return false;
        }

        Shangpin shangpin = new Shangpin();
        BeanUtils.copyProperties(temp,shangpin);
        if(count>0){
            shangpin.setUpdateTime(new Date());
            shangpinMapper.updateByExampleSelective(shangpin,example);
        }else{
            shangpin.setCreateTime(new Date());
            shangpinMapper.insertSelective(shangpin);

            ShangpinGys shangpinGys = new ShangpinGys();
            shangpinGys.setId(goodsId);
            shangpinGys.setShangpinId(shangpin.getId());
            shangpinGys.setLyxt((byte) 2);
            this.shangpinGysMapper.updateByPrimaryKeySelective(shangpinGys);
        }
        return true;
    }


	private void check(ShangpinGys shangpinGys) throws FebsException{
        LambdaQueryWrapper<ShangpinGys> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(shangpinGys.getSpdm())){
            queryWrapper.eq(ShangpinGys::getSpdm,shangpinGys.getSpdm());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("唯一码重复，添加失败");
            }
        }

    }
}
