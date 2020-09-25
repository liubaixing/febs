package com.febs.system.vo.req;

import lombok.Data;

import java.util.List;

/**
 * @ClassName: UserOrgReq
 * @Description:
 * @Author:
 * @Date 2020/9/25
 * @Version 1.0
 */
@Data
public class UserPowerReq {

    /**
     * userOrgId、userGysId、userCangkuId
     */
    private List<Long> powerIds;

    /**
     * 1：userOrg、2：userGys、3：userCangku
     */
    private String powerType;

    private Long userId;



}
