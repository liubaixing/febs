package cc.mrbird.febs.receipt.service;

import cc.mrbird.febs.receipt.entity.OrderXs;

import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 销售单 Service接口
 *
 * @author liubaixing
 * @date 2020-06-02 11:27:56
 */
public interface IOrderXsService extends IService<OrderXs> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param orderXs orderXs
     * @return IPage<OrderXs>
     */
    IPage<OrderXs> findOrderXss(QueryRequest request, OrderXs orderXs);

    /**
     * 查询（所有）
     *
     * @param orderXs orderXs
     * @return List<OrderXs>
     */
    List<OrderXs> findOrderXss(OrderXs orderXs);

    /**
     * 新增
     *
     * @param orderXs orderXs
     */
    void createOrderXs(OrderXs orderXs);

    /**
     * 修改
     *
     * @param orderXs orderXs
     */
    void updateOrderXs(OrderXs orderXs);

    /**
     * 删除
     */
    void deleteOrderXs(String[] ids);
}
