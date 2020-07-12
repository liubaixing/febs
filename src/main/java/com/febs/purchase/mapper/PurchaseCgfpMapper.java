package com.febs.purchase.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.purchase.entity.PurchaseCgfp;
import com.febs.purchase.entity.PurchaseCgfpExample;
import com.febs.purchase.entity.PurchaseTc;
import com.febs.purchase.vo.req.PurchaseCgfpReq;
import com.febs.purchase.vo.resp.PurchaseCgfpResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 采购发票 Mapper
 *
 * @author liubaixing
 * @date 2020-06-27 19:55:27
 */
public interface PurchaseCgfpMapper extends BaseMapper<PurchaseCgfp> {
    long countByExample(PurchaseCgfpExample example);

    int deleteByExample(PurchaseCgfpExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseCgfp record);

    int insertSelective(PurchaseCgfp record);

    List<PurchaseCgfp> selectByExample(PurchaseCgfpExample example);

    PurchaseCgfp selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseCgfp record, @Param("example") PurchaseCgfpExample example);

    int updateByExample(@Param("record") PurchaseCgfp record, @Param("example") PurchaseCgfpExample example);

    int updateByPrimaryKeySelective(PurchaseCgfp record);

    int updateByPrimaryKey(PurchaseCgfp record);

    IPage<PurchaseCgfpResp> selectPageByQuery(Page<PurchaseCgfp> page, PurchaseCgfpReq req);

    List<PurchaseCgfpResp> selectByQuery(PurchaseCgfpReq req);
}
