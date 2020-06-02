package cc.mrbird.febs.shangpin.service.impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.shangpin.entity.ShangpinDl;
import cc.mrbird.febs.shangpin.mapper.ShangpinDlMapper;
import cc.mrbird.febs.shangpin.service.IShangpinDlService;
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
 * 大类 Service实现
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:00
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ShangpinDlServiceImpl extends ServiceImpl<ShangpinDlMapper, ShangpinDl> implements IShangpinDlService {

    @Autowired
    private ShangpinDlMapper shangpinDlMapper;

    @Override
    public IPage<ShangpinDl> findShangpinDls(QueryRequest request, ShangpinDl shangpinDl) {
        LambdaQueryWrapper<ShangpinDl> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<ShangpinDl> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<ShangpinDl> findShangpinDls(ShangpinDl shangpinDl) {
	    LambdaQueryWrapper<ShangpinDl> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createShangpinDl(ShangpinDl shangpinDl) {
        check(shangpinDl);
        this.save(shangpinDl);
    }

    @Override
    @Transactional
    public void updateShangpinDl(ShangpinDl shangpinDl) {
        this.saveOrUpdate(shangpinDl);
    }

    @Override
    @Transactional
    public void deleteShangpinDl(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}

	private void check(ShangpinDl shangpinDl) throws FebsException{
        LambdaQueryWrapper<ShangpinDl> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ShangpinDl::getDldm,shangpinDl.getDldm());
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
            throw new FebsException("数据已存在，添加失败");
        }
    }
}
