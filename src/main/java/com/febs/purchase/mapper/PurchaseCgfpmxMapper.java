package com.febs.purchase.mapper;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.purchase.entity.PurchaseCgfpmx;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.febs.purchase.entity.PurchaseCgfpmxExample;
import com.febs.purchase.vo.resp.PurchaseCgfpmxResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 采购发票明细 Mapper
 *
 * @author liubaixing
 * @date 2020-06-27 19:55:24
 */
public interface PurchaseCgfpmxMapper extends BaseMapper<PurchaseCgfpmx> {
    long countByExample(PurchaseCgfpmxExample example);

    int deleteByExample(PurchaseCgfpmxExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PurchaseCgfpmx record);

    int insertSelective(PurchaseCgfpmx record);

    List<PurchaseCgfpmx> selectByExample(PurchaseCgfpmxExample example);

    PurchaseCgfpmx selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PurchaseCgfpmx record, @Param("example") PurchaseCgfpmxExample example);

    int updateByExample(@Param("record") PurchaseCgfpmx record, @Param("example") PurchaseCgfpmxExample example);

    int updateByPrimaryKeySelective(PurchaseCgfpmx record);

    int updateByPrimaryKey(PurchaseCgfpmx record);

    IPage<PurchaseCgfpmxResp> selectPageByQuery(Page<PurchaseCgfpmx> page,@Param("mx") PurchaseCgfpmx req);

    List<PurchaseCgfpmxResp> selectByQuery(PurchaseCgfpmx req);
}
