package cc.mrbird.febs.basic.service.impl;

import cc.mrbird.febs.basic.entity.BasicKhly;
import cc.mrbird.febs.basic.entity.BasicKhyh;
import cc.mrbird.febs.basic.entity.BasicKhyh;
import cc.mrbird.febs.basic.mapper.BasicKhyhMapper;
import cc.mrbird.febs.basic.service.IBasicKhyhService;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.exception.FebsException;
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
import java.util.List;

/**
 * 开户银行 Service实现
 *
 * @author liubaixing
 * @date 2020-05-22 01:40:01
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BasicKhyhServiceImpl extends ServiceImpl<BasicKhyhMapper, BasicKhyh> implements IBasicKhyhService {

    @Autowired
    private BasicKhyhMapper basicKhyhMapper;

    @Override
    public IPage<BasicKhyh> findBasicKhyhs(QueryRequest request, BasicKhyh basicKhyh) {
        LambdaQueryWrapper<BasicKhyh> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        if(StringUtils.isNotBlank(basicKhyh.getKhyhdm())){
            queryWrapper.like(BasicKhyh::getKhyhdm,basicKhyh.getKhyhdm());
        }
        if(StringUtils.isNotBlank(basicKhyh.getKhyhmc())){
            queryWrapper.like(BasicKhyh::getKhyhmc,basicKhyh.getKhyhmc());
        }
        if(basicKhyh.getStatus()!=null){
            queryWrapper.eq(BasicKhyh::getStatus,basicKhyh.getStatus());
        }
        Page<BasicKhyh> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<BasicKhyh> findBasicKhyhs(BasicKhyh basicKhyh) {
	    LambdaQueryWrapper<BasicKhyh> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createBasicKhyh(BasicKhyh basicKhyh) {
        check(basicKhyh);
        this.save(basicKhyh);
    }

    @Override
    @Transactional
    public void updateBasicKhyh(BasicKhyh basicKhyh) {
        if(basicKhyh.getId()==null){
            throw new FebsException("id不能为空，修改失败");
        }
        this.saveOrUpdate(basicKhyh);
    }

    @Override
    @Transactional
    public void deleteBasicKhyh(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	private void check(BasicKhyh basicKhyh) throws FebsException{
        LambdaQueryWrapper<BasicKhyh> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(basicKhyh.getKhyhdm())){
            queryWrapper.eq(BasicKhyh::getKhyhdm,basicKhyh.getKhyhdm());
        }
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
            throw new FebsException("代码重复，添加失败");
        }
    }
}
