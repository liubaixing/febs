package cc.mrbird.febs.receipt.service;

import cc.mrbird.febs.receipt.entity.OrderXsskmx;

import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 销售收款明细 Service接口
 *
 * @author liubaixing
 * @date 2020-06-02 13:37:33
 */
public interface IOrderXsskmxService extends IService<OrderXsskmx> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param orderXsskmx orderXsskmx
     * @return IPage<OrderXsskmx>
     */
    IPage<OrderXsskmx> findOrderXsskmxs(QueryRequest request, OrderXsskmx orderXsskmx);

    /**
     * 查询（所有）
     *
     * @param orderXsskmx orderXsskmx
     * @return List<OrderXsskmx>
     */
    List<OrderXsskmx> findOrderXsskmxs(OrderXsskmx orderXsskmx);

    /**
     * 新增
     *
     * @param orderXsskmx orderXsskmx
     */
    void createOrderXsskmx(OrderXsskmx orderXsskmx);

    /**
     * 修改
     *
     * @param orderXsskmx orderXsskmx
     */
    void updateOrderXsskmx(OrderXsskmx orderXsskmx);

    /**
     * 删除
     */
    void deleteOrderXsskmx(String[] ids);
}
