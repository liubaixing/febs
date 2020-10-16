package com.febs.system.entity.dingtalk;

import lombok.Data;

/**
 * @ClassName: DingTalkDepartment
 * @Description:
 * @Author:
 * @Date 2020/10/13
 * @Version 1.0
 */
@Data
public class DingTalkDepartmentEntity {

    private Integer id;
    private String name;
    private String parentid;
    private Integer order;
    private boolean createDeptGroup;
    private boolean autoAddUser;
    private String deptManagerUseridList;
    private boolean deptHiding;
    private String deptPermits;
    private String userPermits;
    private boolean outerDept;
    private String outerPermitDepts;
    private String outerPermitUsers;
    private String orgDeptOwner;
    private String sourceIdentifier;
    private String ext;


}
