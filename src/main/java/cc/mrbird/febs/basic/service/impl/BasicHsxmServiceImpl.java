package cc.mrbird.febs.basic.service.impl;

import cc.mrbird.febs.basic.entity.BasicFpsd;
import cc.mrbird.febs.basic.entity.BasicHsxm;
import cc.mrbird.febs.basic.mapper.BasicHsxmMapper;
import cc.mrbird.febs.basic.service.IBasicHsxmService;
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
 * 核算项目 Service实现
 *
 * @author liubaixing
 * @date 2020-05-22 01:38:13
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BasicHsxmServiceImpl extends ServiceImpl<BasicHsxmMapper, BasicHsxm> implements IBasicHsxmService {

    @Autowired
    private BasicHsxmMapper basicHsxmMapper;

    @Override
    public IPage<BasicHsxm> findBasicHsxms(QueryRequest request, BasicHsxm basicHsxm) {
        LambdaQueryWrapper<BasicHsxm> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        if(StringUtils.isNotBlank(basicHsxm.getHsxmdm())){
            queryWrapper.like(BasicHsxm::getHsxmdm,basicHsxm.getHsxmdm());
        }
        if(StringUtils.isNotBlank(basicHsxm.getHsxmmc())){
            queryWrapper.like(BasicHsxm::getHsxmmc,basicHsxm.getHsxmmc());
        }
        if(basicHsxm.getStatus()!=null){
            queryWrapper.eq(BasicHsxm::getStatus,basicHsxm.getStatus());
        }
        Page<BasicHsxm> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<BasicHsxm> findBasicHsxms(BasicHsxm basicHsxm) {
	    LambdaQueryWrapper<BasicHsxm> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createBasicHsxm(BasicHsxm basicHsxm) {
        check(basicHsxm);
        this.save(basicHsxm);
    }

    @Override
    @Transactional
    public void updateBasicHsxm(BasicHsxm basicHsxm) {
        if(basicHsxm.getId()==null){
            throw new FebsException("id不能为空，修改失败");
        }
        this.saveOrUpdate(basicHsxm);
    }

    @Override
    @Transactional
    public void deleteBasicHsxm(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	private void check(BasicHsxm basicHsxm) throws FebsException{
        LambdaQueryWrapper<BasicHsxm> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(basicHsxm.getHsxmdm())){
            queryWrapper.eq(BasicHsxm::getHsxmdm,basicHsxm.getHsxmdm());
        }
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
            throw new FebsException("代码重复，添加失败");
        }
    }
}
