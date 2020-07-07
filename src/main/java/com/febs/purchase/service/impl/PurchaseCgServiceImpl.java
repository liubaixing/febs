package com.febs.purchase.service.impl;

import com.febs.common.constant.OrderConstant;
import com.febs.common.constant.PurchaseConstant;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.DateUtil;
import com.febs.common.utils.StringUtil;
import com.febs.purchase.entity.PurchaseCg;
import com.febs.purchase.mapper.PurchaseCgMapper;
import com.febs.purchase.service.IPurchaseCgService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.purchase.vo.req.PurchaseCgReq;
import com.febs.purchase.vo.resp.PurchaseCgResp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 采购单 Service实现
 *
 * @author liubaixing
 * @date 2020-06-27 19:45:59
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PurchaseCgServiceImpl extends ServiceImpl<PurchaseCgMapper, PurchaseCg> implements IPurchaseCgService {

    @Autowired
    private PurchaseCgMapper purchaseCgMapper;

    @Override
    public IPage<PurchaseCgResp> findPurchaseCgs(QueryRequest request, PurchaseCgReq purchaseCg) {
        Page<PurchaseCg> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.purchaseCgMapper.selectPageByQuery(page,purchaseCg);
    }

    @Override
    public List<PurchaseCg> findPurchaseCgs(PurchaseCg purchaseCg) {
	    LambdaQueryWrapper<PurchaseCg> queryWrapper = new LambdaQueryWrapper<>();
		// TODO 设置查询条件
		return this.baseMapper.selectList(queryWrapper);
    }

    @Override
    @Transactional
    public Long createPurchaseCg(PurchaseCg purchaseCg) {
        this.purchaseCgMapper.insertSelective(purchaseCg);
        String bh = PurchaseConstant.PURCHASE_CG_PREFIX + DateUtil.getYear() + StringUtil.padStart(purchaseCg.getId());
        purchaseCg.setDjbh(bh);
        this.purchaseCgMapper.updateByPrimaryKeySelective(purchaseCg);
        return purchaseCg.getId();
    }

    @Override
    @Transactional
    public void updatePurchaseCg(PurchaseCg purchaseCg) {
        this.purchaseCgMapper.updateByPrimaryKeySelective(purchaseCg);
    }

    @Override
    @Transactional
    public void deletePurchaseCg(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
