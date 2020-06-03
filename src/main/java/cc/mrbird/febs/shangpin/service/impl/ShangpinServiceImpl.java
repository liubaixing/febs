package cc.mrbird.febs.shangpin.service.impl;

import cc.mrbird.febs.basic.entity.BasicJldw;
import cc.mrbird.febs.basic.mapper.BasicJldwMapper;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.enums.IncrEnum;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.service.CommonService;
import cc.mrbird.febs.shangpin.entity.*;
import cc.mrbird.febs.shangpin.mapper.*;
import cc.mrbird.febs.shangpin.service.IShangpinService;
import cc.mrbird.febs.system.entity.Cangku;
import cc.mrbird.febs.system.entity.Gys;
import cc.mrbird.febs.system.mapper.CangkuMapper;
import cc.mrbird.febs.system.mapper.GysMapper;
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
    private CommonService commonService;

    @Override
    public IPage<Shangpin> findShangpins(QueryRequest request, Shangpin shangpin) {
        Page<Shangpin> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.shangpinMapper.selectDetailPage(page,shangpin);
    }

    @Override
    public List<Shangpin> findShangpins(Shangpin shangpin) {
		return this.shangpinMapper.selectDetail(shangpin);
    }

    @Override
    @Transactional
    public void createShangpin(Shangpin shangpin) {
        shangpin.setCreateTime(new Date());
        check(shangpin);
        this.save(shangpin);
        if(StringUtils.isBlank(shangpin.getSpdm())){
            Integer dm = shangpin.getId();
            shangpin.setSpdm(String.format("%07d", dm));
        }
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
    @Override
    @Transactional
    public void saveImport(List<Shangpin> data){
        for(Shangpin sp:data){
            if(StringUtils.isNotBlank(sp.getPpglmc())){
                LambdaQueryWrapper<ShangpinPpgl> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.eq(ShangpinPpgl::getPpglmc,sp.getPpglmc());
                ShangpinPpgl ppgl = ppglMapper.selectOne(queryWrapper);
                if(ppgl == null) throw new FebsException("Excel品牌名称数据异常，导入失败！");
                sp.setPpId(ppgl.getId());
            }
            if(StringUtils.isNotBlank(sp.getCkmc())){
                LambdaQueryWrapper<Cangku> queryWrapper = new LambdaQueryWrapper<>();
                queryWrapper.eq(Cangku::getCkmc,sp.getCkmc());
                Cangku ck = ckMapper.selectOne(queryWrapper);
                if(ck == null) throw new FebsException("Excel仓库名称数据异常，导入失败！");
                sp.setCkId(ck.getId());
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
            Integer dm = commonService.incr(IncrEnum.SHANGPIN.getCode());
            sp.setSpdm(String.format("%07d", dm));
            sp.setCreateTime(new Date());
            this.shangpinMapper.insertSelective(sp);
        }
    }


	private void check(Shangpin shangpin) throws FebsException{
        LambdaQueryWrapper<Shangpin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Shangpin::getMemo,shangpin.getMemo());
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
            throw new FebsException("唯一码重复，添加失败");
        }
    }

}
