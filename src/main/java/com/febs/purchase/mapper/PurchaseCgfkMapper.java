package com.febs.purchase.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.purchase.entity.PurchaseCgfk;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.febs.purchase.entity.PurchaseCgfkExample;
import com.febs.purchase.entity.PurchaseTc;
import com.febs.purchase.vo.req.PurchaseTcReq;
import com.febs.purchase.vo.resp.PurchaseTcResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 采购付款 Mapper
 *
 * @author liubaixing
 * @date 2020-06-27 19:46:20
 */
public interface PurchaseCgfkMapper extends BaseMapper<PurchaseCgfk> {
    long countByExample(PurchaseCgfkExample example);

    int deleteByExample(PurchaseCgfkExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseCgfk record);

    int insertSelective(PurchaseCgfk record);

    List<PurchaseCgfk> selectByExample(PurchaseCgfkExample example);

    PurchaseCgfk selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseCgfk record, @Param("example") PurchaseCgfkExample example);

    int updateByExample(@Param("record") PurchaseCgfk record, @Param("example") PurchaseCgfkExample example);

    int updateByPrimaryKeySelective(PurchaseCgfk record);

    int updateByPrimaryKey(PurchaseCgfk record);

//    IPage<PurchaseTcResp> selectPageByQuery(Page<PurchaseTc> page, PurchaseTcReq req);

}
