package com.febs.orderqt.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.orderqt.entity.OrderqtYfd;
import com.febs.orderqt.entity.OrderqtYsfd;
import com.febs.orderqt.entity.OrderqtYsfdExample;
import com.febs.orderqt.vo.req.YsfdReq;
import com.febs.orderqt.vo.resp.YsfdResp;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 印刷费单 Mapper
 *
 * @author liubaixing
 * @date 2020-07-29 14:14:23
 */
public interface OrderqtYsfdMapper extends BaseMapper<OrderqtYsfd> {
    long countByExample(OrderqtYsfdExample example);

    int deleteByExample(OrderqtYsfdExample example);

    int deleteByPrimaryKey(Long id);

    int insert(OrderqtYsfd record);

    int insertSelective(OrderqtYsfd record);

    List<OrderqtYsfd> selectByExample(OrderqtYsfdExample example);

    OrderqtYsfd selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") OrderqtYsfd record, @Param("example") OrderqtYsfdExample example);

    int updateByExample(@Param("record") OrderqtYsfd record, @Param("example") OrderqtYsfdExample example);

    int updateByPrimaryKeySelective(OrderqtYsfd record);

    int updateByPrimaryKey(OrderqtYsfd record);

    IPage<YsfdResp> selectPageByQuery(Page<OrderqtYsfd> page, @Param("ysf") YsfdReq req);

    List<YsfdResp> selectByQuery(YsfdReq req);

}
