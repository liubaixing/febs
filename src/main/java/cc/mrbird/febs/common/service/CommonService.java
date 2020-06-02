package cc.mrbird.febs.common.service;

import cc.mrbird.febs.common.exception.FebsException;
import cc.mrbird.febs.system.entity.CommonId;
import cc.mrbird.febs.system.mapper.CommonIdMapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 公共自增id表 Service实现
 *
 * @author liubaixing
 * @date 2020-05-30 22:48:51
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
public class CommonService extends ServiceImpl<CommonIdMapper, CommonId> {

    @Autowired
    private CommonIdMapper commonIdMapper;
    @Transactional
    public Integer incr(String name) {
        if(!StringUtils.isNotBlank(name)){
            throw new FebsException("获取自增代码失败");
        }
        LambdaQueryWrapper<CommonId> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(CommonId::getName,name);
        CommonId commonId = this.baseMapper.selectOne(queryWrapper);
        if(commonId == null){
            throw new FebsException("自增代码获取失败");
        }
        Integer num = commonId.getNum();
        commonId.setNum(commonId.getNum()+1);
        this.updateById(commonId);
        return num;
    }
}
