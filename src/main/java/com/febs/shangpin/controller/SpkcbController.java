package com.febs.shangpin.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.febs.common.entity.FebsResponse;
import com.febs.common.entity.QueryRequest;
import com.febs.shangpin.entity.Spkcb;
import com.febs.shangpin.mapper.SpkcbMapper;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName: SpkcbController
 * @Description:
 * @Author:
 * @Date 2020/11/30
 * @Version 1.0
 */
@RestController
@RequestMapping("/spkcb")
public class SpkcbController {

    @Resource
    private SpkcbMapper spkcbMapper;

    @GetMapping("/list")
    public FebsResponse list(QueryRequest request, Spkcb spkcb){
        Page<Spkcb> page = new Page<>(request.getPageNum(), request.getPageSize());
        return new FebsResponse().success().data(spkcbMapper.selectPageByQuery(page,spkcb));

    }

    @PostMapping("")
    public FebsResponse saveObject(Spkcb spkcb){
        spkcbMapper.insertSelective(spkcb);
        return new FebsResponse().success();
    }

    @PutMapping("/")
    public FebsResponse updateObject(Spkcb spkcb){
        spkcbMapper.updateByPrimaryKeySelective(spkcb);
        return new FebsResponse().success();
    }


    @DeleteMapping("/{id}")
    public FebsResponse delete(@PathVariable("id")Integer id){
        spkcbMapper.deleteByPrimaryKey(id);
        return new FebsResponse().success();
    }


}
