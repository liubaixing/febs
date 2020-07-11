package com.febs.purchase.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.purchase.entity.PurchaseCg;
import com.febs.purchase.entity.PurchaseCgmx;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.febs.purchase.entity.PurchaseCgmxExample;
import com.febs.purchase.vo.resp.PurchaseCgmxResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 采购单明细 Mapper
 *
 * @author liubaixing
 * @date 2020-06-27 19:46:14
 */
public interface PurchaseCgmxMapper extends BaseMapper<PurchaseCgmx> {
    long countByExample(PurchaseCgmxExample example);

    int deleteByExample(PurchaseCgmxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseCgmx record);

    int insertSelective(PurchaseCgmx record);

    List<PurchaseCgmx> selectByExample(PurchaseCgmxExample example);

    PurchaseCgmx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseCgmx record, @Param("example") PurchaseCgmxExample example);

    int updateByExample(@Param("record") PurchaseCgmx record, @Param("example") PurchaseCgmxExample example);

    int updateByPrimaryKeySelective(PurchaseCgmx record);

    int updateByPrimaryKey(PurchaseCgmx record);

    IPage<PurchaseCgmxResp> selectPageByQuery(Page<PurchaseCgmx> page, PurchaseCgmx req);

    List<PurchaseCgmxResp> selectByQuery(PurchaseCgmx req);
}
