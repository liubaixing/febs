package cc.mrbird.febs.basic.service.impl;

import cc.mrbird.febs.basic.entity.BasicKhly;
import cc.mrbird.febs.basic.entity.BasicKhqy;
import cc.mrbird.febs.basic.entity.BasicKhqy;
import cc.mrbird.febs.basic.mapper.BasicKhqyMapper;
import cc.mrbird.febs.basic.service.IBasicKhqyService;
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
 * 客户区域 Service实现
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:58
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BasicKhqyServiceImpl extends ServiceImpl<BasicKhqyMapper, BasicKhqy> implements IBasicKhqyService {

    @Autowired
    private BasicKhqyMapper basicKhqyMapper;

    @Override
    public IPage<BasicKhqy> findBasicKhqys(QueryRequest request, BasicKhqy basicKhqy) {
        LambdaQueryWrapper<BasicKhqy> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        if(StringUtils.isNotBlank(basicKhqy.getKhqydm())){
            queryWrapper.like(BasicKhqy::getKhqydm,basicKhqy.getKhqydm());
        }
        if(StringUtils.isNotBlank(basicKhqy.getKhqymc())){
            queryWrapper.like(BasicKhqy::getKhqymc,basicKhqy.getKhqymc());
        }
        if(basicKhqy.getStatus()!=null){
            queryWrapper.eq(BasicKhqy::getStatus,basicKhqy.getStatus());
        }
        Page<BasicKhqy> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<BasicKhqy> findBasicKhqys(BasicKhqy basicKhqy) {
	    LambdaQueryWrapper<BasicKhqy> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createBasicKhqy(BasicKhqy basicKhqy) {
        check(basicKhqy);
        this.save(basicKhqy);
    }

    @Override
    @Transactional
    public void updateBasicKhqy(BasicKhqy basicKhqy) {
        if(basicKhqy.getId()==null){
            throw new FebsException("id不能为空，修改失败");
        }
        this.saveOrUpdate(basicKhqy);
    }

    @Override
    @Transactional
    public void deleteBasicKhqy(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	private void check(BasicKhqy basicKhqy) throws FebsException{
        LambdaQueryWrapper<BasicKhqy> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(basicKhqy.getKhqydm())){
            queryWrapper.eq(BasicKhqy::getKhqydm,basicKhqy.getKhqydm());
        }
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
            throw new FebsException("代码重复，添加失败");
        }
    }
}
