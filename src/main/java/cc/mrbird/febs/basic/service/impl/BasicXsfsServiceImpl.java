package cc.mrbird.febs.basic.service.impl;

import cc.mrbird.febs.basic.entity.BasicPtda;
import cc.mrbird.febs.basic.entity.BasicXsfs;
import cc.mrbird.febs.basic.entity.BasicXsfs;
import cc.mrbird.febs.basic.mapper.BasicXsfsMapper;
import cc.mrbird.febs.basic.service.IBasicXsfsService;
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
 * 销售方式 Service实现
 *
 * @author liubaixing
 * @date 2020-05-22 01:39:45
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class BasicXsfsServiceImpl extends ServiceImpl<BasicXsfsMapper, BasicXsfs> implements IBasicXsfsService {

    @Autowired
    private BasicXsfsMapper basicXsfsMapper;

    @Override
    public IPage<BasicXsfs> findBasicXsfss(QueryRequest request, BasicXsfs basicXsfs) {
        LambdaQueryWrapper<BasicXsfs> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        if(StringUtils.isNotBlank(basicXsfs.getXsfsdm())){
            queryWrapper.like(BasicXsfs::getXsfsdm,basicXsfs.getXsfsdm());
        }
        if(StringUtils.isNotBlank(basicXsfs.getXsfsmc())){
            queryWrapper.like(BasicXsfs::getXsfsmc,basicXsfs.getXsfsmc());
        }
        if(basicXsfs.getStatus()!=null){
            queryWrapper.eq(BasicXsfs::getStatus,basicXsfs.getStatus());
        }
        Page<BasicXsfs> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<BasicXsfs> findBasicXsfss(BasicXsfs basicXsfs) {
	    LambdaQueryWrapper<BasicXsfs> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createBasicXsfs(BasicXsfs basicXsfs) {
        check(basicXsfs);
        this.save(basicXsfs);
    }

    @Override
    @Transactional
    public void updateBasicXsfs(BasicXsfs basicXsfs) {
        if(basicXsfs.getId()==null){
            throw new FebsException("id不能为空，修改失败");
        }
        this.saveOrUpdate(basicXsfs);
    }

    @Override
    @Transactional
    public void deleteBasicXsfs(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	private void check(BasicXsfs basicXsfs) throws FebsException{
        LambdaQueryWrapper<BasicXsfs> queryWrapper = new LambdaQueryWrapper<>();
        if(StringUtils.isNotBlank(basicXsfs.getXsfsdm())){
            queryWrapper.eq(BasicXsfs::getXsfsdm,basicXsfs.getXsfsdm());
        }
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
            throw new FebsException("代码重复，添加失败");
        }
    }
}
