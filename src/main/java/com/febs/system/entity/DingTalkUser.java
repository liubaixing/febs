package com.febs.system.entity;

import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @ClassName: DingTalkUser
 * @Description:
 * @Author:
 * @Date 2020/10/13
 * @Version 1.0
 */
@Data
@ToString
public class DingTalkUser {

    private String staffId;
    private String userid;
    private String name;
    private String orderInDepts;
    private String department;
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

    public String getStaffId() {
        return staffId;
    }

    public void setStaffId(String staffId) {
        this.staffId = staffId;
        this.userid = staffId;
    }
}
