package com.febs.purchase.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.common.entity.QueryRequest;
import com.febs.purchase.entity.PurchaseCgmx;
import com.febs.purchase.entity.PurchaseCgmxExample;
import com.febs.purchase.mapper.PurchaseCgmxMapper;
import com.febs.purchase.service.IPurchaseCgmxService;
import com.febs.purchase.vo.resp.PurchaseCgmxResp;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 采购单明细 Service实现
 *
 * @author liubaixing
 * @date 2020-06-27 19:46:14
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PurchaseCgmxServiceImpl extends ServiceImpl<PurchaseCgmxMapper, PurchaseCgmx> implements IPurchaseCgmxService {

    @Autowired
    private PurchaseCgmxMapper purchaseCgmxMapper;

    @Override
    public IPage<PurchaseCgmxResp> findPurchaseCgmxs(QueryRequest request, PurchaseCgmx purchaseCgmx) {
        Page<PurchaseCgmx> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.purchaseCgmxMapper.selectPageByQuery(page, purchaseCgmx);
    }

    @Override
    public List<PurchaseCgmxResp> findPurchaseCgmxs(PurchaseCgmx purchaseCgmx) {
		return this.purchaseCgmxMapper.selectByQuery(purchaseCgmx);
    }

    @Override
    public PurchaseCgmxResp findById(Long id){
        PurchaseCgmx purchaseCgmx = new PurchaseCgmx();
        purchaseCgmx.setId(id);
        List<PurchaseCgmxResp> resp = this.purchaseCgmxMapper.selectByQuery(purchaseCgmx);
        return CollectionUtils.isEmpty(resp) ? null : resp.get(0);
    }


    @Override
    @Transactional
    public Long createPurchaseCgmx(PurchaseCgmx purchaseCgmx) {
        this.purchaseCgmxMapper.insertSelective(purchaseCgmx);
        return purchaseCgmx.getId();
    }

    @Override
    @Transactional
    public void updatePurchaseCgmx(PurchaseCgmx purchaseCgmx) {
        this.purchaseCgmxMapper.updateByPrimaryKeySelective(purchaseCgmx);
    }

    @Override
    @Transactional
    public void updateByExample(PurchaseCgmx record, PurchaseCgmxExample example) {
        this.purchaseCgmxMapper.updateByExampleSelective(record,example);
    }

    @Override
    @Transactional
    public void deletePurchaseCgmx(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
