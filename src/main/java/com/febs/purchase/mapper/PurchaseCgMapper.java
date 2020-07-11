package com.febs.purchase.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.purchase.entity.PurchaseCg;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.febs.purchase.entity.PurchaseCgExample;
import com.febs.purchase.vo.req.PurchaseCgReq;
import com.febs.purchase.vo.resp.PurchaseCgResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 采购单 Mapper
 *
 * @author liubaixing
 * @date 2020-06-27 19:45:59
 */
public interface PurchaseCgMapper extends BaseMapper<PurchaseCg> {
    long countByExample(PurchaseCgExample example);

    int deleteByExample(PurchaseCgExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseCg record);

    int insertSelective(PurchaseCg record);

    List<PurchaseCg> selectByExample(PurchaseCgExample example);

    PurchaseCg selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseCg record, @Param("example") PurchaseCgExample example);

    int updateByExample(@Param("record") PurchaseCg record, @Param("example") PurchaseCgExample example);

    int updateByPrimaryKeySelective(PurchaseCg record);

    int updateByPrimaryKey(PurchaseCg record);

    IPage<PurchaseCgResp> selectPageByQuery(Page<PurchaseCg> page, PurchaseCgReq req);

    List<PurchaseCgResp> selectByQuery(PurchaseCgReq req);
}
