package com.febs.purchase.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.purchase.entity.PurchaseTc;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.febs.purchase.entity.PurchaseTcExample;
import com.febs.purchase.vo.req.PurchaseTcReq;
import com.febs.purchase.vo.resp.PurchaseTcResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 退仓单 Mapper
 *
 * @author liubaixing
 * @date 2020-06-27 19:55:32
 */
public interface PurchaseTcMapper extends BaseMapper<PurchaseTc> {
    long countByExample(PurchaseTcExample example);

    int deleteByExample(PurchaseTcExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseTc record);

    int insertSelective(PurchaseTc record);

    List<PurchaseTc> selectByExample(PurchaseTcExample example);

    PurchaseTc selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseTc record, @Param("example") PurchaseTcExample example);

    int updateByExample(@Param("record") PurchaseTc record, @Param("example") PurchaseTcExample example);

    int updateByPrimaryKeySelective(PurchaseTc record);

    int updateByPrimaryKey(PurchaseTc record);

    IPage<PurchaseTcResp> selectPageByQuery(Page<PurchaseTc> page, PurchaseTcReq req);

    List<PurchaseTcResp> selectByQuery(PurchaseTcReq req);

}
