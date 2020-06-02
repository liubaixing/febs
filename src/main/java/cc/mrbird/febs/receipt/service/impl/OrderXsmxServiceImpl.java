package cc.mrbird.febs.receipt.service.impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.receipt.entity.OrderXsmx;
import cc.mrbird.febs.receipt.mapper.OrderXsmxMapper;
import cc.mrbird.febs.receipt.service.IOrderXsmxService;
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
 * 销售单明细 Service实现
 *
 * @author liubaixing
 * @date 2020-06-02 13:38:56
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class OrderXsmxServiceImpl extends ServiceImpl<OrderXsmxMapper, OrderXsmx> implements IOrderXsmxService {

    @Autowired
    private OrderXsmxMapper orderXsmxMapper;

    @Override
    public IPage<OrderXsmx> findOrderXsmxs(QueryRequest request, OrderXsmx orderXsmx) {
        LambdaQueryWrapper<OrderXsmx> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<OrderXsmx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<OrderXsmx> findOrderXsmxs(OrderXsmx orderXsmx) {
	    LambdaQueryWrapper<OrderXsmx> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createOrderXsmx(OrderXsmx orderXsmx) {
        LambdaQueryWrapper<OrderXsmx> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
        throw new FebsException("数据已存在，添加失败");
        }
        this.save(orderXsmx);
    }

    @Override
    @Transactional
    public void updateOrderXsmx(OrderXsmx orderXsmx) {
        LambdaQueryWrapper<OrderXsmx> queryWrapper = new LambdaQueryWrapper<>();
        Integer count = this.baseMapper.selectCount(queryWrapper);
        if (count>0) {
        throw new FebsException("数据已存在，添加失败");
        }
        this.saveOrUpdate(orderXsmx);
    }

    @Override
    @Transactional
    public void deleteOrderXsmx(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
