package cc.mrbird.febs.system.service.impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.common.utils.StringUtil;
import cc.mrbird.febs.system.entity.Cangku;
import cc.mrbird.febs.system.mapper.CangkuMapper;
import cc.mrbird.febs.system.service.ICangkuService;
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
 * 仓库管理 Service实现
 *
 * @author MrBird
 * @date 2020-05-22 00:06:45
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class CangkuServiceImpl extends ServiceImpl<CangkuMapper, Cangku> implements ICangkuService {

    @Autowired
    private CangkuMapper cangkuMapper;

    @Override
    public IPage<Cangku> findCangkus(QueryRequest request, Cangku cangku) {
        LambdaQueryWrapper<Cangku> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        if(StringUtils.isNotBlank(cangku.getCkdm())){
            queryWrapper.like(Cangku::getCkdm,cangku.getCkdm());
        }
        if(StringUtils.isNotBlank(cangku.getCkmc())){
            queryWrapper.like(Cangku::getCkmc,cangku.getCkmc());
        }
        if(cangku.getCklxId()!=null){
            queryWrapper.eq(Cangku::getCklxId,cangku.getCklxId());
        }
        if(cangku.getCkxz()!=null){
            queryWrapper.like(Cangku::getCkxz,cangku.getCkxz());
        }
        if(StringUtils.isNotBlank(cangku.getTel())){
            queryWrapper.like(Cangku::getTel,cangku.getTel());
        }
        if(StringUtils.isNotBlank(cangku.getContact())){
            queryWrapper.like(Cangku::getContact,cangku.getContact());
        }
        if(cangku.getStatus()!=null){
            queryWrapper.eq(Cangku::getContact,cangku.getContact());
        }
        Page<Cangku> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<Cangku> findCangkus(Cangku cangku) {
	    LambdaQueryWrapper<Cangku> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createCangku(Cangku cangku) {
        check(cangku);
        cangku.setCreateTime(new Date());
        this.cangkuMapper.insertSelective(cangku);
        if(StringUtils.isBlank(cangku.getCkdm())){
            String dm = StringUtil.padStart(cangku.getId());
            cangku.setCkdm(dm);
            this.cangkuMapper.updateByPrimaryKeySelective(cangku);
        }
    }

    @Override
    @Transactional
    public void updateCangku(Cangku cangku) {
        if(cangku.getId()==null){
            throw new FebsException("id不能为空，添加失败");
        }
        this.cangkuMapper.updateByPrimaryKeySelective(cangku);
    }

    @Override
    @Transactional
    public void deleteCangku(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	private void check(Cangku cangku) throws FebsException{
        LambdaQueryWrapper<Cangku> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(cangku.getCkdm())){
            queryWrapper.eq(Cangku::getCkdm,cangku.getCkdm());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("数据已存在，添加失败");
            }
        }
    }
}
