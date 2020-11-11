package com.febs.shangpin.biz;

import com.febs.common.exception.FebsException;
import com.febs.common.utils.BeanUtils;
import com.febs.shangpin.entity.*;
import com.febs.shangpin.mapper.SpkcbMapper;
import com.febs.shangpin.service.IShangpinService;
import com.febs.shangpin.service.IStockTzService;
import com.febs.shangpin.service.IStockTzmxService;
import com.febs.shangpin.vo.req.StockTzReq;
import com.febs.shangpin.vo.resp.StockTzResp;
import com.febs.system.entity.User;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * @ClassName: StockTzBiz
 * @Description: 、
 * @Author:
 * @Date 2020/11/4
 * @Version 1.0
 */
@Service
public class StockTzBiz {

    @Autowired
    private IStockTzService stockTzService;

    @Autowired
    private IStockTzmxService stockTzmxService;
    @Autowired
    private IShangpinService shangpinService;
    @Resource
    private SpkcbMapper spkcbMapper;

    public void save(StockTzReq req){

        if (req == null || CollectionUtils.isEmpty(req.getStockTzmxList())){
            throw new FebsException("调整单参数为空");
        }

        List<StockTzmx> stockTzmxList = req.getStockTzmxList();

        StockTz stockTz = BeanUtils.transformFrom(req,StockTz.class);
        stockTz = stockTzService.saveObject(stockTz);

        for (StockTzmx i : stockTzmxList){

            Shangpin shangpin = shangpinService.findByPrimaryKey(i.getSpId());
            if (shangpin == null){
                throw new FebsException("商品不存在");
            }

            i.setPid(stockTz.getId());
            stockTzmxService.saveObject(i);
        }

    }

    public void update(StockTzReq req){
        if (req != null || CollectionUtils.isNotEmpty(req.getStockTzmxList())){
            throw new FebsException("调整单参数为空");
        }

        List<StockTzmx> stockTzmxList = req.getStockTzmxList();

        StockTz stockTz = BeanUtils.transformFrom(req,StockTz.class);

        stockTzService.updateObject(stockTz);

        StockTzmxExample example = new StockTzmxExample();
        example.createCriteria().andPidEqualTo(stockTz.getId());
        stockTzmxService.delete(example);

        for (StockTzmx i : stockTzmxList){
            Shangpin shangpin = shangpinService.findByPrimaryKey(i.getSpId());
            if (shangpin == null){
                throw new FebsException("商品不存在");
            }

            i.setPid(stockTz.getId());
            stockTzmxService.saveObject(i);
        }

    }


    public void qr(Long id, User user) {
        StockTzReq req = new StockTzReq();
        req.setId(id);
        List<StockTzResp> stockTzRspList = stockTzService.findStockTzList(req);
        if (CollectionUtils.isEmpty(stockTzRspList)){
            throw new FebsException("通知单不存在");
        }

        for (StockTzResp tzResp : stockTzRspList){
            Shangpin shangpin = shangpinService.findByPrimaryKey(tzResp.getSpId());
            if (shangpin == null)
            {
                throw new FebsException("商品不存在");
            }

            SpkcbExample spkcbExample = new SpkcbExample();
            spkcbExample.createCriteria().andGoodsIdEqualTo(tzResp.getSpId());
            List<Spkcb> spkcbList = spkcbMapper.selectByExample(spkcbExample);
            if (CollectionUtils.isEmpty(spkcbList))
            {
                throw new FebsException("商品库存为空");
            }

            for (Spkcb spkcb : spkcbList){
                spkcb.setSl(spkcb.getSl() + tzResp.getSl());
                spkcbMapper.updateByPrimaryKeySelective(spkcb);
            }
            shangpin.setXsj(tzResp.getJe());
            shangpinService.updateShangpin(shangpin);
        }

        StockTz stockTz = BeanUtils.transformFrom(req,StockTz.class);
        stockTz.setQr((byte)1);
        stockTz.setQrr(user.getUsername());
        stockTz.setQrrq(new Date());
        stockTzService.updateObject(stockTz);
    }

    public StockTzResp view(Long id) {


        StockTz stockTz = stockTzService.getStockTzById(id);
        if (stockTz == null)
        {
            throw new FebsException("调整单不存在");
        }
        StockTzResp stockTzResp = BeanUtils.transformFrom(stockTz,StockTzResp.class);
        StockTzmx req = new StockTzmx();
        stockTzResp.setStockTzmxList(stockTzmxService.findStockTzList(req));

        return stockTzResp;
    }
}
