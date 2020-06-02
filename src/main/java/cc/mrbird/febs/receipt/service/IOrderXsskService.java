package cc.mrbird.febs.receipt.service;

import cc.mrbird.febs.receipt.entity.OrderXssk;

import cc.mrbird.febs.common.entity.QueryRequest;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 销售收款 Service接口
 *
 * @author liubaixing
 * @date 2020-06-02 13:37:28
 */
public interface IOrderXsskService extends IService<OrderXssk> {
    /**
     * 查询（分页）
     *
     * @param request QueryRequest
     * @param orderXssk orderXssk
     * @return IPage<OrderXssk>
     */
    IPage<OrderXssk> findOrderXssks(QueryRequest request, OrderXssk orderXssk);

    /**
     * 查询（所有）
     *
     * @param orderXssk orderXssk
     * @return List<OrderXssk>
     */
    List<OrderXssk> findOrderXssks(OrderXssk orderXssk);

    /**
     * 新增
     *
     * @param orderXssk orderXssk
     */
    void createOrderXssk(OrderXssk orderXssk);

    /**
     * 修改
     *
     * @param orderXssk orderXssk
     */
    void updateOrderXssk(OrderXssk orderXssk);

    /**
     * 删除
     */
    void deleteOrderXssk(String[] ids);
}
