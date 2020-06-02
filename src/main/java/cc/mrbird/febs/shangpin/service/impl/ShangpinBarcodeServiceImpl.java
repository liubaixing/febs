package cc.mrbird.febs.shangpin.service.impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.shangpin.entity.ShangpinBarcode;
import cc.mrbird.febs.shangpin.mapper.ShangpinBarcodeMapper;
import cc.mrbird.febs.shangpin.service.IShangpinBarcodeService;
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
 * 商品条码 Service实现
 *
 * @author liubaixing1
 * @date 2020-05-22 01:11:50
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class ShangpinBarcodeServiceImpl extends ServiceImpl<ShangpinBarcodeMapper, ShangpinBarcode> implements IShangpinBarcodeService {

    @Autowired
    private ShangpinBarcodeMapper shangpinBarcodeMapper;

    @Override
    public IPage<ShangpinBarcode> findShangpinBarcodes(QueryRequest request, ShangpinBarcode shangpinBarcode) {
        LambdaQueryWrapper<ShangpinBarcode> queryWrapper = new LambdaQueryWrapper<>();
        // TODO 设置查询条件
        Page<ShangpinBarcode> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.page(page, queryWrapper);
    }

    @Override
    public List<ShangpinBarcode> findShangpinBarcodes(ShangpinBarcode shangpinBarcode) {
	    LambdaQueryWrapper<ShangpinBarcode> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public void createShangpinBarcode(ShangpinBarcode shangpinBarcode) {
        this.save(shangpinBarcode);
    }

    @Override
    @Transactional
    public void updateShangpinBarcode(ShangpinBarcode shangpinBarcode) {
        if(shangpinBarcode.getBarcodeId()==null){
            new FebsException("id不能为空");
        }
        this.saveOrUpdate(shangpinBarcode);
    }

    @Override
    @Transactional
    public void deleteShangpinBarcode(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
