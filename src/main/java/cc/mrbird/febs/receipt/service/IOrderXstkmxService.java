package cc.mrbird.febs.receipt.service;

import cc.mrbird.febs.receipt.entity.OrderXstkmx;

import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 销售退款明细 Service接口
 *
 * @author liubaixing
 * @date 2020-06-02 13:38:37
 */
public interface IOrderXstkmxService extends IService<OrderXstkmx> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param orderXstkmx orderXstkmx
     * @return IPage<OrderXstkmx>
     */
    IPage<OrderXstkmx> findOrderXstkmxs(QueryRequest request, OrderXstkmx orderXstkmx);

    /**
     * 查询（所有）
     *
     * @param orderXstkmx orderXstkmx
     * @return List<OrderXstkmx>
     */
    List<OrderXstkmx> findOrderXstkmxs(OrderXstkmx orderXstkmx);

    /**
     * 新增
     *
     * @param orderXstkmx orderXstkmx
     */
    void createOrderXstkmx(OrderXstkmx orderXstkmx);

    /**
     * 修改
     *
     * @param orderXstkmx orderXstkmx
     */
    void updateOrderXstkmx(OrderXstkmx orderXstkmx);

    /**
     * 删除
     */
    void deleteOrderXstkmx(String[] ids);
}
