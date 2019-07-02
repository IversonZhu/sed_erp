package com.iverson.sed_erp.vo;

import lombok.Data;

import java.util.Date;

@Data
public class StaffVo {
    /** 员工编号 */
    private String staffNo;
    /** 员工姓名 */
    private String name;
    /** 手机号码 */
    private String phoneNumber;
    /** 年龄 */
    private Integer age;
    /** 性别 */
    private Integer sex;
    /** 生日 */
    private Date birth;
    /** 地址 */
    private String address;
    /** 部门编号 */
    private String departmentNo;
    /** 部门名称 */
    private String departmentName;
}
