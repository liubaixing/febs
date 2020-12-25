package com.febs.system.service;

import com.febs.system.entity.UserGys;
import com.febs.system.entity.UserGysExample;
import com.febs.system.vo.req.UserPowerReq;

import java.util.List;

/**
 * @ClassName: IUserGysService
 * @Description:
 * @Author
 * @Date 2020/9/25
 * @Version 1.0
 */
public interface IUserGysService {

    List<UserGys> listByExample(UserGysExample example);

    List<Long> getUserGys(Long userId);

    void create(UserGys userGys);

    int insertBacth(List<UserGys> userGysList);

    void deleted(UserGysExample example);
}
