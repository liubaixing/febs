package com.febs.purchase.service.impl;

import com.febs.common.constant.PurchaseConstant;
import com.febs.common.entity.QueryRequest;
import com.febs.common.exception.FebsException;
import com.febs.common.utils.DateUtil;
import com.febs.common.utils.StringUtil;
import com.febs.purchase.entity.PurchaseRk;
import com.febs.purchase.mapper.PurchaseRkMapper;
import com.febs.purchase.service.IPurchaseRkService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.febs.purchase.vo.req.PurchaseRkReq;
import com.febs.purchase.vo.resp.PurchaseRkResp;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * 入库单 Service实现
 *
 * @author liubaixing
 * @date 2020-06-27 19:56:08
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class PurchaseRkServiceImpl extends ServiceImpl<PurchaseRkMapper, PurchaseRk> implements IPurchaseRkService {

    @Autowired
    private PurchaseRkMapper purchaseRkMapper;

    @Override
    public IPage<PurchaseRkResp> findPurchaseRks(QueryRequest request, PurchaseRkReq purchaseRk) {
        Page<PurchaseRk> page = new Page<>(request.getPageNum(), request.getPageSize());
        return this.purchaseRkMapper.selectPageByQuery(page, purchaseRk);
    }

    @Override
    public List<PurchaseRkResp> findPurchaseRks(PurchaseRkReq purchaseRk) {
		return this.purchaseRkMapper.selectByQuery(purchaseRk);
    }

    @Override
    public PurchaseRkResp findById(Long id) {
        PurchaseRkReq purchaseRk = new PurchaseRkReq();
        purchaseRk.setId(id);
        List<PurchaseRkResp> purchaseRkResps = findPurchaseRks(purchaseRk);
        return CollectionUtils.isEmpty(purchaseRkResps) ? null : purchaseRkResps.get(0);
    }

    @Override
    @Transactional
    public Long createPurchaseRk(PurchaseRk purchaseRk) {
        this.purchaseRkMapper.insertSelective(purchaseRk);

        String bh = "";
        if (StringUtils.isNotBlank(purchaseRk.getDjbh())){
            bh = purchaseRk.getDjbh() + DateUtil.getYear() + StringUtil.padStart(purchaseRk.getId());
        }else{
            bh = PurchaseConstant.PURCHASE_RK_PREFIX + DateUtil.getYear() + StringUtil.padStart(purchaseRk.getId());
        }
        purchaseRk.setDjbh(bh);

        this.purchaseRkMapper.updateByPrimaryKeySelective(purchaseRk);
        return purchaseRk.getId();
    }

    @Override
    @Transactional
    public void updatePurchaseRk(PurchaseRk purchaseRk) {
        this.purchaseRkMapper.updateByPrimaryKeySelective(purchaseRk);
    }

    @Override
    @Transactional
    public void deletePurchaseRk(String[] ids) {
        List<String> list = Arrays.asList(ids);
        this.removeByIds(list);
	}
}
