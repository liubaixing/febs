package com.febs.purchase.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.purchase.entity.PurchaseCgtk;
import com.febs.purchase.entity.PurchaseCgtkExample;
import com.febs.purchase.vo.req.PurchaseCgtkReq;
import com.febs.purchase.vo.resp.PurchaseCgtkResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 采购退款 Mapper
 *
 * @author liubaixing
 * @date 2020-06-27 19:54:56
 */
public interface PurchaseCgtkMapper extends BaseMapper<PurchaseCgtk> {
    long countByExample(PurchaseCgtkExample example);

    int deleteByExample(PurchaseCgtkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseCgtk record);

    int insertSelective(PurchaseCgtk record);

    List<PurchaseCgtk> selectByExample(PurchaseCgtkExample example);

    PurchaseCgtk selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseCgtk record, @Param("example") PurchaseCgtkExample example);

    int updateByExample(@Param("record") PurchaseCgtk record, @Param("example") PurchaseCgtkExample example);

    int updateByPrimaryKeySelective(PurchaseCgtk record);

    int updateByPrimaryKey(PurchaseCgtk record);

    IPage<PurchaseCgtkResp> selectPageByQuery(Page<PurchaseCgtk> page, PurchaseCgtkReq req);

    List<PurchaseCgtkResp> selectByQuery(PurchaseCgtkReq req);
}
