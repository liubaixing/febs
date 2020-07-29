package com.febs.orderqt.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.orderqt.entity.OrderqtYfd;
import com.febs.orderqt.entity.OrderqtYfdExample;
import com.febs.orderqt.vo.req.YfdReq;
import com.febs.orderqt.vo.resp.YfdResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 运费单 Mapper
 *
 * @author liubaixing
 * @date 2020-07-29 14:14:12
 */
public interface OrderqtYfdMapper extends BaseMapper<OrderqtYfd> {
    long countByExample(OrderqtYfdExample example);

    int deleteByExample(OrderqtYfdExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderqtYfd record);

    int insertSelective(OrderqtYfd record);

    List<OrderqtYfd> selectByExample(OrderqtYfdExample example);

    OrderqtYfd selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderqtYfd record, @Param("example") OrderqtYfdExample example);

    int updateByExample(@Param("record") OrderqtYfd record, @Param("example") OrderqtYfdExample example);

    int updateByPrimaryKeySelective(OrderqtYfd record);

    int updateByPrimaryKey(OrderqtYfd record);

    IPage<YfdResp> selectPageByQuery(Page<OrderqtYfd> page, @Param("yf") YfdReq req);

    List<YfdResp> selectByQuery(YfdReq req);

}
