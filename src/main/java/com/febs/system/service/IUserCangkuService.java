package com.febs.system.service;

import com.febs.system.entity.UserCangku;
import com.febs.system.entity.UserCangkuExample;
import com.febs.system.vo.req.UserPowerReq;

import java.util.List;

/**
 * @ClassName: IUserCangkuService
 * @Description:
 * @Author
 * @Date 2020/9/25
 * @Version 1.0
 */
public interface IUserCangkuService {

    UserCangku getByExample(Long id);

    List<UserCangku> listByExample(UserCangkuExample example);

    List<Long> getUserCangku(Long userId);

    void create(UserCangku userCangku);

    int insertBacth(List<UserCangku> userCangkuList);

    void delete(UserCangkuExample example);
}
