package com.febs.purchase.service.impl;

import com.febs.common.constant.PurchaseConstant;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.DateUtil;
import com.febs.common.utils.StringUtil;
import com.febs.purchase.entity.PurchaseCgtk;
import com.febs.purchase.mapper.PurchaseCgtkMapper;
import com.febs.purchase.service.IPurchaseCgtkService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.purchase.vo.req.PurchaseCgtkReq;
import com.febs.purchase.vo.resp.PurchaseCgtkResp;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 采购退款 Service实现
 *
 * @author liubaixing
 * @date 2020-06-27 19:54:56
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PurchaseCgtkServiceImpl extends ServiceImpl<PurchaseCgtkMapper, PurchaseCgtk> implements IPurchaseCgtkService {

    @Autowired
    private PurchaseCgtkMapper purchaseCgtkMapper;

    @Override
    public IPage<PurchaseCgtkResp> findPurchaseCgtks(QueryRequest request, PurchaseCgtkReq purchaseCgtk) {
        Page<PurchaseCgtk> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.purchaseCgtkMapper.selectPageByQuery(page, purchaseCgtk);
    }

    @Override
    public List<PurchaseCgtkResp> findPurchaseCgtks(PurchaseCgtkReq purchaseCgtk) {
		return this.purchaseCgtkMapper.selectByQuery(purchaseCgtk);
    }

    @Override
    public PurchaseCgtkResp findById(Long id) {
        PurchaseCgtkReq purchaseCgtk = new PurchaseCgtkReq();
        purchaseCgtk.setId(id);
        List<PurchaseCgtkResp> cgtkList = findPurchaseCgtks(purchaseCgtk);
        return CollectionUtils.isEmpty(cgtkList) ? null : cgtkList.get(0);
    }


    @Override
    @Transactional
    public Long createPurchaseCgtk(PurchaseCgtk purchaseCgtk) {
        this.purchaseCgtkMapper.insertSelective(purchaseCgtk);
        String bh = PurchaseConstant.PURCHASE_RK_PREFIX + DateUtil.getYear() + StringUtil.padStart(purchaseCgtk.getId());
        purchaseCgtk.setDjbh(bh);
        this.purchaseCgtkMapper.updateByPrimaryKeySelective(purchaseCgtk);
        return purchaseCgtk.getId();
    }

    @Override
    @Transactional
    public void updatePurchaseCgtk(PurchaseCgtk purchaseCgtk) {
        this.purchaseCgtkMapper.updateByPrimaryKeySelective(purchaseCgtk);
    }

    @Override
    @Transactional
    public void deletePurchaseCgtk(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
