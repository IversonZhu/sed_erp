package com.iverson.sed_erp.pojo;


import lombok.Data;

@Data
public class Staff {
    /** 员工号 */
    private String staffNo;
    /** 员工名 */
    private String name;
    /** 手机号码 */
    private String phoneNumber;
    /** 年纪 */
    private Integer age;
    /** 性别 */
    private Integer sex;
    /** 生日 */
    private String birth;
    /** 地址 */
    private String address;
    /** 部门号 */
    private String departmentNo;
}
