package com.febs.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.basic.entity.BasicKhlb;
import com.febs.basic.mapper.BasicKhlbMapper;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.StringUtil;
import com.febs.system.entity.Kehu;
import com.febs.system.entity.User;
import com.febs.system.mapper.KehuMapper;
import com.febs.system.service.IKehuService;
import com.febs.system.service.IUserService;
import com.febs.system.vo.resp.KehuResp;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * 客户管理 Service实现
 *
 * @author lbx
 * @date 2020-05-16 19:44:24
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class KehuServiceImpl extends ServiceImpl<KehuMapper, Kehu> implements IKehuService {

    @Autowired
    private KehuMapper kehuMapper;

    @Autowired
    private IUserService userService;

    @Autowired
    private BasicKhlbMapper khlbMapper;
    @Override
    public IPage<KehuResp> findKehus(QueryRequest request, KehuResp kehu) {
        Page<Kehu> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.kehuMapper.selectDetailPage(page,kehu);
    }

    @Override
    public List<KehuResp> findKehus(KehuResp kehu) {
        return this.kehuMapper.selectDetail(kehu);
    }

    @Override
    @Transactional
    public void createKehu(Kehu kehu) {
        check(kehu);
        kehu.setCreateTime(new Date());
        this.kehuMapper.insertSelective(kehu);
        if(StringUtils.isBlank(kehu.getKhdm())){
            String dm = StringUtil.padStart(kehu.getId());
            kehu.setKhdm(dm);
            this.kehuMapper.updateByPrimaryKeySelective(kehu);
        }
    }

    @Override
    @Transactional
    public void updateKehu(Kehu kehu) {
        if(kehu.getId()==null){
            throw new FebsException("id不能为空，添加失败");
        }
        this.kehuMapper.updateByPrimaryKeySelective(kehu);

    }

    @Override
    @Transactional
    public void excelInsert(KehuResp kehuResp){
        if(StringUtils.isNotBlank(kehuResp.getUserName())){
           User user = userService.findByName(kehuResp.getUserName());
           if(user == null){
               throw new FebsException("所属用户数据异常");
           }
           kehuResp.setSsyh(user.getUserId());
        }
        if(StringUtils.isNotBlank(kehuResp.getKhlbmc())){
            LambdaQueryWrapper<BasicKhlb> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(BasicKhlb::getKhlbmc,kehuResp.getKhlbmc());
            List<BasicKhlb> khlb = khlbMapper.selectList(wrapper);
            if(CollectionUtils.isEmpty(khlb)){
                throw new FebsException("客户类型不存在");
            }
            if(khlb.size()>1){
                throw new FebsException("有多个同名客户类型，请检查");
            }
            kehuResp.setKhlxId(khlb.get(0).getId());
        }
        Kehu kehu = new Kehu();
        BeanUtils.copyProperties(kehuResp,kehu);
        createKehu(kehu);
    }

    @Override
    @Transactional
    public void deleteKehu(String[] ids) {
        List<String> list = Arrays.asList(ids);
        // 删除用户
        this.removeByIds(list);
	}

	private void check(Kehu kehu) throws FebsException{
        LambdaQueryWrapper<Kehu> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(kehu.getKhdm())){
            queryWrapper.eq(Kehu::getKhdm,kehu.getKhdm());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("数据已存在，添加失败");
            }
        }
        if(StringUtils.isNotBlank(kehu.getKhmc())){
            queryWrapper.eq(Kehu::getKhmc,kehu.getKhmc());
            Integer count = this.baseMapper.selectCount(queryWrapper);
            if (count>0) {
                throw new FebsException("客户名称重复，添加失败");
            }
        }
    }
}
