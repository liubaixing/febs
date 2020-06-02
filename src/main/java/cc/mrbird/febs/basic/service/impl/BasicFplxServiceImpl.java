package cc.mrbird.febs.basic.service.impl;

import cc.mrbird.febs.basic.entity.BasicFplx;
import cc.mrbird.febs.basic.mapper.BasicFplxMapper;
import cc.mrbird.febs.basic.service.IBasicFplxService;
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
 * 发票类型 Service实现
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:37
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BasicFplxServiceImpl extends ServiceImpl<BasicFplxMapper, BasicFplx> implements IBasicFplxService {

    @Autowired
    private BasicFplxMapper basicFplxMapper;

    @Override
    public IPage<BasicFplx> findBasicFplxs(QueryRequest request, BasicFplx basicFplx) {
        LambdaQueryWrapper<BasicFplx> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        if(StringUtils.isNotBlank(basicFplx.getFplxdm())){
            queryWrapper.like(BasicFplx::getFplxdm,basicFplx.getFplxdm());
        }
        if(StringUtils.isNotBlank(basicFplx.getFplxmc())){
            queryWrapper.like(BasicFplx::getFplxmc,basicFplx.getFplxmc());
        }
        if(basicFplx.getStatus()!=null){
            queryWrapper.eq(BasicFplx::getStatus,basicFplx.getStatus());
        }
        Page<BasicFplx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<BasicFplx> findBasicFplxs(BasicFplx basicFplx) {
	    LambdaQueryWrapper<BasicFplx> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createBasicFplx(BasicFplx basicFplx) {
        check(basicFplx);
        this.save(basicFplx);
    }

    @Override
    @Transactional
    public void updateBasicFplx(BasicFplx basicFplx) {
        if(basicFplx.getId()==null){
            throw new FebsException("id不能为空，修改失败");
        }
        this.saveOrUpdate(basicFplx);
    }

    @Override
    @Transactional
    public void deleteBasicFplx(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	private void check(BasicFplx basicFplx) throws FebsException{
        LambdaQueryWrapper<BasicFplx> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(basicFplx.getFplxdm())){
            queryWrapper.eq(BasicFplx::getFplxdm,basicFplx.getFplxdm());
        }
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
            throw new FebsException("代码重复，添加失败");
        }
    }
}
