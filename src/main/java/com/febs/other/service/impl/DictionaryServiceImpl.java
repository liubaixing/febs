package com.febs.other.service.impl;

import com.febs.common.enums.DictionaryEnum;
import com.febs.other.entity.Dictionary;
import com.febs.other.entity.DictionaryExample;
import com.febs.other.mapper.DictionaryMapper;
import com.febs.other.service.IDictionaryService;
import com.febs.receipt.mapper.OrderXsMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName: DictionaryServiceImpl
 * @Description:
 * @Author:
 * @Date 2020/11/4
 * @Version 1.0
 */
@Service
public class DictionaryServiceImpl implements IDictionaryService {

    @Resource
    private DictionaryMapper dictionaryMapper;
    @Resource
    private OrderXsMapper orderXsMapper;

    @Override
    public Long getXsSerialNumber() {
        return dictionaryMapper.getXsSerialNumber();
    }

    @Override
    public Long incr() {
        dictionaryMapper.incr();
        return dictionaryMapper.getXsSerialNumber();
    }
}
