package com.iverson.sed_erp.pojo;

import lombok.Data;

@Data
public class Department {
    /** id */
    private int id;
    /** 部门编号 */
    private String departmentNo;
    /** 部门名称 */
    private String name;
    /** 状态 */
    private Integer status;
}
