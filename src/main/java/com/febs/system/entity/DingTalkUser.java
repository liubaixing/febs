package com.febs.system.entity;

import lombok.Data;

import java.util.List;

/**
 * @ClassName: DingTalkUser
 * @Description:
 * @Author:
 * @Date 2020/10/13
 * @Version 1.0
 */
@Data
public class DingTalkUser {

    private String staffId;
    private String name;
    private String orderInDepts;
    private List<Integer> department;
    private String position;
    private String mobile;
    private String tel;
    private String workPlace;
    private String remark;
    private String email;
    private String orgEmail;
    private String jobnumber;
    private boolean isHide;
    private boolean isSenior;
}
