package com.febs.purchase.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.purchase.entity.PurchaseCgtkmx;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.febs.purchase.entity.PurchaseCgtkmxExample;
import com.febs.purchase.vo.resp.PurchaseCgtkmxResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 采购退款明细 Mapper
 *
 * @author liubaixing
 * @date 2020-06-27 19:54:49
 */
public interface PurchaseCgtkmxMapper extends BaseMapper<PurchaseCgtkmx> {
    long countByExample(PurchaseCgtkmxExample example);

    int deleteByExample(PurchaseCgtkmxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseCgtkmx record);

    int insertSelective(PurchaseCgtkmx record);

    List<PurchaseCgtkmx> selectByExample(PurchaseCgtkmxExample example);

    PurchaseCgtkmx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseCgtkmx record, @Param("example") PurchaseCgtkmxExample example);

    int updateByExample(@Param("record") PurchaseCgtkmx record, @Param("example") PurchaseCgtkmxExample example);

    int updateByPrimaryKeySelective(PurchaseCgtkmx record);

    int updateByPrimaryKey(PurchaseCgtkmx record);


    IPage<PurchaseCgtkmxResp> selectPageByQuery(Page<PurchaseCgtkmx> page,@Param("mx") PurchaseCgtkmx req);

    List<PurchaseCgtkmxResp> selectByQuery(PurchaseCgtkmx req);

}
